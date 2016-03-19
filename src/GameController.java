import javax.swing.JOptionPane;

/**Main Controller of the game
 * @author JRIngram
 * @version 19/03/2016
 *
 **/ 

//----CREATE GUI AND GUESSHANDLER USING THE SAME WORDGENERATOR BY CREATING THEM BOTH IN THIS CLASS.

public class GameController {
	
	private static WordGenerator wordGen;
	private static WordGuesserGUI gui;
	private static GuessHandler handler; 
		
	public static void main(String args[]){
		wordGen = new WordGenerator();
		chooseDifficulty();
		handler = new GuessHandler(wordGen);
		gui = new WordGuesserGUI(wordGen, handler);
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
}
