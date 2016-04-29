package ingram.jr.WordGuesserGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


/**Reads word for text file dictionary.txt to produce words.
 * 
 * @author Jamie Ingram
 * @version 28/04/2016
 * 
 * TODO Ensure that two words cannot be the same when selected.
 * TODO Remove non-alphabetical characters.
 * 
 */

public class DictWordGenerator {
	private BufferedReader reader;
	private ArrayList<String> potentialWords;
	private String[] words;
	private String filePath;
	private Scanner dictionaryScanner;

	/**Constructs a file reader, file path and list of potential words.
	 * 
	 * @throws IOException If error reading the file.
	 */
	
	public DictWordGenerator() throws IOException{
		try{
			filePath = "dictionary.txt";
			potentialWords = new ArrayList<String>();
			dictionaryScanner = new Scanner(new File(filePath));
			words = new String[10];
			reader = new BufferedReader(new FileReader(filePath));
			System.out.println(filePath + " successfully read.");
			fillPotentialWords(10); //Placeholder - change values for testing.
		}catch(Exception e){
			System.out.println("Error reading file!");
		}finally{
			reader.close();
		}
		System.out.println("Chosen words: ");
		chooseWords();
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
			}
		}
		System.out.println("List completed: Selecting Words.");
	}
	
	/**Choose 10 words from the list of potential words.
	 * 
	 */
	private void chooseWords(){
		Random rand = new Random();
		int[] previousRands = new int[10];
		for(int i = 0; i < words.length; i++){
			previousRands[i] = rand.nextInt(potentialWords.size());
			words[i] = potentialWords.get(previousRands[i]);
		}
		for(int i = 0; i < 10; i++){
			System.out.println(words[i]);
		}
	}
}
