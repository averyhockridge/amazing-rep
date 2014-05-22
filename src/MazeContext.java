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
	
	public Graph<Integer> executeStrategy(int size) {
		return this.mazeStrategy.execute(size);
	}
}
