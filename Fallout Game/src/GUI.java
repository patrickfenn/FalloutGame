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
	// Panels of North Center and South regions of the GUI, will be manipulated throughout game
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	
	// JLabel gameTitle will be on every screen on the GUI
	private JLabel gameTitle;
	
	// Objects for the Opening Screen of the Game
	private JLabel openingScreenScore;	// Keeps score
	private JButton openingScreenStartGame;	// Button to Difficulty Selection screen
	private JButton openingScreenHowToPlay;	// Button to How to Play screen
	
	// Return to Opening Screen (used in How to Play Screen and at the end of the game screens)
	private JButton returnToOpeningScreen;	// Return to Opening Screen
	
	// Objects for Difficulty Selection Screen
	private JLabel difficultyText;		// Notifys user to select difficulty to proceed
	private JComboBox difficultySelectionBox;	// User selects difficulty of the game
	private JButton difficultySelectionButton;	// Start game after difficulty is selected
	
	// Objects for the Gameplay Screen
	private Words gameWords;		// Declares gameWords (Game Logic of the program)
	private JLabel numberOfGuessesRemaining;	// Notifys the user of how many guesses left
	private JLabel lettersCorrect;	// Notifys the user of how many letters they got correct
	private JLabel guessHereLastWord;	// Notifys the user to type in their guess in guessHereTextField
	private JTextField guessHereTextField;	// Textfield where the user will put in their guess
	
	// Objects end of game Screen
	private JButton exitGame;	// Option to exit the program at the end of each game (Win or lose)
	
	// JLabel wordlist Objects
	JLabel gameWord0;
	JLabel gameWord1;
	JLabel gameWord2;
	JLabel gameWord3;
	JLabel gameWord4;
	JLabel gameWord5;
	JLabel gameWord6;
	JLabel gameWord7;
	JLabel gameWord8;
	JLabel gameWord9;
	JLabel gameWord10;
	JLabel gameWord11;
	JLabel gameWord12;
	JLabel gameWord13;
	JLabel gameWord14;
	
	public GUI() {
		super("CS31 Project");
		// North Center and South Panels, set the background colors to black
		northPanel = new JPanel();
		northPanel.setBackground(Color.black);
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.black);
		southPanel = new JPanel();
		southPanel.setBackground(Color.black);
		
		// Opening Screen Panel Layout
		northPanel.setLayout(new GridLayout(1, 1));
		centerPanel.setLayout(new GridLayout(1, 1));
		southPanel.setLayout(new GridLayout(1, 2));
		
		// Game Title (will be staying at the top on every screen)
		gameTitle = new JLabel("Fallout Hacking Game");
		whiteTextCenterAlign(gameTitle, 36);
		northPanel.add(gameTitle);
		
		// Score Label for Opening Screen
		openingScreenScore = new JLabel("Score: 0");
		greenTextCenterAlign(openingScreenScore, 24);
		centerPanel.add(openingScreenScore);
		
		// Start Game and How to Play Buttons for Opening Screen
		openingScreenStartGame = new JButton("Start Game");
		southPanel.add(openingScreenStartGame);
		openingScreenHowToPlay = new JButton("How to Play");
		southPanel.add(openingScreenHowToPlay);
		
		// Instatiate Words for the show score ( Will be reinstatiated after difficulty selection)
		gameWords = new Words(1);
		
		// Return to Opening Screen button for How to Play Screen
		returnToOpeningScreen = new JButton("Return to Main Menu");
		
		// Difficulty Selection Combo box for Difficulty Selection Screen
		String[] difficultyNumbers = {"1 (Very Easy)", "2 (Easy)", "3 (Normal)", "4 (Hard)", "5 (Very Hard)"};
		difficultySelectionBox = new JComboBox(difficultyNumbers);
		
		// Difficulty Selection Button for Difficulty Selection Screen
		difficultySelectionButton = new JButton("Start");
		
		// Game Screen
		numberOfGuessesRemaining = new JLabel("Guesses remaining: 4");
		lettersCorrect = new JLabel("You got 0 letters Correct");
		whiteTextCenterAlign(lettersCorrect, 16);
		guessHereTextField = new JTextField();
		
		// JLabels for ArrayList of Words
		gameWord0 = new JLabel("");
		gameWord1 = new JLabel("");
		gameWord2 = new JLabel("");
		gameWord3 = new JLabel("");
		gameWord4 = new JLabel("");
		gameWord5 = new JLabel("");
		gameWord6 = new JLabel("");
		gameWord7 = new JLabel("");
		gameWord8 = new JLabel("");
		gameWord9 = new JLabel("");
		gameWord10 = new JLabel("");
		gameWord11 = new JLabel("");
		gameWord12 = new JLabel("");
		gameWord13 = new JLabel("");
		gameWord14 = new JLabel("");
		
		// Notify the user to guess here and notifies last words guessed
		guessHereLastWord = new JLabel("Enter your guess here:");
		whiteTextCenterAlign(guessHereLastWord, 16);
		
		// Quit Button
		exitGame = new JButton("Quit Game");
		
		// ActionListeners
		ButtonAction buttonAction = new ButtonAction();
		openingScreenStartGame.addActionListener(buttonAction);
		openingScreenHowToPlay.addActionListener(buttonAction);
		returnToOpeningScreen.addActionListener(buttonAction);
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
			if(event.getSource() == openingScreenStartGame) {
				
				// Add text to center panel
				centerPanel.removeAll();
				centerPanel.setLayout(new GridLayout(1, 1));
				difficultyText = new JLabel("Select difficulty then press start");
				centerPanel.add(difficultyText);
				greenTextCenterAlign(difficultyText, 16);
				
				// Remove southpanel buttons and replace with dropdown difficulty and button
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 2));
				southPanel.add(difficultySelectionBox);
				southPanel.add(difficultySelectionButton);
				
				refresh();
				
			} else if (event.getSource() == openingScreenHowToPlay) {
				northPanel.setLayout(new GridLayout(6, 1));
				// TextLabel instructions for the game
				// 1 Label
				JLabel howToPlayLabel1 = new JLabel("•You will be trying to guess the correct word of the pool of words.");
				greenText(howToPlayLabel1, 16);
				northPanel.add(howToPlayLabel1);
				// 2 Label
				JLabel howToPlayLabel2 = new JLabel("•The amount of words given and letters you will be guessing will be");
				greenText(howToPlayLabel2, 16);
				northPanel.add(howToPlayLabel2);
				// 3 Label
				JLabel howToPlayLabel3 = new JLabel("based off your difficulty selected.");
				greenText(howToPlayLabel3, 16);
				northPanel.add(howToPlayLabel3);
				// 4 Label
				JLabel howToPlayLabel4 = new JLabel("•After guessing, the game will tell you how many letters you got correct.");
				greenText(howToPlayLabel4, 16);
				northPanel.add(howToPlayLabel4);
				// 5 Label
				JLabel howToPlayLabel5 = new JLabel("•You will have four chances to get the correct word or you will lose!");
				greenText(howToPlayLabel5, 16);
				northPanel.add(howToPlayLabel5);
				
				// Remove center panel
				centerPanel.removeAll();
				
				// Remove southpanel buttons and replaced with "Return to Main Screen"
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 1));
				southPanel.add(returnToOpeningScreen);
				
				refresh();
				
			} else if (event.getSource() == returnToOpeningScreen){
				// Remove north panel text and replaced with "Fallout Hacking Game"
				northPanel.removeAll();
				northPanel.setLayout(new GridLayout(1, 1));
				northPanel.add(gameTitle);
				// Remove center panel and take the total score and display to the user
				centerPanel.removeAll();
				centerPanel.setLayout(new GridLayout(1, 1));
				int addScore = gameWords.getTotalScore();
				openingScreenScore.setText("Score: " + Integer.toString(addScore));
				centerPanel.add(openingScreenScore);
				// Remove south panel button and replaced with "Start Game" and "How to Play"
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(1, 2));
				southPanel.add(openingScreenStartGame);
				southPanel.add(openingScreenHowToPlay);
				
				refresh();
				
			} else if (event.getSource() == difficultySelectionButton) {
				
				// Set the text to guesses remaining = 4
				numberOfGuessesRemaining.setText("Guesses remaining: 4");
				numberOfGuessesRemaining.setHorizontalAlignment(JLabel.CENTER);
				numberOfGuessesRemaining.setFont(new Font("Helvetica", Font.PLAIN, 16));
				numberOfGuessesRemaining.setForeground(Color.cyan);
				
				// Remove center panel Label to replace with guessing words
				centerPanel.removeAll();
				centerPanel.setLayout(new GridLayout(0, 3));
				
				// Remove south panel buttons to replace with game buttons
				southPanel.removeAll();
				southPanel.setLayout(new GridLayout(2, 2));
				southPanel.add(numberOfGuessesRemaining);
				southPanel.add(lettersCorrect);
				southPanel.add(guessHereLastWord);
				southPanel.add(guessHereTextField);
				
				guessHereLastWord.setText("Enter your guess here:");
				whiteTextCenterAlign(guessHereLastWord, 14);
				
				// Make the word list green
				Font myFont = new Font(Font.MONOSPACED, Font.BOLD, 14);
				greenTextCenterAlign(gameWord0, 14);
				gameWord0.setFont(myFont);
				greenTextCenterAlign(gameWord1, 14);
				gameWord1.setFont(myFont);
				greenTextCenterAlign(gameWord2, 14);
				gameWord2.setFont(myFont);
				greenTextCenterAlign(gameWord3, 14);
				gameWord3.setFont(myFont);
				greenTextCenterAlign(gameWord4, 14);
				gameWord4.setFont(myFont);
				greenTextCenterAlign(gameWord5, 14);
				gameWord5.setFont(myFont);
				greenTextCenterAlign(gameWord6, 14);
				gameWord6.setFont(myFont);
				greenTextCenterAlign(gameWord7, 14);
				gameWord7.setFont(myFont);
				greenTextCenterAlign(gameWord8, 14);
				gameWord8.setFont(myFont);
				greenTextCenterAlign(gameWord9, 14);
				gameWord9.setFont(myFont);
				greenTextCenterAlign(gameWord10, 14);
				gameWord10.setFont(myFont);
				greenTextCenterAlign(gameWord11, 14);
				gameWord11.setFont(myFont);
				greenTextCenterAlign(gameWord12, 14);
				gameWord12.setFont(myFont);
				greenTextCenterAlign(gameWord13, 14);
				gameWord13.setFont(myFont);
				greenTextCenterAlign(gameWord14, 14);
				gameWord14.setFont(myFont);
				
				refresh();
				
				// Based on difficulty selected, will display the amount of words and letters to guess
				if ((String)difficultySelectionBox.getSelectedItem() == "1 (Very Easy)") {
					// Pass argument 1 into Words selecting Easy difficulty
					gameWords = new Words(1);
					
					// Set 7 JLabels to have thw rods in the array
					gameWord0.setText(gameWords.getWord(0));
					centerPanel.add(gameWord0);
					gameWord1.setText(gameWords.getWord(1));
					centerPanel.add(gameWord1);
					gameWord2.setText(gameWords.getWord(2));
					centerPanel.add(gameWord2);
					gameWord3.setText(gameWords.getWord(3));
					centerPanel.add(gameWord3);
					gameWord4.setText(gameWords.getWord(4));
					centerPanel.add(gameWord4);
					gameWord5.setText(gameWords.getWord(5));
					centerPanel.add(gameWord5);
					gameWord6.setText(gameWords.getWord(6));
					centerPanel.add(gameWord6);
					
					lettersCorrect.setText("Guess the 4 - 5 letter word");
					
				} else if ((String)difficultySelectionBox.getSelectedItem() == "2 (Easy)") {
					// Pass argument 2 into Words selecting Easy difficulty
					gameWords = new Words(2);
					
					// Set 9 JLabels to have the words in the array
					gameWord0.setText(gameWords.getWord(0));
					centerPanel.add(gameWord0);
					gameWord1.setText(gameWords.getWord(1));
					centerPanel.add(gameWord1);
					gameWord2.setText(gameWords.getWord(2));
					centerPanel.add(gameWord2);
					gameWord3.setText(gameWords.getWord(3));
					centerPanel.add(gameWord3);
					gameWord4.setText(gameWords.getWord(4));
					centerPanel.add(gameWord4);
					gameWord5.setText(gameWords.getWord(5));
					centerPanel.add(gameWord5);
					gameWord6.setText(gameWords.getWord(6));
					centerPanel.add(gameWord6);
					gameWord7.setText(gameWords.getWord(7));
					centerPanel.add(gameWord7);
					gameWord8.setText(gameWords.getWord(8));
					centerPanel.add(gameWord8);
					
					lettersCorrect.setText("Guess the 5 - 6 letter word");
					
				} else if ((String)difficultySelectionBox.getSelectedItem() == "3 (Normal)") {
					// Pass argument 3 into Words selecting Normal Difficulty
					gameWords = new Words(3);
					
					// Set 11 JLabels to have the words in the array
					gameWord0.setText(gameWords.getWord(0));
					centerPanel.add(gameWord0);
					gameWord1.setText(gameWords.getWord(1));
					centerPanel.add(gameWord1);
					gameWord2.setText(gameWords.getWord(2));
					centerPanel.add(gameWord2);
					gameWord3.setText(gameWords.getWord(3));
					centerPanel.add(gameWord3);
					gameWord4.setText(gameWords.getWord(4));
					centerPanel.add(gameWord4);
					gameWord5.setText(gameWords.getWord(5));
					centerPanel.add(gameWord5);
					gameWord6.setText(gameWords.getWord(6));
					centerPanel.add(gameWord6);
					gameWord7.setText(gameWords.getWord(7));
					centerPanel.add(gameWord7);
					gameWord8.setText(gameWords.getWord(8));
					centerPanel.add(gameWord8);
					gameWord9.setText(gameWords.getWord(9));
					centerPanel.add(gameWord9);
					gameWord10.setText(gameWords.getWord(10));
					centerPanel.add(gameWord10);
					
					lettersCorrect.setText("Guess the 6 - 7 letter word");
					
				} else if ((String)difficultySelectionBox.getSelectedItem() == "4 (Hard)") {
					// Pass argument 4 into Words selecting Hard Difficulty
					gameWords = new Words(4);
					
					// Set 13 JLabels to have the words in the array
					gameWord0.setText(gameWords.getWord(0));
					centerPanel.add(gameWord0);
					gameWord1.setText(gameWords.getWord(1));
					centerPanel.add(gameWord1);
					gameWord2.setText(gameWords.getWord(2));
					centerPanel.add(gameWord2);
					gameWord3.setText(gameWords.getWord(3));
					centerPanel.add(gameWord3);
					gameWord4.setText(gameWords.getWord(4));
					centerPanel.add(gameWord4);
					gameWord5.setText(gameWords.getWord(5));
					centerPanel.add(gameWord5);
					gameWord6.setText(gameWords.getWord(6));
					centerPanel.add(gameWord6);
					gameWord7.setText(gameWords.getWord(7));
					centerPanel.add(gameWord7);
					gameWord8.setText(gameWords.getWord(8));
					centerPanel.add(gameWord8);
					gameWord9.setText(gameWords.getWord(9));
					centerPanel.add(gameWord9);
					gameWord10.setText(gameWords.getWord(10));
					centerPanel.add(gameWord10);
					gameWord11.setText(gameWords.getWord(11));
					centerPanel.add(gameWord11);
					gameWord12.setText(gameWords.getWord(12));
					centerPanel.add(gameWord12);
					
					lettersCorrect.setText("Guess the 7 - 8 letter word");
					
				} else if ((String)difficultySelectionBox.getSelectedItem() == "5 (Very Hard)") {
					// Pass argument 5 into Words selecting Very Hard Difficulty
					gameWords = new Words(5);
					
					// Set 15 JLabels to have the words in the array
					gameWord0.setText(gameWords.getWord(0));
					centerPanel.add(gameWord0);
					gameWord1.setText(gameWords.getWord(1));
					centerPanel.add(gameWord1);
					gameWord2.setText(gameWords.getWord(2));
					centerPanel.add(gameWord2);
					gameWord3.setText(gameWords.getWord(3));
					centerPanel.add(gameWord3);
					gameWord4.setText(gameWords.getWord(4));
					centerPanel.add(gameWord4);
					gameWord5.setText(gameWords.getWord(5));
					centerPanel.add(gameWord5);
					gameWord6.setText(gameWords.getWord(6));
					centerPanel.add(gameWord6);
					gameWord7.setText(gameWords.getWord(7));
					centerPanel.add(gameWord7);
					gameWord8.setText(gameWords.getWord(8));
					centerPanel.add(gameWord8);
					gameWord9.setText(gameWords.getWord(9));
					centerPanel.add(gameWord9);
					gameWord10.setText(gameWords.getWord(10));
					centerPanel.add(gameWord10);
					gameWord11.setText(gameWords.getWord(11));
					centerPanel.add(gameWord11);
					gameWord12.setText(gameWords.getWord(12));
					centerPanel.add(gameWord12);
					gameWord13.setText(gameWords.getWord(13));
					centerPanel.add(gameWord13);
					gameWord14.setText(gameWords.getWord(14));
					centerPanel.add(gameWord14);
					
					lettersCorrect.setText("Guess the 8 - 9 letter word");
					
				}
				refresh();
				
			} else if (event.getSource() == guessHereTextField) {
				// Takes the guess and checks it and clears textfield
				gameWords.guessTaken();
				String userGuess = guessHereTextField.getText();
				guessHereTextField.setText("");
				
				//displays user's last input
				String lastWordEntered = "";
				
				if (gameWords.checkMatches(userGuess) == 999) {
					// If the user guessed the right answer, increase the score and go to end screen
					gameWords.increaseTotalScore();
					
					// Center panel to say you won
					centerPanel.removeAll();
					centerPanel.setLayout(new GridLayout(1,1));
					JLabel youWin = new JLabel ("You were successful!");
					greenTextCenterAlign(youWin, 36);
					centerPanel.add(youWin);
					
					// Bottom panel to give option to go to opening screen or exit
					southPanel.removeAll();
					southPanel.setLayout(new GridLayout(1,2));
					southPanel.add(returnToOpeningScreen);
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
				} else if (gameWords.checkMatches(userGuess) == 8) {
					lettersCorrect.setText("You got 8 letters correct");
				}

        // Greys out the text after guess matches with index of Arraylist
				if (gameWords.getIndex(userGuess) == 0) {
					gameWord0.setForeground(Color.gray);
					gameWord0.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 1) {
					gameWord1.setForeground(Color.gray);
					gameWord1.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 2) {
					gameWord2.setForeground(Color.gray);
					gameWord2.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 3) {
					gameWord3.setForeground(Color.gray);
					gameWord3.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 4) {
					gameWord4.setForeground(Color.gray);
					gameWord4.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 5) {
					gameWord5.setForeground(Color.gray);
					gameWord5.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 6) {
					gameWord6.setForeground(Color.gray);
					gameWord6.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 7) {
					gameWord7.setForeground(Color.gray);
					gameWord7.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 8) {
					gameWord8.setForeground(Color.gray);
					gameWord8.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 9) {
					gameWord9.setForeground(Color.gray);
					gameWord9.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 10) {
					gameWord10.setForeground(Color.gray);
					gameWord10.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 11) {
					gameWord11.setForeground(Color.gray);
					gameWord11.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 12) {
					gameWord12.setForeground(Color.gray);
					gameWord12.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 13) {
					gameWord13.setForeground(Color.gray);
					gameWord13.setText("<html><strike>" + userGuess + "</strike></html>");
				} else if (gameWords.getIndex(userGuess) == 14) {
					gameWord14.setForeground(Color.gray);
					gameWord14.setText("<html><strike>" + userGuess + "</strike></html>");
				}
				
				// Changes the text to guesses left and displays the previous guessed words
				if (gameWords.getGuessesLeft() == 3) {
					// Sets guesses remaining to 3 and yellow
					numberOfGuessesRemaining.setText("Guesses Remaining: 3");
					numberOfGuessesRemaining.setForeground(Color.yellow);
					
					// Displays the last word guessed to crossed out gray
					guessHereLastWord.setForeground(Color.gray);
					gameWords.addLastWord(userGuess);
					lastWordEntered = ("<html><strike>" + gameWords.getLastWord(0) + "</strike></html>");
					guessHereLastWord.setText(lastWordEntered);
					
				} else if (gameWords.getGuessesLeft() == 2) {
					// Sets guesses remaining to 2 and orange
					numberOfGuessesRemaining.setText("Guesses Remaining: 2");
					numberOfGuessesRemaining.setForeground(Color.orange);
					
					// Displays the last 2 words guessed to crossed out gray
					guessHereLastWord.setForeground(Color.gray);
					gameWords.addLastWord(userGuess);
					lastWordEntered = ("<html><strike>" + gameWords.getLastWord(0) + ", " + gameWords.getLastWord(1) + "</strike></html>");
					guessHereLastWord.setText(lastWordEntered);
					
				} else if (gameWords.getGuessesLeft() == 1) {
					// Sets guesses remaining to 1 and red
					numberOfGuessesRemaining.setText("Guesses Remaining: 1");
					numberOfGuessesRemaining.setForeground(Color.red);
					
					// Displays the last 3 words guessed to crossed out gray
					guessHereLastWord.setForeground(Color.gray);
					gameWords.addLastWord(userGuess);
					lastWordEntered = ("<html><strike>" + gameWords.getLastWord(0) + ", " + gameWords.getLastWord(1) + ", " + gameWords.getLastWord(2) + "</strike></html>");
					guessHereLastWord.setText(lastWordEntered);
					
				} else if (gameWords.getGuessesLeft() == 0 && gameWords.checkMatches(userGuess) != 999) {
					// If you have no more guesses and you didn't win, go to end game loss screen
					
					// Unsuccessfully center panel
					centerPanel.removeAll();
					centerPanel.setLayout(new GridLayout(1,1));
					JLabel youLose = new JLabel ("You were unsucessful!");
					youLose.setHorizontalAlignment(JLabel.CENTER);
					youLose.setFont(new Font("Helvetica", Font.PLAIN, 36));
					youLose.setForeground(Color.red);
					centerPanel.add(youLose);
					
					// Buttons to return to opening menu or quit
					southPanel.removeAll();
					southPanel.setLayout(new GridLayout(1,2));
					southPanel.add(returnToOpeningScreen);
					southPanel.add(exitGame);
					
				}
				
				refresh();
				
			} else if (event.getSource() == exitGame) {
				System.exit(0);
			} 
			return;
		}	
	}
	// Used to update the buttons and text after changing
	public void refresh() {
		revalidate();
		repaint();
		return;
	}
	/**
	 * @param Takes a JLabel argument and font size argument
	 * and sets the font to color green
	 */
	public void greenText(JLabel Label, int textSize) {
		Label.setFont(new Font("Helvetica", Font.PLAIN, textSize));
		Label.setForeground(Color.green);
		return;
	}
	/**
	 * @param Takes a JLabel argument and font size argument
	 * and sets the font to color green, center aligns the JLabel in the grid
	 */
	public void greenTextCenterAlign(JLabel Label, int textSize) {
		Label.setFont(new Font("Helvetica", Font.PLAIN, textSize));
		Label.setForeground(Color.green);
		Label.setHorizontalAlignment(JLabel.CENTER);
		return;
	}
	/**
	 * @param Takes a JLabel argument and font size argument
	 * and sets the font to color white, center aligns the JLabel in the grid
	 */
	public void whiteTextCenterAlign(JLabel Label, int textSize) {
		Label.setFont(new Font("Helvetica", Font.PLAIN, textSize));
		Label.setForeground(Color.white);
		Label.setHorizontalAlignment(JLabel.CENTER);
		return;
	}
}