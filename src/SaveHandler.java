import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: SaveHandler.java
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

public class SaveHandler implements EventHandler<ActionEvent> {
	private TextArea textArea;
	private String fileName;
	private FileOperations fileOps;
	
	/*
	 * Default Constructor
	 */
	public SaveHandler(TextArea textArea, String fileName, FileOperations fileOps) {
		this.textArea = textArea;
		this.fileName = fileName;
		this.fileOps = fileOps;
	}
	
	/*
	 * Handles the Save action
	 * @parameter action = The action to handle
	 */
	public void handle(ActionEvent action) {
		fileOps.writeToFile(fileName, textArea.getText());
	}
}
