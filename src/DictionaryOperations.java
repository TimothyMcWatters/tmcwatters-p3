import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: DictionaryOperations.java
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

public class DictionaryOperations {
	private Scanner inputStream = null;
	private String dictionaryFileName = "dictionary.txt";
	private HashSet<String> dictionary = null;
	
	/*
	 * Default Constructor
	 */
	public DictionaryOperations() {
		dictionary = new HashSet<String>();
	}
	
	/*
	 * Reads the dictionary words from the input file
	 * @parameter dictionaryFileName = The name of the dictionary input file
	 */
	public void readDictionaryFile(String dictionaryFileName) {
		
	}
	
	/*
	 * populates the HashSet from the input file dictionary words
	 * 
	 */
	public static void populateDictionary() {
		
	}
	
	/*
	 * Inserts an individual word into the dictionary HashSet
	 * @parameter wordToInsert = The word to insert into the dictionary HashSet
	 */
	private void insertWordIntoDictionary(String wordToInsert) {
		
	}
	
	/*
	 * Checks to see if the dictionary has a particular word
	 * @parameter wordToCheck = The word to check the dictionary for
	 * @return boolean = True if dictionary has the word, false if not
	 */
	public static boolean dictionaryHasWord(String wordToCheck) {
		return false;
	}
}
