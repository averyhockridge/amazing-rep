import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Draws a randomly generated maze using JPanel based on size, width and height
 * @author Brandon Sandoval
 *
 */

public class MazeGenerator extends JPanel{
	private Graph<Integer> maze;
	private int size;
	private int width;
	private int height;
	
	/**
	 * 
	 * @param size the vertical and horizontal lengths of the maze
	 * @param width the width of the maze in pixels
	 * @param height the height of the maze in pixels
	 */
	public MazeGenerator(int size, int width, int height){
		MazeContext context = new MazeContext(new DFS());
		this.size = size;
		this.width = width;
		this.height = height;
		
		this.setBackground(new Color(0,0,0,150));
		
		maze = new Graph<Integer>();
		maze = context.executeStrategy(size);
	}
	
	/**
	 * This draws the maze with simple lines, we will need to import graphics 
	 * when we decide the technical details of the GUI
	 */
	public void paint(Graphics g) {
		//Border
		g.drawLine(0, 0, 0, height);
		g.drawLine(0, 0, width, 0);
		g.drawLine(width, height, width, 0);
		g.drawLine(width, height, 0, height);
		//Maze
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				//draw vertical walls
				if(j < size-1){
					if(!maze.isConnected(j+(size*i), (j+1)+(size*i))) {
						g.drawLine(width/size+(width/size)*j, i*(height/size), width/size+(width/size)*j, (i+1)*(height/size));
					}
				}
				//draw horizontal walls
				if(i < size-1){
					if(!maze.isConnected(j+(size*i), ((j)+(size*i))+size)) {
						g.drawLine(j*(width/size), height/size+(height/size)*i, (j+1)*(width/size), height/size+(height/size)*i);
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @param n
	 * @param m
	 * @return true if n and m are connected
	 */
	public boolean isConnected(int n, int m){
		return maze.isConnected(n, m);
	}
}
