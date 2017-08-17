package dragonball.view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class displayInfo extends JFrame {
	
	private JButton okay = new JButton("OK");
	private JLabel displayRaceInfo = new JLabel();
	
	public displayInfo(String text){
		super("Fighter's Info");
		ImageIcon background = new ImageIcon("CreateFighterBackground.jpg");
		JLabel back = new JLabel(background);
		this.setSize(500, 500);
		this.setDisplayRaceInfo(text);
		back.setLayout(new FlowLayout());
		
		
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.add(displayRaceInfo);
		
		panel.setBackground(null);
		panel.add(okay);
		back.add(panel);
		okay.setLocation(300, 300);
		this.add(back);
		this.okay.setActionCommand("Okay");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new displayInfo("a7aa ba2aaa ");
	}
	
	public JLabel getDisplayRaceInfo() {
		return displayRaceInfo;
	}

	public void setDisplayRaceInfo(String s) {
		this.displayRaceInfo.setText(s);
	}
	
	
}
