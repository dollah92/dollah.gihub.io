/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.button;

/**
 *
 * @author Jhomar
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import fr.brickbreaker.ns.maths.Vector2f;
import fr.brickbreaker.ns.utils.Mouse;
public abstract class Button {

    private Rectangle hitbox;
	private String title;
	private Vector2f titlePosition;
	private Color colorFond, colorTitle;
	private Image texture;
	private Font font;
	
	public Button(int x, int y, int l, int la, String title, Font font, Vector2f titlePosition, Color colorFond, Color colorTitle) {
		hitbox = new Rectangle(x, y, l, la);
		this.title = title;
		this.colorFond = colorFond;
		this.colorTitle = colorTitle;
		this.titlePosition = titlePosition;
		this.font = font;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Vector2f getTitlePosition() {
		return titlePosition;
	}
	
	public Image getTexture() {
		return texture;
	}
	
	public Color getColorFond() {
		return colorFond;
	}
	
	public Color getColorTitle() {
		return colorTitle;
	}
	
	public Font getFont() {
		return font;
	}
	
	protected void setImage(Image image){
		texture = image;
	}
	
	public void setColorFond(Color color) {
		this.colorFond = color;
	}
	
	public void setColorTitle(Color colorTitle) {
		this.colorTitle = colorTitle;
	}
	
	public void setTexture(Image texture) {
		this.texture = texture;
	}
	
	public void setTitle(String title, Vector2f titlePosition) {
		this.title = title;
		this.titlePosition = titlePosition;
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
	public void update(){
		if(Mouse.getHitbox().intersects(getHitbox())){
			mouseEntered();
			if(Mouse.hasLeftClick()) onLeftClick();
			if(Mouse.hasRightClick()) onRightClick();
		}else mouseExited();
	}
	
	public void render(Graphics2D gdd){
		if(texture != null) gdd.drawImage(texture, hitbox.x, hitbox.y, hitbox.width, hitbox.height, null);
		else{
			gdd.setColor(colorFond);
			gdd.fillRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
		}
		gdd.setColor(colorTitle);
		gdd.setFont(font);
		gdd.drawString(title, hitbox.x+titlePosition.getX(), hitbox.y+titlePosition.getY());
	}
	
	public abstract void mouseEntered();
	
	public abstract void mouseExited();
	
	public abstract void onLeftClick();
	public abstract void onRightClick();
	
}
