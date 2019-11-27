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

import fr.brickbreaker.ns.button.Button;
import fr.brickbreaker.ns.maths.Vector2f;
import fr.brickbreaker.ns.textures.Textures;
public class BestScoreButton extends Button {

public BestScoreButton() {
		super(200, 270, 300, 50, "BEST SCORE", new Font("Arial", Font.BOLD, 40), new Vector2f(22,40), Color.gray, Color.BLUE);
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

	}

	@Override
	public void onRightClick() {

	}

}
