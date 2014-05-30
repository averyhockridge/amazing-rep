import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The bar is the image which is across the entire screen
 * @author Anne
 *
 */
public class Bar extends JPanel{
	Image barImage = null;
	
	public Bar(){

		try {
			BufferedImage img = ImageIO.read(new File("resources/bar.jpg"));
			barImage = img;
		} catch (IOException ex){
			
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(barImage, 0, 0, null);
	}
}
