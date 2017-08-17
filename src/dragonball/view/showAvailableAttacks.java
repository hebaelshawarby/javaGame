package dragonball.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.game.Game;

public class showAvailableAttacks extends JFrame {

	private JButton attack = new JButton("Attack");
	private JButton back = new JButton("<< Back");
	private JButton cancel = new JButton("Cancel");
	private JComboBox attackBox = new JComboBox();
	private char temp;
	public char getTemp() {
		return temp;
	}

	public void setTemp(char temp) {
		this.temp = temp;
	}

	private Game game;

	public showAvailableAttacks(Game game, char x) {
		super("Attacking ..");
		temp=x;

		attack.setActionCommand("attacktoattack");
		back.setActionCommand("backToback");
		cancel.setActionCommand("canceltocancel");
		attackBox.setEditable(false);
		JPanel panel;

		switch (x) {
		case 's':
			ArrayList<SuperAttack> sa = game.getPlayer().getActiveFighter().getSuperAttacks();
			String[] ss = new String[sa.size()];
			for (int i = 0; i < ss.length; i++) {
				ss[i] = sa.get(i).getName();
				// System.out.println(fighters[i]);
			}
			attackBox = new JComboBox(ss);

			panel = new JPanel();
			this.setLayout(new GridLayout(10, 10));
			this.add(new JLabel("                                           "));

			panel = new JPanel();
			panel.add(new JLabel("Choose a SuperAttack : "));
			panel.add(attackBox);
			this.add(panel);

			panel = new JPanel();
			this.add(panel);

			this.add(new JLabel("                                           "));

			panel = new JPanel();
			panel.add(back);
			panel.add(attack);
			panel.add(cancel);
			this.add(panel);

			this.setSize(500, 500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			break;
		case 'u':
			ArrayList<UltimateAttack> ua = game.getPlayer().getActiveFighter().getUltimateAttacks();
			String[] uu = new String[ua.size()];
			for (int i = 0; i < uu.length; i++) {
				uu[i] = ua.get(i).getName();
				// System.out.println(fighters[i]);
			}

			attackBox = new JComboBox(uu);

			panel = new JPanel();
			this.setLayout(new GridLayout(10, 10));
			this.add(new JLabel("                                           "));

			panel = new JPanel();
			panel.add(new JLabel("Choose an UltimateAttack : "));
			panel.add(attackBox);
			this.add(panel);

			panel = new JPanel();
			this.add(panel);
			this.add(new JLabel("                                           "));

			panel = new JPanel();
			panel.add(back);
			panel.add(attack);
			panel.add(cancel);
			this.add(panel);

			this.setSize(500, 500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			break;
		}
		this.setLocationRelativeTo(null);

	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public JButton getAddAttack() {
		return attack;
	}

	public void setAddAttack(JButton addAttack) {
		this.attack = addAttack;
	}

	public JComboBox getAttackBox() {
		return attackBox;
	}

	public void setAttackBox(JComboBox attackBox) {
		this.attackBox = attackBox;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
