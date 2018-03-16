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
	
	/*
	 * Reads the input file
	 * @parameter ? = ????
	 */
	public void readFile(String string) {
		
	}
	
	/*
	 * Populates lines from the file array list
	 * @parameter ? = ???
	 */
	private static void populateLinesFromFileArrayList(String string) {
		
	}
	
	/*
	 * Gets the lines from the input file to populate an ArrayList with them
	 * @return linesFromInputFile = An array list of lines read in from the input file
	 */
	public static ArrayList<String> getLinesFromInputFile() {
		return null;
	}
	
	/*
	 * Retrieves an element from an array list
	 * @ elementOfArrayList = ????
	 * @ return ? = ????
	 */
	public static String getLinesFromInputFile(int elementOfArrayList) {
		return "";
	}
	
	/* 
	 * Writes to file
	 * @parameter ? = ????
	 * @parameter ? = ????
	 * 
	 */
	public void writeToFile(String string1, String string2) {
		
	}
}
