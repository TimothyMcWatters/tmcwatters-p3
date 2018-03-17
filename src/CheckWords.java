import java.util.ArrayList;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: CheckWords.java
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

public class CheckWords {
	private ArrayList<MisspelledWord> wordsNotInDictionary = null;
	TokenOperations tokenOps;

	/**
	 * Default constructor
	 */
	public CheckWords(TokenOperations tokenOps) {
		wordsNotInDictionary = new ArrayList<MisspelledWord>();
		this.tokenOps = tokenOps;
	}

	/**
	 * @return the wordsNotInDictionary
	 */
	public ArrayList<MisspelledWord> getWordsNotInDictionary() {
		return wordsNotInDictionary;
	}
	
	/**
	 * Will return the String located at the index parameter from the 
	 * ArrayList<MisspelledWord> of misspelled words. 
	 * @param indexOfArrayList = index of ArrayList<MisspelledWord> that is requested to be returned
	 * @return lineFromInputFile = The line of the input file that has been stored in the
	 * ArrayList<String>
	 */
	public MisspelledWord getWordsNotInDictionary(int indexOfArrayList) {
		return wordsNotInDictionary.get(indexOfArrayList);
	}
	
	/*
	 * Spell Checks the document, and creates MisspelledWord Objects if the spelling 
	 * is not in the dictionary
	 */
	public void spellCheckDocument() {
		boolean wordIsInDictionary = false;
		
		for (int i = 0; i < tokenOps.getWordsFromInputFile().size(); i++) {
			wordIsInDictionary = isWordInDictionary(tokenOps.getWordsFromInputFile(i));
			if (wordIsInDictionary == false) {
				MisspelledWord misspelledWord = new MisspelledWord();
				misspelledWord.setMisspelledWord(tokenOps.getWordsFromInputFile(i));
				misspelledWord.findSuggestions();
				wordsNotInDictionary.add(misspelledWord);
			} else {
				continue;
			}
		}
	}
	
	/*
	 * Checks to see if a word is in the dictionary
	 * @parameter wordToCheck = The word (String) to check if its in the dictionary
	 * @return boolean = true if word is in the dictionary, false if the word is not 
	 */
	private boolean isWordInDictionary(String wordToCheck) {
		String wordToCheckLowerCase = wordToCheck.toLowerCase();
		return DictionaryOperations.dictionaryHasWord(wordToCheckLowerCase);
	}
}
