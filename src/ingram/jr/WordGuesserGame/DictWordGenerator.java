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
 * @version 21/06/2016
 * 
 */

public class DictWordGenerator extends WordGenerator {
	private BufferedReader reader;
	private ArrayList<String> potentialWords;
	private String filePath;
	private Scanner dictionaryScanner;

	/**Constructs a file reader, file path and list of potential words.
	 * 
	 * @throws IOException If error reading the file.
	 */
	
	public DictWordGenerator() throws IOException{
		super();
		try{
			filePath = "dictionary.txt";
			potentialWords = new ArrayList<String>();
			dictionaryScanner = new Scanner(new File(filePath));
			reader = new BufferedReader(new FileReader(filePath));
			System.out.println(filePath + " successfully read.");
		}catch(Exception e){
			System.out.println("Error reading file!");
		}finally{
			reader.close();
		}

	}

	/** Creates a list of words from the dictionary.txt file and places them in an ArrayList.
	 * 
	 * @param wordLength The number of characters in the words we want in the list.
	 */
	private void fillPotentialWords(int wordLength){
		this.wordLength = wordLength;
		System.out.println("Adding words to potentialWords...");
		while(dictionaryScanner.hasNext()){
			String word = dictionaryScanner.next();
			if(word.length() == wordLength && word.matches("[a-zA-Z]+")){
				potentialWords.add(word.toUpperCase());
			}
		}
		System.out.println("List completed: Selecting Words.");
	}
	
	/**Choose 10 words from the list of potential words.
	 * 
	 */
	public void makeWordList(int length){
		fillPotentialWords(length);
		Random rand = new Random();
		int[] previousRands = new int[10];
		for(int i = 0; i < words.length; i++){
			previousRands[i] = rand.nextInt(potentialWords.size());
			words[i] = potentialWords.get(previousRands[i]);
		}
		uniqueWordChecker();
	}
	
	/** Regenerates the word at the index position in the words array.
	 * 
	 *  @param index The index of the word we wish to regenerate.
	 */
	
	public void regenerateSpecificWord(int index){
		Random rand = new Random();
		int randomWord = rand.nextInt(potentialWords.size());
		words[index] = potentialWords.get(randomWord);
	}
}
