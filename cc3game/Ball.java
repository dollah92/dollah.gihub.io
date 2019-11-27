/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.balls;

/**
 *
 * @author Jhomar
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Collection;

import fr.brickbreaker.ns.blocks.Block;
import fr.brickbreaker.ns.game.Level;
import fr.brickbreaker.ns.maths.Vector2f;
public abstract class Ball {
    
	private final BallType type;
	private Vector2f velocity = new Vector2f();
	private boolean destroy;
	private float x, y, speed;
	private Rectangle hitbox;
	private Image texture;
	
	public Ball(float x, float y, int l, int la, BallType type, Image texture) {
		hitbox = new Rectangle((int)x, (int)y, l, la);
		this.x = x;
		this.y = y;
		this.texture = texture;
		this.type = type;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public Image getTexture() {
		return texture;
	}
	
	public BallType getType() {
		return type;
	}
	
	public Vector2f getVelocity() {
		return velocity;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public boolean isDestroy() {
		return destroy;
	}
	
	public void setDestroy(boolean destroy) {
		this.destroy = destroy;
	}
	
	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}
	
	public void setX(float x){
		this.x = x;
		updateHitbox();
	}
	
	public void setY(float y){
		this.y = y;
		updateHitbox();
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	private void updateHitbox(){
		hitbox.x = (int)getX();
		hitbox.y = (int)getY();
	}
	
	public abstract void update(Collection<? extends Block> blocks, Level level);
	
	public void render(Graphics2D gdd){
		gdd.drawImage(texture, getHitbox().x, getHitbox().y, getHitbox().width, getHitbox().height, null);
	}
}


