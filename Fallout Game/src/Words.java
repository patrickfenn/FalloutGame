import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Words {
	
	private String answer;
	private int numOfWords;
	private ArrayList<String> listOfWords = new ArrayList<>();
	
	
	/*
	 * @param difficulty The level of difficulty (1-5) that the player will choose.
	 */
	public Words(int difficulty) {
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
		answer = listOfWords.get(2);
		
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
		if (guess==answer)
			return 999;
		 
		for (int i = 0; i < answer.length() && i < guess.length(); i++)
			if (guess.charAt(i) == answer.charAt(i))
				matches++;
	
		return matches;
	}

}

private int wordTest(String word){ //returns how difficult a word will be based on length and repeated characters
	int size = word.length();
	int sameLetters = 0;
	int difficulty;
	
	for(int i= 0; i < size - 1; i ++) {
		if(word.indexOf(i) == word.indexOf(i+1){
			break;
		}
		else{
			sameLetters++;
		}
	}
	
	difficulty = size - sameLetters;
	
	if(difficulty > 5){ //make 5 the greatest difficulty;
		return 5;
	}
	else{
		return difficulty;
	}
	
}

}
