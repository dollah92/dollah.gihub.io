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

import java.awt.Graphics2D;
public class Game {
    
private GameState state = GameState.MENU;
	private Menu menu = new Menu();
	private Level level;
	private int lvlId;
	
	public Game() {
	}
	
	public void render(Graphics2D gdd){
		switch(state){
		case MENU:
			menu.render(gdd);
			break;
		case LEVEL:
			level.render(gdd);
			break;
		}
	}
	
	public void update(){
		switch(state){
		case MENU:
			menu.update();
			break;
		case LEVEL:
			level.update();
			break;
		}
	}
	
	public GameState getState() {
		return state;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public int getLvlId() {
		return lvlId;
	}
	
	public void setLvlId(int lvlId) {
		this.lvlId = lvlId;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public void setState(GameState state) {
		this.state = state;
	}
	
	public enum GameState{
		MENU, LEVEL;
	}
}
