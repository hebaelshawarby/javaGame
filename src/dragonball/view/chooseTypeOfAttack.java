package dragonball.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

public class chooseTypeOfAttack extends JFrame {

	private JComboBox typeBox = new JComboBox();
	private ArrayList<String> type = new ArrayList<String>();
	private JButton att = new JButton("Attack");
	private JButton back = new JButton("<< Back To Battle");
	private Game game;

	public chooseTypeOfAttack(Game game){
		
			super("Attacking ..");
			type.add("Physical Attack");
			this.game = game;
			
			if(this.game.getPlayer().getActiveFighter().getSuperAttacks().size() > 0)
				type.add("Super Attack");
		if(this.game.getPlayer().getActiveFighter().getUltimateAttacks().size() > 0)
				type.add("Ultimate Attack");
			
			JPanel panel = new JPanel();
			this.setLayout(new GridLayout(10,10));
			typeBox = new JComboBox(type.toArray());
			this.add(new JLabel("                                           "));
			
			att.setActionCommand("btnAttack");
			back.setActionCommand("btnBack");
			typeBox.setEditable(false);
			
			panel.add(new JLabel("Choose Type Of Attack : "));
			panel.add(typeBox);
			this.add(panel);
			
			panel = new JPanel();
			this.add(panel);
			
			panel = new JPanel();
			panel.add(back);
			panel.add(att);
			
			this.add(panel);
			this.setSize(500,500);
			this.setLocationRelativeTo(null);
			//this.setVisible(true);
		
		}
	


	public JComboBox getTypeBox() {
		return typeBox;
	}

	public void setTypeBox(JComboBox typeBox) {
		this.typeBox = typeBox;
	}
	
	public JButton getCon() {
		return att;
	}

	public void setCon(JButton con) {
		this.att = con;
	}

	public static void main(String[] args) {
		try {
			new chooseTypeOfAttack(new Game());
		} catch (MissingFieldException | UnknownAttackTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

}
