/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.platform;

/**
 *
 * @author Jhomar
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Collection;

import fr.brickbreaker.ns.balls.Ball;
import fr.brickbreaker.ns.maths.Vector2f;
import fr.brickbreaker.ns.utils.KeyBoard;
public final class Platform {
   private Rectangle hitbox, up, left, right, c1, c2;
	private float x, speed;
	private boolean magnet;
	private Color color;
	private Image texture;
	private Vector2f velocity;
	
	public Platform(float x, Color color) {
		init(x);
		this.color = color;
	}
	
	public Platform(float x, Image texture) {
		init(x);
		this.texture = texture;
	}
	
	private void init(float x){
		this.x = x;
		speed = 10f;
		velocity = new Vector2f();
		hitbox = new Rectangle((int)x, 410, 50, 12);
		up = new Rectangle(hitbox.x+5, hitbox.y, 40, 12);
		left = new Rectangle(hitbox.x, hitbox.y+5, 5, 7);
		right = new Rectangle(hitbox.x+45, hitbox.y+5, 5, 7);
		c1 = new Rectangle(hitbox.x, hitbox.y, 5, 5);
		c2 = new Rectangle(hitbox.x+45, hitbox.y, 5, 5);
		magnet = true;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public Color getColor() {
		return color;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public Image getTexture() {
		return texture;
	}
	
	public float getX() {
		return x;
	}
	
	public Vector2f getVelocity() {
		return velocity;
	}
	
	public boolean isMagnet() {
		return magnet;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}
	
	public void setX(float x) {
		this.x = x;
		hitbox.x = (int) x;
		up.x = hitbox.x+5;
		left.x = hitbox.x;
		right.x = hitbox.x+45;
		c1.x = hitbox.x;
		c2.x = right.x;
	}
	
	public void setMagnet(boolean magnet) {
		this.magnet = magnet;
	}
	
	public void update(Collection<? extends Ball> balls){
		if(!KeyBoard.isLeft() || !KeyBoard.isRight()) setVelocity(new Vector2f());
		
		if(KeyBoard.isLeft()){
			setVelocity(new Vector2f(-1, 0));
			if(getX() > 39 && isMagnet()){
				for(Ball ball : balls){
					if(ball.getHitbox().intersects(getHitbox())) ball.setX(ball.getX()-getSpeed());
				}
			}
			setX(getX()+getVelocity().getX()*getSpeed());
			if(getX() < 39)setX(39);
		}
		
		if(KeyBoard.isRight()){
			setVelocity(new Vector2f(1, 0));
			if(getX() < 630 && isMagnet()){
				for(Ball ball : balls){
					if(ball.getHitbox().intersects(getHitbox())) ball.setX(ball.getX()+getSpeed());
				}
			}
			setX(getX()+getVelocity().getX()*getSpeed());
			if(getX() > 630) setX(630);
		}
		
		if(KeyBoard.isSpace()){
			for(Ball ball : balls){
				if(ball.getHitbox().intersects(getHitbox())) ball.setVelocity(new Vector2f(getVelocity().getX(), 1));
			}
			setMagnet(false);
		}
		
		for(Ball ball : balls){
			if(ball.getHitbox().intersects(getHitbox())){
				if(isMagnet()) ball.setVelocity(new Vector2f(0, 0));
				else{
					if(ball.getHitbox().intersects(up)) ball.setVelocity(new Vector2f(getVelocity().getX() != 0 ? getVelocity().getX() : ball.getVelocity().getX(), -ball.getVelocity().getY()));
					else if(ball.getHitbox().intersects(c1) || ball.getHitbox().intersects(c2)) ball.setVelocity(new Vector2f(-ball.getVelocity().getX(), -ball.getVelocity().getY()));
					else if(ball.getHitbox().intersects(left) || ball.getHitbox().intersects(right)) ball.setVelocity(new Vector2f(-ball.getVelocity().getX(), ball.getVelocity().getY()));
				}
			}
		}
	}
	
	public void render(Graphics2D gdd){
		if(texture != null) gdd.drawImage(getTexture(), getHitbox().x, getHitbox().y, getHitbox().width, getHitbox().height, null);
		else{
			gdd.setColor(getColor());
			gdd.fillRect(getHitbox().x, getHitbox().y, getHitbox().width, getHitbox().height);
		}
	}
}