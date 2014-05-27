/**
 * A concrete strategy for generating mazes
 * @author Brandon Sandoval
 *
 */
public class MazeContext {
	private MazeStrategy mazeStrategy;
	
	public MazeContext(MazeStrategy mazeStrategy) {
		this.mazeStrategy = mazeStrategy;
	}
	
	/**
	 * Executes a maze generating strategy
	 * @param size
	 * @return
	 */
	public Graph<Integer> executeStrategy(int size) {
		return mazeStrategy.execute(size);
	}
}
