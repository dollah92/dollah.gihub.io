/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns;

/**
 *
 * @author Sublino, Johmar
 *          
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.brickbreaker.ns.game.Game;
import fr.brickbreaker.ns.utils.KeyBoard;
import fr.brickbreaker.ns.utils.Mouse;


public class BrickBreaker extends JPanel {
private static final long serialVersionUID = 26122016L;
	
	private JFrame frame;
	private boolean running;
	private static Game game;
	
	public BrickBreaker() {
		game = new Game();
		
		frame = new JFrame("Christmas Brick Breaker");
		frame.setSize(720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(this);
		frame.setBackground(new Color(150, 20, 20));
		
		
                Mouse mouse = new Mouse();
		
                frame.addMouseListener(mouse);
		frame.addMouseMotionListener(mouse);
		frame.addKeyListener(new KeyBoard());
		frame.setVisible(true);
	}
	
	public void start(){
		running = true;
		run();
	}
	
	public void stop(){
		running = false;
	}
	
	public void exit(){
		System.exit(0);
	}
	
	public void run(){
		long lastTickTime = System.nanoTime(); 
		long lastRenderTime = System.nanoTime(); 
		double tickTime = 1000000000.0/60.0; 
		double renderTime = 1000000000.0/120; 
		int tps = 0; 
		int fps = 0; 
		long timeur = System.currentTimeMillis(); 

		
		while(running){
			if(!frame.isVisible()) stop();

			if(System.nanoTime() -lastTickTime > tickTime){ 
				lastTickTime+=tickTime; 
				update(); 
				tps++; 
                    	}else if(System.nanoTime() -lastRenderTime > renderTime){
				lastRenderTime+=renderTime;
				frame.repaint();
				fps++; 
			}
			
			if(System.currentTimeMillis() - timeur > 1000){
				timeur = System.currentTimeMillis();
				frame.setTitle("Christmas Brick Breaker ");
				tps = 0; fps = 0;
			}
		}
		exit();
	}
	
	public void update(){
		game.update();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gdd = (Graphics2D)g;
		game.render(gdd);
	}
	
	public static Game getGame() {
		return game;
	}
	
	public static void main(String[] args) {
		BrickBreaker brickBreacker = new BrickBreaker();
		brickBreacker.start();
	}
}
