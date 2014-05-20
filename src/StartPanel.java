import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
* @author Stuart Aitken
*/
public class StartPanel implements ActionListener{
	private Difficulty difficulty;
	JButton easyButton;
	JButton hardButton;
	
	public StartPanel(){
		
	}
	
	/**
	 * Draw the screen
	 */
	public void drawGUI(){
		JPanel messagePanel = new JPanel();
		messagePanel.add(new JLabel("Choose your difficulty to start the game"));
		
		JPanel buttonPanel = new JPanel();
		easyButton = new JButton("Easy");
		easyButton.addActionListener(this);
		
		hardButton = new JButton("Hard");
		hardButton.addActionListener(this);
		
	    buttonPanel.add(easyButton);
	    buttonPanel.add(hardButton);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(messagePanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		
		frame.setSize(750, 500);
	    frame.setVisible(true);
		
	}

	/**
	 * get the chosen difficulty setting
	 * @return difficulty 
	 */
	public Difficulty getDifficulty(){
		Difficulty ret = difficulty;
		return ret;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == easyButton){
			difficulty = new Easy();
		}else if (e.getSource() == hardButton){
			difficulty = new Hard();
		}
	}
}
