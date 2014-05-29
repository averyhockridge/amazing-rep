import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
		frame.setSize(851, 532);
        int h = (d.height - frame.getHeight()) /2;
        int w = (d.width - frame.getWidth()) /2;
		frame.setLocation(w, h);
	    frame.setVisible(true);
	    frame.setResizable(false);
	    
	    //specify the sound to play
	    File soundFile = new File("resources/theme.wav");
	    AudioInputStream sound = null;
		try {
			sound = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    //load the sound into Clip
	    DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
	    Clip clip = null;
		try {
			clip = (Clip) AudioSystem.getLine(info);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
	    try {
			clip.open(sound);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if(state == START) {
			start = new StartPanel();
			start.setVisible(true);
			frame.add(start);
			frame.setVisible(true);
			
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
			

			// play the sound clip
		    	clip.start();
			
			mazeGen = new MazeGenerator(difficulty, 500, 500);
			
			play = new PlayPanel(difficulty, mazeGen);
			
			play.setOpaque(false);
			frame.setGlassPane(play);
			
			play.setVisible(true);
			
			frame.add(play, BorderLayout.CENTER);
			frame.add(mazeGen, BorderLayout.CENTER);
			
			
			frame.setVisible(true);
			
			frame.addKeyListener(new KeyboardListener(play));
			frame.setFocusable(true);
			play.repaint();
			
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
