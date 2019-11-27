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

import fr.brickbreaker.ns.textures.Textures;
public class DefaultBlock  extends Block{
    
	public DefaultBlock(int x, int y) {
		super(x, y, BlockType.DEFAULT_BLOCK, new Color(255, 255, 0));
		super.setTexture(Textures.DEFAULT_BLOCK);
	}

}
