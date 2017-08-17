
package dragonball.view;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dragonball.model.character.fighter.Fighter;
import dragonball.model.game.Game;
import dragonball.model.player.Player;


public class PlayersInfo extends JFrame {

	private JLabel enterName = new JLabel("Enter Your Name : ");;
	private JLabel race = new JLabel("Please, Choose A Race : ");;
	private JLabel displayRaceInfo;
	private JTextField text = new JTextField(35);;
	private JRadioButton earthling = new JRadioButton("Earthling");;
	private JRadioButton frieza = new JRadioButton("Frieza");;
	private JRadioButton saiyan = new JRadioButton("Saiyan");;
	private JRadioButton namekian = new JRadioButton("Namekian");
	private JRadioButton majin = new JRadioButton("Majin");
	private JButton start = new JButton("Start");
	private Fighter activeFighter;
	private Player player;
	private Game game;

	public PlayersInfo(Game game) {
		super("Player's Info");
		this.game = game;
		setLayout(new FlowLayout());
		
		this.setSize(400, 400);
		displayRaceInfo = new JLabel("");

		frieza.setActionCommand("frieza");
		earthling.setActionCommand("earthling");
		majin.setActionCommand("majin");
		namekian.setActionCommand("namekian");
		saiyan.setActionCommand("saiyan");
		start.setActionCommand("start");

		ButtonGroup x = new ButtonGroup();
		x.add(earthling);
		x.add(frieza);
		x.add(saiyan);
		x.add(namekian);
		x.add(majin);

		add(enterName);
		add(text);
		add(race);
		add(earthling);
		add(frieza);
		add(saiyan);
		add(namekian);
		add(majin);
		add(displayRaceInfo);
		add(start);

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String getEnterName() {
		return enterName.getText();
	}

	public void setEnterName(JLabel name) {
		this.enterName = name;
	}

	public JLabel getRace() {
		return race;
	}

	public void setRace(JLabel race) {
		this.race = race;
	}

	public JLabel getDisplayRaceInfo() {
		return displayRaceInfo;
	}

	public void setDisplayRaceInfo(String s) {
		this.displayRaceInfo.setText(s);
	}

	public String getText() {
		return text.getText();
	}

	public void setText(JTextField text) {
		this.text = text;
	}

	public JRadioButton getEarthling() {
		return earthling;
	}

	public void setEarthling(JRadioButton earthling) {
		this.earthling = earthling;
	}

	public JRadioButton getFrieza() {
		return frieza;
	}

	public void setFrieza(JRadioButton frieza) {
		this.frieza = frieza;
	}

	public JRadioButton getSaiyan() {
		return saiyan;
	}

	public void setSaiyan(JRadioButton saiyan) {
		this.saiyan = saiyan;
	}

	public JRadioButton getNamekian() {
		return namekian;
	}

	public void setNamekian(JRadioButton namekian) {
		this.namekian = namekian;
	}

	public JRadioButton getMajin() {
		return majin;
	}

	public void setMajin(JRadioButton majin) {
		this.majin = majin;
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	public Fighter getActiveFighter() {
		return activeFighter;
	}

	public void setActiveFighter(Fighter activeFighter) {
		this.activeFighter = activeFighter;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
