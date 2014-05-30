
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

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
	private Timer timer;
	private int timeLimit;

    /**
     * PlayPanel constructor - adds a bunch of gui elements and a player
     * @param difficulty the difficulty of the maze.
     */
	public PlayPanel(int difficulty, MazeGenerator maze){
		timeLimit = difficulty * 2;
		
		
		//timer and ActionListener - ends game on time = 0
		final JLabel timerLabel = new JLabel("Start");
		timerLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		timerLabel.setForeground(new Color(0,255,0,150));
		this.add(timerLabel);
		timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	timerLabel.setText(String.valueOf(timeLimit));
                timeLimit--;
                if (timeLimit == 0) {
                      timer.stop();
                      endState = 2;                      
                }
            }
        });
		timer.start();
		
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






