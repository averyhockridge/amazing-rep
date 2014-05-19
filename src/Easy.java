/**
* @author Stuart Aitken
* Makes the maze Easier by setting less paths with more wall breaks
*/
public class Easy implements Difficulty{
	private int size;
	private int extraPaths;

	/**
	 * Easy constructor
	*/
	public Easy(){
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
