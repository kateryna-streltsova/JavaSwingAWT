package uk.javaswing;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Bike extends Vehicle  {
	public Bike(int x, int y, int v) {
		super(x, y, v,  new ImageIcon("res/cycleRider.png").getImage());
	}

	
	private int yUp = -15;
	private int yDown = 40;
	protected static final int MAX_V = 40;
	protected static final int MAX_TOP = 120;
	protected static final int MAX_BOTTOM = 350;
	
	private int dv;	
	private int shiftX;

	public int getBikeShiftX() {
		return shiftX;
	}
   
	private int shiftY;

	private int getBikeShiftY(int shift){
		shiftY = 0;
		shiftY = getY() + shift;
		return shiftY;
	}

		
	public void move(){
		int v = getV();
		int y = getY();
		setV(v + dv);
		if(v >= MAX_V){
			setV(MAX_V);
		}
 
		if(v <= 0){
			setV(0); 
		}
		if(y <= MAX_TOP){
			setY(MAX_TOP);
		}
		if(y >= MAX_BOTTOM){
			setY(MAX_BOTTOM);
		}
	    int roadLength = Road.img.getWidth(null);
	   if(roadLength + shiftX > Main.getFrameWidth()){
		    shiftX -= v;
	   }else{
		   shiftX = 0;
	   }
	}
	
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			dv = 5;
		}if(key == KeyEvent.VK_LEFT){
			dv = -5;
		}if(key == KeyEvent.VK_UP){
			setY(getBikeShiftY(yUp));
		}if(key == KeyEvent.VK_DOWN){
			setY(getBikeShiftY(yDown));
		}
 	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT ||key== KeyEvent.VK_LEFT){
			dv = 0;
		}
		if(key == KeyEvent.VK_UP){
			setY(getY()-yUp);
		}
		if(key== KeyEvent.VK_DOWN){
			setY(getY()-yDown);
		}
	}

}
