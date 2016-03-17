import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**Generates a GUI for the Word Guesser Game
 * @author JRIngram
 * @version 06/03/2016
 * 
 **/ 

public class WordGuesserGUI {
	
	private JFrame mainFrame;
	private JTextArea list;

	public WordGuesserGUI(WordGenerator wordGen){
		JButton quitButton = new JButton();
		quitButton.setText("Quit");
		quitButton.setToolTipText("Allows user to exit program");
		//Constructs 10 buttons, 1 for each word.
		JButton[] wordButtons = new JButton[10];
		for(int i = 0; i <= wordButtons.length - 1; i++){
			wordButtons[i] = new JButton();
			wordButtons[i].setText(wordGen.getWord(i));
			wordButtons[i].setToolTipText("Guess " + wordGen.getWord(i) + " as the correct word.");
		}
		list = new JTextArea(wordGen.printWordList() +
				"The computer has chosen a word from the list above.\n"
				+ "It is your job to work out which word the computer has chosen.\n"
				+ "This is done by entering the number of the word you wish to guess from above.\n"
				+ "You will then be told the similarity of the chosen word, and your guess.\n"
				+ "Similarity is defined as the same letter in the same position.\n"
				+ "For example:\nIf the computer chose 'bacde' and you guessed 'bucke' the similarity would be 3/5.\n"
				+ "This is because both words contain b, c and e in the same position.\n"
				+ "Begin by choosing the word you want to guess.");
		
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
			guessRow1.add(wordButtons[i]);
		}
		for(int i = 5; i <= wordButtons.length - 1; i++){
			guessRow2.add(wordButtons[i]);
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
		
		//Display
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	
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
}
