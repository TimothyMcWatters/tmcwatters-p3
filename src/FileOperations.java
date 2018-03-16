import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: FileOperations.java
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

public class FileOperations {
	private Scanner inputStream = null;
	private static ArrayList<String> linesFromInputFile = null;
	private PrintWriter outputStream = null;
	
	/*
	 * Default Constructor
	 */
	public FileOperations() {
		linesFromInputFile = new ArrayList<String>();
	}
	
	/**
	 * Reads a file line by line, and calls the helper method populateLinesFromFileArrayList to populate an ArrayList
	 * with each line read in from the file.
	 * @param fileName = name of the file to read
	 */
	public void readFile(String fileName) {
		try {
			inputStream = new Scanner(new FileInputStream(fileName));
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: File " + fileName + " was not found, or could not be opened.");
			System.exit(0);
		}
		while (inputStream.hasNextLine()) {
			populateLinesFromFileArrayList(inputStream.nextLine());
		} 
		inputStream.close();
	}
	
	/**
	 * Populates an ArrayList with Strings
	 * @param lineFromFile = The string to populate the ArrayList with
	 */
	private static void populateLinesFromFileArrayList(String lineFromFile) {
		linesFromInputFile.add(lineFromFile);
	}
	
	/*
	 * Gets the lines from the input file in an ArrayList<String>
	 * @return linesFromInputFile = An array list of lines read in from the input file
	 */
	public static ArrayList<String> getLinesFromInputFile() {
		return linesFromInputFile;
	}
	
	/**
	 * Will return the String located at the index parameter from the 
	 * ArrayList<String> of Strings read in from the file. 
	 * @param indexOfArrayList = index of ArrayList<String> that is requested to be returned
	 * @return lineFromInputFile = The line of the input file that has been stored in the
	 * ArrayList<String>
	 */
	public static String getLinesFromInputFile(int indexOfArrayList) {
		return linesFromInputFile.get(indexOfArrayList);
	}
	
	/* 
	 * Writes to file
	 * @parameter outputFileName = The name of the file to write to
	 * @parameter stringToWriteToFile = The string to write to the file
	 * 
	 */
	public void writeToFile(String fileName, String stringToWriteToFile) {
		try {
			//attempt to open the file
			outputStream = new PrintWriter(new FileOutputStream(fileName));
			outputStream.println(stringToWriteToFile);
			outputStream.flush();
			outputStream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("WARNING: Log file not found.");
			System.exit(0);
		}
	}
}
