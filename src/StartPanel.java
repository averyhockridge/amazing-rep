import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
* @author Stuart Aitken
*/
@SuppressWarnings("serial")
public class StartPanel extends JPanel{

	private int difficulty = 0;
	
	public StartPanel(){
		JPanel messagePanel = new JPanel();
		this.add(new JLabel("Choose your difficulty to start the game"));
		
		JPanel buttonPanel = new JPanel();
		JButton easyButton= new JButton("Easy");
		JButton hardButton = new JButton("Hard");
		
		easyButton.addActionListener(new
	            ActionListener()
	            {
	               public void actionPerformed(ActionEvent event)
	               {
	            	   difficulty = 10;
	               }
	            });		
		
		hardButton.addActionListener(new
	            ActionListener()
	            {
	               public void actionPerformed(ActionEvent event)
	               {
	            	   difficulty = 20;
	               }
	            });
		
	    buttonPanel.add(easyButton);
	    buttonPanel.add(hardButton);	
	    
	    this.add(messagePanel);
	    this.add(buttonPanel);
	}

	/**
	 * get the chosen difficulty setting
	 * @return difficulty 
	 */
	public int getDifficulty(){
		int ret = difficulty;
		return ret;	
	}
}
