/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.brickbreaker.ns.maths;

/**
 *
 * @author Jhomar
 */
public class Vector2f {
    public float x, y;
	
	public Vector2f() {
		this(0.0f, 0.0f);
	}
	
	public Vector2f(Vector2f vector) {
		this(vector.getX(), vector.getY());
	}
	
	public Vector2f(float x, float y) {
		set(x, y);
	}
	
	//***********************************
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	//************************************
	public Vector2f set(float x, float y){
		setX(x);
		setY(y);
		return this;
	}
	
	public Vector2f set(Vector2f vector){
		setX(vector.getX());
		setY(vector.getY());
		return this;
	}
	
	public Vector2f setX(float x) {
		this.x = x;
		return this;
	}
	
	public Vector2f setY(float y) {
		this.y = y;
		return this;
	}
	
	//************************************
	public Vector2f add(float x, float y){
		addX(x);
		addY(y);
		return this;
	}
	
	public Vector2f add(Vector2f vector){
		addX(vector.getX());
		addY(vector.getY());
		return this;
	}
	
	public Vector2f addX(float x){
		this.x += x;
		return this;
	}
	
	public Vector2f addY(float y){
		this.y += y;
		return this;
	}
	
	//***********************************
	public Vector2f sub(float x, float y){
		subX(x);
		subY(y);
		return this;
	}
	
	public Vector2f sub(Vector2f vector){
		subX(vector.getX());
		subY(vector.getY());
		return this;
	}
	
	public Vector2f subX(float x){
		this.x -= x;
		return this;
	}
	
	public Vector2f subY(float y){
		this.y -= y;
		return this;
	}
	
	//***********************************
	public Vector2f mul(float x, float y){
		mulX(x);
		mulY(y);
		return this;
	}
	
	public Vector2f mul(Vector2f vector){
		mulX(vector.getX());
		mulY(vector.getY());
		return this;
	}
	
	public Vector2f mulX(float x){
		this.x *= x;
		return this;
	}
	
	public Vector2f mulY(float y){
		this.y *= y;
		return this;
	}
	
	//***********************************
	public Vector2f div(float x, float y){
		divX(x);
		divY(y);
		return this;
	}
	
	public Vector2f div(Vector2f vector){
		divX(vector.getX());
		divY(vector.getY());
		return this;
	}
	
	public Vector2f divX(float x){
		this.x /= x;
		return this;
	}
	
	public Vector2f divY(float y){
		this.y /= y;
		return this;
	}
}


