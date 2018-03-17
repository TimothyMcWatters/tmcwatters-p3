import java.util.ArrayList;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 3
 * File Name: MisspelledWord.java
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

public class MisspelledWord {
	private String misspelledWord = "";
	private ArrayList<String> suggestedWords = null;
	
	/*
	 * Default Constructor
	 */
	public MisspelledWord() {
		suggestedWords = new ArrayList<String>();
	}
	
	/*
	 * Tests the MisspelledWord to see if there are any words in the dictionary to use as 
	 * suggested replacement words
	 */
	public void findSuggestions() {
		oneLetterMissing();
		oneLetterAdded();
		lettersReversed();
		System.out.println(toString());
	}
	
	/*
	 * Tests the word for a missing letter
	 */
	private void oneLetterMissing() {
		StringBuilder stringBuilder = new StringBuilder(misspelledWord);
		String letters = "abcdefghijklmnopqrstuvwxyz";
		String suggestedWord = "";
		char[] alphabet = letters.toCharArray();
		
		for (int i = 0; i <= getMisspelledWord().length(); i++) {
			for (int j = 0; j < alphabet.length; j++) {
				suggestedWord = stringBuilder.insert(i, alphabet[j]).toString();
				if (DictionaryOperations.dictionaryHasWord(suggestedWord.toLowerCase()) 
						&& !suggestedWords.contains(suggestedWord.toLowerCase())) {
					suggestedWords.add(suggestedWord.toLowerCase());
				}
				suggestedWord = stringBuilder.deleteCharAt(i).toString();
			}
		}
	}
	
	/*
	 * Tests the word for an added letter
	 */
	private void oneLetterAdded() {
		char temp = '\u0000';
		StringBuilder stringBuilder = new StringBuilder(misspelledWord);
		String suggestedWord = "";
		
		for (int i = 0; i < getMisspelledWord().length(); i++) {
			temp = misspelledWord.charAt(i);
			suggestedWord = stringBuilder.deleteCharAt(i).toString();
			if (DictionaryOperations.dictionaryHasWord(suggestedWord.toLowerCase()) 
					&& !suggestedWords.contains(suggestedWord.toLowerCase())) {
				suggestedWords.add(suggestedWord.toLowerCase());
			}
			suggestedWord = stringBuilder.insert(i, temp).toString();
		}
	}
	
	/*
	 * Tests the word for reversed letters
	 */
	private void lettersReversed() {
		String firstCharacter = "";
		String secondCharacter = "";
		int beginingRangeChar = 2;
		int endingRangeChar = 4;
		StringBuilder stringBuilder = new StringBuilder(misspelledWord);
		String suggestedWord = "";
		
		for (int i = 0; i < getMisspelledWord().length() - 1; i++) {
			stringBuilder = new StringBuilder(misspelledWord);
			firstCharacter = String.valueOf(misspelledWord.charAt(i + 1));
			secondCharacter = String.valueOf(misspelledWord.charAt(i));
			

			stringBuilder.insert(i, firstCharacter).toString();
			stringBuilder.insert(i + 1, secondCharacter).toString();
			stringBuilder.delete(i + beginingRangeChar, i + endingRangeChar).toString();
			suggestedWord = stringBuilder.toString();
			
			if (DictionaryOperations.dictionaryHasWord(suggestedWord.toLowerCase()) 
					&& !suggestedWords.contains(suggestedWord.toLowerCase())) {
				suggestedWords.add(suggestedWord.toLowerCase());
			}
		}
	}
	
	/**
	 * @return the misspelledWord
	 */
	public String getMisspelledWord() {
		return misspelledWord;
	}

	/**
	 * @param misspelledWord the misspelledWord to set
	 */
	public void setMisspelledWord(String misspelledWord) {
		this.misspelledWord = misspelledWord;
	}

	/*
	 * String Representation of the MisspelledWord Object
	 */
	public String toString() {
		if (suggestedWords.size() > 0) {
			String string = "";
			string += ("Suggestions for [" + getMisspelledWord() + "] \n");
			for (int i = 0; i < suggestedWords.size(); i++) {
				string += (suggestedWords.get(i) + "\n");
			}
			return string;
		} else {
			return ("[" + getMisspelledWord() + "] is misspelled, unfortunatly we have no spelling suggestions.\n");
		}
	}
}
