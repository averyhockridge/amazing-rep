import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		 
	private JButton OkButton = new JButton("OK");
   	private JButton quitButton = new JButton("Exit");
   	JPanel messagePanel = new JPanel();
	messagePanel.add(new JLabel("Here is your help page - This is how you should play the game"));
	JPanel buttonPanel = new JPanel();
		
			
	public void actionListiner(ActionEvent e){
		
	}
	
	/**
	 * Get the chosen outcome - ie play on or quit
   	 * @return endstatus
   	 */
	@Override
   	public void actionPerformed(ActionEvent e) {
   	//   System.out.println("go again"); 
   		if(e.getSource() == okButton){
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
			
	

