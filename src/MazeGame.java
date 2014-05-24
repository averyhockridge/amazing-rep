import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Stuart Aitken, Brandon Sandoval, Leah Williams
 *
 */
public class MazeGame implements ActionListener {

	private final static int START = 0;
	private final static int PLAY = 1;
	private final static int END = 2;
	private final static int QUIT = 3;
	private static int state;
	private int difficulty = 0;
	static MazeGame maze = new MazeGame(START);
	
	public static void main(String[] args) {
		while(maze.run());
	}
	
	public MazeGame(int state){
		this.state = state;
	}
	
	public boolean run() {
		StartPanel start = null;
		PlayPanel play = null;
		MazeGenerator mazeGen = null;
		EndPanel end = null;
		HelpPanel help = null;

		boolean ret;
		int endState = 0;
		int continueGame = 0;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 500);
	    frame.setVisible(true);

		if(state == START) {
			start = new StartPanel();
			start.setVisible(true);
			frame.add(start);
			frame.setVisible(true);
			while(difficulty == 0) {
				difficulty = start.getDifficulty();	
				System.out.println("loop1");	
			}
			state = PLAY;
		}
		else if(state == PLAY) {			
			play = new PlayPanel(difficulty);
			play.setVisible(true);
			
			mazeGen = new MazeGenerator(difficulty, 500, 500);
			mazeGen.setVisible(true);

			frame.add(play, BorderLayout.NORTH);
			frame.add(mazeGen, BorderLayout.CENTER);
			
			frame.setVisible(true);

			while(endState == 0){
				endState = play.getEndState();	
				System.out.println("loop2");
			}
			difficulty = 0;
			state = END;
		}
		else if(state == END) {
			end = new EndPanel(1);
		    frame.add(end, BorderLayout.CENTER);
			end.setVisible(true);
			while(continueGame == 0) {
				continueGame = end.getContinueState();	
				System.out.println("loop3");
			}
			if(continueGame == 2) {
				state = QUIT;
			}
			else{
				state = START;
			}
		}
		
		frame.dispose();
		if(state == QUIT) {
			ret = false;
		}
		else{
			ret = true;
		}
		return ret;
	}

	public void actionListener(ActionEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
