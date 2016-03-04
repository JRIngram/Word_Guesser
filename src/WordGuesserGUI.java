import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


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
		}
		list = new JTextArea();
		
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
		
		mainFrame.setLayout(new BorderLayout());
		guessBox.setLayout(new FlowLayout());
		guessRow1.setLayout(new FlowLayout());
		guessRow2.setLayout(new FlowLayout());
		
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
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}
