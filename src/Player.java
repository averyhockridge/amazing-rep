import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * 
 * @author Stuart Aitken, Leah Williamson, Brandon Sandoval Avery Hockridge
 *
 */
public class Player extends MazeCommon{
	
	private int location;
	private Image playerImageLarge;
	private Image playerImageSmall;
	private int size;
	private MazeGenerator maze;
	
	private int upKeyCode;
	private int downKeyCode;
	private int leftKeyCode;
	private int rightKeyCode;
	
	public Player(int startLocation, int size, MazeGenerator maze){
		
		location = startLocation;
		try {
			BufferedImage img = ImageIO.read(new File("resources/alien.gif"));
			playerImageLarge = img;
			img = ImageIO.read(new File("resources/alienSmall.gif"));
			playerImageSmall = img;
		} catch (IOException ex){
			
		}
		
		this.size = size;
		this.maze = maze;
		
		//Initilise controls to default arrow keys
		upKeyCode = KeyEvent.VK_UP;
		downKeyCode = KeyEvent.VK_DOWN;
		leftKeyCode = KeyEvent.VK_LEFT;
		rightKeyCode = KeyEvent.VK_RIGHT;
		
		//Load in the controls from config file
		try {
			loadControlsFromFile("resources/controls.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * moves the player in a specific direction, if it can
	 * @param direction
	 */
	public void movePlayer(String direction){
		if (direction.equals("up")){
			if (canMove(direction)){
				location = location - size;
			}			
		} else if (direction.equals("down")){
			if (canMove(direction)){
				location = location + size;
			}			
		}else if (direction.equals("left")){
			if (canMove(direction)){
				location = location - 1;
			}			
		}else if (direction.equals("right")){
			if (canMove(direction)){
				location = location + 1;
			}			
		}
	}

	/**
	 * Checks if the player is within bounds
	 * @param direction
	 * @return
	 */
	private boolean withinBounds(String direction) {
		ArrayList<Integer> neighbours = new ArrayList<Integer>(getNeighbours(location, size));
		int check = 0;
		boolean ret = false;
		
		if(direction.equals("up")){
			check = location - size;
			if(neighbours.contains(check)){
				ret = true;
			}
		}
		
		if(direction.equals("down")){
			check = location + size;
			if(neighbours.contains(check)){
				ret = true;
			}
		}
		
		if(direction.equals("left")){
			check = location - 1;
			if(neighbours.contains(check)){
				ret = true;
			}
		}
		
		if(direction.equals("right")){
			check = location + 1;
			if(neighbours.contains(check)){
				ret = true;
			}
		}
		return ret;
	}
	
	/**
	 * @param direction
	 * @return true if the player can move in a particular direction
	 */
	public boolean canMove(String direction){
		int check = location;
		if(direction.equals("up")){
			check = location - size;
		}
		
		if(direction.equals("down")){
			check = location + size;
		}
		
		if(direction.equals("left")){
			check = location - 1;
		}
		
		if(direction.equals("right")){
			check = location + 1;
		}
		boolean ret = withinBounds(direction) && maze.isConnected(location, check);
		System.out.println("Can now move " + direction + "? " + ret);
		return ret;
	}



	/**
	 * Triggers the player to move on key events -
	 * whatever keys are set in the controls file will move the player
	 * @param e
	 */
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == upKeyCode){
			movePlayer("up");
		} else if (code == downKeyCode){
			movePlayer("down");
		} else if (code == leftKeyCode){
			movePlayer("left");
		} else if (code == rightKeyCode){
			movePlayer("right");
		}
		
	}

	
	/**
	 * 
	 * @return the location of the player
	 */
	public int getLocation(){
		return location;
	}
	
	/**
	 * Gets the image of the player
	 * @return
	 */
	public Image getImage(){
		Image img = null;
		if (size < 20){
			img = playerImageLarge;
		} else {
			img = playerImageSmall;
		}
		return img;
	}
	
	/**
	 * Loads control scheme from a given file
	 * @param path
	 * @throws IOException
	 */
	public void loadControlsFromFile(String path) throws IOException{
		FileReader f = new FileReader(path);
		BufferedReader bf = new BufferedReader(f);
		String line;
		int[] controlsArray = {0,0,0,0};
		int i = 0;
		while ((line = bf.readLine()) != null){
			controlsArray[i] = Integer.parseInt(line);
			i++;
		}
		upKeyCode = controlsArray[0];
		downKeyCode = controlsArray[1];
		leftKeyCode = controlsArray[2];
		rightKeyCode = controlsArray[3];
		
		bf.close();
	}
	
}
