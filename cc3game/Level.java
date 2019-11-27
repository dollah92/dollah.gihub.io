/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.game;

/**
 *
 * @author Jhomar
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.brickbreaker.ns.BrickBreaker;
import fr.brickbreaker.ns.audio.Sound;
import fr.brickbreaker.ns.balls.Ball;
import fr.brickbreaker.ns.balls.DefaultBall;
import fr.brickbreaker.ns.blocks.Block;
import fr.brickbreaker.ns.game.Game.GameState;
import fr.brickbreaker.ns.platform.Platform;
import fr.brickbreaker.ns.textures.Textures;

public abstract class Level {
   private final List<Ball> balls = new ArrayList<>();
	private final List<Block> blocks = new ArrayList<>();
	private final Platform platform = new Platform(330, Textures.PLATFORM);
	private final String levelName;
	private int nbBalls = 3, score = 0;
	
	public Level(String levelName) {
		this.levelName = levelName;
	}
	
	public Collection<? extends Ball> getBalls() {
		return balls;
	}
	
	public Collection<? extends Block> getBlocks() {
		return blocks;
	}
	
	public String getLevelName() {
		return levelName;
	}
	
	public int getLife() {
		return nbBalls;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score){
		this.score+=score;
	}
	
	public void removeScore(int score){
		this.score+=score;
	}
	
	public void addBall(Ball ball){
		balls.add(ball);
	}
	
	public void addBlock(Block block){
		blocks.add(block);
	}
	
	public abstract Level newLevel();
	
	public void update(){
		Sound.LEVEL_SOUND.start();
		if(blocks.isEmpty()){
			restart();
		}else{
			for(Ball ball : getBalls()) ball.update(blocks, this);
			for(Block block : getBlocks()) block.update();
			platform.update(balls);
		
			for(int i = 0; i < balls.size(); i++){
				if(balls.get(i).isDestroy()) balls.remove(balls.get(i));
			}
		
			if(balls.isEmpty()){
				if(nbBalls > 0){
					platform.setMagnet(true);
					platform.setX(330);
					addBall(new DefaultBall(350, 401));
				}
				if (nbBalls > -1) nbBalls--;
			}
		
			if(nbBalls == -1){
				restart();
			}
		}
	}
	
	private int time = 5*60;
	
	public void restart(){
		time--;
		if(time == 0){
			Sound.LEVEL_SOUND.stop();
			BrickBreaker.getGame().setState(GameState.MENU);
		}
	}
	
	public void render(Graphics2D gdd){
		gdd.setColor(new Color(0,0,0));
		gdd.fill3DRect(39, 20, 641, 415, true);
		for(Ball ball : getBalls()) ball.render(gdd);
		for(Block block : getBlocks()) block.render(gdd);
		platform.render(gdd);
		
		if(nbBalls > -1 && !blocks.isEmpty()){
			gdd.setFont(new Font("Arial", Font.ITALIC, 20));
			gdd.setColor(new Color(0, 255, 0));
			gdd.drawString("Scores : "+getScore(), 40, 430);
			gdd.setFont(new Font("Arial", Font.ITALIC, 20));
			gdd.setColor(new Color(0, 255, 255));
			gdd.drawString("Ball(s) : "+nbBalls, 590, 430);
		}else{
			gdd.setFont(new Font("Arial", Font.BOLD, 40));
			gdd.setColor(new Color(200, 0, 200));
			gdd.drawString("GAME OVER", 225, 200);
			gdd.setFont(new Font("Arial", Font.ITALIC, 20));
			gdd.setColor(new Color(0, 255, 0));
			gdd.drawString("Scores : "+getScore(), 290, 220);
		}
	}
}