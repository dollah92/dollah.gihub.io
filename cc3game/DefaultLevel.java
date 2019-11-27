/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.game.level;

/**
 *
 * @author Jhomar
 */
import fr.brickbreaker.ns.balls.DefaultBall;
import fr.brickbreaker.ns.blocks.DefaultBlock;
import fr.brickbreaker.ns.game.Level;
public class DefaultLevel extends Level {
   public DefaultLevel() {
		super("Level #001");
		super.addBall(new DefaultBall(350, 401));
		
		for(int x = 40; x < 670; x+=64){
			for(int y = 20; y < 100; y+=21){
				super.addBlock(new DefaultBlock(x, y));
			}
		}
	}

	@Override
	public Level newLevel() {
		return new DefaultLevel();
	}

}
