import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeGame implements ActionListener {

	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		StartPanel start;
		PlayPanel play;
		EndPanel end;
		HelpPanel help;

		Difficulty difficulty;
		int endState;
		boolean continueGame;

		do{
			difficulty = start.getDifficulty();
			start.close();

			play(difficulty);
			endState = play.getEndState();
			play.close();

			end(endState);
			continueGame = end.continueGame();
			end.close();
		}
		while(continueGame);
	}

	public void actionListener(ActionEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
