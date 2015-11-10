package uk.javaswing;

import javax.swing.ImageIcon;

public class Car extends Vehicle {
	private Road road;
	public Road getRoad() {
		return road;
	}

	public Car(int x, int y, int v, Road road){
		super(x, y, v, new ImageIcon("res/car.png").getImage());
		this.road =road;
	}

	public void move(){
		 int x = getX() + road.bike.getBikeShiftX() + getV();
		 setX(x);
	}
	
	
}
