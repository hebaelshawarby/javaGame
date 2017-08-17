package dragonball.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dragonball.model.attack.Attack;
import dragonball.model.attack.PhysicalAttack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.battle.BattleListener;
import dragonball.model.battle.BattleOpponent;
import dragonball.model.cell.Cell;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.dragon.DragonWishType;
import dragonball.model.exceptions.MapIndexOutOfBoundsException;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.model.world.WorldListener;
import dragonball.view.AssignAttack;
import dragonball.view.AttackType;
import dragonball.view.BattleView;
import dragonball.view.CreateFighter;
import dragonball.view.DragonView;
import dragonball.view.MainGrid;
import dragonball.view.PlayersName;
import dragonball.view.StartMenu;
import dragonball.view.SwitchFighter;
import dragonball.view.UpgradeFighter;
import dragonball.view.chooseTypeOfAttack;
import dragonball.view.showAvailableAttacks;

public class Controller implements ActionListener, KeyListener, GameListener, BattleListener, WorldListener {

	private Game game;
	private StartMenu menu;
	private CreateFighter fightersInfo;
	private MainGrid grid;
	private UpgradeFighter upgrade;
	private SwitchFighter switchFighter;
	private AssignAttack assignAttack;
	private DragonView dragonView;
	private BattleView battleView;
	private PlayersName playersName;
	private AttackType attackType;
	private Battle battle;
	private String savedGame;
	private showAvailableAttacks sORu;
	private chooseTypeOfAttack type;
	Dragon chosenDragon;
	char x = 'x';
	String fightersName;
	Attack pp;
	PhysicalAttack pf;
	BattleEvent event;

	public Battle getBattle() {
		return battle;
	}

