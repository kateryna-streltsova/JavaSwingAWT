package uk.javaswing;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class Vehicle {
	private Image img;
	private int x;
	private int y;
	private int speed;

	public void setX(int x) {
		this.x = x;
	}

	public void setV(int v) {
		this.speed = v;
	}

	public Vehicle(int x, int y, int speed, Image img){
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.img = img;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeed() {
		return speed;
	}

	public Image getImg() {
		return img;
	}

	
	public Rectangle getRectange(){
		return new Rectangle(x , y, img.getWidth(null), img.getHeight(null));
	}

	public abstract void move();
}
