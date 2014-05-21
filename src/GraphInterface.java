import java.util.ArrayList;
import java.util.List;

public interface GraphInterface<E> {
	void addNode(E e);
	void deleteNode(E e);
	void addEdge(E e1, E e2);
	void deleteEdge(E e1, E e2);
	boolean contains(E e);
	boolean isConnected(E e1, E e2);
	ArrayList<E> allConnectedNodes(E e);
	int numNodes();
	int numEdges();
	List<E> getNodes();
}
