package panels;

import static utils.Constant.ARIAL_FONT;
import static utils.Constant.DAMAGED_PART;
import static utils.Constant.INTACT_PART;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import models.Player;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class GamePanel extends JPanel {

	private Color shipColor;
	private Color damagedShip;
	private Integer unitSize;
	private Integer quantity;
	private Integer margin;
	private Player player;

	public GamePanel(Integer maxSize, Integer quantity, Player player) {
		this.shipColor = Color.BLACK;
		this.damagedShip = Color.RED;
		this.quantity = quantity;
		this.unitSize = maxSize / quantity;
		this.margin = (maxSize % quantity) / 2;
		this.player = player;
	}

	@Override
	public void paint(Graphics pinter) {
		super.paint(pinter);

		for (int i = 0; i < quantity; i++) {
			for (int j = 0; j < quantity; j++) {
				if (player.getMatriz()[i][j].equals(DAMAGED_PART)) {
					pinter.setColor(damagedShip);
					pinter.fillRect(margin + j * unitSize, margin + i * unitSize, unitSize - 1, unitSize - 1);
				}

				if (player.getMatriz()[i][j].equals(INTACT_PART)) {
					pinter.setColor(shipColor);
					pinter.fillRect(margin + j * unitSize, margin + i * unitSize, unitSize - 1, unitSize - 1);
				}
			}
		}

		pinter.setColor(Color.BLACK);
		pinter.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		pinter.drawString(player.getStatus(), 0, 220);
	}

}
