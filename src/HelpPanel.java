import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



	/**
	* @author Leah Williams
	*/
@SuppressWarnings("serial")
public class HelpPanel extends JPanel implements ActionListener{
	         /**
		 * Draw the Help screen
		 */
		 
	private JButton OkButton;
   	private JButton quitButton;
   	private JPanel messagePanel;
	private JPanel buttonPanel;
	int continueState;
		
	public HelpPanel(){
		OkButton = new JButton("OK");
		quitButton = new JButton("Exit");
		messagePanel = new JPanel();
		messagePanel.add(new JLabel("Here is your help page - This is how you should play the game"));
		buttonPanel = new JPanel();
	}
	public void actionListiner(ActionEvent e){
		
	}
	
	/**
	 * Get the chosen outcome - ie play on or quit
   	 * @return endstatus
   	 */
	@Override
   	public void actionPerformed(ActionEvent e) {
   	//   System.out.println("go again"); 
   		if(e.getSource() == OkButton){
   			continueState = 1;
   		} else if (e.getSource() == quitButton) {	
   		//   System.out.println("quitting"); 
   			continueState = 2;
   		}
   	}
			
   	/**
   	 * 
   	 * @return the state of the game
   	 */
   	public int getContinueState(){
   		return continueState;
   	}
 }	
			
	

