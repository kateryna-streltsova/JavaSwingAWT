package uk.javaswing;
import javax.swing.JFrame;


public class Main {
	private static  int frameWidth;
	private static  int frameHeight;

	public static void main(String[] args) {
		JFrame f =new JFrame ("Bike rally");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(700, 580);
		f.add(new Road());
		f.setVisible(true);
		frameWidth=(int) f.getSize().getWidth();
		frameHeight=(int) f.getSize().getHeight();
	}

	public static int getFrameWidth(){
		return frameWidth;
	}
	
	public static int getFrameHeight(){
		return frameHeight;
	}
	
}
