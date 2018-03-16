import java.util.ArrayList;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: MisspelledWord.java
 * 
 * This Program: Will create a graphical spell checker program
 * It will have a menu item to open an input file and place it into a TextArea in a window. 
 * When the checking proceeds, it will extract a word from the text to be checked, 
 * hash it into the table, and determine if it exists. 
 * You will continue this process until you have checked all the words in the file. 
 * Each time you find a word that you cannot match in the dictionary, you will let the user 
 * know and you will attempt to generate a list of suggested words. 
 * You will generate the list by assembling similar words via three methods:
 *		One letter missing. 
 *		One letter added. 
 *		Two letters reversed. 
 */

public class MisspelledWord {
	private static final int sizeOfAlphabet = 26;
	private String misspelledWord = "";
	private ArrayList<String> suggestedWords = null;
	
	/*
	 * Default Constructor
	 */
	public MisspelledWord() {
		suggestedWords = new ArrayList<String>();
	}
	
	/*
	 * 
	 */
	public void findSuggestions() {
		
	}
	
	/*
	 * 
	 */
	private void oneLetterMissing() {
		
	}
	
	/*
	 * 
	 */
	private void oneLetterAdded() {
		
	}
	
	/*
	 * 
	 */
	private void lettersReversed() {
		
	}
	
	/*
	 * 
	 */
	public String toString() {
		return "";
	}
}
