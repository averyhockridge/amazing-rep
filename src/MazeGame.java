import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

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
	
	public static void main(String[] args) throws Exception{
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
	public boolean run() throws Exception{
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
	    
	    //specify the sound to play
	    File soundFile = new File("resources/theme.wav");
	    AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);

	    //load the sound into Clip
	    DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
	    Clip clip = (Clip) AudioSystem.getLine(info);
	    clip.open(sound);

		if(state == START) {
			start = new StartPanel();
			start.setVisible(true);
			frame.add(start);
			frame.setVisible(true);
			
			// play the sound clip
		    	clip.start();
			
			do{
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				difficulty = start.getDifficulty();
			} while((difficulty == 0));
			
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
			
			do{
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				endState = play.getEndState();
			}while(endState == 0);
			
			difficulty = 0;
			state = END;
		}
		else if(state == END) {
			end = new EndPanel(endState);
		    frame.add(end, BorderLayout.CENTER);
			end.setVisible(true);
			
			do{
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continueGame = end.getContinueState();
			}while(continueGame == 0);
			
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
	public class KeyboardListener extends KeyAdapter {
		private PlayPanel p;
		
		public KeyboardListener(PlayPanel p){
			this.p = p;
		}
		public void keyReleased(KeyEvent e){
			p.keyReleased(e);
		}
	}
}
