package dragonball.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridButtons extends JPanel {

	private final JLabel fPlayersName = new JLabel("Player's Name : ");
	private JLabel vPlayersName = new JLabel("");
	private JButton switchFighter = new JButton("Switch Fighter");
	private JButton createFighter = new JButton("Create Fighter");
	private JButton save = new JButton("Save Game");
	private JButton upgradeFighter = new JButton("Upgrade Fighter");

	public GridButtons() {

		createFighter.setActionCommand("CreateFighter");
		switchFighter.setActionCommand("SwitchFighter");
		upgradeFighter.setActionCommand("UpgradeFighter");
		save.setActionCommand("SaveGame");
		assignAttack.setActionCommand("AssignAttack");

		setLayout(new FlowLayout());
		add(fPlayersName);
		add(vPlayersName);
		add(new JLabel("        "));
		add(new JLabel("        "));
		add(assignAttack);
		add(upgradeFighter);
		add(switchFighter);
		add(createFighter);
		add(save);

	}

	public JButton getSwitchFighter() {
		return switchFighter;
	}

	public void setSwitchFighter(JButton switchFighter) {
		this.switchFighter = switchFighter;
	}

	public JButton getSave() {
		return save;
	}

	public void setSave(JButton save) {
		this.save = save;
	}

	public JButton getUpgradeFighter() {
		return upgradeFighter;
	}

	public void setUpgradeFighter(JButton upgradeFighter) {
		this.upgradeFighter = upgradeFighter;
	}

	public JButton getAssignAttack() {
		return assignAttack;
	}

	public void setAssignAttack(JButton assignAttack) {
		this.assignAttack = assignAttack;
	}

	public JLabel getvPlayersName() {
		return vPlayersName;
	}

	public void setvPlayersName(JLabel vPlayersName) {
		this.vPlayersName = vPlayersName;
	}

	public JButton getCreateFighter() {
		return createFighter;
	}

	public void setCreateFighter(JButton createFighter) {
		this.createFighter = createFighter;
	}

	public JLabel getfPlayersName() {
		return fPlayersName;
	}

	private JButton assignAttack = new JButton("Assign Attack");

}
