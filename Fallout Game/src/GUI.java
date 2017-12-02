import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	JPanel northPanel;
	JPanel southPanel;
	// Title of the Game
	JLabel mainScreenTitle;
	
	// Objects for the Opening Main Screen of the game
	JButton mainScreenStartGame;
	JButton mainScreenHowToPlay;
	
	// Button for How To Play Screen
	JButton howToPlayReturnToMainScreen;
	
	// Objects for Difficulty Selection Screen
	JButton difficultySelectionButton;
	JTextField difficultySelectionTextField;
	
	public GUI() {
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		mainScreenTitle = new JLabel("Fallout Hacking Game");
		mainScreenTitle.setHorizontalAlignment(JLabel.CENTER);
		mainScreenTitle.setFont(new Font("Helvetica", Font.PLAIN, 36));
		mainScreenTitle.setForeground(Color.green);
		mainScreenStartGame = new JButton("Start Game");
		mainScreenHowToPlay = new JButton("How to Play");
		
		northPanel.setLayout(new GridLayout(1, 1));
		northPanel.add(mainScreenTitle);
		northPanel.setBackground(Color.black);
		
		southPanel.setLayout(new GridLayout(1, 2));
		southPanel.add(mainScreenStartGame);
		southPanel.add(mainScreenHowToPlay);
		southPanel.setBackground(Color.black);
		
		howToPlayReturnToMainScreen = new JButton("Return to Main Menu");
		
		difficultySelectionButton = new JButton("Select Difficulty (1-5)");
		difficultySelectionTextField = new JTextField();
		
		ButtonAction buttonAction = new ButtonAction();
		mainScreenStartGame.addActionListener(buttonAction);
		mainScreenHowToPlay.addActionListener(buttonAction);
		howToPlayReturnToMainScreen.addActionListener(buttonAction);
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private class ButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == mainScreenStartGame) {
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 2));
				
				refresh();
			} else if (event.getSource() == mainScreenHowToPlay) {
				northPanel.setLayout(new GridLayout(5, 1));
				// TextLabel instructions for the game
				// 1 Label
				JLabel howToPlayLabel1 = new JLabel("•In this game, you will be trying to guess the passwords in the terminal.");
				howToPlayLabel1.setFont(new Font("Helvetica", Font.PLAIN, 16));
				howToPlayLabel1.setForeground(Color.white);
				northPanel.add(howToPlayLabel1);
				// 2 Label
				JLabel howToPlayLabel2 = new JLabel("•The amount of words and letters you will be guessing will be based");
				howToPlayLabel2.setFont(new Font("Helvetica", Font.PLAIN, 16));
				howToPlayLabel2.setForeground(Color.white);
				northPanel.add(howToPlayLabel2);
				// 3 Label
				JLabel howToPlayLabel3 = new JLabel("off your difficulty selected.");
				howToPlayLabel3.setFont(new Font("Helvetica", Font.PLAIN, 16));
				howToPlayLabel3.setForeground(Color.white);
				northPanel.add(howToPlayLabel3);
				// 4 Label
				JLabel howToPlayLabel4 = new JLabel("•After guessing, the game will tell you how many letters you got correct.");
				howToPlayLabel4.setFont(new Font("Helvetica", Font.PLAIN, 16));
				howToPlayLabel4.setForeground(Color.white);
				northPanel.add(howToPlayLabel4);
				// Remove southpanel buttons and replaced with "Return to Main Screen"
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 1));
				southPanel.add(howToPlayReturnToMainScreen);
				
				refresh();
			} else if (event.getSource() == howToPlayReturnToMainScreen){
				// Remove north panel text and replaced with "Fallout Hacking Game"
				northPanel.removeAll();
				northPanel.setLayout(new GridLayout(1, 1));
				northPanel.add(mainScreenTitle);
				// Remove south panel buttons and replaced with "Start Game" and "How to Play"
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 2));
				southPanel.add(mainScreenStartGame);
				southPanel.add(mainScreenHowToPlay);
				
				refresh();
			}
		}
		// Used to update the buttons and text after changing
		public void refresh() {
			revalidate();
			repaint();
		}
	}
}