import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author Avery Hockridge (ajho661)
 *
 */
public class Player implements KeyListener{
	
	private Point location;
	
	public Player(Point startLocation){
		location = new Point(startLocation.x, startLocation.y);
	}
	
	/**
	 * moves the player in a specific direction, if it can
	 * @param direction
	 */
	public void movePlayer(String direction){
		if (direction.equals("up")){
			location.y = location.y + 1;
		} else if (direction.equals("down")){
			location.y = location.y - 1;
		} else if (direction.equals("left")){
			location.x = location.x - 1;
		} else {
			location.x = location.x + 1;
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
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

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @return the location of the player
	 */
	public Point getLocation(){
		return location;
	}
	

}
