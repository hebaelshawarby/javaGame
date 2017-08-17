package dragonball.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PlayersName extends JFrame {
	private JTextField name = new JTextField(30);
	private JButton next = new JButton("Next");
	private JLabel label = new JLabel("Enter Your Name : ");

	public PlayersName() {
		super("Player's Name");
		this.setSize(400, 400);
		this.setLayout(new FlowLayout());
		this.add(label);
		this.add(name);
		this.add(next);
		this.setLocationRelativeTo(null);
		next.setActionCommand("Next");

	}

	public String getName() {
		return name.getText();
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JButton getNext() {
		return next;
	}

	public void setNext(JButton next) {
		this.next = next;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

}
