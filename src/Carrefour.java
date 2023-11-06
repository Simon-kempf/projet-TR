import java.awt.Container;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class Carrefour {
	
	public static int SIZE = 64;
	public static int SIZE_MAX = 10;
	public static int n1 = 10;
	public static int n2 = 10;
	
	public static ArrayList<JLabel> cars1 = new ArrayList<JLabel>();
	public static ArrayList<JLabel> cars2 = new ArrayList<JLabel>();
	public static boolean engage = false;
	public static int feu = 1;
	public static JFrame frame;
	public static JLabel trafficlight1;
	public static JLabel trafficlight2;
	public static Container container;
	
	public static void main(String[] args) throws IOException {
		frame = new JFrame("Carrefour");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    container = frame.getContentPane();
		for(int k = 0; k < n1; k++) {
			JLabel car = new JLabel();
			car.setIcon(new ImageIcon("res/car.png"));
			car.setBounds(5*Carrefour.SIZE, Carrefour.SIZE*Carrefour.SIZE_MAX, Carrefour.SIZE, Carrefour.SIZE);
			cars1.add(car);
			container.add(car);
		}
		for(int k = 0; k < n2; k++) {
			JLabel car = new JLabel();
			car.setIcon(new ImageIcon("res/carV.png"));
			car.setBounds(0, 5*Carrefour.SIZE, Carrefour.SIZE, Carrefour.SIZE);
			cars2.add(car);
			container.add(car);
		}
	    for(int i = 0; i < SIZE_MAX; i++) {
	    	for(int j = 0; j < SIZE_MAX; j++) {
	    		if(i == 4 && j == 4) {
	    			JLabel road1 = new JLabel();
	    			road1.setIcon(new ImageIcon("res/road2.jpg"));
	    			road1.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
	    			container.add(road1);
	    		}
	    		else if(i == 4 && j == 5) {
	    			JLabel road1 = new JLabel();
	    			road1.setIcon(new ImageIcon("res/road2IV.jpg"));
	    			road1.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
	    			container.add(road1);
	    		}
	    		else if(i == 5 && j == 4) {
	    			JLabel road1 = new JLabel();
	    			road1.setIcon(new ImageIcon("res/road2V.jpg"));
	    			road1.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
	    			container.add(road1);
	    		}
	    		else if(i == 5 && j == 5) {
	    			JLabel road1 = new JLabel();
	    			road1.setIcon(new ImageIcon("res/road2I.jpg"));
	    			road1.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
	    			container.add(road1);
	    		}
	    		else if(i == 4) {
	    			JLabel road1 = new JLabel();
	    			road1.setIcon(new ImageIcon("res/road.jpg"));
	    			road1.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
	    			container.add(road1);
	    		}
	    		else if(i == 5) {
	    	        JLabel road2 = new JLabel();
	    			road2.setIcon(new ImageIcon("res/roadI.jpg"));
	    			road2.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
	    			container.add(road2);
	    		}
	    		else if(j == 4) {
	    			JLabel road1 = new JLabel();
	    			road1.setIcon(new ImageIcon("res/roadV.jpg"));
	    			road1.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
	    			container.add(road1);
	    		}
	    		else if(j == 5) {
	    	        JLabel road2 = new JLabel();
	    			road2.setIcon(new ImageIcon("res/roadIV.jpg"));
	    			road2.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
	    			container.add(road2);
	    		}
	    		else if(i == 6 && j == 6) {
	    			trafficlight1 = new JLabel();
	    			trafficlight1.setIcon(new ImageIcon("res/green.jpg"));
	    			trafficlight1.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
	    			container.add(trafficlight1);
	    		}
	    		else if(i == 3 && j == 6) {
	    			trafficlight2 = new JLabel();
	    			trafficlight2.setIcon(new ImageIcon("res/redV.jpg"));
	    			trafficlight2.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
	    			container.add(trafficlight2);
	    		}
	    		else {
		    		JLabel ground = new JLabel();
					ground.setIcon(new ImageIcon("res/ground.jpg"));
					ground.setBounds(i*SIZE, j*SIZE, SIZE, SIZE);
					container.add(ground);
	    		}
	    	}
	    }
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
	    new ChangementFeu().start();
	    for(int i = 0; i < n1; i++) {
	    	new VoitureFeu1(i).start();
	    }
	    for(int i = 0; i < n2; i++) {
	    	new VoitureFeu2(i).start();
	    }
		
	}

}
