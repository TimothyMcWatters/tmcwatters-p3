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
		String fileName = "textBoxFile.txt";
		
		//Read the dictionary.txt file and populate the dictionary
		DictionaryOperations dictionaryOps = new DictionaryOperations();
		dictionaryOps.readDictionaryFile(dictionaryOps.getDictionaryFileName());
		FileOperations fileOps = new FileOperations();
		fileOps.readFile(fileName);
		
		//create the GUI's menu bar
		MenuBar menuBar = new MenuBar();
		
		//create the menu's for the menu bar
		Menu file = new Menu("File");
		Menu edit = new Menu("Edit");
		
		//create the items to populate the menu's
		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		MenuItem exit = new MenuItem("Exit");
		MenuItem spellCheck = new MenuItem("Spell Check");
		
		//populate the menu's with the menu items
		file.getItems().addAll(open, save, exit);
		edit.getItems().add(spellCheck);
		
		//populate the menu bar with menu's
		menuBar.getMenus().addAll(file, edit);
		
		//create the text area
		TextArea textArea = new TextArea();
		textArea.setWrapText(true);
		OpenHandler openAction = new OpenHandler(textArea);
		SaveHandler saveAction = new SaveHandler(textArea, fileName, fileOps);
		ExitHandler exitAction = new ExitHandler();
		SpellCheckHandler spellCheckAction = new SpellCheckHandler(fileName, fileOps);
	
		//set menu item actions
		open.setOnAction(openAction);
		save.setOnAction(saveAction);
		exit.setOnAction(exitAction);
		spellCheck.setOnAction(spellCheckAction);
		
		//sets up the boarder pane to hold the GUI items
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(menuBar);
		borderPane.setCenter(textArea);
		Scene scene = new Scene(borderPane, 350, 400);
		
		//displays the GUI
		stage.setTitle("Tim's Amazing Spell Checker");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
