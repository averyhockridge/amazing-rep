import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * The main game class
 * @author Stuart Aitken, Brandon Sandoval, Leah Williams
 *
 */
public class MazeGame implements ActionListener {

	private final static int START = 0;
	private final int PLAY = 1;
	private final int END = 2;
	private final int QUIT = 3;
	private int state;
	private int difficulty = 0;
	private int endState = 0;
	
	public static void main(String[] args) {
		MazeGame main = new MazeGame(START);
		while(main.run());
	}
	
	public MazeGame(int state){
		this.state = state;
	}
	
	/**
	 * Runs the game.
	 * @return
	 */
	public boolean run() {
		StartPanel start = null;
		PlayPanel play = null;
		MazeGenerator mazeGen = null;
		EndPanel end = null;
		HelpPanel help = null;

		boolean ret;
		int continueGame = 0;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Centre window in middle of screen
		Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
		frame.setSize(1028, 720);
        int h = (d.height - frame.getHeight()) /2;
        int w = (d.width - frame.getWidth()) /2;
		frame.setLocation(w, h);
	    frame.setVisible(true);
	    frame.setResizable(false);

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
			
			
			
			mazeGen = new MazeGenerator(difficulty, 500, 500);
			
			play = new PlayPanel(difficulty, mazeGen);
			
			play.setOpaque(false);
			frame.setGlassPane(play);
			
			play.setVisible(true);

			mazeGen.setBackground(new Color(255, 150, 0, 50));
			
			frame.add(play, BorderLayout.CENTER);
			frame.add(mazeGen, BorderLayout.CENTER);
			
			
			frame.setVisible(true);
			
			frame.addKeyListener(new KeyboardListener(play));
			frame.setFocusable(true);
			

			while(endState == 0){
				endState = play.getEndState();	
				//System.out.println("loop2");
				//System.out.println("tessst");
			}
			difficulty = 0;
			state = END;
		}
		else if(state == END) {
			end = new EndPanel(endState);
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
				endState = 0;
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
	
	/**
	 * Listens to the keyboard, then passes it down to the PlayPanel
	 * @author Avery Hockridge
	 *
	 */
	private class KeyboardListener extends KeyAdapter {
		private PlayPanel p;
		
		public KeyboardListener(PlayPanel p){
			this.p = p;
		}
		public void keyReleased(KeyEvent e){
			p.keyReleased(e);
		}
	}
}
