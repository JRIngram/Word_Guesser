package ingram.jr.WordGuesserGame.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ingram.jr.WordGuesserGame.WordList;

public class WordListTest {
	
	private WordList wordList;
	
	@Before
	public void setUp(){
		wordList = new WordList(2);
	}
	
	@Test
	public void testConstructor(){
		assertEquals(0, wordList.getCurrentSize());
		assertEquals(2, wordList.getMaxSize());
	}
	
	@Test
	public void testAdding(){
		assertEquals(true, wordList.addWord("Apple"));
		assertEquals(1, wordList.getCurrentSize());
		assertEquals(false, wordList.addWord("Apple"));
		assertEquals(1, wordList.getCurrentSize());
		assertEquals(true, wordList.addWord("Banana"));
		assertEquals(2, wordList.getCurrentSize());
		assertEquals(false, wordList.addWord("Banana"));
		assertEquals(2, wordList.getCurrentSize());
		assertEquals(false, wordList.addWord("Carrot"));
		assertEquals(2, wordList.getCurrentSize());
	}
	
	@Test
	public void testReset(){
		assertEquals(true, wordList.addWord("Apple"));
		assertEquals(1, wordList.getCurrentSize());
		assertEquals(false, wordList.addWord("Apple"));
		assertEquals(1, wordList.getCurrentSize());
		assertEquals(true, wordList.addWord("Banana"));
		assertEquals(2, wordList.getCurrentSize());
		assertEquals(false, wordList.addWord("Banana"));
		assertEquals(2, wordList.getCurrentSize());
		assertEquals(false, wordList.addWord("Carrot"));
		assertEquals(2, wordList.getCurrentSize());
		wordList.resetWordList();
		assertEquals(0, wordList.getCurrentSize());
		assertEquals(true, wordList.addWord("Apple"));
		assertEquals(1, wordList.getCurrentSize());
		assertEquals(false, wordList.addWord("Apple"));
		assertEquals(1, wordList.getCurrentSize());
		assertEquals(true, wordList.addWord("Banana"));
		assertEquals(2, wordList.getCurrentSize());
		assertEquals(false, wordList.addWord("Banana"));
		assertEquals(2, wordList.getCurrentSize());
		assertEquals(false, wordList.addWord("Carrot"));
		assertEquals(2, wordList.getCurrentSize());
	}
	
	@Test
	public void testGetWord(){
		assertEquals("ERROR", wordList.getWord(0));
		assertEquals(true, wordList.addWord("Apple"));
		assertEquals(1, wordList.getCurrentSize());
		assertEquals("Apple", wordList.getWord(0));
	}

}
