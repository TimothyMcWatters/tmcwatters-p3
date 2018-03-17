import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: OpenHandler.java
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

public class OpenHandler implements EventHandler<ActionEvent> {
	private TextArea textArea;
	private String fileName;
	private FileOperations fileOps;
	
	/*
	 *  Constructor
	 */
	public OpenHandler(TextArea textArea, String fileName) {
		this.textArea = textArea;
		this.fileName = fileName;
	}
	
	/*
	 * Handles the Open action
	 * @parameter action = The action to handle
	 */
	public void handle(ActionEvent action) {
		fileOps = new FileOperations(fileName);
		String textToDisplay = "";
		fileOps.readFile();
		for (int i = 0; i < fileOps.getLinesFromInputFile().size(); i++) {
			textToDisplay += fileOps.getLinesFromInputFile(i);
		}
		textArea.setText(textToDisplay);
	}
}
