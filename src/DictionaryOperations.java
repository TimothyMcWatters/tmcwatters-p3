import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private String dictionaryFileName = "Words.txt";
	private static HashSet<String> dictionary = null;
	
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
		try {
			inputStream = new Scanner(new FileInputStream(dictionaryFileName));
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: File " + dictionaryFileName + " was not found, or could not be opened.");
			System.exit(0);
		}
		populateDictionary();
	}
	
	public void populateDictionary() {
		while (inputStream.hasNextLine()) {
			insertWordIntoDictionary(inputStream.nextLine());
		} 
		inputStream.close();
	}
	
	/*
	 * Inserts an individual word into the dictionary HashSet
	 * @parameter wordToInsert = The word to insert into the dictionary HashSet
	 */
	private static void insertWordIntoDictionary(String wordToInsert) {
		dictionary.add(wordToInsert);
	}
	
	/*
	 * Checks to see if the dictionary has a particular word
	 * @parameter wordToCheck = The word to check the dictionary for
	 * @return boolean = True if dictionary has the word, false if not
	 */
	public static boolean dictionaryHasWord(String wordToCheck) {
		return dictionary.contains(wordToCheck);
	}
	
	/*
	 * Getter for dictionaryFileName
	 * @returns the file name of the dictionary input file
	 */
	public String getDictionaryFileName() {
		return this.dictionaryFileName;
	}
	
	/*
	 * Setter for dictionaryFileName
	 * @parameter the file name of the dictionary input file
	 */
	public void setDictionaryFileName(String dictionaryFileName) {
		this.dictionaryFileName = dictionaryFileName;
	}
}
