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
	
	/**
	 * Returns the current amount of items in the WordList
	 * @return
	 */
	public int getCurrentSize(){
		return front;
	}
	
	/**
	 * Returns the maximum size of the WordList
	 * @return
	 */
	public int getMaxSize(){
		return maxSize;
	}
	
	/**
	 * Returns a specific word from the WordList
	 * @param index Index of the word you want to retrieve. 
	 * @return
	 */
	public String getWord(int index){
		try{
			if(!words[index].equals(null))
				return words[index];
			else
				return "ERROR";
		}catch(NullPointerException e){
			return "ERROR";
		}
			
	}
	
	/**
	 * Prints the numbers of words in the list.
	 */
	@Override
	public String toString(){
		String listString = "";
		for(int i = 0; i < front; i++){
			listString += words[i] + "\n";
		}
		return listString;
	}
	
}
