import java.awt.Color;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		
		GUI gui = new GUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(512, 288);
		gui.getContentPane().setBackground(Color.black);
		gui.setVisible(true);
	}

}