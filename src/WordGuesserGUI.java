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
		list = new JTextArea();
		
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
