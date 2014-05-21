import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 
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
		this.size = size;
		this.width = width;
		this.height = height;
		maze = new Graph<Integer>();
		//Add all the nodes to the graph
		for(int i = 0; i < size*size; i++) {
			maze.addNode(i);
		}
		
		randomizeMaze();
	}

	/**
	 * Randomised Prim's algorithm (modified version)
	 */
	public void randomizeMaze() {
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> adjacentCells = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int max, rand, node1, node2;
		/*
		int seed = 5;
		Random generator = new Random(seed);*/
		
		//Pick a cell, and add it to visited
		visited.add(0);
		//Add the neighbours of the cell to the adjacentCells list.
		temp.addAll(getUnvisitedNeighbours(0, visited));
		for(int i = 0; i < temp.size(); i++){
			if(!adjacentCells.contains(temp.get(i))) {
				adjacentCells.add(temp.get(i));
			}
		}
		//While there are integers in the adjacentCells list
		while(!adjacentCells.isEmpty()) {
			//Pick a random node in adjacentCell
			adjacentCells.trimToSize();
			max = adjacentCells.size();
			rand = (int)(Math.random()*max);
			//rand = generator.nextInt(max);
			//Assign it to node1
			node1 = adjacentCells.get(rand);
			adjacentCells.remove(rand);
			//node2 is a random possible neighbour for node1
			node2 = getRandomNeighbour(node1, visited);
			
			if(node2 == -1) {
				System.out.println("Error");
				break;
			}//If the cell on the opposite side is already visited, remove it from this list
			else if(visited.contains(node1)) {
				adjacentCells.remove(node1);
			}//If the cell has not been visited, create a link and make the cell visited
			else {
				addLink(node1, node2);
				temp = getUnvisitedNeighbours(node1, visited);
				for(int i = 0; i < temp.size(); i++){
					if(!adjacentCells.contains(temp.get(i))) {
						adjacentCells.add(temp.get(i));
					}
				}
				visited.add(node1);
			}
		}
	}
	/**
	 * Return a random neighbour that is in the adjacent cells list, 
	 * otherwise return -1 if node has no adjacent cells in list
	 * @param neighbours
	 * @param visited
	 * 
	 */
	
	public int getRandomNeighbour(int node, ArrayList<Integer> adjacentCells) {
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		int max, index, ret;
		
		neighbours = getVisitedNeighbours(node, adjacentCells);
		max = neighbours.size();
		
		if(max > 0) {
			index = (int)(Math.random()*max);
			ret = neighbours.get(index);
		}
		else {
			ret = -1;
		}
		return ret;
	}
	/**
	 * Return a list of unvisited neighbours by comparing the 
	 * visited list with a node
	 * @param neighbours
	 * @param visited
	 * 
	 */
	public ArrayList<Integer> getUnvisitedNeighbours(int node, ArrayList<Integer> visited) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> unvisitedNeighbours = new ArrayList<Integer>();
		
		list = getNeighbours(node);
		
		for(int i = 0; i < list.size(); i++) {
			if(!visited.contains(list.get(i))) {
				unvisitedNeighbours.add(list.get(i));
			}
		}
		
		return unvisitedNeighbours;
	}
	/**
	 * Return a list of visited neighbours by comparing the 
	 * visited list with a node
	 * @param neighbours
	 * @param visited
	 * 
	 */
	public ArrayList<Integer> getVisitedNeighbours(int node, ArrayList<Integer> visited) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> visitedNeighbours = new ArrayList<Integer>();
		
		list = getNeighbours(node);
		
		for(int i = 0; i < list.size(); i++) {
			if(visited.contains(list.get(i))) {
				visitedNeighbours.add(list.get(i));
			}
		}
		
		return visitedNeighbours;
	}
	/**
	 * Return a list of neighbours relative to the node, the 
	 * list size should be between 2-4.
	 * @param node
	 * 
	 */
	public ArrayList<Integer> getNeighbours(int node) {
		
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		
		if(node == 0) { //Top-left
			neighbours.add(node+1);
			neighbours.add(node+size);
		}
		else if (node == size-1) { //Top-right
			neighbours.add(node-1);
			neighbours.add(node+size);
		}
		else if (node == size*size-size) { //Bottom-left
			neighbours.add(node+1);
			neighbours.add(node-size);
		}
		else if (node == size*size-1) { //Bottom-right
			neighbours.add(node-1);
			neighbours.add(node-size);
		}
		else if (node%size == 0) { //Left
			neighbours.add(node+1);
			neighbours.add(node+size);
			neighbours.add(node-size);
		}
		else if ((node+1)%size == 0) { //Right
			neighbours.add(node-1);
			neighbours.add(node+size);
			neighbours.add(node-size);
		}
		else if (node<size) { //Top
			neighbours.add(node+1);
			neighbours.add(node-1);
			neighbours.add(node+size);
		}
		else if (node>(size*size-size)) { //Bottom
			neighbours.add(node+1);
			neighbours.add(node-1);
			neighbours.add(node-size);
		}
		else { //Centre (all 4 neighbours)
			neighbours.add(node+1);
			neighbours.add(node-1);
			neighbours.add(node+size);
			neighbours.add(node-size);
		}
		
		return neighbours;
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
	 * @param direction
	 * @return
	 */
	public boolean canMove(int direction){
		return true;
	}	
	private void addLink(int n1, int n2) {
		maze.addEdge(n1, n2);
		maze.addEdge(n2, n1);
	}
	private void deleteLink(int n1, int n2) {
		maze.deleteEdge(n1, n2);
		maze.deleteEdge(n2, n1);
	}
}
