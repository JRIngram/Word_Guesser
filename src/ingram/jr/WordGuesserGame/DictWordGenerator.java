package ingram.jr.WordGuesserGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**Reads word for text file dictionary.txt to produce words.
 * 
 * @author Jamie Ingram
 * @version 28/04/2016
 * 
 * TODO Select words to be chosen for the game.
 * 
 */

public class DictWordGenerator {
	private BufferedReader reader;
	private ArrayList<String> potentialWords;
	private String filePath;
	private Scanner dictionaryScanner;

	/**Constructs a file reader, file path and list of potential words.
	 * 
	 * 
	 * @throws IOException If error reading the file.
	 */
	public DictWordGenerator() throws IOException{
		reader = null;
		filePath = "dictionary.txt";
		potentialWords = new ArrayList<String>();
		dictionaryScanner = new Scanner(new File(filePath));
		try{
			reader = new BufferedReader(new FileReader(filePath));
			System.out.println(filePath + " successfully read.");
			fillPotentialWords(20); //Placeholder - change values for testing.
		}catch(Exception e){
			System.out.println("Error reading file!");
		}finally{
			reader.close();
		}
	}

	/** Creates a list of words from the dictionary.txt file and places them in an ArrayList.
	 * 
	 * @param length The number of characters in the words we want in the list.
	 */
	private void fillPotentialWords(int length){
		System.out.println("Adding words to potentialWords...");
		while(dictionaryScanner.hasNext()){
			String word = dictionaryScanner.next();
			if(word.length() == length){
				potentialWords.add(word);
				System.out.println(word);
			}
		}
		System.out.println("List completed: Selecting Words.");
	}
}
