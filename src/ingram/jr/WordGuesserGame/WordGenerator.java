package ingram.jr.WordGuesserGame;

import java.util.Random;

/**Super class for word generators.
 * 
 * @author JRIngram
 * @version 08/05/2016
 *
 */

public abstract class WordGenerator {
	
	protected String words[];
	
	/** Creates an empty String array of length 10.
	 * 
	 */
	public WordGenerator(){
		words = new String[10];
	}
	
	/** Generates a list of 10 words of varying length.
	 * 
	 * @param length The length of the words we desire.
	 */
	
	public abstract void makeWordList(int length);
	
	public abstract void regenerateSpecificWord(int index);
	
	/**
	 * Prints all item in the wordList array.
	 * 
	 * <p>Prints all item in the wordList array. This would need to be edited if the size of the wordList array was increased,
	 * as a normal for loop is used rather than an enhanced for loop.</p> 
	 * 
	 * @return The list of words, with a line of a asterisks above and below.
	 * */
	public String printWordList(){
		StringBuilder sb = new StringBuilder();
		sb.append("*********************\n");
		for(int i = 0; i < 10; i++){
			sb.append(i + 1 + ". " + words[i] + "\n");
		}
		sb.append("*********************\n");
		return sb.toString();
	}
	
	/** Cycles through the words array list and checks that all words are unique.
	 *  Completes this using an embedded for loop. If a word has to be regenerated, all loops are reset.
	 */
	
	public void uniqueWordChecker(){
		for(int i = 0; i < words.length; i++){
			for(int c = words.length - 1; c >= 0; c--){
				if(c != i){
					if(words[i].equals(words[c])){
						regenerateSpecificWord(i);
						i = 0;
						c = 0;
					}
				}
			}
		}
		System.out.println("All words unique!");
	}
	
	/**
	 * Selects and returns a random word from the generated words.
	 * 
	 * <p>Uses a random number generator to select a word from the wordList array; this word will be the word the user has to guess.</p>
	 * @return String: The word from the wordList array that the user/player must guess correctly in order to win the game.
	 * */
	public String wordChooser(){
		Random wordChooser = new Random();
		int wordNumber = wordChooser.nextInt(10);
		String chosenWord = words[wordNumber];
		return chosenWord;
		
	}
}
