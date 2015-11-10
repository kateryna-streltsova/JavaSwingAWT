package uk.javaswing;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class Vehicle {
	private Image img;
	private int x;
	private int y;
	private int v;

	public void setX(int x) {
		this.x = x;
	}

	public void setV(int v) {
		this.v = v;
	}

	public Vehicle(int x, int y, int v, Image img){
		this.x = x;
		this.y = y;
		this.v = v;
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

	public int getV() {
		return v;
	}

	public Image getImg() {
		return img;
	}

	
	public Rectangle getRectange(){
		return new Rectangle(x , y, img.getWidth(null), img.getHeight(null));
	}

	public abstract void move();
}
