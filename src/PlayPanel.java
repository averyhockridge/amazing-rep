import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 
 * @author Stuart Aitken, Leah Williams, Brandon Sandoval
 *
 */
public class PlayPanel extends JPanel{
	int endState;
	int location;
	Player player;
	int difficulty;
	/**
	 * 
	 */
	public PlayPanel(int difficulty){
		JPanel mazePanel = new JPanel();
		mazePanel.add(new MazeGenerator(difficulty, 200, 200), BorderLayout.CENTER);
		//mazePanel.setVisible(true);
		this.difficulty = difficulty;
		endState = 0;
		location = 0;
		player = new Player(location, difficulty);
		
		this.add(mazePanel);
		
	}
	
	public int getEndState(){
	int ret = endState;
	return ret;
	}
	/*
	public void paint(Graphics g) {
		location = player.getLocation();
		g.drawOval(location%difficulty, location/difficulty, 2, 2);
		
	}*/
}
