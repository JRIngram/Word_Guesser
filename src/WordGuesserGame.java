import java.util.Scanner;
import java.util.Random;

public class WordGuesserGame {
	private static WordGenerator wordGen;
	private static String[] words;
	private static Scanner input;
	private static String chosenWord = null;
	private static int numberOfGuesses = 0;
	
			
	public static void main(String[] args) {
		wordGen = new WordGenerator();
		words = new String[10];
		input = new Scanner(System.in);
		boolean correct = false;
		
		
		//Generates 10 words.
		for(int i = 0; i < 10; i++){
			words[i] = wordGen.generateWord();
			for(int c = i - 1; c >= 0 ; c--){
				while(words[i].equals(words[c])){
					words[i] = wordGen.generateWord();
				}
			}
		}
		wordChooser();
		
		//Prints the 10 generated words.
		System.out.println("************");
		for(int i = 0; i < 10; i++){
			System.out.print(i + 1 + ". ");
			System.out.println(words[i]);
		}
		System.out.println("************\n");
		
		welcome();
		while(!correct){
			System.out.print("> ");
			int guess = input.nextInt();
			numberOfGuesses++;
			correct = game(guess);
		}
		System.out.println("Thank you for playing Word Guesser!");
	}
	
	public static void welcome(){
		System.out.println("The computer has chosen a word from the list above.");
		System.out.println("It is your job to work out which word the computer has chosen.");
		System.out.println("This is done by entering the number of the word you wish to guess from above.");
		System.out.println("You will then be told the similarity of the chosen word, and your guess.");
		System.out.println("Similarity is defined as the same letter in the same position.");
		System.out.println("For example: If the computer chose 'bacde' and you guessed 'bucke' the similarity would be 3/5 as both words contain b, c and e in the same position.");
		System.out.println("Begin by choosing the number of the word you want to guess, or enter 0 or a negative number to exit.:");
	}
	
	//Randomly chooses a word out of the words Array.
	public static void wordChooser(){
		Random wordChooser = new Random();
		int wordNumber = wordChooser.nextInt(10);
		chosenWord = words[wordNumber]; 
	}
	
	//Main loop for the game.
	public static boolean game(int guess){
		//-1 so that the user input aligns with the number on the word list.
		guess--;
		
		//allows user to exit game
		if(guess < 0){
			return true;
		}
		
		//If the guess and the word are the same, congratulate player and exit game.
		else if(words[guess].equals(chosenWord)){
			System.out.println("CONGRATULATIONS! " + words[guess] + " was the correct word!");
			if(numberOfGuesses == 1){
				System.out.println("You solved it in a single guess!");
			}else{
				System.out.println("You solved it in " + numberOfGuesses + " guesses!");
			}
				
			return true;
		
		//Splits string into characters and compares each character	
		}else{
			int similarity = 0;
			String chosenWordLetters[] = chosenWord.split("");
			String guessLetters[] = words[guess].split("");
			for(int i = 0; i < chosenWordLetters.length; i++ ){
				if(guessLetters[i].equals(chosenWordLetters[i])){
					similarity++;
				}
			}
			System.out.println("You chose " + words[guess] + ". This has a similarity of " + similarity + "/5.");
			System.out.print("Guess another word, or enter 0 or a negative number to exit.");
			return false;
		}
	}

}

