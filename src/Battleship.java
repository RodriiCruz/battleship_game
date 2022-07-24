
import static utils.Constant.ARIAL_FONT;
import static utils.Constant.COLUMN;
import static utils.Constant.COLUMN_NUMBERS;
import static utils.Constant.GAME_TITLE;
import static utils.Constant.ROW;
import static utils.Constant.SHOT;
import static utils.Constant.WINDOW_HEIGHT;
import static utils.Constant.WINDOW_WIDTH;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import models.Player;
import panels.BackgroundPanel;
import panels.GamePanel;
import services.BattleshipService;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Battleship extends JFrame {

	private JPanel contentPane;
	private BackgroundPanel bgPanel;
	private GamePanel gamePanel;
	private JSpinner rowSpinner;
	private JSpinner columnSpinner;
	private Player player;
	private BattleshipService battleshipService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Battleship frame = new Battleship();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Battleship() {
		initAttributes();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WINDOW_WIDTH, WINDOW_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setTitle(GAME_TITLE);
		setLocationRelativeTo(null);

		addSpinners();
		addLabels();
		addButton();
		addRowsNumbers(); // TODO mejorar esto

		this.gamePanel = new GamePanel(200, 10, player);
		getContentPane().add(gamePanel);
		gamePanel.setBounds(44, 30, 200, 225);
		gamePanel.setOpaque(false);
		gamePanel.setLayout(null);

		this.bgPanel = new BackgroundPanel(200, 10);
		getContentPane().add(bgPanel);
		bgPanel.setBounds(44, 30, 200, 200);
		bgPanel.setLayout(null);
	}

	/**
	 * Init attributes
	 */
	private void initAttributes() {
		this.player = new Player();
		this.battleshipService = new BattleshipService(player);

		battleshipService.putShips();
	}

	private void addLabels() {
		JLabel lblColumns = new JLabel(COLUMN_NUMBERS);
		lblColumns.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		lblColumns.setEnabled(true);
		lblColumns.setBounds(50, 0, 210, 44);
		contentPane.add(lblColumns);

		JLabel lblColumn = new JLabel(COLUMN);
		lblColumn.setBounds(10, 314, 50, 14);
		contentPane.add(lblColumn);

		JLabel lblRow = new JLabel(ROW);
		lblRow.setBounds(10, 283, 50, 14);
		contentPane.add(lblRow);
	}

	private void addButton() {
		JButton btnShot = new JButton(SHOT);
		btnShot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String row = String.valueOf(rowSpinner.getValue());
				String column = String.valueOf(columnSpinner.getValue());

				battleshipService.shot(row, column);
				gamePanel.repaint();
			}
		});
		btnShot.setBounds(188, 279, 89, 52);
		contentPane.add(btnShot);
	}

	private void addSpinners() {
		rowSpinner = new JSpinner();
		rowSpinner.setBounds(82, 280, 86, 20);
		contentPane.add(rowSpinner);

		columnSpinner = new JSpinner();
		columnSpinner.setBounds(82, 311, 86, 20);
		contentPane.add(columnSpinner);
	}

	private void addRowsNumbers() {

		JLabel zero = new JLabel("0");
		zero.setBounds(30, 31, 10, 16);
		zero.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		contentPane.add(zero);

		JLabel one = new JLabel("1");
		one.setBounds(30, 51, 10, 16);
		one.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		contentPane.add(one);

		JLabel two = new JLabel("2");
		two.setBounds(30, 71, 10, 16);
		two.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		contentPane.add(two);

		JLabel three = new JLabel("3");
		three.setBounds(30, 91, 10, 16);
		three.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		contentPane.add(three);

		JLabel four = new JLabel("4");
		four.setBounds(30, 111, 10, 16);
		four.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		contentPane.add(four);

		JLabel five = new JLabel("5");
		five.setBounds(30, 131, 10, 16);
		five.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		contentPane.add(five);

		JLabel six = new JLabel("6");
		six.setBounds(30, 151, 10, 16);
		six.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		contentPane.add(six);

		JLabel seven = new JLabel("7");
		seven.setBounds(30, 171, 10, 16);
		seven.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		contentPane.add(seven);

		JLabel eight = new JLabel("8");
		eight.setBounds(30, 191, 10, 16);
		eight.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		contentPane.add(eight);

		JLabel nine = new JLabel("9");
		nine.setBounds(30, 211, 10, 16);
		nine.setFont(new Font(ARIAL_FONT, Font.PLAIN, 14));
		contentPane.add(nine);
	}
}
