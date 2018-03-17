import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: GUI.java
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

public class GUI extends Application {
	
	/*
	 * 
	 */
	public void start(Stage stage) {
		//Read the dictionary.txt file and populate the dictionary
		DictionaryOperations dictionaryOps = new DictionaryOperations();
		dictionaryOps.readDictionaryFile(dictionaryOps.getDictionaryFileName());
		
		//create the GUI's menu bar
		MenuBar menuBar = new MenuBar();
		
		//create the menu's for the menu bar
		Menu file = new Menu();
		Menu edit = new Menu();
		
		//create the items to populate the menu's
		MenuItem open = new MenuItem();
		MenuItem save = new MenuItem();
		MenuItem exit = new MenuItem();
		MenuItem spellCheck = new MenuItem();
		
		//populate the menu's with the menu items
		file.getItems().addAll(open, save, exit);
		edit.getItems().addAll(spellCheck);
		
		//populate the menu bar with menu's
		menuBar.getMenus().addAll(file, edit);
		
		//create the text area
		TextArea textArea = new TextArea();
		textArea.setWrapText(true);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menuBar);
		borderPane.setCenter(textArea);
		Scene scene = new Scene(borderPane, 350, 400);
		
		stage.setTitle("Tim's Amazing Spell Checker");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
