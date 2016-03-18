import java.util.Scanner;
import javax.swing.JOptionPane;

/**@version 17/03/2016
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
	public WordGuesserGame(){
		wordGen = new WordGenerator();
		GuessHandler gh = new GuessHandler(wordGen); 
		input = new Scanner(System.in);
		chosenWord = null;
		numberOfGuesses = 0;
		correct = false;
		chooseDifficulty();
		chosenWord = wordGen.wordChooser();
		WordGuesserGUI gui = new WordGuesserGUI(wordGen, gh);
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
		//Prints info to the console.
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
	
	public static boolean guessChecker(int guess){
		//guess -1 so that the user input aligns with the number on the word list.
		guess--;
		System.out.print("\n");
		
		//If the guess and the word are the same, congratulate player and exit game.
		if(wordGen.getWord(guess).equals(chosenWord)){
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
	
	/**Allows the user to choose one of the predefined difficulties, through a dialogue box:
	 * <p>'EASY': Easy, sets the word length as 5.</p>
	 * <p>'MED': Medium, sets the word length as 7.</p>
	 * <p>'HARD': Hard, sets the word length as 10.</p>
	 * <p>'CUST': Customer, allows the player to set the word length between 3 and 10, using a dialogue box.</p>
	 * */	
	public static void chooseDifficulty(){
		String[] options = new String[4];
		String difficultyMessage = "Welcome to WordGuesser! What difficulty would you like to play?:" +
				"\n'EASY': 5 letter-length words, 4 guesses." +
				"\n'MED': 7 letter-length words, 4 guesses." +
				"\n'HARD': 10 letter-length words, 4 guesses." +
				"\n'CUST': Custom letter-length, 4 guesses.";
		options[0] = "Easy";
		options[1] = "Medium";
		options[2] = "Hard";
		options[3] = "Custom";
		int difficulty = JOptionPane.showOptionDialog(null, difficultyMessage, "Choose Difficulty", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		switch(difficulty){
		case 0: 
			wordGen.makeWordList(5);
			break;
		case 1:
			wordGen.makeWordList(7);
			break;
		case 2:
			wordGen.makeWordList(10);
			break;
		case 3:
			//Another dialogue to choose word length.
			String[] custWordLength = new String [8];
			custWordLength[0] = "3";
			custWordLength[1] = "4";
			custWordLength[2] = "5";
			custWordLength[3] = "6";
			custWordLength[4] = "7";
			custWordLength[5] = "8";
			custWordLength[6] = "9";
			custWordLength[7] = "10";
			int customWordLength = JOptionPane.showOptionDialog(null, "What length would you like the letters?", "Choose Letter Length:", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, custWordLength, custWordLength[0]);
			switch(customWordLength){
			case 0:
				wordGen.makeWordList(3);
				break;
			case 1: 
				wordGen.makeWordList(4);
				break;
			case 2:
				wordGen.makeWordList(5);
				break;
			case 3: 
				wordGen.makeWordList(6);
				break;
			case 4:
				wordGen.makeWordList(7);
				break;
			case 5:
				wordGen.makeWordList(8);
				break;
			case 6:
				wordGen.makeWordList(9);
				break;
			case 7:
				wordGen.makeWordList(10);
				break;
			}
			break;
		default: 
			System.out.println("Error."); 
			break;
		}
		
	}
	
	public void setChosenWord(String chosenWord){
		this.chosenWord = chosenWord;
	}
	
	public String getChosenWord(){
		return chosenWord;
	}
	
}

