package uk.javaswing;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener, Runnable {
	private boolean isCollision; 
	static Image img;
	Timer mainTimer = new Timer (20, this);

	public Road(){
		img = new ImageIcon("res/road1.png").getImage();
		mainTimer.start();
		addKeyListener(new MyKeyAdapter());
		carsThread.start();
		setFocusable(true);
	}
	
	Bike bike = new Bike(30, 165, 5);
	Ambulance ambulance;

	Thread carsThread = new Thread(this);
	List<Car> cars = new ArrayList<Car>();

	private class MyKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			bike.keyPressed(e);
		}

		public void keyReleased(KeyEvent e){
			bike.keyReleased(e);
		}
	}

	public void paint(Graphics g){
		//g=(Graphics2D)g;
		g.drawImage(img, bike.getBikeShiftX(), 0, null);
		g.drawImage(bike.getImg(), bike.getX(), bike.getY(), null);
		Font font = new Font ("Courier New", Font.BOLD, 16);
		g.setFont(font);
		g.drawString("Bike speed is: "+bike.getSpeed(), 15, 25);

		Iterator <Car> iterator = cars.iterator();
		while (iterator.hasNext()){
			Car car = iterator.next();
			if(car.getX() > Main.getFrameWidth() +10 ||car.getX() < - Main.getFrameWidth() - 10){
				iterator.remove();
			}else{
				g.drawImage(car.getImg(), car.getX(), car.getY(), null);
			}
		}
		if(isCollision){
			g.drawImage(ambulance.getImg(), ambulance.getX(), ambulance.getY(), null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(isCollision){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.exit(0); 
		}
		bike.move();
		Iterator <Car> iterator = cars.iterator();
		while (iterator.hasNext()){
			Car car = iterator.next();
			car.move();
		}

		isCollision = collision();
		 if(isCollision){
			ambulance = new Ambulance(bike.getX(), Bike.MAX_BOTTOM-50, 0, this);
			repaint();
			JOptionPane.showMessageDialog(null, "You crashed a car");
		}else{
		   repaint();
		}
	}

	private boolean collision(){
		Iterator <Car> iterator = cars.iterator();
		while (iterator.hasNext()){
			Car car = iterator.next();
			if(bike.getRectange().intersects(car.getRectange())){
				return true;
			}
		}
		return false;
	}

	@Override
	public void run() {
		while(true){
			Random rand = new Random ();
			try{
				Thread.sleep(rand.nextInt(4000));
				int minY = Main.getFrameHeight()/3;
				int maxY = minY*2;
				cars.add(new Car(Main.getFrameWidth(), rand.nextInt((maxY - minY) + 1) + minY, 0, this));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}
