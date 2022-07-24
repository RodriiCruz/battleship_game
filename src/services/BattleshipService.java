package services;

import static utils.Constant.DAMAGED_PART;
import static utils.Constant.DAMAGED_SHIP;
import static utils.Constant.INTACT_PART;
import static utils.Constant.SHOT_IN_WATER;
import static utils.Constant.SUNKEN_SHIP;
import static utils.Constant.WATER;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Player;

/**
 *
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class BattleshipService {

	private Player player;
	private List<Integer> busyRows;

	public BattleshipService(Player player) {
		this.player = player;
		this.busyRows = new ArrayList<>();
	}

	/**
	 * completa la matriz con agua
	 */
	private void placeWater() {
		for (int i = 0; i < player.getMatriz().length; i++) {
			for (int j = 0; j < player.getMatriz().length; j++) {
				player.getMatriz()[i][j] = WATER;
			}
		}
	}

	/**
	 * Coloca el barco en la matriz
	 */
	public void putShips() {
		this.placeWater();
		int shipSize = 4;

		for (int i = 1; i < 5; i++) {
			this.locateShips(player.getMatriz(), i, shipSize);
			shipSize--;
		}
	}

	/**
	 * Ubica un barco por fila de la matriz
	 */
	private void locateShips(String[][] matriz, int numberOfShips, int shipSize) {
		int row = 0;

		for (int i = 0; i < numberOfShips; i++) {
			do {
				row = (int) (Math.random() * 10);
			} while (busyRows.contains(row));

			int column = (int) (Math.random() * 10);
			column = (column + shipSize) > 10 ? column = column - shipSize : column;

			busyRows.add(row);
			this.drawShip(matriz, row, column, shipSize);
		}
	}

	/**
	 * Dibuja el barco con ceros (0)
	 */
	private void drawShip(String[][] matriz, int row, int column, int shipSize) {

		for (int i = 0; i < shipSize; i++) {
			matriz[row][column + i] = INTACT_PART;
		}
	}

	public void shot(String stringRow, String stringColumn) {
		String[][] matriz = player.getMatriz();
		int row, column;
		try {
			row = Integer.parseInt(stringRow);
			column = Integer.parseInt(stringColumn);

			if (matriz[row][column].equals(WATER) || matriz[row][column].equals(DAMAGED_PART)) {
				JOptionPane.showMessageDialog(null, SHOT_IN_WATER);
			}

			if (matriz[row][column].equals(INTACT_PART)) {
				matriz[row][column] = DAMAGED_PART;

				if (!this.isSunken(row)) {
					JOptionPane.showMessageDialog(null, DAMAGED_SHIP);
				}

				player.setHits(player.getHits() + 1);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, SHOT_IN_WATER);
		}

		player.shot();
	}

	/**
	 * Comprueba si quedan barcos, o restos de barcos, en la fila indicada para
	 * saber si un barco fue averiado o hundido
	 */
	private boolean isSunken(int row) {
		boolean isSunken = true;

		for (int i = row; i == row; i++) {
			for (int j = 0; j < player.getMatriz().length; j++) {
				if (player.getMatriz()[row][j].equals(INTACT_PART)) {
					isSunken = false;
				}
			}
		}

		if (isSunken) {
			JOptionPane.showMessageDialog(null, SUNKEN_SHIP);
		}

		return isSunken;
	}
}
