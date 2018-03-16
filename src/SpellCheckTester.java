
/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: SpellCheckTester.java
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

public class SpellCheckTester {

	public static void main(String[] args) {
		String fileName = "textBoxFile";
		String stringToWriteToFile = "Hello\nThis is a test for the textBoxFile\nTest1, Test2";
		
		//Create a textBoxFile to write to and write to it
		FileOperations fileOps = new FileOperations();
		fileOps.writeToFile(fileName, stringToWriteToFile);
		
		//Read and display from textBoxFile
		fileOps.readFile(fileName);
		for (int i = 0; i < FileOperations.getLinesFromInputFile().size(); i++) {
			System.out.println(FileOperations.getLinesFromInputFile(i));
		}
		
		//tokenize into words, and display them
		new TokenOperations();
		TokenOperations.populateWordsFromInputFile();
		for (int i = 0; i < TokenOperations.getWordsFromInputFile().size(); i++) {
			System.out.println(TokenOperations.getWordsFromInputFile(i));
		}
	}
}
