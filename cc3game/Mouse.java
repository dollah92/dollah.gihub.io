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

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class Mouse implements MouseListener, MouseMotionListener {
  private static Rectangle hitbox = new Rectangle(0,0,1,1);
	private static boolean[] mouseButton = new boolean[50];
	
	private static int click_left = 1, click_right = 3;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		hitbox.x = e.getX()-5;
		hitbox.y = e.getY()-25;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseButton[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseButton[e.getButton()] = false;
	}
	
	public static int getX(){
		return hitbox.x;
	}
	
	public static int getY(){
		return hitbox.y;
	}
	
	public static Rectangle getHitbox(){
		return hitbox;
	}
	
	public static boolean hasLeftClick(){
		return mouseButton[click_left];
	}
	
	public static boolean hasRightClick(){
		return mouseButton[click_right];
	}
}
