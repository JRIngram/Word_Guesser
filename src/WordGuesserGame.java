import java.util.Scanner;

public class WordGuesserGame {
	private static WordGenerator wordGen;
	private static String[] words;
	private static Scanner input;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordGen = new WordGenerator();
		words = new String[10];
		input = new Scanner(System.in);
		for(int i = 0; i < 10; i++){
			words[i] = wordGen.generateWord();
			for(int c = i - 1; c >= 0 ; c--){
				while(words[i].equals(words[c])){
					words[i] = wordGen.generateWord();
				}
			}
		}
		System.out.println("************");
		for(int i = 0; i < 10; i++){
			System.out.print(i + 1 + ". ");
			System.out.println(words[i]);
		}
		System.out.println("************\n");
		welcome();
		System.out.print(">");
		String guess = input.nextLine();
		
			
	}
	public static void welcome(){
		
		System.out.println("The computer has chosen a word from the list above.");
		System.out.println("It is your job to work out which word the computer has chosen.");
		System.out.println("This is done by entering the number of the word you wish to guess from above.");
		System.out.println("You will then be told the similarity of the chosen word, and your guess.");
		System.out.println("Similarity is defined as the same letter in the same position.");
		System.out.println("For example: If the computer chose 'bacde' and you guessed 'bucke' the similarity would be 3/5 as both words contain b, c and e in the same position.");
		System.out.println("Begin by choosing the number of the word you want to guess:");
	}

}

