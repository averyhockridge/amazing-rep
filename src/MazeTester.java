import java.awt.*;
import javax.swing.*;


public class MazeTester{
	public static void main(String[] args){

	      JFrame window = new JFrame();
	      
	      window.setSize(600, 600);
	      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      window.setLayout(new BorderLayout());
	      window.add(new JLabel("Test"), BorderLayout.NORTH);
	      window.add(new MazeGenerator(10, 500, 500), BorderLayout.CENTER);
	      window.add(new JLabel("Test"), BorderLayout.SOUTH);

	      window.setVisible(true);
	      //window.pack();
	}
}
