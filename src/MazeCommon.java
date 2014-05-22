import java.util.ArrayList;

/**
 * Common maze functions used by most algorithms,
 * i.e. getting a list of neighbours etc
 * @author Brandon Sandoval
 *
 */
public class MazeCommon {

	/**
	 * Return a random neighbour that is in the adjacent cells list, 
	 * otherwise return -1 if node has no adjacent cells in list
	 * @param neighbours
	 * @param visited
	 * 
	 */
	
	public int getRandomNeighbour(int node, ArrayList<Integer> adjacentCells, int size) {
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		int max, index, ret;
		
		neighbours = getVisitedNeighbours(node, adjacentCells, size);
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
	public ArrayList<Integer> getUnvisitedNeighbours(int node, ArrayList<Integer> visited, int size) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> unvisitedNeighbours = new ArrayList<Integer>();
		
		list = getNeighbours(node, size);
		
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
	public ArrayList<Integer> getVisitedNeighbours(int node, ArrayList<Integer> visited, int size) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> visitedNeighbours = new ArrayList<Integer>();
		
		list = getNeighbours(node, size);
		
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
	public ArrayList<Integer> getNeighbours(int node, int size) {
		
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
	
	public void addLink(Graph<Integer>maze, int n1, int n2) {
		maze.addEdge(n1, n2);
		maze.addEdge(n2, n1);
	}
	
	public void deleteLink(Graph<Integer> maze, int n1, int n2) {
		maze.deleteEdge(n1, n2);
		maze.deleteEdge(n2, n1);
	}
}
