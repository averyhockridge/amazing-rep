import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



	/**
	* @author Leah Williams
	*/
	public class EndPanel extends JPanel implements ActionListener {
   		/**
   		 * Creating the final screen - either Go again or Quit the game
   		 */
   		private JButton replayButton = new JButton("Go Again");
   		private JButton quitButton = new JButton("Quit");
   		private int end = 0;
   		private int continueState = 0;
   		
		
   		public EndPanel(int end){
   			this.end = end;
   			/**
   			 * Draw the screen - depending on how the Play screen ended - i.e. User WON! or User lost
   			 */
   			
   			JPanel buttonPanel = new JPanel();
 			replayButton.addActionListener(this);
  			quitButton.addActionListener(this);
			buttonPanel.add(replayButton);
			buttonPanel.add(quitButton);
   			
   			JLabel won = new JLabel("Congratulations You Won! - Would you like to play again?");
   			JLabel lost = new JLabel("Sorry you lost! - Would you like to try again?");
   			if (end == 1){	
   				this.add(won);
   			}
   			else {
   				this.add(lost);	
   			}
   			
   			this.add(buttonPanel);
   		}  
   		/**
   		 * Get the chosen outcome - ie play on or quit
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
			
	

