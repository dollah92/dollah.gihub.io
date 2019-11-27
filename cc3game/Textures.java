/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.textures;

/**
 *
 * @author Jhomar
 */
import java.awt.Image;

import javax.swing.ImageIcon;

public class Textures {
   public static final Image Ball_DEFAULT = new Textures("balls/ball_0").getTexture();
	public static final Image BUTTON_1_0 = new Textures("button/button_1_0").getTexture();
	public static final Image BUTTON_1_1 = new Textures("button/button_1_1").getTexture();
	public static final Image DEFAULT_BLOCK = new Textures("blocks/default_block").getTexture();
	public static final Image PLATFORM = new Textures("platform/platform").getTexture();
	public static final Image LOGO = new Textures("logo/logo").getTexture();
	
	private final Image texture;
	
	private Textures(String path) {
		this.texture = new ImageIcon(getClass().getResource("/asset/textures/"+path+".png")).getImage();
	}
	
	private Image getTexture() {
		return texture;
	}
}
