package ingram.jr.WordGuesserGame;

/**
 * A Class for storing a set of unique words.
 * @author JRIngram
 * 
 *
 */
public class WordList {
	
	private String[] words;
	int front;
	int maxSize;
	
	public WordList(int size){
		words = new String[size];
		maxSize = size;
		front = 0;
	}
	
	/**
	 * Adds a new word to the WordList if the new word is distinct and the array isn't full. 
	 * @param newWord A word being added to the WordList
	 * @return boolean on if the word adding was successful
	 */
	public boolean addWord(String newWord){
		if(maxSize == front)
			return false;
		for(int i = 0; i < front; i++){
			if(newWord.equals(words[i]))
				return false;
		}
		words[front] = newWord;
		front++;
		return true;
	}
	
	/**
	 * Resets front of wordList to 0.
	 */
	public void resetWordList(){
		front = 0;
	}
	
	public int getCurrentSize(){
		return front;
	}
	
	public int getMaxSize(){
		return maxSize;
	}
	
}
