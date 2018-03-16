import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: TokenOperations.java
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

public class TokenOperations {
	private static ArrayList<String> wordsFromInputFile = null;
	
	/*
	 * Default Constructor
	 */
	public TokenOperations() {
		wordsFromInputFile = new ArrayList<String>();
	}
	
	/*
	 * creates an ArrayList<String> of all the words from the input file 
	 */
	public static void populateWordsFromInputFile() {
		for (int i = 0; i < FileOperations.getLinesFromInputFile().size(); i++) {
			delimitString(FileOperations.getLinesFromInputFile(i));
		}
	}
	
	/*
	 * Delimits a string into tokens and places them in an ArrayList<String>
	 * @parameter stringToDelimit = The string to delimit into tokens
	 */
	private static void delimitString(String stringToDelimit) {
		StringTokenizer tokens = new StringTokenizer(stringToDelimit);
		while (tokens.hasMoreTokens()) {
			wordsFromInputFile.add(tokens.nextToken());
		}
	}
	
	/*
	 * Gets the words from the input file in an ArrayList<String>
	 * @return wordsFromInputFile = An array list of words read in from the input file
	 */
	public static ArrayList<String> getWordsFromInputFile() {
		return wordsFromInputFile;
	}
	
	/**
	 * Will return the String located at the index parameter from the 
	 * ArrayList<String> of words read in from the file. 
	 * @param indexOfArrayList = index of ArrayList<String> that is requested to be returned
	 * @return String = The requested word from the input file
	 * ArrayList<String>
	 */
	public static String getWordsFromInputFile(int indexOfArrayList) {
		return wordsFromInputFile.get(indexOfArrayList);
	}
}
