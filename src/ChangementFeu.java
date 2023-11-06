import java.io.IOException;
import javax.swing.ImageIcon;

public class ChangementFeu extends Thread {
	static int duree_feu = 3;
	public ChangementFeu() throws IOException {

	}

	public void attendre(int duree_feu) {
		try {
			sleep(duree_feu * 1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public void run() {
		Carrefour.feu = 1;
		while (true) {
			attendre(duree_feu);
			if(Carrefour.feu == 1) {
				Carrefour.feu = 2;
				Carrefour.trafficlight2.setIcon(new ImageIcon("res/greenV.jpg"));
				Carrefour.trafficlight1.setIcon(new ImageIcon("res/red.jpg"));
			}
			else {
				Carrefour.feu = 1;
				Carrefour.trafficlight1.setIcon(new ImageIcon("res/green.jpg"));
				Carrefour.trafficlight2.setIcon(new ImageIcon("res/redV.jpg"));
			}
		}
	}
}