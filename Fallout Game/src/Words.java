import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Words {
	
	private String answer;
	private int numOfWords;
	private int amountOfGuesses;
	private static int totalScore;
	private ArrayList<String> listOfWords = new ArrayList<>();
	
	
	/*
	 * @param difficulty The level of difficulty (1-5) that the player will choose.
	 */
	public Words(int difficulty) {
		amountOfGuesses = 4;
		int wordSize = 0;
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
		Path file = Paths.get("src/enable1.txt");
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		   while (listOfWords.size() < numOfWords) {
				inputStream = new FileInputStream("src/enable1.txt");
			    sc = new Scanner(inputStream, "UTF-8");
			    int lineToRead = rand.nextInt(172819);
			    int count = 0;
			    boolean found = false;
			    while (sc.hasNextLine() && listOfWords.size()<numOfWords && found == false) {
			        String line = sc.nextLine();
			        count++;
					if (line.length()==wordSize && count>=lineToRead-300 && count<=lineToRead+300) {
						listOfWords.add(line);	
						found = true;
					}
				}
		   }
	
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
		
		int index = rand.nextInt(numOfWords);
		answer = listOfWords.get(index);
		
	}// end of constructor
	
	
	/*
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
	
	
	/*
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
	
	
	/*
	 * @return Returns totalScore;
	 */
	public int getTotalScore() {
		return totalScore;
	}
	
	
	public void guessTaken() {
		amountOfGuesses--;
	}
	/*
	 * @return Returns the amount of guesses left
	 */
	public int getGuessesLeft() {
		return amountOfGuesses;
	}
	
	
	/*
	 * @return Returns the arraylist
	 */
	public ArrayList<String> getWordList() {
		return listOfWords;
	}
	
}