import java.awt.Color;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {

		//testing
		Words test = new Words(3);
		System.out.print(test.returnWordsList());
		
		GUI gui = new GUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(512, 288);
		gui.getContentPane().setBackground(Color.black);
		gui.setVisible(true);
	}

}