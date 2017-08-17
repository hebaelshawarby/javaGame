package dragonball.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AttackType extends JFrame {
	
	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}
	
	private JComboBox typeBox = new JComboBox();
	private String[] type = {"", "Super Attack", "Ultimate Attack"};
	private JButton con = new JButton("Continue");
	private JButton back = new JButton("<< Back To Game");
	
	public AttackType(){
		super("Assigning an Attack ..");
		JPanel panel = new JPanel();
		this.setLayout(new GridLayout(10,10));
		typeBox = new JComboBox(type);
		this.add(new JLabel("                                           "));
		con.setActionCommand("Continue");
		back.setActionCommand("backGrid");
		typeBox.setActionCommand("TypeBox");
		typeBox.setEditable(false);
		panel.add(new JLabel("Choose Type Of Attack : "));
		panel.add(typeBox);
		this.add(panel);
		
		panel = new JPanel();
		this.add(panel);
		
		panel = new JPanel();
		panel.add(back);
		panel.add(con);
		
		this.add(panel);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
	
	}
	
	public JComboBox getTypeBox() {
		return typeBox;
	}

	public void setTypeBox(JComboBox typeBox) {
		this.typeBox = typeBox;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public JButton getCon() {
		return con;
	}

	public void setCon(JButton con) {
		this.con = con;
	}

	public static void main(String[] args) {
		new AttackType();
	}

}
