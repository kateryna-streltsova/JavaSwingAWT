package uk.javaswing;

import javax.swing.ImageIcon;

public class Ambulance extends Vehicle {
	private Road road;
	public Road getRoad() {
		return road;
	}


	public Ambulance(int x, int y, int v,  Road road) {
		super(x, y, v,  new ImageIcon("res/ambulance.png").getImage());
		this.road =road;
	}

	@Override
	public void move() {
		 int x = road.bike.getX();
		 setX(x);		
	}

}
