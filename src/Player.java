import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * 
 * @author Stuart Aitken, Leah Williamson, Brandon Sandoval Avery Hockridge
 *
 */
public class Player extends MazeCommon{
	
	private int location;
	private Image player;
	private int size;
	private MazeGenerator maze;
	
	public Player(int startLocation, int size, MazeGenerator maze){
		
		location = startLocation;
		ImageIcon img = new ImageIcon("/src/alien.gif");
		player = img.getImage();
		this.size = size;
		this.maze = maze;
		
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




	public void keyReleased(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_UP){
			movePlayer("up");
		} else if (code == KeyEvent.VK_DOWN){
			movePlayer("down");
		} else if (code == KeyEvent.VK_LEFT){
			movePlayer("left");
		} else if (code == KeyEvent.VK_RIGHT){
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
		return player;
	}
}
