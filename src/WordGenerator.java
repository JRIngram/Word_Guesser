//Generates a word using random letters. 
//The word follows CVCCV structure (C for consonant, V for vowel). 
import java.util.Random;

public class WordGenerator{
	
	public WordGenerator(){
		
	}
	
	//Random generates a word with the length specified by the user.
	public String generateWord(int wordLength){
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
	
	public String vowelGenerator(int vowelNumber){
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
	
	public String consonantGenerator(int consonantNumber){
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
	
	
}