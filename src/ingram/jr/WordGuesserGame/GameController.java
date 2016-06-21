package ingram.jr.WordGuesserGame;
import javax.swing.JOptionPane;
import java.io.IOException;

/**Main Controller of the game
 * 
 * @author JRIngram
 * @version 21/06/2016
 * 
 * @see WordGuesserGame
 * 
 */ 
public class GameController {

	private static WordGenerator wordGen;
	private static WordGuesserGUI gui;
	private static GuessHandler handler; 

	public static void main(String args[]) throws IOException{
		DictWordGenerator testDictWordGen = new DictWordGenerator();
		int gameMode = chooseGameMode();
		if(gameMode == 0){
			//realwords.
			wordGen = new DictWordGenerator();
		}else{
			//falseFakeWords. KILL KILL KILL!
			wordGen = new RandomWordGenerator();
		}
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

	private static void chooseDifficulty(){
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
			wordGen.makeWordList(5);
			System.out.println("Dialogue box closed too early, defaulted to easy difficulty.");
			break;
		}

	}
	
	/** <p>Creates a JOptionPane dialog box with two choices. Asks the user whether they want to choose pseudo-random words or reals words supplied from (dictionary.txt).</p>
	 * @return The chosen game mode (0 for real words; 1 for pseudo-random words).
	 */
	private static int chooseGameMode(){
		JOptionPane gameModeSelector = new JOptionPane();
		String[] gameModes =  {
				"Real Words", "'Random' Words"
		};
		String gameModeDescriptions = "Which game mode would you like to play?\nReal Words uses words from a dictionary file.\nRandom Words' creates pseudo-random words.";
		int gameMode = gameModeSelector.showOptionDialog(
				null,
				gameModeDescriptions,
				"Select Game Mode.", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				gameModes, 
				gameModes[0]);	
		if(gameMode == 1){
			System.out.println("FALSE WORDS MUST DIE!");
		}
		else if(gameMode == 0){
			System.out.println("THE TRUE LORD AND REAL WORDS!");
		}
		return gameMode;
	}
}
