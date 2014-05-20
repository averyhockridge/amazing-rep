import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


	/**
	* @author Leah Williams
	*/
	public class EndPanel implements ActionListener{
		
		public EndPanel(){
			
		}
		
		/**
		 * Draw the screen
		 */
		public void drawGUI(){
			JPanel messagePanel = new JPanel();
			messagePanel.add(new JLabel("You won! Congrats - Play again?"));
			
			JPanel buttonPanel = new JPanel();
			JButton easyButton = new JButton("Go again");
			JButton hardButton = new JButton("Quit");
		    buttonPanel.add(goAgainButton);
		    buttonPanel.add(quitButton);
			
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(messagePanel, BorderLayout.NORTH);
			frame.add(buttonPanel, BorderLayout.CENTER);
			
			frame.setSize(500, 500);
		    frame.setVisible(true);
			
		}

		/**
		 * get the chosen outcome - ie play on or quit
		 * @return endstatus
		 */
		
			
				
		
		
		public void actionListiner(ActionEvent e){
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {

		}
	
	}
	

