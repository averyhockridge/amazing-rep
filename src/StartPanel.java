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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * the start panel
 * @author Stuart Aitken
 */
public class StartPanel extends JPanel {

	private int difficulty = 0;
	private boolean showHelp = false;
	private Image background;
	private Image help;
	private JButton easyButton;
	private JButton hardButton;
	private JLabel message;
	private JButton helpButton;
	private JButton backButton;

	public StartPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel messagePanel = new JPanel();		
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
		messagePanel.setOpaque(false);
		message = new JLabel("Choose difficulty to start the game");
		message.setFont(new Font("Sans Serif", Font.PLAIN, 30));
		message.setForeground(new Color(0, 255, 0, 150));
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		messagePanel.add(message);

		//Background from wallpapersinhq.com/150816-outer_space_in_green/
		try {
			BufferedImage img = ImageIO.read(new File(
					"resources/background1.jpg"));
			background = img;
		} catch (IOException ex) {
		}
		try {
			BufferedImage img = ImageIO.read(new File(
					"resources/help.jpg"));
			help = img;
		} catch (IOException ex) {
		}

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setOpaque(false);
		
		//Easy button
		easyButton = new JButton();
		try {
			BufferedImage img = ImageIO.read(new File(
					"resources/easybutton.jpg"));
			easyButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		easyButton.setBorder(null);
		buttonPanel.add(easyButton);

		//hard button
		hardButton = new JButton();
		try {
			BufferedImage img = ImageIO.read(new File(
					"resources/hardbutton.jpg"));
			hardButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		hardButton.setBorder(null);
		buttonPanel.add(hardButton);
		
		//help button
		helpButton = new JButton();
		try {
			BufferedImage img = ImageIO.read(new File(
					"resources/helpbutton.jpg"));
			helpButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		helpButton.setBorder(null);
		buttonPanel.add(helpButton);
		
		//back button
		backButton = new JButton();
		try {
			BufferedImage img = ImageIO.read(new File(
					"resources/help.jpg"));
			backButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		backButton.setBorder(null);
		
		buttonPanel.add(backButton);
		backButton.setHorizontalAlignment(SwingConstants.RIGHT);

		easyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				difficulty = 20;
			}
		});

		hardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				difficulty = 25;
			}
		});
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showHelp = true;
				repaint();
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showHelp = false;
				repaint();
			}
		});

		messagePanel.add(buttonPanel);
		this.add(messagePanel, BorderLayout.CENTER);
	}

	/**
	 * get the chosen difficulty setting
	 * 
	 * @return difficulty
	 */
	public int getDifficulty() {
		int ret = difficulty;
		return ret;
	}

	/**
	 * This draws the maze with simple lines, we will need to import graphics
	 * when we decide the technical details of the GUI
	 */
	@Override
	public void paintComponent(Graphics g) {
		if(showHelp) {
			//g.drawImage(help, 0, 0, null);
			easyButton.setVisible(false);
			hardButton.setVisible(false);
			message.setVisible(false);
			helpButton.setVisible(false);
			backButton.setVisible(true);
			
		}else {
			g.drawImage(background, 0, 0, null);
			easyButton.setVisible(true);
			hardButton.setVisible(true);
			message.setVisible(true);
			helpButton.setVisible(true);
			backButton.setVisible(false);
		}
	}
}
