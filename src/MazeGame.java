import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * @author Stuart Aitken, Brandon Sandoval, Leah Williams
 *
 */
public class MazeGame implements ActionListener {
	private static int state;
	static MazeGame maze = new MazeGame(0);
	public static void main(String[] args) {
		maze.run();
	}
	
	public MazeGame(int state){
		this.state = state;
	}
	
	public void run() {
		StartPanel start = new StartPanel();
		PlayPanel play = new PlayPanel();
		EndPanel end = new EndPanel(1);
		HelpPanel help = new HelpPanel();

		int difficulty = 0;
		int endState;
		int continueGame = 0;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 500);
	    frame.setVisible(true);
	
	    //if(state != 10){
	    	while(state != 10){
				if(state == 0){
				    frame.add(start, BorderLayout.CENTER);
					end.setVisible(false);
					start.setVisible(true);
					while(difficulty == 0) {
						difficulty = start.getDifficulty();		
					}
					state = 1;
					continueGame = 0;
				}
				else if(state == 1){
					//TODO Still need a working PlayPanel
				    frame.add(new MazeGenerator(10, 100, 100), BorderLayout.CENTER);
					end.setVisible(false);
					start.setVisible(false);
					while(true){}
					
				}
				else if(state == 2){
				    frame.add(end, BorderLayout.CENTER);
					System.out.println("end");
					end = new EndPanel(1);
					start.setVisible(false);
					end.setVisible(true);
					while(continueGame == 0) {
						continueGame = end.getContinueState();
					}
					if(continueGame == 2)
						state = 10;
				}
				frame.dispose();
				run();
				System.out.println(difficulty);

				//frame.add(play, BorderLayout.CENTER);
				//play.play(difficulty);
				//endState = play.getEndState();

				//end = new EndPanel();
				//frame.add(end, BorderLayout.CENTER);
				//end(endState);
				//continueGame = end.continueGame();
				
			};
	    //}
	}

	public void actionListener(ActionEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
