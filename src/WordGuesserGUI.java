import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**GUI for the Word Guesser Game
 * @author JRIngram
 * @version 19/03/2016
 **/ 

public class WordGuesserGUI {
	
	private JFrame mainFrame;
	private JTextArea list;
	private JButton wordButton[];
	private JButton quitButton;
	private GuessHandler gh;
	
	/**Generates GUI for the Word Guesser Game.
	 * 
	 * @param wg Containers the WordGenerator to allow display of the same words.
	 * @param gh Containers the GuessHandler so that it can respond to guesses made by the user and disable buttons once words have been guessed or the maximum amount of guesses have been reached.
	 */

	public WordGuesserGUI(WordGenerator wg, GuessHandler gh){
		this.gh = gh;
		quitButton = new JButton();
		quitButton.setText("Quit");
		quitButton.setToolTipText("Allows user to exit program");
		//Constructs 10 buttons, 1 for each word.
		wordButton = new JButton[10];
		for(int i = 0; i <= wordButton.length - 1; i++){
			wordButton[i] = new JButton();
			wordButton[i].setText(wg.getWord(i));
			wordButton[i].setToolTipText("Guess " + wg.getWord(i) + " as the correct word.");
		}
		list = new JTextArea(wg.printWordList() +
				"The computer has chosen a word from the list above.\n"
				+ "It is your job to work out which word the computer has chosen.\n"
				+ "This is done by entering the number of the word you wish to guess from above.\n"
				+ "You will then be told the similarity of the chosen word, and your guess.\n"
				+ "Similarity is defined as the same letter in the same position.\n"
				+ "For example:\nIf the computer chose 'bacde' and you guessed 'bucke' the similarity would be 3/5.\n"
				+ "This is because both words contain b, c and e in the same position.\n"
				+ "Begin by choosing the word you want to guess."
				+ "\n*********************\n");
		
		//GUI properties.
		list.setEditable(false);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setMinimumSize(new Dimension(200,200));
		listScroller.setPreferredSize(new Dimension(300,300));
		mainFrame = new JFrame("Word Guesser Game");
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(400, 400));
		mainFrame.setMinimumSize(new Dimension(600,500));
		JPanel guessBox = new JPanel();
		JPanel guessRow1 = new JPanel();
		JPanel guessRow2 = new JPanel();
		
		//Set-up layouts
		mainFrame.setLayout(new BorderLayout());
		guessBox.setLayout(new FlowLayout());
		guessRow1.setLayout(new FlowLayout());
		guessRow2.setLayout(new FlowLayout());
		
		//Position components.
		mainFrame.add(listScroller, BorderLayout.NORTH);
		mainFrame.add(guessBox, BorderLayout.CENTER);
		mainFrame.add(quitButton, BorderLayout.SOUTH);
		guessBox.add(guessRow1, BorderLayout.CENTER);
		guessBox.add(guessRow2, BorderLayout.SOUTH);
		for(int i = 0; i <= 4; i++){
			guessRow1.add(wordButton[i]);
		}
		for(int i = 5; i <= wordButton.length - 1; i++){
			guessRow2.add(wordButton[i]);
		}
		
		//Event Handlers
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				exitProgram();
			}
		});
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				exitProgram();
			}
		});
		
		//Assign event handlers for word guessing buttons.
		wordButton[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gh.guessChecker(0);
				list.append(gh.appendGuessText(0));
				wordButton[0].setEnabled(false);
				disableButtons(0, 4);
			}
		});
		
		wordButton[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				wordButton[1].setEnabled(false);
				list.append(gh.appendGuessText(1));
				disableButtons(1, 4);
			}
		});
		
		wordButton[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gh.guessChecker(2);
				list.append(gh.appendGuessText(2));
				wordButton[2].setEnabled(false);
				disableButtons(2, 4);
			}
		});
		
		wordButton[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gh.guessChecker(3);
				list.append(gh.appendGuessText(3));
				wordButton[3].setEnabled(false);
				disableButtons(3, 4);
			}
		});
		
		wordButton[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gh.guessChecker(4);
				list.append(gh.appendGuessText(4));
				wordButton[4].setEnabled(false);
				disableButtons(4, 4);
			}
		});
		
		wordButton[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gh.guessChecker(5);
				list.append(gh.appendGuessText(5));
				wordButton[5].setEnabled(false);
				disableButtons(5, 4);
			}
		});
		
		wordButton[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gh.guessChecker(6);
				list.append(gh.appendGuessText(6));
				wordButton[6].setEnabled(false);
				disableButtons(6, 4);
			}
		});
		
		wordButton[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gh.guessChecker(7);
				list.append(gh.appendGuessText(7));
				wordButton[7].setEnabled(false);
				disableButtons(7, 4);
			}
		});
		
		wordButton[8].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gh.guessChecker(8);
				list.append(gh.appendGuessText(8));
				wordButton[8].setEnabled(false);
				disableButtons(8, 4);
			}
		});
		
		wordButton[9].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gh.guessChecker(9);
				list.append(gh.appendGuessText(9));
				wordButton[9].setEnabled(false);
				disableButtons(9, 4);
			}
		});
		
		//Display
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	/**Asks the user if they wish to exit the program, and exits on confirmation.
	 */
	private void exitProgram(){
		int response = JOptionPane.showConfirmDialog(mainFrame,
				"Are you sure you wish to quit?",
				"Quit?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if(response == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
	/**Disables all word buttons if the guess is correct or maximum number of guesses is exceeded.
	 * @param guess is the number of word the player is guessing.
	 * @param maxGuess is the maximum number of guesses the player is allowed.
	 */
	private void disableButtons(int guess, int maxGuess){
		if(gh.guessChecker(guess) || gh.overMaxGuesses(maxGuess)){
			for(int c = 0; c <= 9; c++){
				wordButton[c].setEnabled(false);
			}
		}
	}
}
