import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
		JPanel buttonPanel = new JPanel();
		JButton end = new JButton("endTest");
		end.addActionListener(new
	            ActionListener()
	            {
	               public void actionPerformed(ActionEvent event)
	               {
	            	    endState = 1;
	               }
	            });	
		end.setVisible(true);	
		mazePanel.add(new MazeGenerator(difficulty, 200, 200));
		mazePanel.setVisible(true);
		this.difficulty = difficulty;
		endState = 0;
		location = 0;
		player = new Player(location, difficulty);
		
		buttonPanel.add(end);
		buttonPanel.setVisible(true);
		this.add(mazePanel);
		this.add(end);
		
	}
	
	public int getEndState(){
		return endState;
	}
	
	public void paint(Graphics g) {
		location = player.getLocation();
		g.drawOval((location%difficulty)*50, (location/difficulty)*50, 50, 50);
	}
}
