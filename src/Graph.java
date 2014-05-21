import java.util.ArrayList;
import java.util.List;

public class Graph<E> implements GraphInterface<E>{

	public Graph() {
		nodes = new ArrayList<E>();
		graph = new ArrayList<ArrayList<E>>();
	}
	
	public void addNode(E e) {
		if(!nodes.contains(e)){
			nodes.add(e);
			graph.add(new ArrayList<E>());
		}
	}

	public void deleteNode(E e) {
		if(nodes.contains(e)){
			int index = nodes.indexOf(e);
			nodes.remove(e);
			graph.remove(index);
		}
	}

	public void addEdge(E e1, E e2) {
		int index = nodes.indexOf(e1);
		graph.get(index).add(e2);
	}

	public void deleteEdge(E e1, E e2) {
		int index1 = nodes.indexOf(e1);
		int index2 = graph.get(index1).indexOf(e2);
		graph.get(index1).remove(index2);
	}

	public boolean contains(E e) {
		return nodes.contains(e);
	}

	public int numNodes() {
		nodes.trimToSize();
		return nodes.size();
	}

	public int numEdges() {
		int count = 0;
		for(int i = 0; i < graph.size(); i++){
			count += graph.get(i).size();
		}
		return count;
	}

	public List<E> getNodes() {
		ArrayList<E> copyNodes = new ArrayList<E>();
		copyNodes.addAll(0, nodes);
		return copyNodes;
	}
	
	public boolean isConnected(E e1, E e2) {
		int index = nodes.indexOf(e1);

		if(nodes.contains(e1) && nodes.contains(e2)){
			if(graph.get(index).contains(e2)){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<E> allConnectedNodes(E e){
		ArrayList<E> list = new ArrayList<E>();
		int index = nodes.indexOf(e);
		list.addAll(0, graph.get(index));
		return list;
	}
	
	private ArrayList<E> nodes;
	private ArrayList<ArrayList<E>> graph;
}
