/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.audio;

/**
 *
 * @author Sublino, Johmar
 */

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Sound implements Runnable{
    
public final static Sound MENU_SOUND = new Sound("menu_sound");
	public final static Sound LEVEL_SOUND = new Sound("level_sound");
	public final static Sound HIT_SOUND = new Sound("hit_sound");
	
	String path = "";
	private SourceDataLine line;
	private Thread thread;
	private boolean running;
	
	private Sound(String pPath){
		path = pPath;
	}
	
	public void start(){
		if(!running){
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void stop(){
		if(running){
			running = false;
		}
	}
	
	@Override
	public void run() {
		AudioInputStream audioInputStream;
		AudioFormat audioFormat;
			
		try {
			audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/asset/sounds/"+path+".wav"));
		}catch (UnsupportedAudioFileException | IOException e) {
			return;
		}
			
		audioFormat = audioInputStream.getFormat();
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
			
		try { 
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(audioFormat);
		}catch (LineUnavailableException e){
			return;
		}
			
		line.start();
			
		try {
			byte bytes[] = new byte[64];
			int bytesRead = 100;
			
			while(((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) && running){
				line.write(bytes, 0, bytesRead);
			}
			running = false;
		}catch (IOException e) {
			return;
		}
	}
}