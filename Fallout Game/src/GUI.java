import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	JLabel score;
	JButton mainScreenStartGame;
	JButton mainScreenHowToPlay;
	
	// Button for How To Play Screen
	JButton returnToMainScreen;
	
	// Objects for Difficulty Selection Screen
	JLabel difficultyText;
	JButton difficultySelectionButton;
	JComboBox difficultySelectionBox;
	String difficultyString;
	int difficultyInt;
	
	// Objects for the Gameplay Screen
	Words gameWords;
	JLabel numberOfGuessesRemaining;
	JLabel lettersCorrect;
	JLabel guessHereLabel;
	JTextField guessHereTextField;
	
	// Objects end of game Screen
	JButton exitGame;
	
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
		score = new JLabel("Score: 0");
		score.setFont(new Font("Helvetica", Font.PLAIN, 24));
		score.setForeground(Color.green);
		score.setHorizontalAlignment(JLabel.CENTER);
		mainScreenStartGame = new JButton("Start Game");
		mainScreenHowToPlay = new JButton("How to Play");
		gameWords = new Words(1);
		
		// How to Play Screen
		returnToMainScreen = new JButton("Return to Main Menu");
		
		// Difficulty Selection Screen
		difficultySelectionButton = new JButton("Start");
		String[] difficultyNumbers = {"1 (Very Easy)", "2 (Easy)", "3 (Normal)", "4 (Hard)", "5 (Very Hard)"};
		difficultySelectionBox = new JComboBox(difficultyNumbers);
		
		// Initialize Main Screen
		northPanel.setLayout(new GridLayout(1, 1));
		northPanel.add(mainScreenTitle);
		centerPanel.setLayout(new GridLayout(1, 1));
		centerPanel.add(score);
		southPanel.setLayout(new GridLayout(1, 2));
		southPanel.add(mainScreenStartGame);
		southPanel.add(mainScreenHowToPlay);
		
		// Game Screen
		numberOfGuessesRemaining = new JLabel("Guesses remaining: 4");
		
		lettersCorrect = new JLabel("0/10 correct");
		lettersCorrect.setHorizontalAlignment(JLabel.CENTER);
		lettersCorrect.setFont(new Font("Helvetica", Font.PLAIN, 16));
		lettersCorrect.setForeground(Color.white);
		
		guessHereLabel = new JLabel("Enter your guess here:");
		guessHereLabel.setHorizontalAlignment(JLabel.CENTER);
		guessHereLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
		guessHereLabel.setForeground(Color.white);
		
		guessHereTextField = new JTextField();
		
		exitGame = new JButton("Quit Game");
		
		// ActionListeners
		ButtonAction buttonAction = new ButtonAction();
		mainScreenStartGame.addActionListener(buttonAction);
		mainScreenHowToPlay.addActionListener(buttonAction);
		returnToMainScreen.addActionListener(buttonAction);
		difficultySelectionButton.addActionListener(buttonAction);
		guessHereTextField.addActionListener(buttonAction);
		exitGame.addActionListener(buttonAction);
		
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
				centerPanel.removeAll();
				centerPanel.setLayout(new GridLayout(1, 1));
				difficultyText = new JLabel("Select difficulty then press start");
				centerPanel.add(difficultyText);
				difficultyText.setFont(new Font("Helvetica", Font.PLAIN, 16));
				difficultyText.setHorizontalAlignment(JLabel.CENTER);
				difficultyText.setForeground(Color.green);
				// Remove southpanel buttons and replace with dropdown difficulty and button
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 2));
				southPanel.add(difficultySelectionBox);
				southPanel.add(difficultySelectionButton);

				numberOfGuessesRemaining.setText("Guesses remaining: 4");
				numberOfGuessesRemaining.setHorizontalAlignment(JLabel.CENTER);
				numberOfGuessesRemaining.setFont(new Font("Helvetica", Font.PLAIN, 16));
				numberOfGuessesRemaining.setForeground(Color.blue);
				
				refresh();
			} else if (event.getSource() == mainScreenHowToPlay) {
				northPanel.setLayout(new GridLayout(6, 1));
				// TextLabel instructions for the game
				// 1 Label
				JLabel howToPlayLabel1 = new JLabel("•You will be trying to guess the correct word of the pool of words.");
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
				southPanel.add(returnToMainScreen);
				
				refresh();
			} else if (event.getSource() == returnToMainScreen){
				// Remove north panel text and replaced with "Fallout Hacking Game"
				northPanel.removeAll();
				northPanel.setLayout(new GridLayout(1, 1));
				northPanel.add(mainScreenTitle);
				// Remove center panel
				centerPanel.removeAll();
				centerPanel.setLayout(new GridLayout(1, 1));
				int addScore = gameWords.getTotalScore();
				score.setText("Score: " + Integer.toString(addScore));
				centerPanel.add(score);
				// Remove south panel button and replaced with "Start Game" and "How to Play"
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 2));
				southPanel.add(mainScreenStartGame);
				southPanel.add(mainScreenHowToPlay);
				
				refresh();
			} else if (event.getSource() == difficultySelectionButton) {
				// JLabel wordlist Objects
				JLabel gameWord1 = new JLabel("1");
				gameWord1.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord1.setForeground(Color.green);
				gameWord1.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord2 = new JLabel("1");
				gameWord2.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord2.setForeground(Color.green);
				gameWord2.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord3 = new JLabel("1");
				gameWord3.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord3.setForeground(Color.green);
				gameWord3.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord4 = new JLabel("1");
				gameWord4.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord4.setForeground(Color.green);
				gameWord4.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord5 = new JLabel("1");
				gameWord5.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord5.setForeground(Color.green);
				gameWord5.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord6 = new JLabel("1");
				gameWord6.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord6.setForeground(Color.green);
				gameWord6.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord7 = new JLabel("1");
				gameWord7.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord7.setForeground(Color.green);
				gameWord7.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord8 = new JLabel("1");
				gameWord8.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord8.setForeground(Color.green);
				gameWord8.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord9 = new JLabel("1");
				gameWord9.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord9.setForeground(Color.green);
				gameWord9.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord10 = new JLabel("1");
				gameWord10.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord10.setForeground(Color.green);
				gameWord10.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord11 = new JLabel("1");
				gameWord11.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord11.setForeground(Color.green);
				gameWord11.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord12 = new JLabel("1");
				gameWord12.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord12.setForeground(Color.green);
				gameWord12.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord13 = new JLabel("1");
				gameWord13.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord13.setForeground(Color.green);
				gameWord13.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord14 = new JLabel("1");
				gameWord14.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord14.setForeground(Color.green);
				gameWord14.setHorizontalAlignment(JLabel.CENTER);
				JLabel gameWord15 = new JLabel("1");
				gameWord15.setFont(new Font("Helvetica", Font.PLAIN, 14));
				gameWord15.setForeground(Color.green);
				gameWord15.setHorizontalAlignment(JLabel.CENTER);
				
				// Remove center panel Label to replace with guessing words
				centerPanel.removeAll();
				centerPanel.setLayout(new GridLayout(0, 3));
				
				// Remove south panel buttons to replace with game buttons
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(2, 2));
				southPanel.add(numberOfGuessesRemaining);
				southPanel.add(lettersCorrect);
				southPanel.add(guessHereLabel);
				southPanel.add(guessHereTextField);
				
				refresh();
				// Based on difficulty selected, will display the amount of words
				if ((String)difficultySelectionBox.getSelectedItem() == "1 (Very Easy)") {
					gameWords = new Words(1);
					ArrayList<String> array = gameWords.getWordList();
					
					gameWord1.setText(array.get(0));
					centerPanel.add(gameWord1);
					gameWord2.setText(array.get(1));
					centerPanel.add(gameWord2);
					gameWord3.setText(array.get(2));
					centerPanel.add(gameWord3);
					gameWord4.setText(array.get(3));
					centerPanel.add(gameWord4);
					gameWord5.setText(array.get(4));
					centerPanel.add(gameWord5);
					gameWord6.setText(array.get(5));
					centerPanel.add(gameWord6);
					gameWord7.setText(array.get(6));
					centerPanel.add(gameWord7);
					
					lettersCorrect.setText("Guess the 4 letter word");
				} else if ((String)difficultySelectionBox.getSelectedItem() == "2 (Easy)") {
					gameWords = new Words(2);
					ArrayList<String> array = gameWords.getWordList();
					
					gameWord1.setText(array.get(0));
					centerPanel.add(gameWord1);
					gameWord2.setText(array.get(1));
					centerPanel.add(gameWord2);
					gameWord3.setText(array.get(2));
					centerPanel.add(gameWord3);
					gameWord4.setText(array.get(3));
					centerPanel.add(gameWord4);
					gameWord5.setText(array.get(4));
					centerPanel.add(gameWord5);
					gameWord6.setText(array.get(5));
					centerPanel.add(gameWord6);
					gameWord7.setText(array.get(6));
					centerPanel.add(gameWord7);
					gameWord8.setText(array.get(7));
					centerPanel.add(gameWord8);
					gameWord9.setText(array.get(8));
					centerPanel.add(gameWord9);
					
					lettersCorrect.setText("Guess the 5 letter word");
				} else if ((String)difficultySelectionBox.getSelectedItem() == "3 (Normal)") {
					gameWords = new Words(3);
					ArrayList<String> array = gameWords.getWordList();
					
					gameWord1.setText(array.get(0));
					centerPanel.add(gameWord1);
					gameWord2.setText(array.get(1));
					centerPanel.add(gameWord2);
					gameWord3.setText(array.get(2));
					centerPanel.add(gameWord3);
					gameWord4.setText(array.get(3));
					centerPanel.add(gameWord4);
					gameWord5.setText(array.get(4));
					centerPanel.add(gameWord5);
					gameWord6.setText(array.get(5));
					centerPanel.add(gameWord6);
					gameWord7.setText(array.get(6));
					centerPanel.add(gameWord7);
					gameWord8.setText(array.get(7));
					centerPanel.add(gameWord8);
					gameWord9.setText(array.get(8));
					centerPanel.add(gameWord9);
					gameWord10.setText(array.get(9));
					centerPanel.add(gameWord10);
					gameWord11.setText(array.get(10));
					centerPanel.add(gameWord11);
					
					lettersCorrect.setText("Guess the 6 letter word");
				} else if ((String)difficultySelectionBox.getSelectedItem() == "4 (Hard)") {
					gameWords = new Words(4);
					ArrayList<String> array = gameWords.getWordList();
					
					gameWord1.setText(array.get(0));
					centerPanel.add(gameWord1);
					gameWord2.setText(array.get(1));
					centerPanel.add(gameWord2);
					gameWord3.setText(array.get(2));
					centerPanel.add(gameWord3);
					gameWord4.setText(array.get(3));
					centerPanel.add(gameWord4);
					gameWord5.setText(array.get(4));
					centerPanel.add(gameWord5);
					gameWord6.setText(array.get(5));
					centerPanel.add(gameWord6);
					gameWord7.setText(array.get(6));
					centerPanel.add(gameWord7);
					gameWord8.setText(array.get(7));
					centerPanel.add(gameWord8);
					gameWord9.setText(array.get(8));
					centerPanel.add(gameWord9);
					gameWord10.setText(array.get(9));
					centerPanel.add(gameWord10);
					gameWord11.setText(array.get(10));
					centerPanel.add(gameWord11);
					gameWord12.setText(array.get(11));
					centerPanel.add(gameWord12);
					gameWord13.setText(array.get(12));
					centerPanel.add(gameWord13);
					
					lettersCorrect.setText("Guess the 7 letter word");
				} else if ((String)difficultySelectionBox.getSelectedItem() == "5 (Very Hard)") {
					gameWords = new Words(5);
					ArrayList<String> array = gameWords.getWordList();
					
					gameWord1.setText(array.get(0));
					centerPanel.add(gameWord1);
					gameWord2.setText(array.get(1));
					centerPanel.add(gameWord2);
					gameWord3.setText(array.get(2));
					centerPanel.add(gameWord3);
					gameWord4.setText(array.get(3));
					centerPanel.add(gameWord4);
					gameWord5.setText(array.get(4));
					centerPanel.add(gameWord5);
					gameWord6.setText(array.get(5));
					centerPanel.add(gameWord6);
					gameWord7.setText(array.get(6));
					centerPanel.add(gameWord7);
					gameWord8.setText(array.get(7));
					centerPanel.add(gameWord8);
					gameWord9.setText(array.get(8));
					centerPanel.add(gameWord9);
					gameWord10.setText(array.get(9));
					centerPanel.add(gameWord10);
					gameWord11.setText(array.get(10));
					centerPanel.add(gameWord11);
					gameWord12.setText(array.get(11));
					centerPanel.add(gameWord12);
					gameWord13.setText(array.get(12));
					centerPanel.add(gameWord13);
					gameWord14.setText(array.get(13));
					centerPanel.add(gameWord14);
					gameWord15.setText(array.get(14));
					centerPanel.add(gameWord15);
					
					lettersCorrect.setText("Guess the 8 letter word");
				}
				refresh();
			} else if (event.getSource() == guessHereTextField) {
				gameWords.guessTaken();
				String userGuess = guessHereTextField.getText();
				guessHereTextField.setText("");
				gameWords.checkMatches(userGuess);
				if (gameWords.checkMatches(userGuess) == 999) {
					gameWords.increaseTotalScore();
					
					centerPanel.removeAll();
					centerPanel.setLayout(new GridLayout(1,1));
					JLabel youWin = new JLabel ("You were successful!");
					youWin.setHorizontalAlignment(JLabel.CENTER);
					youWin.setFont(new Font("Helvetica", Font.PLAIN, 36));
					youWin.setForeground(Color.green);
					centerPanel.add(youWin);
					
					southPanel.removeAll();
					southPanel.setLayout(new GridLayout(1,2));
					southPanel.add(returnToMainScreen);
					southPanel.add(exitGame);
				} else if (gameWords.checkMatches(userGuess) == 0) {
					lettersCorrect.setText("You got 0 letters correct");
				} else if (gameWords.checkMatches(userGuess) == 1) {
					lettersCorrect.setText("You got 1 letter correct");
				} else if (gameWords.checkMatches(userGuess) == 2) {
					lettersCorrect.setText("You got 2 letters correct");
				} else if (gameWords.checkMatches(userGuess) == 3) {
					lettersCorrect.setText("You got 3 letters correct");
				} else if (gameWords.checkMatches(userGuess) == 4) {
					lettersCorrect.setText("You got 4 letters correct");
				} else if (gameWords.checkMatches(userGuess) == 5) {
					lettersCorrect.setText("You got 5 letters correct");
				} else if (gameWords.checkMatches(userGuess) == 6) {
					lettersCorrect.setText("You got 6 letters correct");
				} else if (gameWords.checkMatches(userGuess) == 7) {
					lettersCorrect.setText("You got 7 letters correct");
				}
				if (gameWords.getGuessesLeft() == 3) {
					numberOfGuessesRemaining.setText("Guesses Remaining: 3");
					numberOfGuessesRemaining.setForeground(Color.yellow);
				} else if (gameWords.getGuessesLeft() == 2) {
					numberOfGuessesRemaining.setText("Guesses Remaining: 2");
					numberOfGuessesRemaining.setForeground(Color.orange);
				} else if (gameWords.getGuessesLeft() == 1) {
					numberOfGuessesRemaining.setText("Guesses Remaining: 1");
					numberOfGuessesRemaining.setForeground(Color.red);
				} else if (gameWords.getGuessesLeft() == 0 && gameWords.checkMatches(userGuess) != 999) {
					centerPanel.removeAll();
					centerPanel.setLayout(new GridLayout(1,1));
					JLabel youLose = new JLabel ("You were unsucessful!");
					youLose.setHorizontalAlignment(JLabel.CENTER);
					youLose.setFont(new Font("Helvetica", Font.PLAIN, 36));
					youLose.setForeground(Color.red);
					centerPanel.add(youLose);
					
					southPanel.removeAll();
					southPanel.setLayout(new GridLayout(1,2));
					southPanel.add(returnToMainScreen);
					southPanel.add(exitGame);
					
				}
				refresh();
			} else if (event.getSource() == exitGame) {
				System.exit(0);
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