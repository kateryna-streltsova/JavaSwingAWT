package uk.javaswing;

import javax.swing.ImageIcon;

public class Car extends Vehicle {
	private Road road;
	public Road getRoad() {
		return road;
	}

	public Car(int x, int y, int speed, Road road){
		super(x, y, speed, new ImageIcon("res/car.png").getImage());
		this.road =road;
	}

	public void move(){
		 int x = getX() + road.bike.getBikeShiftX() + getSpeed();
		 setX(x);
	}
	
	
}
