package models;

import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Player {

	private String[][] matriz;
	private Integer hits;
	private Integer shots;

	public Player() {
		this.matriz = new String[10][10];
		this.hits = 0;
		this.shots = 25;
	}

	public String[][] getMatriz() {
		return matriz;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Integer getShots() {
		return shots;
	}

	public void shot() {
		this.shots--;
		checkHits();
		checkShots();
	}

	private void checkHits() {
		if (this.hits == 20) {
			JOptionPane.showMessageDialog(null, "Felicitaciones!\n" + "Hundiste todos los barcos enemigos!");
			System.exit(0);
		}
	}

	private void checkShots() {
		if (this.shots == 0) {
			JOptionPane.showMessageDialog(null,
					"Te quedaste sin disparos!\n" + "Puntuación final: " + this.hits + " de 20.");
			System.exit(0);
		}
	}

	public String getStatus() {
		return "Aciertos: " + hits + "/20  -  Disparos: " + shots;
	}

}
