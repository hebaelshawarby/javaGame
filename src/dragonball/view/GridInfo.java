package dragonball.view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridInfo extends JPanel {
	
	private final JLabel fFightersName = new JLabel("Fighter's Name : ");
	private final JLabel fDragonBalls = new JLabel("Dargon Balls : ");
	private final JLabel fSenzuBeans = new JLabel("Senzu Beans : ");
	private final JLabel fHealthPoints = new JLabel("Health Points : ");
	private final JLabel fStamina = new JLabel("Stamina : ");
	private final JLabel fKi = new JLabel("Ki : ");
	private final JLabel fAbilityPoints = new JLabel("Ability Points : ");
	private final JLabel fPhysicalDamage = new JLabel("Physical Damage : ");
	private final JLabel fBlastDamage = new JLabel("Blast Damage : ");
	private final JLabel fPlayersLevel = new JLabel("Level : ");


	private JLabel vFightersName = new JLabel("Fighter's Name : ");
	private JLabel vDragonBalls = new JLabel("");
	private JLabel vSenzuBeans = new JLabel("");
	private JLabel vHealthPoints = new JLabel("");
	private JLabel vStamina = new JLabel("");
	private JLabel vKi = new JLabel("");
	private JLabel vAbilityPoints = new JLabel("");
	private JLabel vPhysicalDamage = new JLabel("");
	private JLabel vBlastDamage = new JLabel("");
	private JLabel vPlayersLevel = new JLabel("");
	

	public GridInfo() {
		setLayout(new GridLayout(1, 2));

		JPanel playerInfoPanel1 = new JPanel();
		JPanel playerInfoPanel2 = new JPanel();
		playerInfoPanel1.setLayout(new GridLayout(5, 2));
		playerInfoPanel2.setLayout(new GridLayout(5, 2));
		playerInfoPanel1.add(fFightersName);
		playerInfoPanel1.add(vFightersName);
		playerInfoPanel1.add(fPlayersLevel);
		playerInfoPanel1.add(vPlayersLevel);
		playerInfoPanel1.add(fDragonBalls);
		playerInfoPanel1.add(vDragonBalls);
		playerInfoPanel1.add(fSenzuBeans);
		playerInfoPanel1.add(vSenzuBeans);
		playerInfoPanel1.add(fHealthPoints);
		playerInfoPanel1.add(vHealthPoints);
		playerInfoPanel2.add(fStamina);
		playerInfoPanel2.add(vStamina);
		playerInfoPanel2.add(fKi);
		playerInfoPanel2.add(vKi);
		playerInfoPanel2.add(fAbilityPoints);
		playerInfoPanel2.add(vAbilityPoints);
		playerInfoPanel2.add(fPhysicalDamage);
		playerInfoPanel2.add(vPhysicalDamage);
		playerInfoPanel2.add(fBlastDamage);
		playerInfoPanel2.add(vBlastDamage);

		JPanel emptyPanel = new JPanel();

		add(playerInfoPanel1);
		add(playerInfoPanel2);
		
	}
	
	
	
	public JLabel getvDragonBalls() {
		return vDragonBalls;
	}

	public void setvDragonBalls(JLabel vDragonBalls) {
		this.vDragonBalls = vDragonBalls;
	}

	public JLabel getvSenzuBeans() {
		return vSenzuBeans;
	}

	public void setvSenzuBeans(JLabel vSenzuBeans) {
		this.vSenzuBeans = vSenzuBeans;
	}

	public JLabel getvHealthPoints() {
		return vHealthPoints;
	}

	public void setvHealthPoints(JLabel vHealthPoints) {
		this.vHealthPoints = vHealthPoints;
	}

	public JLabel getvStamina() {
		return vStamina;
	}

	public void setvStamina(JLabel vStamina) {
		this.vStamina = vStamina;
	}

	public JLabel getvKi() {
		return vKi;
	}

	public void setvKi(JLabel vKi) {
		this.vKi = vKi;
	}

	public JLabel getvAbilityPoints() {
		return vAbilityPoints;
	}

	public void setvAbilityPoints(JLabel vAbilityPoints) {
		this.vAbilityPoints = vAbilityPoints;
	}

	public JLabel getvPhysicalDamage() {
		return vPhysicalDamage;
	}

	public void setvPhysicalDamage(JLabel vPhysicalDamage) {
		this.vPhysicalDamage = vPhysicalDamage;
	}

	public JLabel getvBlastDamage() {
		return vBlastDamage;
	}

	public void setvBlastDamage(JLabel vBlastDamage) {
		this.vBlastDamage = vBlastDamage;
	}

	public JLabel getvFightersName() {
		return vFightersName;
	}

	public void setvFightersName(JLabel vPlayersName) {
		this.vFightersName = vPlayersName;
	}

	public JLabel getvPlayersLevel() {
		return vPlayersLevel;
	}

	public void setvPlayersLevel(JLabel vPlayersLevel) {
		this.vPlayersLevel = vPlayersLevel;
	}

	public static void main(String[] args) {
		new GridInfo();
	}

}
