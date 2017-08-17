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
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

public class AssignAttack extends JFrame {
	private JButton addAttack = new JButton("Add/Replace Attack");
	private JButton back = new JButton("<< Back");
	private JButton cancel = new JButton("Cancel");
	private String chosenType = "xx";
	private JComboBox attackBox = new JComboBox();
	private JComboBox fightersAttacks = new JComboBox();

	private Game game;

	public AssignAttack(Game game, int idx) {
		super("Assigning an Attack ..");
		
		addAttack.setActionCommand("AddOrReplace");
		back.setActionCommand("backToChange");
		cancel.setActionCommand("Cancel");
		attackBox.setEditable(false);
		fightersAttacks.setEditable(false);
		JPanel panel;

		switch (idx) {
		case 1:
			chosenType = "sa";
			ArrayList<SuperAttack> sa = game.getPlayer().getSuperAttacks();
			String[] ss = new String[sa.size()];
			for (int i = 0; i < ss.length; i++) {
				ss[i] = sa.get(i).getName();
				// System.out.println(fighters[i]);
			}
			String[] sx = { "sa1", "sa2", "sa3", "sa4" };
			attackBox = new JComboBox(ss);

			sa = game.getPlayer().getActiveFighter().getSuperAttacks();
			if (sa == null)
				ss[0] = "There is no avaialbe attacks.";
			else {
				ss = new String[sa.size() + 1];
				ss[0] = null;
				for (int i = 1; i < ss.length; i++) {
					ss[i] = sa.get(i - 1).getName();
					// System.out.println(fighters[i]);
				}
			}
			fightersAttacks = new JComboBox(ss);

			panel = new JPanel();
			this.setLayout(new GridLayout(10, 10));
			this.add(new JLabel("                                           "));

			panel = new JPanel();
			panel.add(new JLabel("Choose a SuperAttack : "));
			panel.add(attackBox);
			this.add(panel);

			panel = new JPanel();
			this.add(panel);

			panel = new JPanel();
			panel.add(new JLabel("Only if you want to replace a SuperAttack, CHOOSE an attack to be replaced !!"));
			this.add(panel);

			panel = new JPanel();
			panel.add(fightersAttacks);
			this.add(panel);

			this.add(new JLabel("                                           "));

			panel = new JPanel();
			panel.add(back);
			panel.add(addAttack);
			panel.add(cancel);
			this.add(panel);

			this.setSize(500, 500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			break;
		case 2:
			chosenType = "ua";
			ArrayList<UltimateAttack> ua = game.getPlayer().getUltimateAttacks();
			String[] uu = new String[ua.size()];
			for (int i = 0; i < uu.length; i++) {
				uu[i] = ua.get(i).getName();
				// System.out.println(fighters[i]);
			}
			
			String[] ux = {"ua1","ua2","ua3","ua4"};
			attackBox = new JComboBox(uu);

			ua = game.getPlayer().getActiveFighter().getUltimateAttacks();
			if (ua == null)
				uu[0] = "There is no avaialbe attacks.";

			else {
				uu = new String[ua.size() + 1];
				uu[0] = null;
				for (int i = 1; i < uu.length; i++) {
					uu[i] = ua.get(i - 1).getName();
					// System.out.println(fighters[i]);
				}
			}
			fightersAttacks = new JComboBox(uu);
			panel = new JPanel();
			this.setLayout(new GridLayout(10, 10));
			this.add(new JLabel("                                           "));

			panel = new JPanel();
			panel.add(new JLabel("Choose an UltimateAttack : "));
			panel.add(attackBox);
			this.add(panel);

			panel = new JPanel();
			this.add(panel);

			panel = new JPanel();
			panel.add(new JLabel("Only if you want to replace an UltimateAttack, CHOOSE an attack to be replaced !!"));
			this.add(panel);

			panel = new JPanel();
			panel.add(fightersAttacks);
			this.add(panel);

			this.add(new JLabel("                                           "));

			panel = new JPanel();
			panel.add(back);
			panel.add(addAttack);
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

	public String getChosenType() {
		return chosenType;
	}

	public void setChosenType(String chosenType) {
		this.chosenType = chosenType;
	}

	public JButton getAddAttack() {
		return addAttack;
	}

	public void setAddAttack(JButton addAttack) {
		this.addAttack = addAttack;
	}

	public JComboBox getAttackBox() {
		return attackBox;
	}

	public void setAttackBox(JComboBox attackBox) {
		this.attackBox = attackBox;
	}

	public JComboBox getFightersAttacks() {
		return fightersAttacks;
	}

	public void setFightersAttacks(JComboBox fightersAttacks) {
		this.fightersAttacks = fightersAttacks;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public static void main(String[] args) {
		try {
			new AssignAttack(new Game(), 1);
		} catch (MissingFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownAttackTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
