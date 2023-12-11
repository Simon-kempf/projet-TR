import java.util.Random;

public class VoitureFeu1 extends Thread {
	private int n_dir = 1;
	private int pos;
	private int n;
	private int pos_debut_carrefour;
	private int pos_fin_carrefour;
	private boolean inv;
	public VoitureFeu1(int n, boolean inv) {
		this.inv = inv;
		if(inv) {
			this.pos = -1;
			this.pos_debut_carrefour = 6;
			this.pos_fin_carrefour = 3;
		}
		else {
			this.pos = Carrefour.SIZE_MAX;
			this.pos_debut_carrefour = 3;
			this.pos_fin_carrefour = 6;
		}
		this.n = n;
	}

	public void traverser_ligne_droite() {
		if(inv) {
			pos = pos + 1;
			Carrefour.cars3.get(this.n).setLocation(4*Carrefour.SIZE, pos*Carrefour.SIZE);
		}
		else {
			pos = pos - 1;
			Carrefour.cars1.get(this.n).setLocation(5*Carrefour.SIZE, pos*Carrefour.SIZE);
		}
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
			if(pos_fin_carrefour == pos && Carrefour.feu == n_dir) {
				try {
					Carrefour.engage.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(Carrefour.feu == n_dir) {
					traverser_ligne_droite();
				}
				else {
					Carrefour.engage.release();
				}
			}
			else if(pos_fin_carrefour != pos) {
				traverser_ligne_droite();
			}
			if(pos_debut_carrefour == pos) {
				Carrefour.engage.release();
			}
		}
	}
}