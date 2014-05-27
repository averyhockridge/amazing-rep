
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author Stuart Aitken, Leah Williams, Brandon Sandoval
 *
 */
@SuppressWarnings("serial")
public class PlayPanel extends JPanel{
	/**
	 * 
	 */
	int endState;
	int location;
	Player player;
	int difficulty;
	/**
	 * 
	 */
	public PlayPanel(int difficulty){
		
		
		
		
		JPanel mazePanel = new JPanel();
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
		
		mazePanel.add(new MazeGenerator(difficulty, 200, 200));
		mazePanel.setVisible(true);
		
		
		
		this.difficulty = difficulty;
		endState = 0;
		location = 0;
		player = new Player(location, difficulty);
		
		
		this.add(mazePanel);
		this.add(buttonPanel);
		
	}
	
	public int getEndState(){
		return endState;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		location = player.getLocation();
		if(difficulty == 10) {
			g.drawOval((location%difficulty)*50, (location/difficulty)*50, 50, 50);
		}
		else if(difficulty == 20) {
			g.drawOval((location%difficulty)*25, (location/difficulty)*25, 25, 25);	
		}
	}
	
	
	public void keyReleased(KeyEvent e){
		player.keyReleased(e);
		repaint();
	}
}
