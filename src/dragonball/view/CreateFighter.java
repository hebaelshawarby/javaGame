
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

public class CreateFighter extends JFrame {

	private JLabel enterName = new JLabel("Enter Your Fighter's Name");;
	private JLabel race = new JLabel("Please, Choose A Race : ");;
	private JLabel displayRaceInfo;
	private JTextField text = new JTextField(30);;
	private JRadioButton earthling = new JRadioButton("Earthling");;
	private JRadioButton frieza = new JRadioButton("Frieza");;
	private JRadioButton saiyan = new JRadioButton("Saiyan");;
	private JRadioButton namekian = new JRadioButton("Namekian");
	private JRadioButton majin = new JRadioButton("Majin");
	private JButton start = new JButton("Create");
	private Fighter activeFighter;
	private Player player;
	private Game game;

	public CreateFighter(Game game) {
		super("Create Fighter");
		this.game = game;
		/**
		ImageIcon background = new ImageIcon("StartMenuBackground.jpg");
		JLabel back = new JLabel(background);
		enterName.setFont(new Font("Old English Text MT", Font.BOLD, 45));
		enterName.setBounds(680,750,450,200);
		back.add(enterName);
		text.setBounds(680,900 ,400,50);
		back.add(text);
		JLabel friezaa = new JLabel ("Frieza");
		friezaa.setFont(new Font("Harlow Solid Italic", Font.BOLD, 30));
		friezaa.setBounds(100,-100,300,300);
		back.add(friezaa);
		
		JLabel earthlingg = new JLabel("Earthling");
		earthlingg.setFont(new Font("Harlow Solid Italic", Font.BOLD, 30));
		earthlingg.setBounds(400,200,300,300);
		back.add(earthlingg);
		JLabel saiyann = new JLabel ("Saiyan");
		saiyann.setFont(new Font("Harlow Solid Italic", Font.BOLD, 30));
		saiyann.setBounds(750,-100,300,300);
		back.add(saiyann);
		JButton namekian = new JLabel ("Namekian");
		namekian.setFont(new Font("Harlow Solid Italic", Font.BOLD, 30));
		namekian.setBounds(1150,50,300,300);
		back.add(namekian);
		JLabel majinn = new JLabel ("Majin"); 
		majinn.setFont(new Font("Harlow Solid Italic", Font.BOLD, 30));
		majinn.setBounds(1500,-100,300,300);
		back.add(majinn);
		
		Icon ff =  new ImageIcon (((new ImageIcon("frieza.png")).getImage()).getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH));
	     JLabel nameLabel = new JLabel (ff);
		nameLabel.setBounds(-100,100,600,600);
		back.add(nameLabel);
		Icon ee =  new ImageIcon (((new ImageIcon("earthling.png")).getImage()).getScaledInstance(350, 500, java.awt.Image.SCALE_SMOOTH));
		JLabel nameLabel2 = new JLabel (ee);
			nameLabel2.setBounds(240,350,500,500);
		back.add(nameLabel2);
		
		Icon ss =  new ImageIcon (((new ImageIcon("saiyan.png")).getImage()).getScaledInstance(250,550, java.awt.Image.SCALE_SMOOTH));
		JLabel nameLabel3 = new JLabel (ss);
			nameLabel3.setBounds(580,100,550,550);
		back.add(nameLabel3);
		
		Icon nn =  new ImageIcon (((new ImageIcon("namekian.png")).getImage()).getScaledInstance(250,550, java.awt.Image.SCALE_SMOOTH));
		JLabel nameLabel4 = new JLabel (nn);
			nameLabel4.setBounds(980,250,550,550);
		back.add(nameLabel4);
		
		Icon mm =  new ImageIcon (((new ImageIcon("majin.png")).getImage()).getScaledInstance(250,550, java.awt.Image.SCALE_SMOOTH));
		JLabel nameLabel5 = new JLabel (mm);
		nameLabel5.setBounds(1300,100,550,550);
		back.add(nameLabel5);
		
		

		Icon image =  new ImageIcon (((new ImageIcon("C:/Users/vip/Desktop/dragonsPic/select.png")).getImage()).getScaledInstance(150,50, java.awt.Image.SCALE_SMOOTH));
		
		earthling = new JButton(image);
		earthling.setBounds(80,700,150, 50);
		back.add(earthling);
		
		
		frieza = new JButton(image);
		frieza.setBounds(400,850, 150, 50);
		back.add(frieza);
		
		saiyan= new JButton(image);
		saiyan.setBounds(780,660, 150, 50);
		back.add(saiyan);
		
		
		namekian= new JButton(image);
		namekian.setBounds(1180,820, 150, 50);
		back.add(namekian);
		

		majin= new JButton(image);
		majin.setBounds(1520,700, 150, 50);
		back.add(majin);
		
		
		Icon next =  new ImageIcon (((new ImageIcon("C:/Users/vip/Desktop/dragonsPic/next.png")).getImage()).getScaledInstance(700,150, java.awt.Image.SCALE_SMOOTH));
		start = new JButton(next);
		start.setBounds(1300,900,600,100);
		back.add(start);
		
		frieza.setActionCommand("frieza");
		earthling.setActionCommand("earthling");
		majin.setActionCommand("majin");
		namekian.setActionCommand("namekian");
		saiyan.setActionCommand("saiyan");
		start.setActionCommand("start");
		
		
	/*	
		Icon sel =  new ImageIcon (((new ImageIcon("C:/Users/vip/Desktop/dragonsPic/select.png")).getImage()).getScaledInstance(130,80, java.awt.Image.SCALE_SMOOTH));
		JLabel select = new JLabel (sel);
		select.setBounds(-50,500,550,550);
		back.add(select);
		
		JLabel select2 = new JLabel(sel);
		select2.setBounds(310,100,320,320);
		back.add(select2);
		
		
		*/
		/*
		add(back);
		this.setSize(1920,1080);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		/**
		 * 
		 */
		
		setLayout(new FlowLayout());

		this.setSize(400, 400);
		displayRaceInfo = new JLabel("");

		frieza.setActionCommand("frieza");
		earthling.setActionCommand("earthling");
		majin.setActionCommand("majin");
		namekian.setActionCommand("namekian");
		saiyan.setActionCommand("saiyan");
		start.setActionCommand("Create");

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
		add(start);
		add(new JLabel("          "));
		add(new JLabel("          "));
		add(new JLabel("          "));
		add(new JLabel("          "));
		add(displayRaceInfo);

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
