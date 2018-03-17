import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: SpellCheckHandler.java
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

public class SpellCheckHandler implements EventHandler<ActionEvent> {
	private String fileName;
	private TextArea textArea;
	
	/*
	 *  Constructor
	 */
	public SpellCheckHandler(String fileName, TextArea textArea) {
		this.fileName = fileName;
		this.textArea = textArea;
	}
	
	/*
	 * Handles the Spell Check action
	 * @parameter action = The action to handle
	 */
	public void handle(ActionEvent action) {
		FileOperations fileOps = new FileOperations(fileName);
		fileOps.writeToFile(textArea.getText());
		fileOps.readFile();
		TokenOperations tokenOps = new TokenOperations(fileOps);
		tokenOps.populateWordsFromInputFile();
		CheckWords checkWords = new CheckWords(tokenOps);
		for (int i = 0; i < 50; ++i) { 
			System.out.println();
		}
		System.out.println("DOCUMENT HAS BEEN SPELL CHECKED, HERE ARE SOME SUGGESTIONS: \n");
		checkWords.spellCheckDocument();
	}
}
