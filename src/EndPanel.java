import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



	/**
	* @author Leah Williams
	*/
	public class EndPanel extends JPanel{
   		/**
   		 * Creating the final screen - either Go again or Quit the game
   		 */

   		private int continueState = 0;
		private Image background;
   		
		
   		public EndPanel(int end){
   			/**
   			 * Draw the screen - depending on how the Play screen ended - i.e. User WON! or User lost
   			 */
   			this.setLayout(new BorderLayout());
   			
   			JPanel messagePanel = new JPanel();		
   			messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
   			messagePanel.setOpaque(false);
   			
   			JLabel message = new JLabel();
   			
   			if (end == 1){	
   				//message.add(new JLabel("Choose difficulty to start the game"));
   				message = new JLabel("Congratulations You Won! - Would you like to play again?");
   			}else {
   				message = new JLabel("Sorry you lost! - Would you like to try again?");	
   			}
   			
   			message.setFont(new Font("Sans Serif", Font.PLAIN, 20));
   			message.setForeground(new Color(0, 255, 0, 150));
   			message.setAlignmentX(Component.CENTER_ALIGNMENT);
   			messagePanel.add(message);

   			
   			try {
   				BufferedImage img = ImageIO.read(new File("resources/background1.jpg"));
   				background = img;
   			} catch (IOException ex) {
   			}
   			
   			JPanel buttonPanel = new JPanel();
   			buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
   			buttonPanel.setOpaque(false);
   			
   			JButton replayButton = new JButton();
   			try {
   				BufferedImage img = ImageIO.read(new File(
   						"resources/goAgainbutton.jpg"));
   				replayButton.setIcon(new ImageIcon(img));
   			} catch (IOException ex) {
   			}
   			replayButton.setBorder(null);
   			buttonPanel.add(replayButton);

   			JButton quitButton = new JButton();
   			try {
   				BufferedImage img = ImageIO.read(new File(
   						"resources/quitbutton.jpg"));
   				quitButton.setIcon(new ImageIcon(img));
   			} catch (IOException ex) {
   			}
   			quitButton.setBorder(null);
   			buttonPanel.add(quitButton);
   			
   			replayButton.addActionListener(new ActionListener() {
   				public void actionPerformed(ActionEvent event) {
   					continueState = 1;
   				}
   			});

   			quitButton.addActionListener(new ActionListener() {
   				public void actionPerformed(ActionEvent event) {
   					continueState = 2;
   				}
   			});
    			
   			messagePanel.add(buttonPanel);
   			this.add(messagePanel, BorderLayout.CENTER);
   		}  

			
   		/**
   		 * 
   		 * @return the state of the game
   		 */
   		public int getContinueState(){
   			return continueState;
   		}
   		
   		@Override
   		public void paintComponent(Graphics g) {
   			g.drawImage(background, 0, 0, null);
   		}
   	}	
			
	

