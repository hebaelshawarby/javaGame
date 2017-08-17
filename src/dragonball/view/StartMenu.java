package dragonball.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartMenu extends JFrame {

	private JButton NewGame = new JButton("New Game");
	private JButton LoadGame = new JButton("Load Game");
	private JButton QuitGame = new JButton("Quit Game");
	private JLabel jLabel = new JLabel();
	private ImageIcon image;

	
	public StartMenu() {
		super("Start Menu");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 400);
		
		this.NewGame.setActionCommand("NewGame");
		this.LoadGame.setActionCommand("LoadGame");
		this.QuitGame.setActionCommand("QuitGame");
		/**
		image = new ImageIcon("C:/Users/HP-PC/Desktop/Game/ii.jpg");
		Image img = image.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
		jLabel.setIcon(new ImageIcon(img));
		this.setContentPane(jLabel);
		**/
		this.setLayout(new GridLayout(3,3));
		this.add(NewGame);
			this.add(LoadGame);
		this.add(QuitGame);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//this.setActionListener(new Action());
	}
	
	public JButton getNewGame() {
		return NewGame;
	}

	public void setNewGame(JButton newGame) {
		NewGame = newGame;
	}

	public JButton getLoadGame() {
		return LoadGame;
	}

	public void setLoadGame(JButton loadGame) {
		LoadGame = loadGame;
	}

	public JButton getQuitGame() {
		return QuitGame;
	}

	public void setQuitGame(JButton quitGame) {
		QuitGame = quitGame;
	}

	public JLabel getjLabel() {
		return jLabel;
	}

	public void setjLabel(JLabel jLabel) {
		this.jLabel = jLabel;
	}


}
