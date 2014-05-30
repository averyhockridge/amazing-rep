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
 * @author Stuart Aitken
 */
public class StartPanel extends JPanel {

	private int difficulty = 0;
	private Image background;

	public StartPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel messagePanel = new JPanel();		
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
		messagePanel.setOpaque(false);
		JLabel message = new JLabel("Choose difficulty to start the game");
		message.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		message.setForeground(new Color(0, 255, 0, 150));
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		messagePanel.add(message);

		try {
			BufferedImage img = ImageIO.read(new File(
					"resources/background.jpg"));
			background = img;
		} catch (IOException ex) {
		}

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setOpaque(false);
		
		JButton easyButton = new JButton();
		try {
			BufferedImage img = ImageIO.read(new File(
					"resources/easybutton.jpg"));
			easyButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		easyButton.setBorder(null);
		buttonPanel.add(easyButton);

		JButton hardButton = new JButton();
		try {
			BufferedImage img = ImageIO.read(new File(
					"resources/hardbutton.jpg"));
			hardButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		hardButton.setBorder(null);
		buttonPanel.add(hardButton);

		easyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				difficulty = 10;
			}
		});

		hardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				difficulty = 20;
			}
		});

		messagePanel.add(buttonPanel);
		this.add(messagePanel, BorderLayout.EAST);
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
		g.drawImage(background, 0, 0, null);
	}
}
