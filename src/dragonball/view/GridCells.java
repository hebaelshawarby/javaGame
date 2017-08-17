package dragonball.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dragonball.model.cell.Cell;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class GridCells extends JPanel {

	private final int NUMBER_CELLS_PER_SIDE = 10;
	private final int CELL_SIZE = 45;
	private final int BOARD_SIZE = CELL_SIZE * NUMBER_CELLS_PER_SIDE;
	private Game game;

	private JButton[][] mapButton = new JButton[10][10];

	public GridCells(Game game) {
		this.game = game;
		setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
		setLayout(new GridLayout(10, 10));
		Cell[][] map = this.game.getWorld().getMap();
		int row = game.getWorld().getPlayerRow();
		int column = game.getWorld().getPlayerColumn();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == column && i == row)
					mapButton[i][j] = new JButton("Player");
				else 
					if(map[i][j].toString().equals("[b]"))
						mapButton[i][j] = new JButton("BOSS");
				else
					mapButton[i][j] = new JButton();
				mapButton[i][j].setActionCommand(mapButton[i][j].getText());
				mapButton[i][j].setFocusable(true);
				add(mapButton[i][j]);

			}
		}
	}
	
	public JButton[][] getMapButton() {
		return mapButton;
	}

	public void setMapButton(JButton[][] mapButton) {
		this.mapButton = mapButton;
	}

	/*
	 * show dialog bow when interaction occurs, to ask for user's interaction
	 * choice return string choice
	 */
	/**
	 * public String askSkillChoice(Opponent opponent) { int buttonPressed; // 0
	 * joke, 1 fight, 2 steps String choice = ""; String message = ""; String
	 * title = ""; String[] options = { "" };
	 * 
	 * if (opponent instanceof Helper) { Helper helper = (Helper) opponent;
	 * options = helper.getOptions(); title = "Helper encountered"; message =
	 * "Someone wants to help you ! \n" + "Choose an option :"; } else if
	 * (opponent instanceof Enemy) { Enemy enemy = (Enemy) opponent; options =
	 * enemy.getOptions(); title = "Enemy encountered"; message =
	 * "This person will not let you pass !\n" + "Try to beat him with :"; }
	 * 
	 * buttonPressed = JOptionPane.showOptionDialog(this, message, title,
	 * JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
	 * options, options[0]); switch (buttonPressed) { case 0: choice = "joke";
	 * break; case 1: choice = "fight"; break; case 2: choice = "steps"; break;
	 * default: ; } return choice; }
	 * 
	 * /* update the board display when turn is played
	 */
	/**
	 * public void update(Observable observable, Object object) { Board board =
	 * (Board) observable;
	 * 
	 * if (object == null) { Position activePosition =
	 * board.getPlayer().getPosition(); int scope =
	 * board.getPlayer().getVisionScope(); for (int i = 0; i <
	 * NUMBER_CELLS_PER_SIDE; i++) { for (int j = 0; j < NUMBER_CELLS_PER_SIDE;
	 * j++) {
	 * 
	 * tileRenderers[i][j].update(board.getTile(i, j), new Position(i, j),
	 * activePosition, scope); } } } }
	 * 
	 * public Icons getIcons() { return icons; }
	 **/
}
