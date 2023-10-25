import java.util.Random;

public class VoitureFeu2 extends Thread {
	private int pos = 0;
	private int n;
	private static int pos_debut_carrefour = 3;
	private static int pos_fin_carrefour = 6;
	public VoitureFeu2(int n) {
		this.n = n;
	}

	public void traverser_ligne_droite() {
		pos = pos + 1;
		Carrefour.cars2.get(this.n).setLocation(pos*Carrefour.SIZE, 5*Carrefour.SIZE);
	}

	public void run() {
		try {
			sleep(1000*new Random().nextInt(10));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if((pos_debut_carrefour == pos && Carrefour.feu == 2 && !Carrefour.engage) || pos_debut_carrefour != pos) {
				if(pos_debut_carrefour == pos) {
					Carrefour.engage = true;
				}
				traverser_ligne_droite();
			}
			if(pos_fin_carrefour == pos) {
				Carrefour.engage = false;
			}
		}
	}
}