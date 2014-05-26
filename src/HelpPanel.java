import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



	/**
	* @author Leah Williams
	*/
	public class HelpPanel implements ActionListener{
		
	/*	public HelpPanel(){
			
		}*/
		
		/**
		 * Draw the screen
		 */
		public void drawGUI(){
			JPanel messagePanel = new JPanel();
			messagePanel.add(new JLabel("Here is your help page - This is how you should play the game"));
			
			JPanel buttonPanel = new JPanel();
	
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(messagePanel, BorderLayout.NORTH);
			frame.add(buttonPanel, BorderLayout.CENTER);
			
			frame.setSize(500, 500);
		    frame.setVisible(true);
			
		}

			
				
		
		
		public void actionListiner(ActionEvent e){
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}

