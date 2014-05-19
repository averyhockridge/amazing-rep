/**
* @author Stuart Aitken
* Makes the maze Harder by setting more paths with less wall breaks
*/
public class Hard implements Difficulty{
	private int size;
	private int extraPaths;

	/**
	 * Easy constructor
	*/
	public Hard(){
		size = 15;
		extraPaths = 0;
	}

	@Override
	public int getSize() {
		int size = this.size;
		return size;
	}

	@Override
	public int getExtraPaths() {
		int extraPaths = this.extraPaths;
		return extraPaths;
	}
}