	public Controller(Game game) throws MissingFieldException, UnknownAttackTypeException {
		this.game = game;
		this.menu = new StartMenu();
		this.menu.getNewGame().addActionListener(this);
		this.menu.getLoadGame().addActionListener(this);
		this.menu.getQuitGame().addActionListener(this);
		menu.setVisible(true);

		this.savedGame = "7ywan";

		playersName = new PlayersName();
		playersName.getNext().addActionListener(this);

		this.fightersInfo = new CreateFighter(game);
		this.fightersInfo.getEarthling().addActionListener(this);
		this.fightersInfo.getFrieza().addActionListener(this);
		this.fightersInfo.getMajin().addActionListener(this);
		this.fightersInfo.getNamekian().addActionListener(this);
		this.fightersInfo.getSaiyan().addActionListener(this);
		this.fightersInfo.getStart().addActionListener(this);

		this.grid = new MainGrid(game);
		this.grid.addKeyListener(this);
		this.grid.getButtons().getSave().addActionListener(this);
		this.grid.getButtons().getSwitchFighter().addActionListener(this);
		this.grid.getButtons().getUpgradeFighter().addActionListener(this);
		this.grid.getButtons().getAssignAttack().addActionListener(this);
		this.grid.getButtons().getCreateFighter().addActionListener(this);

		JButton[][] gridButtons = this.grid.getGrid().getMapButton();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				gridButtons[i][j].setActionCommand(gridButtons[i][j].getText());
				gridButtons[i][j].addActionListener(this);
				gridButtons[i][j].addKeyListener(this);
			}
		}

		game.setListener(this);
		
		this.dragonView = new DragonView();
		this.dragonView.getAbilityPoints().addActionListener(this);
		this.dragonView.getSenzuBeans().addActionListener(this);
		this.dragonView.getSuperAttack().addActionListener(this);
		this.dragonView.getUltimateAttack().addActionListener(this);
		this.dragonView.getBackButton().addActionListener(this);

		this.battleView = new BattleView();

		this.battleView.getAttack().addActionListener(this);
		this.battleView.getAttack().setActionCommand("GetAttack");
		this.battleView.getBlock().addActionListener(this);
		this.battleView.getBlock().setActionCommand("GetBlock");
		this.battleView.getUse().addActionListener(this);
		this.battleView.getUse().setActionCommand("GetUse");

	}

	public static void main(String[] args) throws MissingFieldException, UnknownAttackTypeException {
		new Controller(new Game());

	}

	public void updateMap() {

		this.grid.getGrid().removeAll();
		int row = game.getWorld().getPlayerRow();
		int column = game.getWorld().getPlayerColumn();
		JButton[][] grid = this.grid.getGrid().getMapButton();
		Cell[][] map = this.game.getWorld().getMap();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == column && i == row)
					grid[i][j] = new JButton("Player");
				else if (map[i][j].toString().equals("[b]"))
					grid[i][j] = new JButton("BOSS");
				else
					grid[i][j] = new JButton();
				grid[i][j].setActionCommand(grid[i][j].getText());
				grid[i][j].addActionListener(this);
				grid[i][j].addKeyListener(this);
				grid[i][j].setFocusable(true);
				this.grid.getGrid().add(grid[i][j]);

			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		switch (action) {
		case "NewGame":
			menu.setVisible(false);
			playersName.setVisible(true);
			break;

		case "LoadGame":
			try {
				game.load(savedGame);
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(savedGame)));
				Game temp = (Game) ois.readObject();
				fightersInfo = new CreateFighter(temp);
				grid = new MainGrid(temp);
				grid.updatePalyersName(temp.getPlayer().getName());
				grid.updatePlayersInfo(temp.getPlayer());
				this.grid.addKeyListener(this);
				this.grid.getButtons().getSave().addActionListener(this);
				this.grid.getButtons().getSwitchFighter().addActionListener(this);
				this.grid.getButtons().getUpgradeFighter().addActionListener(this);
				this.grid.getButtons().getAssignAttack().addActionListener(this);
				this.grid.getButtons().getCreateFighter().addActionListener(this);
				this.game = temp;
				game.setListener(this);

				JButton[][] gridButtons = this.grid.getGrid().getMapButton();
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						gridButtons[i][j].setActionCommand(gridButtons[i][j].getText());
						gridButtons[i][j].addActionListener(this);
						gridButtons[i][j].addKeyListener(this);
					}
				}

				this.dragonView = new DragonView();
				this.dragonView.getAbilityPoints().addActionListener(this);
				this.dragonView.getSenzuBeans().addActionListener(this);
				this.dragonView.getSuperAttack().addActionListener(this);
				this.dragonView.getUltimateAttack().addActionListener(this);
				this.dragonView.getBackButton().addActionListener(this);

				this.battleView = new BattleView();

				this.battleView.getAttack().addActionListener(this);
				this.battleView.getAttack().setActionCommand("GetAttack");
				this.battleView.getBlock().addActionListener(this);
				this.battleView.getBlock().setActionCommand("GetBlock");
				this.battleView.getUse().addActionListener(this);
				this.battleView.getUse().setActionCommand("GetUse");
				menu.setVisible(false);
				grid.requestFocus();
				grid.setVisible(true);

			} catch (ClassNotFoundException | IOException e1) {

				JOptionPane.showMessageDialog(null, "There is No Saved Games !", "Error ..",
						JOptionPane.INFORMATION_MESSAGE);
			}
			// gui.showHighScore(highScore); lesaaa ya ba2ara
			break;

		case "QuitGame":
			int choice = JOptionPane.showConfirmDialog(null, "Do you really want to close ?", "Confirm exit ? ",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (choice == JOptionPane.YES_OPTION)
				menu.dispatchEvent(new WindowEvent(menu, WindowEvent.WINDOW_CLOSING));
			break;

		case "Next":
			String xx = this.playersName.getName();
			if (xx == null || xx.length() == 0)
				JOptionPane.showMessageDialog(null, "Please, Enter Your Name !", "Enter A Name ..",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				this.game.getPlayer().setName(xx);
				this.grid.updatePalyersName(xx);
				this.playersName.setVisible(false);
				this.fightersInfo.setVisible(true);
			}
			break;

		case "Create":
			if (x == 'x')
				JOptionPane.showMessageDialog(null, "Please, Choose A Race To Start Game !", "Error ..",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				this.game.getPlayer().createFighter(x, fightersName);
				System.out.println(this.game.getPlayer().getFighters().size());
				this.fightersInfo.setVisible(false);
				this.grid.updatePlayersInfo(game.getPlayer());
				this.grid.setVisible(true);
				this.grid.requestFocus();
			}
			break;

		case "CreateFighter":
			fightersInfo = new CreateFighter(game);
			this.fightersInfo.getEarthling().addActionListener(this);
			this.fightersInfo.getFrieza().addActionListener(this);
			this.fightersInfo.getMajin().addActionListener(this);
			this.fightersInfo.getNamekian().addActionListener(this);
			this.fightersInfo.getSaiyan().addActionListener(this);
			this.fightersInfo.getStart().addActionListener(this);
			this.fightersInfo.setVisible(true);
			x = 'x';
			fightersName = null;
			break;

		case "earthling":
			this.fightersInfo.setDisplayRaceInfo(
					"<html>Earthling has<br> HealthPoints = 1250<br>BlastDamage = 50<br>Physical Damage = 50<br>MaxKi = 4<br>MaxStamina = 4<html>");
			this.x = 'E';
			this.fightersName = fightersInfo.getText();
			if (this.fightersName == null || this.fightersName.length() == 0)
				JOptionPane.showMessageDialog(null, "Please, Enter Your Fighter's Name !", "Enter A Name ..",
						JOptionPane.INFORMATION_MESSAGE);

			break;

		case "namekian":
			this.fightersInfo.setDisplayRaceInfo(
					"<html>Namekian has<br> HealthPoints = 1350<br>BlastDamage = 0<br>Physical Damage = 50<br>MaxKi = 3<br>MaxStamina = 5<html>");
			this.x = 'N';
			this.fightersName = fightersInfo.getText();
			if (this.fightersName == null || this.fightersName.length() == 0)

				JOptionPane.showMessageDialog(null, "Please, Enter Your Fighter's Name !", "Enter A Name ..",
						JOptionPane.INFORMATION_MESSAGE);
			break;

		case "saiyan":
			this.fightersInfo.setDisplayRaceInfo(
					"<html>Saiyan has<br> HealthPoints = 1000<br>BlastDamage = 150<br>Physical Damage = 100<br>MaxKi = 5<br>MaxStamina = 3<html>");
			this.x = 'S';
			this.fightersName = fightersInfo.getText();
			if (this.fightersName == null || this.fightersName.length() == 0)
				JOptionPane.showMessageDialog(null, "Please, Enter Your Fighter's Name !", "Enter A Name ..",
						JOptionPane.INFORMATION_MESSAGE);

			break;

		case "frieza":
			this.fightersInfo.setDisplayRaceInfo(
					"<html>Frieza has<br> HealthPoints = 1100<br>BlastDamage = 75<br>Physical Damage = 75<br>MaxKi = 4<br>MaxStamina = 4<html>");
			this.x = 'F';
			this.fightersName = fightersInfo.getText();
			if (this.fightersName == null || this.fightersName.length() == 0)
				JOptionPane.showMessageDialog(null, "Please, Enter Your Fighter's Name !", "Enter A Name ..",
						JOptionPane.INFORMATION_MESSAGE);

			break;

		case "majin":
			this.fightersInfo.setDisplayRaceInfo(
					"<html>Majin has<br> HealthPoints = 1500<br>BlastDamage = 50<br>Physical Damage = 50<br>MaxKi = 3 <br>MaxStamina = 6<html>");

			this.x = 'M';
			this.fightersName = fightersInfo.getText();
			if (this.fightersName == null || this.fightersName.length() == 0)
				JOptionPane.showMessageDialog(null, "Please, Enter Your Fighter's Name !", "Enter A Name ..",
						JOptionPane.INFORMATION_MESSAGE);

			break;

		case "Upgrade":

			if (this.upgrade.getBox().getSelectedIndex() == 0)
				JOptionPane.showMessageDialog(null, "Choose an option !", "Error ..", JOptionPane.INFORMATION_MESSAGE);
			else {
				int idx = this.upgrade.getBox().getSelectedIndex();
				char v = 'e';
				try {
					switch (idx) {
					case 1:
						v = 'H';
						break;
					case 2:
						v = 'P';
						break;
					case 3:
						v = 'B';
						break;
					case 4:
						v = 'K';
						break;
					case 5:
						v = 'S';
						break;
					}
					this.game.getPlayer().upgradeFighter(this.game.getPlayer().getActiveFighter(), v);
					this.upgrade.setVisible(false);
					this.grid.updatePlayersInfo(this.game.getPlayer());
					this.grid.requestFocus();
				} catch (NotEnoughAbilityPointsException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error ..", JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
			}

			break;

		case "UpgradeFighter":
			this.upgrade = new UpgradeFighter();
			this.upgrade.getUpgrade().addActionListener(this);
			this.upgrade.getBack().addActionListener(this);
			this.upgrade.setVisible(true);
			break;

		case "SaveGame":
			try {
				this.game.save(savedGame);
				JOptionPane.showMessageDialog(menu, "Your Game is Successfully Saved !", "Saving Your Game ..",
						JOptionPane.INFORMATION_MESSAGE);
				this.grid.requestFocus();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "SwitchFighter":
			this.switchFighter = new SwitchFighter(game);
			this.switchFighter.getButton().addActionListener(this);
			this.switchFighter.getBack().addActionListener(this);
			this.switchFighter.getMainBox().addActionListener(this);
			if (this.game.getPlayer().getFighters().size() == 1) {
				JOptionPane.showMessageDialog(grid, "You Only Have ONE Fighter !", "Error ..",
						JOptionPane.INFORMATION_MESSAGE);
				this.grid.requestFocus();
			} else
				this.switchFighter.setVisible(true);

			break;

		case "backgrid":
			this.switchFighter.setVisible(false);
			this.grid.requestFocus();
			break;
		case "switch":
			if (this.switchFighter.getMainBox().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Please, Choose a Fighter !", "Switching Fighters ..",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				this.game.getPlayer().setActiveFighter(this.game.getPlayer().getFighters()
						.get(this.switchFighter.getMainBox().getSelectedIndex() - 1));
				this.grid.updatePlayersInfo(this.game.getPlayer());
				this.grid.requestFocus();

			}
			break;

		case "AssignAttack":
			if (this.game.getPlayer().getSuperAttacks().size() == 0
					&& this.game.getPlayer().getUltimateAttacks().size() == 0) {
				JOptionPane.showMessageDialog(null, "You do not have SuperAttacks nor UltimateAttacks !", "Error ..",
						JOptionPane.INFORMATION_MESSAGE);
				this.grid.requestFocus();
			} else {
				this.attackType = new AttackType();
				this.attackType.getCon().addActionListener(this);
				this.attackType.getBack().addActionListener(this);
				this.attackType.setVisible(true);
			}
			break;

		case "Continue":
			if (this.attackType.getTypeBox().getSelectedItem() == null
					|| this.attackType.getTypeBox().getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Please, Choose an Attack Type !", "Error ..",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (this.attackType.getTypeBox().getSelectedIndex() == 1
					&& this.game.getPlayer().getSuperAttacks().size() == 0) {
				JOptionPane.showMessageDialog(null, "You do not have SuperAttacks !", "Error ..",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (this.attackType.getTypeBox().getSelectedIndex() == 2
					&& this.game.getPlayer().getUltimateAttacks().size() == 0) {
				JOptionPane.showMessageDialog(null, "You do not have UltimateAttacks !", "Error ..",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				this.assignAttack = new AssignAttack(game, this.attackType.getTypeBox().getSelectedIndex());
				this.attackType.setVisible(false);
				this.assignAttack.setVisible(true);
				this.assignAttack.getAddAttack().addActionListener(this);
				this.assignAttack.getBack().addActionListener(this);
				this.assignAttack.getCancel().addActionListener(this);
			}

			break;

		case "AddOrReplace":
			if (this.assignAttack.getChosenType().charAt(0) == 's') {
				Attack sa = this.game.getPlayer().getSuperAttacks()
						.get(this.assignAttack.getAttackBox().getSelectedIndex());
				if (this.assignAttack.getFightersAttacks().getSelectedIndex() == 0
						|| this.assignAttack.getFightersAttacks().getSelectedItem() == null)
					this.game.getPlayer().getActiveFighter().getSuperAttacks().add((SuperAttack) sa);
				else {
					this.game.getPlayer().getActiveFighter().getSuperAttacks()
							.remove(this.assignAttack.getFightersAttacks().getSelectedIndex() - 1);
					this.game.getPlayer().getActiveFighter().getSuperAttacks().add((SuperAttack) sa);
				}

			} else {
				Attack ua = this.game.getPlayer().getUltimateAttacks()
						.get(this.assignAttack.getAttackBox().getSelectedIndex());
				if (this.assignAttack.getFightersAttacks().getSelectedIndex() == 0
						|| this.assignAttack.getFightersAttacks().getSelectedItem() == null)
					this.game.getPlayer().getActiveFighter().getUltimateAttacks().add((UltimateAttack) ua);
				else {
					this.game.getPlayer().getActiveFighter().getUltimateAttacks()
							.remove(this.assignAttack.getFightersAttacks().getSelectedIndex() - 1);
					this.game.getPlayer().getActiveFighter().getUltimateAttacks().add((UltimateAttack) ua);
				}
			}
			this.assignAttack.setVisible(false);
			this.grid.requestFocus();

			break;
		case "backToChange":
			this.assignAttack.setVisible(false);
			this.attackType.setVisible(true);
			break;
		case "backGrid":
			this.attackType.setVisible(false);
			this.grid.requestFocus();

			break;
		case "Cancel":
			this.assignAttack.setVisible(false);
			this.grid.requestFocus();
			break;

		case "backGridd":
			this.upgrade.setVisible(false);
			this.grid.requestFocus();

			break;

		case "[w]":
			battle = new Battle(game.getPlayer().getActiveFighter(),
					(BattleOpponent) game.getWorld().getMap()[game.getWorld().getPlayerRow()][game.getWorld()
							.getPlayerColumn()]);

			BattleEvent event = new BattleEvent(battle, BattleEventType.STARTED);
			this.onBattleEvent(event);

			// this.game.notifyOnBattleEvent(event);

			break;

		case "[s]":
			this.grid.updatePlayersInfo(game.getPlayer());
			break;

		case "[d]":
			if (this.game.getPlayer().getDragonBalls() == 7 || this.game.getPlayer().getDragonBalls() == 0) {
				this.grid.setVisible(false);
				this.dragonView.setVisible(true);
			}

			this.grid.updatePlayersInfo(game.getPlayer());

			break;

		case "GetSuperAttack":
			try {
				DragonWish wish = getWish(DragonWishType.SUPER_ATTACK);
				// this.game.onDragonCalled();
				this.game.getPlayer().chooseWish(wish);
				this.dragonView.setVisible(false);
				this.grid.requestFocus();
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null,
						"The dragon " + this.chosenDragon.getName() + " does not have SuperAttacks !",
						"Choose Another Wish ..", JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		case "GetUltimateAttack":
			try {
				DragonWish wish = getWish(DragonWishType.ULTIMATE_ATTACK);
				// this.game.onDragonCalled();
				this.game.getPlayer().chooseWish(wish);
				this.dragonView.setVisible(false);
				this.grid.requestFocus();
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null,
						"The dragon " + this.chosenDragon.getName() + " does not have UltimateAttacks !",
						"Choose Another Wish ..", JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		case "GetSenzuBeans":
			try {
				DragonWish wish = getWish(DragonWishType.SENZU_BEANS);
				// this.game.onDragonCalled();
				this.game.getPlayer().chooseWish(wish);
				// System.out.println(this.game.getPlayer().getSenzuBeans()+"sds");
				this.dragonView.setVisible(false);
				this.grid.requestFocus();
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null,
						"The dragon " + this.chosenDragon.getName() + " does not have SenzuBeans !",
						"Choose Another Wish ..", JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		case "GetAbilityPoints":
			try {
				DragonWish wish = getWish(DragonWishType.ABILITY_POINTS);
				this.game.getPlayer().chooseWish(wish);
				this.dragonView.setVisible(false);
				this.grid.requestFocus();
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null,
						"The dragon " + this.chosenDragon.getName() + " does not have AbilityPoints !",
						"Choose Another Wish ..", JOptionPane.INFORMATION_MESSAGE);

			}
			break;

		case "GetAttack":
			this.type = new chooseTypeOfAttack(game);
			this.type.getBack().addActionListener(this);
			this.type.getCon().addActionListener(this);
			this.type.setVisible(true);
			break;

		case "GetBlock":
			battle.block();
			break;

		case "GetUse":
			try {
				battle.use(game.getPlayer(), Collectible.SENZU_BEAN);
			} catch (NotEnoughSenzuBeansException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "New Notification",
						JOptionPane.INFORMATION_MESSAGE);
			}

		case "btnAttack":
			if (this.type.getTypeBox().getSelectedItem().equals("Physical Attack")) {
				try {
					JOptionPane.showMessageDialog(null, "Player is using Physical Attack.", "New Notification",
							JOptionPane.INFORMATION_MESSAGE);
					battle.attack(new PhysicalAttack());
					this.type.setVisible(false);
					this.battleView.requestFocus();
				} catch (NotEnoughKiException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "New Notification",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else if (this.type.getTypeBox().getSelectedItem().equals("Super Attack")) {
				this.sORu = new showAvailableAttacks(game, 's');
				this.sORu.getBack().addActionListener(this);
				this.sORu.getCancel().addActionListener(this);
				this.sORu.getAddAttack().addActionListener(this);
				this.type.setVisible(false);
				this.sORu.setVisible(true);
			} else {
				this.sORu = new showAvailableAttacks(game, 'u');
				this.sORu.getBack().addActionListener(this);
				this.sORu.getCancel().addActionListener(this);
				this.sORu.getAddAttack().addActionListener(this);
				this.type.setVisible(false);
				this.sORu.setVisible(true);
			}

			break;

		case "btnBack":
			this.type.setVisible(false);
			this.battleView.requestFocus();
			break;

		case "attacktoattack":
int attack = this.sORu.getAttackBox().getSelectedIndex();
			
			if (this.sORu.getTemp() == 's') {
				try {
					SuperAttack x = this.game.getPlayer().getActiveFighter().getSuperAttacks().get(attack);
					JOptionPane.showMessageDialog(null, "Player is using SuperAttack : " + x.getName(),
							"New Notification", JOptionPane.INFORMATION_MESSAGE);
					battle.attack(x);
				} catch (NotEnoughKiException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "New Notification",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				UltimateAttack x = this.game.getPlayer().getActiveFighter().getUltimateAttacks().get(attack);
				try {
					JOptionPane.showMessageDialog(null, "Player is using UltimateAttack : " + x.getName(),
							"New Notification", JOptionPane.INFORMATION_MESSAGE);
					battle.attack((UltimateAttack) x);
				} catch (NotEnoughKiException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "New Notification",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}

			break;
		case "backtoback":
			this.sORu.setVisible(false);
			this.type.setVisible(true);

			break;

		case "canceltocancel":
			this.sORu.setVisible(false);
			this.battleView.requestFocus();
			break;

		default:
			;
		}

		// gui.requestFocus();
	}

	public DragonWish getWish(DragonWishType type) {
		DragonWish[] wish = this.chosenDragon.getWishes();
		for (int i = 0; i < wish.length; i++)
			if (type == wish[i].getType())
				return wish[i];
		return null;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		try {
			if (code == KeyEvent.VK_DOWN) {
				game.getWorld().moveDown();
				this.updateMap();
				this.grid.validate();
				this.grid.repaint();
				this.grid.setFocusable(true);
				this.grid.updatePlayersInfo(game.getPlayer());

			} else if (code == KeyEvent.VK_UP) {
				game.getWorld().moveUp();
				this.updateMap();
				this.grid.validate();
				this.grid.repaint();
				this.grid.setFocusable(true);
				this.grid.updatePlayersInfo(game.getPlayer());

			} else if ((code == KeyEvent.VK_RIGHT)) {
				game.getWorld().moveRight();
				this.updateMap();
				this.grid.validate();
				this.grid.repaint();
				this.grid.setFocusable(true);
				this.grid.updatePlayersInfo(game.getPlayer());

			} else if (code == KeyEvent.VK_LEFT) {
				game.getWorld().moveLeft();
				this.updateMap();
				this.grid.validate();
				this.grid.repaint();
				this.grid.setFocusable(true);
				this.grid.updatePlayersInfo(game.getPlayer());
			}
		} catch (MapIndexOutOfBoundsException x) {
			// JOptionPane.showMessageDialog(null, x.getMessage() + "!",
			// "Invalid Move", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDragonCalled(Dragon dragon) {
		this.chosenDragon = dragon;
		this.dragonView.setVisible(true);
		this.dragonView.repaint();
		this.dragonView.validate();

	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
		if (collectible == Collectible.SENZU_BEAN)
			JOptionPane.showMessageDialog(null, "Lucky YOU ! , You have just found a SenzuBean.", "Congrats ..",
					JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Lucky YOU ! , You have just found a DragonBall.", "Congrats ..",
					JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void onBattleEvent(BattleEvent e) {
		Fighter x = (Fighter) (((Battle) (e.getSource())).getFoe());
		battleView.getPlayerName().setText("Name: " + x.getName());
		battleView.getPlayerLevel().setText("Level: " + x.getLevel());
		battleView.getPlayerCK().setText("Ki : " + x.getKi());
		battleView.getPlayerMK().setText("Max Ki: " + x.getMaxKi());
		battleView.getPlayerCS().setText("Stamina: " + x.getStamina());
		battleView.getPlayerMS().setText("Max Stamina: " + x.getMaxStamina());
		battleView.getPlayerHP().setText("HealthPoints: " + x.getHealthPoints());
		battleView.getPlayerMH().setText("MaxHealthPoints " + x.getMaxHealthPoints());

		battleView.getOponentName().setText("Name: " + game.getPlayer().getActiveFighter().getName());
		battleView.getOponentLevel().setText("Level: " + game.getPlayer().getActiveFighter().getLevel());
		battleView.getOponentCK().setText("Ki : " + game.getPlayer().getActiveFighter().getKi());
		battleView.getOponentMK().setText("Max Ki: " + game.getPlayer().getActiveFighter().getMaxKi());
		battleView.getOponentCS().setText("Stamina: " + game.getPlayer().getActiveFighter().getStamina());
		battleView.getOponentMS().setText("Max Stamina: " + game.getPlayer().getActiveFighter().getMaxStamina());
		battleView.getOponentHP().setText("HealthPoints: " + game.getPlayer().getActiveFighter().getHealthPoints());
		battleView.getOponentMH()
				.setText("MaxHealthPoints " + game.getPlayer().getActiveFighter().getMaxHealthPoints());

		// battle = new Battle(game.getPlayer().getActiveFighter(),
		// ((FoeCell)(game.getWorld().getMap()[game.getWorld().getPlayerRow()][game.getWorld().getPlayerColumn()])).getFoe());
		battle = ((Battle) (e.getSource()));
		if (e.getType() == BattleEventType.STARTED) {
			this.battleView.setVisible(true);
			this.battleView.requestFocus();
			battleView.repaint();
			battleView.validate();

		}

		// if (e.getType() == BattleEventType.ATTACK)
		// JOptionPane.showMessageDialog(null, "Player is attacking ..", "New
		// Notification",
		// JOptionPane.INFORMATION_MESSAGE);

		if (e.getType() == BattleEventType.BLOCK)
			if (battle.isMeBlocking())
				JOptionPane.showMessageDialog(null, "Player is blocking !", "New Notification",
						JOptionPane.INFORMATION_MESSAGE);

		if (e.getType() == BattleEventType.USE)
			JOptionPane.showMessageDialog(null, "Player is using a senzuBean", "New Notification",
					JOptionPane.INFORMATION_MESSAGE);

		if (e.getType() == BattleEventType.NEW_TURN) {

			if (battle.getAttacker() == battle.getMe())
				JOptionPane.showMessageDialog(null, "Player's Turn !", "New Notification",
						JOptionPane.INFORMATION_MESSAGE);
			else
				try {
					JOptionPane.showMessageDialog(null, "Opponent's Turn !", "New Notification",
							JOptionPane.INFORMATION_MESSAGE);
					battle.play();

				} catch (NotEnoughKiException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "New Notification",
							JOptionPane.INFORMATION_MESSAGE);
				}

		}

		if (e.getType() == BattleEventType.ENDED) {
			if (e.getWinner() == battle.getFoe())
				JOptionPane.showMessageDialog(null, "Hard Luck , you Lost", "GameOver",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				// mafrod ha3ml 7agat hena bs lsa msh 3arfa
				JOptionPane.showMessageDialog(null, "You Win", "GameOver", JOptionPane.INFORMATION_MESSAGE);

			}

			this.battleView.setVisible(false);
		}
	}

	public BattleView getBattleView() {
		return battleView;
	}

	public void setBattleView(BattleView battleView) {
		this.battleView = battleView;
	}

	@Override
	public void onFoeEncountered(NonPlayableFighter foe) {
		//JOptionPane.showMessageDialog(null, "You've encountered a FOE, Battle is about to START !",
		//		"Foe Encountered ..", JOptionPane.INFORMATION_MESSAGE);

	}

}