import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
	private FileOperations fileOps;
	private FileChooser fileChooser = new FileChooser();
	private Stage stage;
	
	/*
	 *  Constructor
	 */
	public OpenHandler(TextArea textArea, Stage stage) {
		this.textArea = textArea;
		this.stage = stage;
	}
	
	/*
	 * Handles the Open action
	 * @parameter action = The action to handle
	 */
	public void handle(ActionEvent action) {
		File file = fileChooser.showOpenDialog(stage);
		fileOps = new FileOperations();
		FileOperations.setFileName(file.getAbsolutePath());
		if (file != null) {
			String textToDisplay = "";
			fileOps.readFile();
			for (int i = 0; i < fileOps.getLinesFromInputFile().size(); i++) {
				textToDisplay += fileOps.getLinesFromInputFile(i);
			}
			textArea.setText(textToDisplay);
		}
		
	}
}
