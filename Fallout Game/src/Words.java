
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Words {
	
	private String answer;
	private int numOfWords;
	private int amountOfGuesses;
	private static int totalScore;
	private ArrayList<String> listOfWords = new ArrayList<>();
	private ArrayList<String> lastWord = new ArrayList<>();
	
	/**
	 * Loads a random set of words into an ArrayList. The length of words and
	 * the number of words is based on the difficulty.
	 * @param difficulty The level of difficulty (1-5) that the player will choose.
	 */
	public Words(int difficulty) {
		// Amount of guess default to 4
		amountOfGuesses = 4;
		int wordSize = 0;
		
		// Set game difficulty based on constructor argument
		if (difficulty==1) {
			numOfWords=7;
			wordSize=4;
		}
		else if (difficulty==2) {
			numOfWords=9;
			wordSize=5;
		}
		else if (difficulty==3) {
			numOfWords=11;
			wordSize=6;
		}
		else if (difficulty==4) {
			numOfWords=13;
			wordSize=7;
		}
		else if (difficulty==5) {
			numOfWords=15;
			wordSize=8;
		}
		
		Random rand = new Random();
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		   while (listOfWords.size() < numOfWords) {
			   // Open file
				inputStream = new FileInputStream("src/enable1.txt");
			    sc = new Scanner(inputStream, "UTF-8");
			    
			    // Pick a line in the file
			    int lineToRead = rand.nextInt(172819);
			    int count = 0;
			    boolean found = false;
			    
			    // This while loops checks if the file has a next line, if listOfWords is
			    // less than the number of words needed, and if the next word hasn't
			    // yet been found.
			    while (sc.hasNextLine() && listOfWords.size()<numOfWords && found == false) {
			        String line = sc.nextLine();
			        count++;
			        
			        // If the current line is within a range of 600 of the target line, and
			        // matches the number of characters, add it to the list
					if (line.length()==wordSize+rand.nextInt(2) && count>=lineToRead-300 && count<=lineToRead+300 && wordTest(line) == difficulty) {
						listOfWords.add(line);	
						found = true;
					}
				}
		   }
	
		   
		  // A bunch of error handling and the inputstream/scanner closing.
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} catch (FileNotFoundException e) {
			System.out.println("Error file not found");
		} catch (IOException e) {
			System.out.println("Error reading line");
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println("Error closing file");
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		
		// pick a random word from the word list for the answer.
		int index = rand.nextInt(numOfWords);
		answer = listOfWords.get(index);
		
	}// end of constructor
	
	
	/**
	 * @return All words in wordsArr on their own line
	 */
	public String returnWordsList() {
		String str = "";
		for (int i = 0; i < listOfWords.size(); i++) {
			str+=listOfWords.get(i);
			str+="\n";
		}
		return str; 
	}
	
	
	/**
	 * @return The number of character matches, or 999 if correct.
	 * @param guess The word selected by the user to guess.
	 */
	public int checkMatches(String guess) { 
		int matches = 0;
		for (int i = 0; i < answer.length() && i < guess.length(); i++) {
			if (guess.charAt(i) == answer.charAt(i)) {
				matches++;
				if (matches == answer.length()) {
					return 999;
				}
			}
		}
		return matches;
	}
	
	
	/**
	 * Increase the total score according to difficulty:
	 * 1: +20
	 * 2: +30
	 * 3: +40
	 * 4: +50
	 * 5: +60
	 */
	public void increaseTotalScore() {
		if (numOfWords == 7) {
			totalScore += 20;
		} else if (numOfWords == 9) {
			totalScore += 30;
		} else if (numOfWords == 11) {
			totalScore += 40;
		} else if (numOfWords == 13) {
			totalScore += 50;
		} else if (numOfWords == 15) {
			totalScore += 60;
		}
		return;
	}
	
	
	/**
	 * @return Returns totalScore;
	 */
	public int getTotalScore() {
		return totalScore;
	}
	
	/**
	 * @param index The index that will be returned from the list of words
	 * @return returns a String from the index argument
	 */
	public String getWord(int index) {
		return listOfWords.get(index);
	}
	
	
	/**
	 * Decrements the variable amountOfGuesses
	 */
	public void guessTaken() {
		amountOfGuesses--;
		return;
	}
	/**
	 * @return Returns the amount of guesses left
	 */
	public int getGuessesLeft() {
		return amountOfGuesses;
	}
	
	
	/**
	 * @return How difficult a word will be based on length and repeated characters
	 * @param word The word to analyze
	 */
	private int wordTest(String word){ //returns how difficult a word will be based on length and repeated characters. Have to account for some repeated character being repeated more than others. 
		
		String myword = word;
		String temp = "";
		StringBuilder sb;
		int size = word.length(), repeats = 0, difficulty,counter;

		Vector<Character> uniqueChars = new Vector<Character>();
	
		uniqueChars.add(word.charAt(word.length()-1));
		
		for(int i = 0; i < word.length() -1; i++){
			if(word.charAt(i) != word.charAt(i+1) && !uniqueChars.contains(word.charAt(i))){
				uniqueChars.add(word.charAt(i));
			}
		}
		

		for(int i = 0; i < uniqueChars.size(); i++){
			counter = 0;
			for(int j= 0 ; j < word.length(); j++){
				
				if(word.charAt(j) == uniqueChars.get(i)){
					counter++;
					
				}
				
			}
			if(counter > 1){
				repeats += counter;
			}
		
		}
		
		
		difficulty =  size - repeats;
		if(difficulty >5){
			return 5;
		}
		else{
			return difficulty;
		}
		
	}
	/**
	 * This method saves the last word that the user
	 * has selected.
	 * @param lastWord The word to assign to lastWord variable
	 */ 
	public void addLastWord(String lastWord){
		this.lastWord.add(lastWord);
		return;
	}

	
	/**
	 * @return Gets the string from the last word ArrayList
	 * @param index of the Last Word you want to return
	 */
	public String getLastWord(int index){
		return lastWord.get(index);
	}
}
