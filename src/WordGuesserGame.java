
public class WordGuesserGame {
	private static WordGenerator wordGen;
	private static String[] words;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordGen = new WordGenerator();
		words = new String[10];
		for(int i = 0; i < 10; i++){
			words[i] = wordGen.generateWord();
			for(int c = i - 1; c >= 0 ; c--){
				while(words[i].equals(words[c])){	
				}
			}
		}
		System.out.println("************");
		for(int i = 0; i < 10; i++){
			System.out.println(words[i]);
		}
		System.out.println("************");
		
	}

}

