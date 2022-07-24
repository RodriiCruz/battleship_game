package panels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class BackgroundPanel extends JPanel {

	private Color backgroundColor;
	private Integer unitSize;
	private Integer quantity;
	private Integer margin;

	public BackgroundPanel(Integer maxSize, Integer quantity) {
		this.backgroundColor = Color.getHSBColor(0, 109, 232);
		this.quantity = quantity;
		this.unitSize = maxSize / quantity;
		this.margin = (maxSize % quantity) / 2;
	}

	@Override
	public void paint(Graphics pinter) {
		super.paint(pinter);
		pinter.setColor(backgroundColor);

		for (int i = 0; i < quantity; i++) {
			for (int j = 0; j < quantity; j++) {
				pinter.fillRect(margin + i * unitSize, margin + j * unitSize, unitSize, unitSize);
			}
		}
	}
}
