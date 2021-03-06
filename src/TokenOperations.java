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
	private ArrayList<String> wordsFromInputFile = null;
	private FileOperations fileOps;
	
	/*
	 *  Constructor
	 */
	public TokenOperations(FileOperations fileOps) {
		this.fileOps = fileOps;
		wordsFromInputFile = new ArrayList<String>();
	}
	
	/*
	 * creates an ArrayList<String> of all the words from the input file 
	 */
	public void populateWordsFromInputFile() {
		for (int i = 0; i < fileOps.getLinesFromInputFile().size(); i++) {
			delimitString(fileOps.getLinesFromInputFile(i));
		}
	}
	
	/*
	 * Delimits a string into tokens and places them in an ArrayList<String>
	 * @parameter stringToDelimit = The string to delimit into tokens
	 */
	private void delimitString(String stringToDelimit) {
		StringTokenizer tokens = new StringTokenizer(stringToDelimit);
		while (tokens.hasMoreTokens()) {
			String wordBeforeCommaDotRemoved = tokens.nextToken();
			if (wordBeforeCommaDotRemoved.endsWith(".") || wordBeforeCommaDotRemoved.endsWith(",")) {
				int lengthOfWord = wordBeforeCommaDotRemoved.length();
				String wordAfterCommaDotRemoved = wordBeforeCommaDotRemoved.substring(0, (lengthOfWord - 1));
				wordsFromInputFile.add(wordAfterCommaDotRemoved);
			} else {
				wordsFromInputFile.add(wordBeforeCommaDotRemoved);
			}
		}
	}
	
	/*
	 * Gets the words from the input file in an ArrayList<String>
	 * @return wordsFromInputFile = An array list of words read in from the input file
	 */
	public ArrayList<String> getWordsFromInputFile() {
		return wordsFromInputFile;
	}
	
	/**
	 * Will return the String located at the index parameter from the 
	 * ArrayList<String> of words read in from the file. 
	 * @param indexOfArrayList = index of ArrayList<String> that is requested to be returned
	 * @return String = The requested word from the input file
	 * ArrayList<String>
	 */
	public String getWordsFromInputFile(int indexOfArrayList) {
		return wordsFromInputFile.get(indexOfArrayList);
	}
}
