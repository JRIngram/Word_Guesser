package ingram.jr.WordGuesserGame;

import java.util.Random;

/**Generates a word using random letters and controls access to word list.
 * @author JRIngram
 * @version 21/06/2016
 * 
 **/ 

public class RandomWordGenerator extends WordGenerator{
	
	/**Creates an empty String array which can hold 10 items used for holding the generated words.
	 * 
	 * */
	public RandomWordGenerator(){
		super();
	}
	
	/**
	 *	Randomly generates a word with the length specified by the user.
	 * <p>Letters 2, 5, 8 and 10 letters are vowels, others are consonants.
	 * To change this change the values of i (where i + 1 = vowel) in the if statement within the method.</p>
	 * 
	 * @param wordLength Determines number of iterations of for loop, and thus length of all generated words.
	 * @return A String type which is contained in the Object's String array 'words'.
	 * */
	private String generateWord(int wordLength){
		this.wordLength = wordLength;
		Random vowelRandom = new Random();
		Random consonantRandom = new Random();
		String word;
		StringBuilder wordBuilder = new StringBuilder();						
		for(int i = 0; i < wordLength; i++){
			if(i == 1 || i == 4 || i == 7 || i == 9){ //On 2nd, 4th, 7th and 10th letter, generate a vowel. 
				int vowelNumber = vowelRandom.nextInt(5);
				wordBuilder.append(vowelGenerator(vowelNumber));
			}else{ 
				int consonantNumber = consonantRandom.nextInt(21);
				wordBuilder.append(consonantGenerator(consonantNumber));
			}
		}
		word = wordBuilder.toString().toUpperCase();
		return word;
		
	}
	
	public void regenerateSpecificWord(int index){
		words[index] = generateWord(wordLength);
	}
	
	/**
	 * Creates a list of vowels and selects one based on parameter.
	 * <p>Takes the parameter vowelNumber and chooses a vowel based off of that, using a switch statement, with each different case being a different vowel.</p>
	 * <p>E! marks an error, and is the default case.</p>
	 * 
	 * @param vowelNumber The parameter which decides which vowel is returned. This is given to this method from the 'WordGuesserGame' class.
	 * @return String: A vowel character. 
	 * */
	private String vowelGenerator(int vowelNumber){
		String vowel = null;
		switch(vowelNumber){
			case 0:
				vowel = "a";
				break;
			case 1:
				vowel = "e";
				break;
			case 2:
				vowel = "i";
				break;
			case 3: 
				vowel = "o";
				break;
			case 4:
				vowel = "u";
				break;
			default:
				vowel = "E!"; //Signifies an error.
		}
		return vowel;
		
	}
	
	/**
	 * Creates a list of consonants and selects one based on parameter.
	 * <p>Takes the parameter consonantNumber and chooses a vowel based off of that, using a switch statement, with each different case being a different consonant.</p>
	 * <p>E! marks an error, and is the default case.</p>
	 * 
	 * @param consonantNumber The parameter which decides which consonant is returned. This is given to this method from the 'WordGuesserGame' class.
	 * @return String: A consonant character. 
	 * */
	private String consonantGenerator(int consonantNumber){
		String consonant = null;
		switch(consonantNumber){
		case 0:
			consonant = "b";
			break;
		case 1: 
			consonant = "c";
			break;
		case 2:
			consonant = "d";
			break;
		case 3:
			consonant = "f";
			break; 
		case 4:
			consonant = "g";
			break;
		case 5:
			consonant = "h";
			break;
		case 6: 
			consonant = "j";
			break;
		case 7:
			consonant = "k";
			break;
		case 8:
			consonant = "l";
			break;
		case 9:
			consonant = "m";
			break;
		case 10:
			consonant = "n";
			break;
		case 11:
			consonant = "p";
			break;
		case 12:
			consonant = "q";
			break;
		case 13:
			consonant = "r";
			break;
		case 14:
			consonant = "s";
			break;
		case 15:
			consonant = "t";
			break;
		case 16:
			consonant = "v";
			break;
		case 17:
			consonant = "w";
			break;
		case 18:
			consonant = "x";
			break;
		case 19:
			consonant = "y";
			break;
		case 20:
			consonant = "z";
			break;
		default:
			consonant = "E!"; //Signifies an error.
			
		}
		return consonant;
	}
	
	/**
	 * Checks word length and creates a list of 10 words
	 * <p>Calls the generateWord method 10 times to produce a list of 10 words. If a word that's generated is the same as a previous word, the word is regenerated until it's different to a previous word.</p> 
	 * <p>Runs uniqueWordChecker to ensure all words are unique.
	 * @param wordLength Determines the length of the words generated.
	 * */
	public void makeWordList(int wordLength){
		this.wordLength = wordLength;
		for(int i = 0; i < 10; i++){
			words[i] = generateWord(wordLength);
			//If the new word is the same as a previous word, regenerate.
			for(int c = i - 1; c >= 0 ; c--){
				while(words[i].equals(words[c])){
					words[i] = generateWord(wordLength);
				}
			}
		}
		uniqueWordChecker();
	}
	
}