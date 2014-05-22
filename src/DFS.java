import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Depth first search algorithm (backtracking) for maze generation
 * Uses the MazeStrategy
 * @author Brandon Sandoval
 *
 */

public class DFS extends MazeCommon implements MazeStrategy{
	
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
		Deque<Integer> backTrack = new ArrayDeque<Integer>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> adjacentCells = new ArrayList<Integer>();
		int mazeSize = size*size;
		int current = 0;
		int temp = 0;
		
		// 1. Make the initial cell the current cell and mark it as visited
		visited.add(current);
		
		//2. While there are unvisited cells 
		while(visited.size() < mazeSize) {
			adjacentCells.clear();
			adjacentCells.addAll(getUnvisitedNeighbours(current, visited, size));
			
			//1. If the current cell has any neighbours which have not been visited 
			if(!adjacentCells.isEmpty()) {
				//1. Choose randomly one of the unvisited neighbours
				temp = getRandomNeighbour(current, adjacentCells, size);
				//2. Push the current cell to the stack
				backTrack.push(temp);
				//3. Remove the wall between the current cell and the chosen cell
				addLink(maze, current, temp);
				//4. Make the chosen cell the current cell and mark it as visited
				current = temp;
				visited.add(current);
			}
			else if(!backTrack.isEmpty()) {
				//1. Pop a cell from the stack
				temp = backTrack.pop();
				//2. Make it the current cell
				current = temp;
			}
			else {
			    //1. Pick a random unvisited cell, make it the current cell and mark it as visited
				System.out.println("Error");
				break;
			}
		}
		return maze;
	}
	
}
