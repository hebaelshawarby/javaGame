package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DragonView extends JFrame {
	private JButton senzuBeans = new JButton();
	private JButton abilityPoints = new JButton();
	private JButton superAttack = new JButton();
	private JButton ultimateAttack = new JButton();
	private JButton backButton = new JButton();

	public JButton getBackButton() {
		return backButton;
	}

	public JButton getSenzuBeans() {
		return senzuBeans;
	}

	public JButton getAbilityPoints() {
		return abilityPoints;
	}

	public JButton getSuperAttack() {
		return superAttack;
	}

	public JButton getUltimateAttack() {
		return ultimateAttack;
	}

	public DragonView() {
		super("Dragon View");
		
		ImageIcon background = new ImageIcon("DragonViewBackGround.jpg");
		JLabel back = new JLabel(background);
		Icon senzu = new ImageIcon(((new ImageIcon("dragonsButton.png")).getImage())
				.getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH));
		senzuBeans = new JButton(senzu);
		senzuBeans.setBounds(200, 0, 300, 300);
		senzuBeans.setIcon(senzu);
		senzuBeans.setContentAreaFilled(false);
		senzuBeans.setBorderPainted(false);
		JLabel senzuLabel = new JLabel("SENZUBEANS");
		senzuLabel.setForeground(Color.BLACK);
		senzuLabel.setFont(new Font("Snap ITC", Font.BOLD, 23));
		senzuLabel.setBounds(220, 0, 300, 300);
		back.add(senzuLabel);

		back.add(senzuBeans);

		Icon ability = new ImageIcon(((new ImageIcon("dragonsButton.png")).getImage())
				.getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH));
		abilityPoints = new JButton(ability);
		abilityPoints.setBounds(350, 200, 300, 300);
		abilityPoints.setIcon(ability);
		abilityPoints.setContentAreaFilled(false);
		abilityPoints.setBorderPainted(false);
		JLabel abilityLabel = new JLabel("ABILITYPOINT");
		abilityLabel.setForeground(Color.BLACK);
		abilityLabel.setFont(new Font("Snap ITC", Font.BOLD, 23));
		abilityLabel.setBounds(360, 200, 300, 300);
		back.add(abilityLabel);
		back.add(abilityPoints);

		Icon supers = new ImageIcon(((new ImageIcon("dragonsButton.png")).getImage())
				.getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH));
		superAttack = new JButton(supers);
		superAttack.setBounds(500, 400, 300, 300);
		superAttack.setIcon(supers);
		superAttack.setContentAreaFilled(false);
		superAttack.setBorderPainted(false);
		JLabel superLabel = new JLabel("SUPERATTACK");
		superLabel.setForeground(Color.BLACK);
		superLabel.setFont(new Font("Snap ITC", Font.BOLD, 23));
		superLabel.setBounds(510, 400, 300, 300);
		back.add(superLabel);

		back.add(superAttack);

		Icon ultimate = new ImageIcon(((new ImageIcon("dragonsButton.png")).getImage())
				.getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH));
		ultimateAttack = new JButton(ultimate);
		ultimateAttack.setBounds(650, 600, 300, 300);
		ultimateAttack.setIcon(ultimate);
		ultimateAttack.setContentAreaFilled(false);
		ultimateAttack.setBorderPainted(false);
		JLabel ultimateLabel = new JLabel("ULTIMATEATTACK");
		ultimateLabel.setForeground(Color.BLACK);
		ultimateLabel.setFont(new Font("Snap ITC", Font.BOLD, 23));
		ultimateLabel.setBounds(660, 600, 300, 300);
		back.add(ultimateLabel);
		back.add(ultimateAttack);

		// mesh 3arfaa el soraa feeen 
		// malhash lazma la2no lazem ye5tar 7aga 3ashan yekammel
		
		/**Icon backIcon = new ImageIcon(((new ImageIcon("C:/Users/vip/Desktop/dragonsPic/left.png")).getImage())
				.getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH));
		backButton = new JButton(backIcon);
		backButton.setBounds(0, 700, 300, 300);
		backButton.setIcon(backIcon);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		JLabel backLabel = new JLabel("Back to Map");
		backLabel.setForeground(Color.black);
		backLabel.setFont(new Font("Snap ITC", Font.BOLD, 30));
		backLabel.setBounds(65, 700, 300, 300);
		back.add(backLabel);
		back.add(backButton);
		**/

		abilityPoints.setActionCommand("GetAbilityPoints");
		senzuBeans.setActionCommand("GetSenzuBeans");
		superAttack.setActionCommand("GetSuperAttack");
		ultimateAttack.setActionCommand("GetUltimateAttack");
		backButton.setActionCommand("GetBackButton");

		// BALLS
		/*
		 * Icon ball = new ImageIcon(((new
		 * ImageIcon("C:/Users/vip/Desktop/dragonsPic/ball2.png")).getImage()).
		 * getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)); JLabel
		 * ballLabel = new JLabel(ball); ballLabel.setBounds(-30, 50, 300, 300);
		 * back.add(ballLabel);
		 * 
		 * JLabel ballLabel2 = new JLabel(ball); ballLabel2.setBounds(120, 250,
		 * 300, 300); back.add(ballLabel2);
		 * 
		 * JLabel ballLabel3 = new JLabel(ball); ballLabel3.setBounds(270, 450,
		 * 300, 300); back.add(ballLabel3);
		 * 
		 * JLabel ballLabel4 = new JLabel(ball); ballLabel4.setBounds(420, 650,
		 * 300, 300); back.add(ballLabel4);
		 * 
		 */

		add(back);

		this.setSize(1950, 1100);
		this.setLocationRelativeTo(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		requestFocus();
		// this.setVisible(true);
	}

	public static void main(String[] args) {
		new DragonView();
	}

}
