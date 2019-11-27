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
import java.util.Collection;

import fr.brickbreaker.ns.blocks.Block;
import fr.brickbreaker.ns.game.Level;
import fr.brickbreaker.ns.maths.Vector2f;
import fr.brickbreaker.ns.textures.Textures;
public class DefaultBall extends Ball {
 
    public DefaultBall(int x, int y) {
		super(x, y, 10, 10, BallType.DEFAULT, Textures.Ball_DEFAULT);
		super.setSpeed(5.0f);
	}

	@Override
	public void update(Collection<? extends Block> blocks, Level level) {
		setX(getX()+(getVelocity().getX()*getSpeed()));
		setY(getY()+(getVelocity().getY()*getSpeed()));
		for(Block block : blocks){
			if(!block.isDestroy()){
				if(block.getHitbox().intersects(getHitbox())){
					block.action(this, level);
					break;
				}
			}
		}
		if(getX() < 39 || getX() > 670){
			setX(getX() < 39 ? 39 : 670);
			setVelocity(new Vector2f(-getVelocity().getX(), getVelocity().getY()));
		}
		if(getY() < 20){
			setY(20);
			setVelocity(new Vector2f(getVelocity().getX(), -getVelocity().getY()));
		}
		if(getY() > 425) setDestroy(true);
	}

}
