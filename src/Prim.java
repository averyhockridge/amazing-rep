import java.util.ArrayList;

/**
 * Prim's modified version algorithm for maze generation
 * Uses the MazeStrategy
 * @author Brandon Sandoval
 *
 */

public class Prim extends MazeCommon implements MazeStrategy{
	
	/**
	 * @param size the vertical and horizontal lengths of the maze
	 * @param width the width of the maze in pixels
	 * @param height the height of the maze in pixels
	 */
	public Graph<Integer> execute(int size) {
		Graph<Integer> maze = new Graph<Integer>();
		//Add all the nodes to the graph
		for(int i = 0; i < size*size; i++) {
			maze.addNode(i);
		}
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> adjacentCells = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int max, rand, node1, node2;
		
		//Pick a cell, and add it to visited
		visited.add(0);
		//Add the neighbours of the cell to the adjacentCells list.
		temp.addAll(getUnvisitedNeighbours(0, visited, size));
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
			//Assign it to node1
			node1 = adjacentCells.get(rand);
			adjacentCells.remove(rand);
			//node2 is a random possible neighbour for node1
			node2 = getRandomNeighbour(node1, visited, size);
			
			if(node2 == -1) {
				System.out.println("Error");
				break;
			}//If the cell on the opposite side is already visited, remove it from this list
			else if(visited.contains(node1)) {
				adjacentCells.remove(node1);
			}//If the cell has not been visited, create a link and make the cell visited
			else {
				addLink(maze, node1, node2);
				temp = getUnvisitedNeighbours(node1, visited, size);
				for(int i = 0; i < temp.size(); i++){
					if(!adjacentCells.contains(temp.get(i))) {
						adjacentCells.add(temp.get(i));
					}
				}
				visited.add(node1);
			}
		}
		return maze;
	}
	
}
