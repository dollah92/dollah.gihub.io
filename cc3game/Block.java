/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.blocks;

/**
 *
 * @author Jhomar
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import fr.brickbreaker.ns.audio.Sound;
import fr.brickbreaker.ns.balls.Ball;
import fr.brickbreaker.ns.game.Level;
import fr.brickbreaker.ns.maths.Vector2f;
public abstract class Block {
    private final BlockType type;
	private Rectangle hitbox, left, up, right, down;
	private boolean destroy;
	private Color color;
	private Image texture;
	
	public Block(int x, int y, BlockType type, Color color) {
		hitbox = new Rectangle(x, y, 63, 20);
		left = new Rectangle(x, y+3, 3, 14);
		up = new Rectangle(x+3, y, 57, 3);
		right = new Rectangle(x+60, y+3, 3, 14);
		down = new Rectangle(x+3, y+17, 57, 3);
		this.color = color;
		this.type = type;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public BlockType getType() {
		return type;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Image getTexture() {
		return texture;
	}
	
	public boolean isDestroy() {
		return destroy;
	}
	
	public Rectangle getUp() {
		return up;
	}
	
	public Rectangle getLeft() {
		return left;
	}
	
	public Rectangle getDown() {
		return down;
	}
	
	public Rectangle getRight() {
		return right;
	}
	
	public void setTexture(Image texture) {
		this.texture = texture;
	}
	
	public void setDestroy(boolean destroy) {
		this.destroy = destroy;
	}
	
	public void update(){
		
	}
	
	public void action(Ball ball, Level level){
		if(ball.getHitbox().intersects(getLeft()) || ball.getHitbox().intersects(getRight())){
			ball.setVelocity(new Vector2f(-ball.getVelocity().getX(), ball.getVelocity().getY()));
			level.addScore(getType().getScores()*getType().getMultUp());
		}else if(ball.getHitbox().intersects(getUp()) || ball.getHitbox().intersects(getDown())){
			ball.setVelocity(new Vector2f(ball.getVelocity().getX(), -ball.getVelocity().getY()));
			level.addScore(getType().getScores()*getType().getMultSide());
		}else{
			ball.setVelocity(new Vector2f(-ball.getVelocity().getX(), -ball.getVelocity().getY()));
			level.addScore(getType().getScores()*getType().getMultCorner());
		}
		setDestroy(true);
		Sound.HIT_SOUND.start();
	}
	
	public void render(Graphics2D gdd){
		if(isDestroy()) return;
		if(texture != null) gdd.drawImage(getTexture(), getHitbox().x, getHitbox().y, getHitbox().width, getHitbox().height, null);
		else{
			gdd.setColor(color);
			gdd.fillRect(getHitbox().x, getHitbox().y, getHitbox().width, getHitbox().height);
		}
	}
}
