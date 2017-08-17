package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleOpponent;
import dragonball.model.game.Game;

public class BattleView extends JFrame {
	private JButton attack = new JButton();
	private JButton block = new JButton();
	private JButton use = new JButton();
	private JLabel playerMH, playerHP, playerMK, playerCK, playerMS, playerCS, playerName, playerLevel, oponentMH,
			oponentHP, oponentMK, oponentCK, oponentMS, oponentCS, oponentName, oponentLevel;

	

	public BattleView() {

		ImageIcon background = new ImageIcon("BattleViewBackground.gif");
		JLabel back = new JLabel(background);
		Icon fighter = new ImageIcon(((new ImageIcon("activeFighter.png")).getImage())
				.getScaledInstance(330, 430, java.awt.Image.SCALE_SMOOTH));
		Icon monster = new ImageIcon(((new ImageIcon("foe.gif")).getImage())
				.getScaledInstance(200, 450, java.awt.Image.SCALE_SMOOTH));
		JLabel fighterLabel = new JLabel(fighter);
		JLabel monsterLabel = new JLabel(monster);
		fighterLabel.setSize(50, 50);
		fighterLabel.setBounds(1100, 220, 500, 900);
		monsterLabel.setBounds(250, 250, 500, 900);
		back.add(fighterLabel);
		back.add(monsterLabel);
		block = new JButton("block");
		Icon blockImage = new ImageIcon("block.jpg");
		block.setBounds(1450, 500, 130, 60);
		block.setIcon(blockImage);
		block.setContentAreaFilled(false);

		block.setBorderPainted(false);
		back.add(block);
		use = new JButton("use");
		Icon useImage = new ImageIcon("use.jpg");
		use.setBounds(1500, 550, 113, 60);
		use.setIcon(useImage);
		use.setContentAreaFilled(false);

		use.setBorderPainted(false);
		back.add(use);
		attack = new JButton("attack");
		Icon attackImage = new ImageIcon("attack.jpg");
		
		attack.setBounds(1550, 600, 140, 60);
		attack.setIcon(attackImage);
		attack.setContentAreaFilled(false);

		attack.setBorderPainted(false);
		back.add(attack);
		/////////////////////////////////////////////////////////////////////
		///

		Icon name = new ImageIcon(((new ImageIcon("foesName.png")).getImage())
				.getScaledInstance(350, 130, java.awt.Image.SCALE_SMOOTH));
		JLabel nameLabel = new JLabel(name);
		nameLabel.setBounds(50, 0, 500, 500);
		playerName = new JLabel("Name:  ");
		playerName.setFont(new Font("Snap ITC", Font.ITALIC, 23));
		playerName.setBounds(140, -25, 500, 500);
		playerLevel = new JLabel("Level:  ");
		playerLevel.setFont(new Font("Snap ITC", Font.ITALIC, 23));
		playerLevel.setBounds(140, 15, 500, 500);
		back.add(playerLevel);
		back.add(playerName);
		back.add(nameLabel);
		Icon name2 = new ImageIcon(((new ImageIcon("activeFightersName.png")).getImage())
				.getScaledInstance(350, 130, java.awt.Image.SCALE_SMOOTH));
		JLabel name2Label = new JLabel(name2);
		name2Label.setBounds(1350, 0, 500, 500);
		oponentName = new JLabel("Name:  ");
		oponentName.setFont(new Font("Snap ITC", Font.ITALIC, 23));
		oponentName.setBounds(1470, -25, 500, 500);
		oponentLevel = new JLabel("Level:  ");
		oponentLevel.setFont(new Font("Snap ITC", Font.ITALIC, 23));
		oponentLevel.setBounds(1470, 15, 500, 500);
		back.add(oponentLevel);
		back.add(oponentName);
		back.add(name2Label);

		Icon box = new ImageIcon(((new ImageIcon("activeFightersInfo.png")).getImage())
				.getScaledInstance(400, 210, java.awt.Image.SCALE_SMOOTH));
		JLabel boxLabel = new JLabel(box);
		boxLabel.setBounds(450, -50, 500, 500);

		playerHP = new JLabel("HealthPoints");
		playerHP.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		playerHP.setBounds(650, -110, 500, 500);
		back.add(playerHP);

		playerMH = new JLabel("MaxHealth");
		playerMH.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		playerMH.setBounds(650, -90, 500, 500);
		back.add(playerMH);

		playerCK = new JLabel("Current Ki");
		playerCK.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		playerCK.setBounds(650, -70, 500, 500);
		back.add(playerCK);

		playerMK = new JLabel("Max Ki");
		playerMK.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		playerMK.setBounds(650, -50, 500, 500);
		back.add(playerMK);

		playerCS = new JLabel("Stamina");
		playerCS.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		playerCS.setBounds(650, -30, 500, 500);
		back.add(playerCS);

		playerMS = new JLabel("Max Stamina");
		playerMS.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		playerMS.setBounds(650, -10, 500, 500);
		back.add(playerMS);

		back.add(boxLabel);

		JLabel boxLabel2 = new JLabel(box);
		boxLabel2.setBounds(950, -50, 500, 500);

		oponentHP = new JLabel("HealthPoints");
		oponentHP.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		oponentHP.setBounds(1150, -110, 500, 500);
		back.add(oponentHP);

		oponentMH = new JLabel("MaxHealth");
		oponentMH.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		oponentMH.setBounds(1150, -90, 500, 500);
		back.add(oponentMH);

		oponentCK = new JLabel("Current Ki");
		oponentCK.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		oponentCK.setBounds(1150, -70, 500, 500);
		back.add(oponentCK);

		oponentMK = new JLabel("Max Ki");
		oponentMK.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		oponentMK.setBounds(1150, -50, 500, 500);
		back.add(oponentMK);

		oponentCS = new JLabel("Stamina");
		oponentCS.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		oponentCS.setBounds(1150, -30, 500, 500);
		back.add(oponentCS);

		oponentMS = new JLabel("Max Stamina");
		oponentMS.setFont(new Font("Snap ITC", Font.ITALIC, 15));
		oponentMS.setBounds(1150, -10, 500, 500);
		back.add(oponentMS);

		back.add(boxLabel2);

		add(back);

		attack.setActionCommand("GetAttack");
		block.setActionCommand("GetBlock");
		use.setActionCommand("GetUse");
		
		 this.setSize(1900, 1000);
		 setLocationRelativeTo(null); setFocusable(true);
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setFocusable(true);
		   requestFocus();
		  // setVisible(true);
		

	}public JButton getAttack() {
		return attack;
	}

	public JButton getBlock() {
		return block;
	}

	public JButton getUse() {
		return use;
	}

	public JLabel getPlayerMH() {
		return playerMH;
	}

	public JLabel getPlayerHP() {
		return playerHP;
	}

	public JLabel getPlayerMK() {
		return playerMK;
	}

	public JLabel getPlayerCK() {
		return playerCK;
	}

	public JLabel getPlayerMS() {
		return playerMS;
	}

	public JLabel getPlayerCS() {
		return playerCS;
	}

	public JLabel getPlayerName() {
		return playerName;
	}

	public JLabel getPlayerLevel() {
		return playerLevel;
	}

	public JLabel getOponentMH() {
		return oponentMH;
	}

	public JLabel getOponentHP() {
		return oponentHP;
	}

	public JLabel getOponentMK() {
		return oponentMK;
	}

	public JLabel getOponentCK() {
		return oponentCK;
	}

	public JLabel getOponentMS() {
		return oponentMS;
	}

	public JLabel getOponentCS() {
		return oponentCS;
	}

	public JLabel getOponentName() {
		return oponentName;
	}

	public JLabel getOponentLevel() {
		return oponentLevel;
	}
	
	

	public static void main(String[] args) {
		new BattleView();
	}

}
