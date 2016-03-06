import java.util.Scanner;

/**@version 06/02/2016
 * @author JRIngram 
 * */

public class WordGuesserGame{
	private static WordGenerator wordGen;
	private static Scanner input;
	private static String chosenWord;
	private static int numberOfGuesses;
	public static boolean correct;
	
	
	/**
	 * Main class: consists of assigning variables and a main-loop
	 * */
	public static void main(String[] args) {
		
		wordGen = new WordGenerator();
		input = new Scanner(System.in);
		chosenWord = null;
		numberOfGuesses = 0;
		correct = false;
		chooseDifficulty();
		chosenWord = wordGen.wordChooser();
		WordGuesserGUI gui = new WordGuesserGUI(wordGen);
		welcome();
		
		while(!correct){
			System.out.print("> ");
			int guess = input.nextInt();
			numberOfGuesses++;
			correct = guessChecker(guess);
		}
		System.out.println("Thank you for playing Word Guesser!");
	}
	
	/**Prints welcome message and list of words for the game.*/
	public static void welcome(){
		wordGen.printWordList();
		System.out.println("The computer has chosen a word from the list above.");
		System.out.println("It is your job to work out which word the computer has chosen.");
		System.out.println("This is done by entering the number of the word you wish to guess from above.");
		System.out.println("You will then be told the similarity of the chosen word, and your guess.");
		System.out.println("Similarity is defined as the same letter in the same position.");
		System.out.println("For example: If the computer chose 'bacde' and you guessed 'bucke' the similarity would be 3/5 as both words contain b, c and e in the same position.");
		System.out.println("Begin by choosing the number of the word you want to guess, enter 0 to enter command mode, or a negative number to exit.:");
	}
	
	/**Used to check number of guesses.
	 * <p>Prints the number of guesses. If the number of guesses is more than the maximum number of guesses the game ends and the correct word is revealed. </p>
	 * 
	 * @param maxGuesses determines the maximum number of guesses the player can have. 
	 * @return boolean: returns true if the player has guessed equal or more than the maximum guesses. 
	 * */
	public static boolean maxGuesses(int maxGuesses){
		if(numberOfGuesses >= maxGuesses){
			System.out.println("You have had your " + maxGuesses + " guesses and haven't guessed the correct word!\nYou lose!\nThe correct word was: " + chosenWord + ".");
			return true;
		}
		else if(numberOfGuesses > 1){
			System.out.println("You have had " + numberOfGuesses + " guesses.");
			return false;
		}
		else{
			System.out.println("You have had " + numberOfGuesses + " guess.");
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
	
	//***ERROR: Player can enter >10 and causes crash.*** 
	public static boolean guessChecker(int guess){
		//guess -1 so that the user input aligns with the number on the word list.
		guess--;
		System.out.print("\n");
		
		//Allows user to exit game
		if(guess <= -1){
			return true;
		}
		
		//If the guess and the word are the same, congratulate player and exit game.
		else if(wordGen.getWord(guess).equals(chosenWord)){
			System.out.println("CONGRATULATIONS! " + wordGen.getWord(guess) + " was the correct word!");
			if(numberOfGuesses == 1){
				System.out.println("You solved it in a single guess!");
			}else{
				System.out.println("You solved it in " + numberOfGuesses + " guesses!");
			}
				
			return true;		
		}
		
		//Displays similarity between guessed word and chosen word.
		else{
			System.out.println("You chose " + wordGen.getWord(guess) + ". This has a similarity of " + getSimilarity(guess) + "/" + wordGen.getWordLength() + ".");
			if(!maxGuesses(4)){
				System.out.print("Guess another word, or enter 0 or a negative number to exit.\n");
				return false;
			} 
			else{
				return true;
			}
		}
	}
	
	/** 
	 * Calculates similarity of guessed word and actual word.
	 * <p>Splits string into characters and compares each character. If a character is the same, and in the same place, the similarity is increased by 1.<p>
	 * @param guess The index of the word the player is guessing.
	 * @return int: the "similarity": the number of times the same character appears in the same space in both the chosen and actual word the player has to guess.
	 */
	
	public static int getSimilarity(int guess){
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
	
	/**Allows the user to choose one of the predefined difficulties:
	 * <p>'EASY': Easy, sets the word length as 5.</p>
	 * <p>'MED': Medium, sets the word length as 7.</p>
	 * <p>'HARD': Hard, sets the word length as 10.</p>
	 * <p>'CUST': Customer, allows the player to set the word length between 3 and 10.</p>
	 * */	
	public static void chooseDifficulty(){
		System.out.print("Welcome to WordGuesser! What difficulty would you like to play?\n"
				+ "'EASY': 5 letter-length words, 4 guesses.\n"
				+ "'MED': 7 letter-length words, 4 guesses.\n"
				+ "'HARD': 10 letter-length words, 4 guesses.\n"
				+ "'CUST': Custom letter-length, 4 guesses.\n> ");
		boolean valid = false;
		while(!valid){
			String difficulty = input.nextLine();
			if(difficulty.toUpperCase().equals("EASY")){
				valid = true; 
				wordGen.makeWordList(5);
				System.out.print("EASY difficulty chosen: \n\n");
			}else if(difficulty.toUpperCase().equals("MED")){
				valid = true; 
				wordGen.makeWordList(7);
				System.out.print("MED difficulty chosen: \n\n");
			}else if(difficulty.toUpperCase().equals("HARD")){
				valid = true;
				wordGen.makeWordList(10);
				System.out.print("HARD difficulty chosen: \n\n");
			}else if(difficulty.toUpperCase().equals("CUST")){
				System.out.println("CUST difficulty chosen: ");
				while(!valid){
					System.out.print("What length would you like the words?(Min: 3; Max: 10)\n> ");
					int length = input.nextInt();
					if(length >= 3 && length <= 10){
						valid = true; 
						wordGen.makeWordList(length);
					}else{
						System.out.println("Invalid length entered.\n");	
					}
				}
			}else{
				System.out.print("Invalid difficulty.\nPlease choose a difficulty from the list above.\n> ");
			}
			
		}
	}
	
}