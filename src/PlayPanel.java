
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * The panel used while the game is being played
 * @author Stuart Aitken, Leah Williams, Brandon Sandoval, Avery Hockridge
 *
 */
public class PlayPanel extends JPanel{

	private final int EASY = 20;
	private final int HARD = 25;
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
		this.setLayout(new GridLayout());
		
		//timer and ActionListener - ends game on time = 0
		final JLabel timerLabel = new JLabel("Start");
		timerLabel.setFont(new Font("Serif", Font.PLAIN, 150));
		timerLabel.setForeground(new Color(166, 105, 174, 255));
		timerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		timerLabel.setVerticalAlignment(SwingConstants.CENTER);
		this.add(timerLabel);
		
		
		
		timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	timerLabel.setText(String.valueOf(timeLimit));
                timeLimit--;
                if(timeLimit < 10){
                	timerLabel.setForeground(Color.RED);
                }
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
		if(difficulty == EASY) {
			g.drawImage(player.getImage(), (location%difficulty)*(500/EASY), (location/difficulty)*(500/EASY)+71, (500/EASY), (500/EASY), null);
		}
		else if(difficulty == HARD) {
			g.drawImage(player.getImage(), (location%difficulty)*(500/HARD), (location/difficulty)*(500/HARD)+71, (500/HARD), (500/HARD), null);
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






