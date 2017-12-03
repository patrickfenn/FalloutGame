import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	JPanel northPanel;
	JPanel centerPanel;
	JPanel southPanel;
	
	// Objects for the Opening Main Screen of the game
	JLabel mainScreenTitle;
	JButton mainScreenStartGame;
	JButton mainScreenHowToPlay;
	
	// Button for How To Play Screen
	JButton howToPlayReturnToMainScreen;
	
	// Objects for Difficulty Selection Screen
	JLabel difficultyText;
	JButton difficultySelectionButton;
	JComboBox difficultySelectionBox;
	String difficultyString;
	int difficultyInt;
	
	public GUI() {
		// North Center and South Panels
		northPanel = new JPanel();
		centerPanel = new JPanel();
		southPanel = new JPanel();
		northPanel.setBackground(Color.black);
		centerPanel.setBackground(Color.black);
		southPanel.setBackground(Color.black);
		
		// Main Screen
		mainScreenTitle = new JLabel("Fallout Hacking Game");
		mainScreenTitle.setHorizontalAlignment(JLabel.CENTER);
		mainScreenTitle.setFont(new Font("Helvetica", Font.PLAIN, 36));
		mainScreenTitle.setForeground(Color.green);
		mainScreenStartGame = new JButton("Start Game");
		mainScreenHowToPlay = new JButton("How to Play");
		
		// How to Play Screen
		howToPlayReturnToMainScreen = new JButton("Return to Main Menu");
		
		// Difficulty Selection Screen
		difficultySelectionButton = new JButton("Start");
		String[] difficultyNumbers = {"1", "2", "3", "4", "5"};
		difficultySelectionBox = new JComboBox(difficultyNumbers);
		
		// Initialize Main Screen
		northPanel.setLayout(new GridLayout(1, 1));
		northPanel.add(mainScreenTitle);
		southPanel.setLayout(new GridLayout(1, 2));
		southPanel.add(mainScreenStartGame);
		southPanel.add(mainScreenHowToPlay);
		
		// ActionListeners
		ButtonAction buttonAction = new ButtonAction();
		mainScreenStartGame.addActionListener(buttonAction);
		mainScreenHowToPlay.addActionListener(buttonAction);
		howToPlayReturnToMainScreen.addActionListener(buttonAction);
		difficultySelectionButton.addActionListener(buttonAction);
		
		// Add panels to the BorderLayout
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private class ButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == mainScreenStartGame) {
				difficultyText = new JLabel("Select difficulty then press start");
				centerPanel.add(difficultyText);
				difficultyText.setFont(new Font("Helvetica", Font.PLAIN, 16));
				difficultyText.setForeground(Color.white);
				// Remove southpanel buttons and replace with dropdown difficulty and button
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 2));
				southPanel.add(difficultySelectionBox);
				southPanel.add(difficultySelectionButton);

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
				// Remove center panel
				centerPanel.removeAll();
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
				// Remove center panel
				centerPanel.removeAll();
				// Remove south panel button and replaced with "Start Game" and "How to Play"
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 2));
				southPanel.add(mainScreenStartGame);
				southPanel.add(mainScreenHowToPlay);
				
				refresh();
			} else if (event.getSource() == difficultySelectionButton) {
				difficultyString = (String)difficultySelectionBox.getSelectedItem();
				difficultyInt = Integer.parseInt(difficultyString);
				System.out.println(difficultyString);
				if (difficultyInt > 0 && difficultyInt < 5) {
					
				} else {
					
				}
			}
		}
		// Used to update the buttons and text after changing
		public void refresh() {
			revalidate();
			repaint();
		}
	}
}