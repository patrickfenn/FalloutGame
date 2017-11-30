import java.io.*;
import java.util.Random;

public class Words {
	
	private String answer;
	private String[] wordsArr;
	
	
	/*
	 * @param difficulty The level of difficulty (1-5) that the player will choose.
	 */
	public Words(int difficulty) {
		int wordSize = 0;
		if (difficulty==1) {
			wordsArr = new String[7];
			wordSize=4;
		}
		else if (difficulty==2) {
			wordsArr = new String[9];
			wordSize=5;
		}
		else if (difficulty==3) {
			wordsArr = new String[11];
			wordSize=6;
		}
		else if (difficulty==4) {
			wordsArr = new String[13];
			wordSize=7;
		}
		else if (difficulty==5) {
			wordsArr = new String[15];
			wordSize=8;
		}
		
		LineNumberReader reader = null;
		try {
			reader = new LineNumberReader(new FileReader("src/enable1.txt"));
		} 
		catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		}
		
		Random rand = new Random();
		int wordsChosen = 0;
		String temp = null;
		while (wordsChosen<wordsArr.length) {
			reader.setLineNumber(rand.nextInt(172819)); //pick a random line in file
			try {
				temp = reader.readLine();
			} catch (IOException e) {
				System.out.println("Error reading line in file");
			}
			
			boolean match = false;
			for (int i = 0; i < wordsArr.length; i++) {
				if (temp == wordsArr[i]) {
					match = true;
					break;
				}
			}
			if (!match) {
				if (temp.length() == wordSize) {	// if no match and if correct size, add to array
					wordsArr[wordsChosen] = temp;
					wordsChosen++;
				}
			}
		}// end of while loop
		
		//Randomly choose an answer from the chosen set of words
		answer = wordsArr[rand.nextInt(wordsArr.length)];
		
	}// end of constructor
	
	
	/*
	 * @return All words in wordsArr on their own line
	 */
	public String returnWordsList() {
		String str = null;
		for (int i = 0; i < wordsArr.length; i++) {
			str+=wordsArr[i];
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
		if (guess==answer)
			return 999;
		 
		for (int i = 0; i < answer.length() && i < guess.length(); i++)
			if (guess.charAt(i) == answer.charAt(i))
				matches++;
	
		return matches;
	}

}
