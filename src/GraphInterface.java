import java.util.ArrayList;
import java.util.List;

/**
 * An interface for graphs
 * @author Leah Williams
 *
 * @param <E> the type of the graph
 */
public interface GraphInterface<E> {
	/**
	 * Adds a node to the graph
	 * @param e
	 */
	void addNode(E e);
	
	/**
	 * Deletes a node from the graph
	 * @param e
	 */
	void deleteNode(E e);
	
	/**
	 * Adds an edge between two nodes
	 * @param e1
	 * @param e2
	 */
	void addEdge(E e1, E e2);
	
	/**
	 * Deletes an edge between two nodes
	 * @param e1
	 * @param e2
	 */
	void deleteEdge(E e1, E e2);
	
	/**
	 * 
	 * @param e
	 * @return true if the graph contains the given node
	 */
	boolean contains(E e);
	
	/**
	 * 
	 * @param e1
	 * @param e2
	 * @return true if the two nodes are connected
	 */
	boolean isConnected(E e1, E e2);
	
	/**
	 * 
	 * @param e
	 * @return a list of all the nodes connected to a given node
	 */
	ArrayList<E> allConnectedNodes(E e);
	
	/**
	 * 
	 * @return the number of nodes
	 */
	int numNodes();
	
	/**
	 * 
	 * @return the number of edges
	 */
	int numEdges();
	
	/**
	 * 
	 * @return a list of all the nodes
	 */
	List<E> getNodes();
}
