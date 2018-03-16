import java.util.ArrayList;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: CheckWords.java
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

public class CheckWords {
	private ArrayList<MisspelledWord> wordsNotInDictionary = null;

	/**
	 * Default constructor
	 */
	public CheckWords() {
		ArrayList<MisspelledWord> wordsNotInDictionary = new ArrayList<MisspelledWord>();
	}

	/**
	 * @return the wordsNotInDictionary
	 */
	public ArrayList<MisspelledWord> getWordsNotInDictionary() {
		return wordsNotInDictionary;
	}
	
	/*
	 * Spell Checks the document
	 */
	public void spellCheckDocument() {
		String wordToCheck = "";
		boolean wordIsInDictionary = isWordInDictionary(wordToCheck);
	}
	
	/*
	 * Checks to see if a word is in the dictionary
	 * @parameter word = The word (String) to check if its in the dictionary
	 * @return boolean = true if word is in the dictionary, false if the word is not 
	 */
	private boolean isWordInDictionary(String word) {
		return false;
	}
}
