package uk.javaswing;
import javax.swing.JFrame;


public class Main {
	private static  int frameWidth;
	private static  int frameHeight;

	public static void main(String[] args) {
		JFrame frame =new JFrame ("Bike rally");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 580);
		frame.add(new Road());
		frame.setVisible(true);
		frameWidth=(int) frame.getSize().getWidth();
		frameHeight=(int) frame.getSize().getHeight();
	}

	public static int getFrameWidth(){
		return frameWidth;
	}
	
	public static int getFrameHeight(){
		return frameHeight;
	}
	
}
