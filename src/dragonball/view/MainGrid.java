package dragonball.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import dragonball.model.cell.Cell;
import dragonball.model.game.Game;
import dragonball.model.player.Player;

public class MainGrid extends JFrame {
	private Game game;
	private GridInfo info;
	private GridCells grid;
	private GridButtons buttons;

	public MainGrid(Game game) {
		this.game = game;
		info = new GridInfo();
		buttons = new GridButtons();
		grid = new GridCells(game);
		requestFocusInWindow();
		setLayout(new BorderLayout());
		add(grid, BorderLayout.CENTER);
		add(buttons, BorderLayout.NORTH);
		add(info, BorderLayout.SOUTH);
		pack();
		setSize(1200, 700);
		// setMinimumSize(getSize());
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		requestFocus();
		setLocationRelativeTo(null);

	}

	public void updatePlayersInfo(Player player) {
		if (player != null && player.getActiveFighter() != null) {
			info.getvFightersName().setText(player.getActiveFighter().getName());
			info.getvAbilityPoints().setText("" + player.getActiveFighter().getAbilityPoints());
			info.getvBlastDamage().setText("" + player.getActiveFighter().getBlastDamage());
			info.getvDragonBalls().setText("" + player.getDragonBalls());
			info.getvHealthPoints().setText("" + player.getActiveFighter().getHealthPoints());
			info.getvKi().setText("" + player.getActiveFighter().getKi());
			info.getvPhysicalDamage().setText("" + player.getActiveFighter().getPhysicalDamage());
			info.getvSenzuBeans().setText("" + player.getSenzuBeans());
			info.getvStamina().setText("" + player.getActiveFighter().getStamina());
			info.getvPlayersLevel().setText("" + player.getActiveFighter().getLevel());
		}
	}

	public void updatePalyersName(String x) {
		this.getButtons().getvPlayersName().setText(x);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GridInfo getInfo() {
		return info;
	}

	public void setInfo(GridInfo info) {
		this.info = info;
	}

	public GridCells getGrid() {
		return grid;
	}

	public void setGrid(GridCells grid) {
		this.grid = grid;
	}

	public GridButtons getButtons() {
		return buttons;
	}

	public void displayMap() {
		Cell[][] map = this.game.getWorld().getMap();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				System.out.print(map[i][j].toString());
		
		System.out.println();
		
	}
	}
	public void setButtons(GridButtons buttons) {
		this.buttons = buttons;
	}

}
