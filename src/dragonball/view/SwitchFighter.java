package dragonball.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.game.Game;

public class SwitchFighter extends JFrame {
	private JComboBox mainBox = new JComboBox();
	private JLabel label = new JLabel("Choose a Fighter : ");
	final JButton button = new JButton("Switch Fighter");
	final JButton back = new JButton("<< Back To Game");
	private Game game;

	public SwitchFighter(Game game) {
		super("Switching Fighters");
		this.game = game;
		this.updateSwitchBox();
		
		this.setLayout(new GridLayout(10,10));
		mainBox.setEditable(false);
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(mainBox);
		this.add(panel);
		this.add(new JPanel());
		this.add(new JPanel());
		panel = new JPanel();
		panel.add(back);
		panel.add(button);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);

		// JPanel panel = new JPanel();
		// panel.add(mainBox);
		// add(panel, BorderLayout.CENTER);
		// add(button, BorderLayout.SOUTH);
		// ActionListener actionListener = new ActionListener() {
		// public void actionPerformed(ActionEvent actionEvent) {
		//
		// }
		// };
		// button.addActionListener(actionListener);

	//	setVisible(true);

	}
	
	
	public JButton getBack() {
		return back;
	}


	public void updateSwitchBox(){
		ArrayList<PlayableFighter> availableFighter = game.getPlayer().getFighters();
		String[] fighters = new String[availableFighter.size()+1];
		fighters[0] = null;
		for (int i = 1; i < fighters.length; i++) {
			fighters[i] = availableFighter.get(i-1).getName();
			//System.out.println(fighters[i]);
		}

		//DefaultComboBoxModel box = new DefaultComboBoxModel(fighters);
		mainBox = new JComboBox(fighters);
		
		mainBox.setActionCommand("switchBox");
		button.setActionCommand("switch");
		back.setActionCommand("backgrid");
		
	}

	public JComboBox getMainBox() {
		return mainBox;
	}

	public void setMainBox(JComboBox mainBox) {
		this.mainBox = mainBox;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public JButton getButton() {
		return button;
	}

}
