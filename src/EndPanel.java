import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



	/**
	* @author Leah Williams
	*/
   	public class EndPanel extends JPanel implements ActionListener {
   		/**
   		 * 
   		 */
   		private static final long serialVersionUID = 1L;
   		private JButton replayButton = new JButton("Go Again");
   		private JButton quitButton = new JButton("Quit");
   		private int end = 0;
   		private int continueState = 0;
   		//private JFrame frame;
		
   		public EndPanel(int end){
   			this.end = end;
   			/**
   			 * Draw the screen
   			 */
   			JPanel messagePanel = new JPanel();
   			if (end == 1){	
   				messagePanel.add(new JLabel("Congratulations You Won! - Would you like to play again?"));
   			}
   			else {
   				messagePanel.add(new JLabel("Sorry you lost! - Would you like to try again?"));	
   			}
		      
   			JPanel buttonPanel = new JPanel();
   			//JButton replayButton = new JButton("Go Again");
   			replayButton.addActionListener(this);
   			//JButton quitButton = new JButton("Quit");
   			quitButton.addActionListener(this);
   			buttonPanel.add(replayButton);
   			buttonPanel.add(quitButton);
   			this.add(messagePanel);
   			this.add(buttonPanel);
   		}  
   		/**
   		 * get the chosen outcome - ie play on or quit
   		 * @return endstatus
   		 */
			
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			//   System.out.println("go again"); 
   			if(e.getSource() == replayButton){
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
			
	

