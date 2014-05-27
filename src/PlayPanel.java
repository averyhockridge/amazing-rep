
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * The panel used while the game is being played
 * @author Stuart Aitken, Leah Williams, Brandon Sandoval, Avery Hockridge
 *
 */
@SuppressWarnings("serial")
public class PlayPanel extends JPanel{

	private int    endState;
	private Player player;
	private int    difficulty;
	private int    goalLocation;
	private JPanel mazePanel;

    /**
     * PlayPanel constructor - adds a bunch of gui elements and a player
     * @param difficulty the difficulty of the maze.
     */
	public PlayPanel(int difficulty, MazeGenerator maze){

		mazePanel = new JPanel();
				
		
		this.difficulty = difficulty;
		endState = 0;
		int playerLocation = 0;
		player = new Player(playerLocation, difficulty, maze);
		goalLocation = difficulty * difficulty - 1;
		
		
	}
	
	/**
	 * 
	 * @return the endState (0 if it hasn't ended yet)
	 */
	public int getEndState(){
		return endState;
	}
	

	public void paint(Graphics g) {
		super.paint(g);
		
		int location = player.getLocation();
		if(difficulty == 10) {
			g.drawImage(player.getImage(), (location%difficulty)*50, (location/difficulty)*50, null);
		}
		else if(difficulty == 20) {
			g.drawImage(player.getImage(), (location%difficulty)*25, (location/difficulty)*25, null);
		}
		if (location == goalLocation){
			endState = 1;
		}
		System.out.println("Currently at " + location + " going to " + goalLocation);
	}
	
	
	/**
	 * runs when a key is pressed
	 * @param e
	 */
	public void keyReleased(KeyEvent e){
		player.keyReleased(e);
		repaint();
	}
}
