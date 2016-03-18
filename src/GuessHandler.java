/**Handles and processes the players guesses
 * 
 * @author JRIngram
 * @version 18/03/2016
 *
 */
public class GuessHandler {
	
	private int numberOfGuesses;
	private String chosenWord;
	private WordGenerator wordGen;
	
	public GuessHandler(WordGenerator wg){
		this.wordGen = wg;
		numberOfGuesses = 0;
		chosenWord = wordGen.wordChooser();
		
	}
	
	/**Used to check number of guesses.
	 * <p>Prints the number of guesses. If the number of guesses is more than the maximum number of guesses the game ends and the correct word is revealed. </p>
	 * 
	 * @param maxGuesses determines the maximum number of guesses the player can have. 
	 * @return boolean: returns true if the player has guessed equal or more than the maximum guesses. 
	 * */
	public boolean overMaxGuesses(int maxGuesses){
		if(numberOfGuesses >= maxGuesses){
			return true;
		}
		else if(numberOfGuesses > 1){
			return false;
		}
		else{
			return false;
		}
		
	}
	
	/**Main loop for the game.
	 * <p>If player guesses the correct word, the player is congratulated and the game ends. If they enter 0 or less, the game exits. A number between 1-10 allows the player to guess the word.
	 * If this word is the correct word then the game exits, if the number is the wrong word the player is told the similarity between the chosen word and the actual word.</p>
	 * 
	 * @param guess The index of the wordList array that the player is guessing to be the chosen word. 
	 * @return boolean: returns true if entered the correct word, or 0 or lower true is returned. If it's the wrong word false is returned.
	 * */
	public boolean guessChecker(int guess){
		//If the guess and the word are the same, congratulate player and exit game.
		if(wordGen.getWord(guess).equals(chosenWord)){	
			return true;		
		}
		
		//Displays similarity between guessed word and chosen word.
		else{
			if(!overMaxGuesses(4)){
				return false;
			} 
			else{
				return true;
			}
		}
	}
	
	/**Appends the text area of the GUI.
	 * 
	 * @param guess
	 * @return String: The string that is changing the text-area of the GUI.
	 */
	public String appendGuessText(int guess){
		StringBuilder sb = new StringBuilder();
		numberOfGuesses++;
		if(wordGen.getWord(guess).equals(chosenWord)){
			sb.append("CONGRATULATIONS! " + wordGen.getWord(guess) + " was the correct word!\n");
			if(numberOfGuesses == 1){
				sb.append("You solved it in a single guess!\n");
			}else{
				sb.append("You solved it in " + numberOfGuesses + " guesses!\n");
			}
			return sb.toString();		
		}
		//Displays similarity between guessed word and chosen word.
		else{
			sb.append("You chose " + wordGen.getWord(guess) + ": This has a similarity of " + getSimilarity(guess) + "/" + wordGen.getWordLength() + ".");
			if(!overMaxGuesses(4)){
				sb.append("\nPlease guess another word.");
			}
			sb.append("\n*********************\n");
			if(overMaxGuesses(4)){
				sb.append("Unfortunately you are over your maximum guesses!\n");
				sb.append("The correct word was: " + chosenWord);
			}
			return sb.toString();
		}
	}
	
	/** 
	 * Calculates similarity of guessed word and actual word.
	 * <p>Splits string into characters and compares each character. If a character is the same, and in the same place, the similarity is increased by 1.<p>
	 * @param guess The index of the word the player is guessing.
	 * @return int: the "similarity": the number of times the same character appears in the same space in both the chosen and actual word the player has to guess.
	 */
	private int getSimilarity(int guess){
		int similarity = 0;
		String chosenWordLetters[] = chosenWord.split("");
		String guessLetters[] = wordGen.getWord(guess).split("");
		for(int i = 0; i < chosenWordLetters.length; i++ ){
			if(guessLetters[i].equals(chosenWordLetters[i])){
				similarity++;
			}
		}
		return similarity;
	}
	
	public int getNumberOfGuesses(){
		return numberOfGuesses;
	}
}
