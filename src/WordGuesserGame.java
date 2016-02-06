//@Version 06/02/2016

import java.util.Scanner;

public class WordGuesserGame{
	private static WordGenerator wordGen;
	private static Scanner input;
	private static String chosenWord = null;
	private static int numberOfGuesses = 0;
			
	public static void main(String[] args) {
				
		wordGen = new WordGenerator();
		input = new Scanner(System.in);
		boolean correct = false;
		
		chooseDifficulty();
		chosenWord = wordGen.wordChooser();
		welcome();
		
		while(!correct){
			System.out.print("> ");
			int guess = input.nextInt();
			numberOfGuesses++;
			correct = guessChecker(guess);
		}
		System.out.println("Thank you for playing Word Guesser!");
	}
	
	//Prints welcome message and list of words for the game.
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
	
	//Used to check number of guesses.
	public static boolean maxGuesses(int maxGuesses){
		if(numberOfGuesses >= maxGuesses){
			System.out.println("You have had your" + maxGuesses + "guesses and haven't guessed the correct word!\nYou lose!\nThe correct word was: " + chosenWord + ".");
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
	
	//Main loop for the game.
	public static boolean guessChecker(int guess){
		//guess -1 so that the user input aligns with the number on the word list.
		guess--;
		System.out.print("\n");
		
		/*
		*	if(guess == 0){
		*	//
		*	return false; 
		*	}
		*/
		
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
	
	/*Calculates similarity of guessed word and actual word.
	 * Splits string into characters and compares each character.
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
	
	public static void chooseDifficulty(){
		System.out.print("Welcome to WordGuesser! What difficulty would you like to play?\n"
				+ "'EASY': 5 letter-length words, 4 guesses.\n"
				+ "'MED': 7 letter-length words, 4 guesses.\n"
				+ "'HARD': 10 letter-length words, 4 guesses.\n> ");
		boolean valid = false;
		while(valid == false){
			String difficulty = input.nextLine();
			if(difficulty.toUpperCase().equals("EASY")){
				valid = true; 
				wordGen.makeWordList(4, 5, 10);
				System.out.print("EASY difficulty chosen: \n\n");
			}else if(difficulty.toUpperCase().equals("MED")){
				valid = true; 
				wordGen.makeWordList(7,5,10);
				System.out.print("MED difficulty chosen: \n\n");
			}else if(difficulty.toUpperCase().equals("HARD")){
				valid = true;
				wordGen.makeWordList(10, 5, 10);
				System.out.print("HARD difficulty chosen: \n\n");
			}else{
				System.out.print("Invalid difficulty.\nPlease choose a difficulty from the list above.\n> ");
			}
		}
	}
	
}