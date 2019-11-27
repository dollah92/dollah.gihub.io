/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.button.menu;

/**
 *
 * @author Jhomar
 */
import java.awt.Color;
import java.awt.Font;

import fr.brickbreaker.ns.BrickBreaker;
import fr.brickbreaker.ns.audio.Sound;
import fr.brickbreaker.ns.button.Button;
import fr.brickbreaker.ns.game.LevelType;
import fr.brickbreaker.ns.game.Game.GameState;
import fr.brickbreaker.ns.maths.Vector2f;
import fr.brickbreaker.ns.textures.Textures;
public class StartButton extends Button{
    

	public StartButton() {
		super(200, 200, 300, 50, "START", new Font("Arial", Font.BOLD, 40), new Vector2f(85, 40), Color.GRAY, Color.BLUE);
		super.setImage(Textures.BUTTON_1_0);
	}

	@Override
	public void mouseEntered() {
		super.setImage(Textures.BUTTON_1_1);
	}

	@Override
	public void mouseExited() {
		super.setImage(Textures.BUTTON_1_0);
	}

	@Override
	public void onLeftClick() {
		BrickBreaker.getGame().setLevel(LevelType.getLevel(BrickBreaker.getGame().getLvlId()));
		BrickBreaker.getGame().setState(GameState.LEVEL);
		Sound.MENU_SOUND.stop();
	}

	@Override
	public void onRightClick() {
		
	}

}
