import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
* @author Stuart Aitken
*/
public class StartPanel implements ActionListener{
	
	public StartPanel(){
		
	}
	
	/**
	 * Draw the screen
	 */
	public void drawGUI(){
		JPanel messagePanel = new JPanel();
		messagePanel.add(new JLabel("Choose your difficulty to start the game"));
		
		JPanel buttonPanel = new JPanel();
		JButton easyButton = new JButton("Easy");
		JButton hardButton = new JButton("Hard");
	    buttonPanel.add(easyButton);
	    buttonPanel.add(hardButton);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(messagePanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		
		frame.setSize(500, 500);
	    frame.setVisible(true);
		
	}

	/**
	 * get the chosen difficulty setting
	 * @return difficulty 
	 */
	public Difficulty getDifficulty(String difficulty){
		Difficulty ret = null;
		
		if(difficulty.equals("easy")){
			ret = new Easy();
		}else{
			ret = new Hard();
		}

		return ret;	
	}
	
	public void actionListiner(ActionEvent e){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
