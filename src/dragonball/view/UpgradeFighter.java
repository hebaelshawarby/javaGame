package dragonball.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpgradeFighter extends JFrame {
	private JButton back = new JButton("<< Back To Game");
	private JButton upgrade = new JButton("Upgrade");
	private JComboBox box = new JComboBox();

	public UpgradeFighter() {
		super("Upgrade Your Fighter");
		this.setSize(500, 500);
		this.setLayout(new GridLayout(10,10));
		back.setActionCommand("backGridd");
		upgrade.setActionCommand("Upgrade");
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.add(new JLabel("Choose an option to upgrade your fighter : "));
		this.add(panel);
		panel = new JPanel();
		String[] x = { "","Increase Max Health Points by 50 points.", "Increase Physical Damage by 50 points.",
				"Increase Blast Damage by 50 points.", "Increase Max Ki by one bar.", "Increase Max Stamina by one bar." };
		box = new JComboBox(x);
		panel.add(box);
		this.add(panel);

		panel = new JPanel();
		this.add(panel);
		panel = new JPanel();
		this.add(panel);
		panel = new JPanel();
		panel.add(back);
		panel.add(upgrade);
		this.add(panel);
		this.setResizable(false);
		setVisible(true);

	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JComboBox getBox() {
		return box;
	}

	public void setBox(JComboBox box) {
		this.box = box;
	}

	public static void main(String[] args) {
		new UpgradeFighter();
	}

	public JButton getUpgrade() {
		return upgrade;
	}

	public void setUpgrade(JButton upgrade) {
		this.upgrade = upgrade;
	}

}
