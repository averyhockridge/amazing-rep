
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
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
		JPanel buttonPanel = new JPanel();
		JButton winButton= new JButton("Simulate Win");
		JButton lossButton = new JButton("Simulate Loss");
		
		winButton.addActionListener(new
	            ActionListener()
	            {
	               public void actionPerformed(ActionEvent event)
	               {
	            	   endState = 1;
	               }
	            });		
		
		lossButton.addActionListener(new
	            ActionListener()
	            {
	               public void actionPerformed(ActionEvent event)
	               {
	            	   endState = 2;
	               }
	            });
		
	    buttonPanel.add(winButton);
	    buttonPanel.add(lossButton);
		buttonPanel.setVisible(true);
		
		MazeGenerator mg = maze;
		mg.setVisible(true);
		
		mazePanel.add(mg);
		mazePanel.setVisible(true);
				
		
		this.difficulty = difficulty;
		endState = 0;
		int playerLocation = 0;
		player = new Player(playerLocation, difficulty, mg);
		
		
		this.add(maze, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.EAST);
		this.setBackground(new Color(100,200,150,100));
		
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
		mazePanel.paint(g);
		int location = player.getLocation();
		if(difficulty == 10) {
			//g.drawOval((location%difficulty)*50, (location/difficulty)*50, 50, 50);
			g.drawImage(player.getImage(), (location%difficulty)*50, (location/difficulty)*50, null);
		}
		else if(difficulty == 20) {
			//g.drawOval((location%difficulty)*25, (location/difficulty)*25, 25, 25);	
		}
	}
	
	
	public void keyReleased(KeyEvent e){
		player.keyReleased(e);
		repaint();
	}
}
