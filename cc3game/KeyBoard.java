/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.utils;

/**
 *
 * @author Jhomar
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyBoard implements KeyListener {
    private static boolean[] keyPressed = new boolean[256];
	private static int left = 37, right = 39, pause = 0, space = 32;
	
	@Override
	public void keyPressed(KeyEvent e) {
		keyPressed[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyPressed[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	public static boolean isLeft(){
		return keyPressed[left];
	}
	
	public static boolean isRight(){
		return keyPressed[right];
	}
	
	public static boolean isPause(){
		return keyPressed[space];
	}
	
	public static boolean isSpace(){
		return keyPressed[space];
	}
}