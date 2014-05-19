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
		size = 0;
		extraPaths = 0;
	}

	@Override
	public int getSize() {

		return size;
	}

	@Override
	public int getExtraPaths() {

		return extraPaths;
	}
}
