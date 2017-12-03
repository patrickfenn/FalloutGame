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
	
	// Objects for the Gameplay
	Words gameWords;
	JLabel numberOfGuessesRemaining;
	JLabel lettersCorrect;
	JLabel guessHereLabel;
	JTextField guessHereTextField;
	
	
	public GUI() {
		super("CS31 Project");
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
		mainScreenTitle.setForeground(Color.white);
		mainScreenStartGame = new JButton("Start Game");
		mainScreenHowToPlay = new JButton("How to Play");
		
		// How to Play Screen
		howToPlayReturnToMainScreen = new JButton("Return to Main Menu");
		
		// Difficulty Selection Screen
		difficultySelectionButton = new JButton("Start");
		String[] difficultyNumbers = {"1 (Very Easy)", "2 (Easy)", "3 (Normal)", "4 (Hard)", "5 (Very Hard)"};
		difficultySelectionBox = new JComboBox(difficultyNumbers);
		
		// Initialize Main Screen
		northPanel.setLayout(new GridLayout(1, 1));
		northPanel.add(mainScreenTitle);
		southPanel.setLayout(new GridLayout(1, 2));
		southPanel.add(mainScreenStartGame);
		southPanel.add(mainScreenHowToPlay);
		
		// Game Screen
		numberOfGuessesRemaining = new JLabel("# of guesses remaining: 0");
		numberOfGuessesRemaining.setHorizontalAlignment(JLabel.CENTER);
		numberOfGuessesRemaining.setFont(new Font("Helvetica", Font.PLAIN, 16));
		numberOfGuessesRemaining.setForeground(Color.white);
		
		lettersCorrect = new JLabel("0/10 correct");
		lettersCorrect.setHorizontalAlignment(JLabel.CENTER);
		lettersCorrect.setFont(new Font("Helvetica", Font.PLAIN, 16));
		lettersCorrect.setForeground(Color.white);
		
		guessHereLabel = new JLabel("Guess here:");
		guessHereLabel.setHorizontalAlignment(JLabel.RIGHT);
		guessHereLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
		guessHereLabel.setForeground(Color.white);
		
		guessHereTextField = new JTextField(5);
		
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
	} // end of Constructor
	
	// Actionlistener class that implements the button functions
	private class ButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == mainScreenStartGame) {
				// Add text to center panel
				difficultyText = new JLabel("Select difficulty then press start");
				centerPanel.add(difficultyText);
				difficultyText.setFont(new Font("Helvetica", Font.PLAIN, 16));
				difficultyText.setForeground(Color.green);
				// Remove southpanel buttons and replace with dropdown difficulty and button
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 2));
				southPanel.add(difficultySelectionBox);
				southPanel.add(difficultySelectionButton);

				refresh();
			} else if (event.getSource() == mainScreenHowToPlay) {
				northPanel.setLayout(new GridLayout(6, 1));
				// TextLabel instructions for the game
				// 1 Label
				JLabel howToPlayLabel1 = new JLabel("•In this game, you will be trying to guess the passwords in the terminal.");
				howToPlayLabel1.setFont(new Font("Helvetica", Font.PLAIN, 16));
				howToPlayLabel1.setForeground(Color.green);
				northPanel.add(howToPlayLabel1);
				// 2 Label
				JLabel howToPlayLabel2 = new JLabel("•The amount of words given and letters you will be guessing will be");
				howToPlayLabel2.setFont(new Font("Helvetica", Font.PLAIN, 16));
				howToPlayLabel2.setForeground(Color.green);
				northPanel.add(howToPlayLabel2);
				// 3 Label
				JLabel howToPlayLabel3 = new JLabel("based off your difficulty selected.");
				howToPlayLabel3.setFont(new Font("Helvetica", Font.PLAIN, 16));
				howToPlayLabel3.setForeground(Color.green);
				northPanel.add(howToPlayLabel3);
				// 4 Label
				JLabel howToPlayLabel4 = new JLabel("•After guessing, the game will tell you how many letters you got correct.");
				howToPlayLabel4.setFont(new Font("Helvetica", Font.PLAIN, 16));
				howToPlayLabel4.setForeground(Color.green);
				northPanel.add(howToPlayLabel4);
				// 5 Label
				JLabel howToPlayLabel5 = new JLabel("•You will have four chances to get the correct word or you will lose!");
				howToPlayLabel5.setFont(new Font("Helvetica", Font.PLAIN, 16));
				howToPlayLabel5.setForeground(Color.green);
				northPanel.add(howToPlayLabel5);
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
				// Remove center panel Label to replace with guessing words
				centerPanel.removeAll();
				centerPanel.setLayout(new GridLayout(5, 3));
				centerPanel.setFont(new Font("Helvetica", Font.PLAIN, 16));
				centerPanel.setForeground(Color.green);
				
				// Remove south panel buttons to replace with game buttons
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(2, 2));
				southPanel.add(numberOfGuessesRemaining);
				southPanel.add(lettersCorrect);
				southPanel.add(guessHereLabel);
				southPanel.add(guessHereTextField);
				
				// Based on difficulty selected, will display the amount of words
				if ((String)difficultySelectionBox.getSelectedItem() == "1 (Very Easy)") {
					gameWords = new Words(1);
					lettersCorrect.setText("0/7 Correct");
				} else if ((String)difficultySelectionBox.getSelectedItem() == "2 (Easy)") {
					gameWords = new Words(2);
					lettersCorrect.setText("0/9 Correct");
				} else if ((String)difficultySelectionBox.getSelectedItem() == "3 (Normal)") {
					gameWords = new Words(3);
					lettersCorrect.setText("0/11 Correct");
				} else if ((String)difficultySelectionBox.getSelectedItem() == "4 (Hard)") {
					gameWords = new Words(4);
					lettersCorrect.setText("0/13 Correct");
				} else if ((String)difficultySelectionBox.getSelectedItem() == "5 (Very Hard)") {
					gameWords = new Words(5);
					lettersCorrect.setText("0/15 Correct");
				}
			}
			return;
		}
		// Used to update the buttons and text after changing
		public void refresh() {
			revalidate();
			repaint();
			return;
		}
	}
}