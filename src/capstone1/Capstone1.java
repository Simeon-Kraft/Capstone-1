package capstone1;

import java.util.Scanner;

/*
 * This program translates single-word user input into Pig Latin.
 *
 * Words containing numbers and special characters are returned having not been translated, as per instruction.
 *
 * A special exception was made to accommodate apostrophes. Contractions are translated as such.
 *
 * Word case is accounted for.
 * 
 * The program validates the input to ensure that something is entered. Though it accepts mere whitespace, it does
 * tell the user that whitespace cannot be translated.
 * 
 * Though the program cannot translate whole lines, the methods are designed such that the program could be 
 * easily modified to accept entire sentences.
 * 
 */


public class Capstone1 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String yes = null;

		
		
		System.out.println("Give me a word, and I'll translate it into Pig Latin: ");
		do {

			String word = scnr.nextLine();

			while (!isNotEmpty(word)) {
				System.out.println("Please enter something to be translated: ");
				word = scnr.nextLine();
			}

			if (!isWord(word)) {
				System.out.println("Your untranslatable word is: " + word);

			} else {
				System.out.println("In Pig Latin, your entry translates to: " + parseString((word)));
			}
			System.out.println("Do you want to translate another word? (y/n)");
			yes = scnr.next();
		} while (yes.equalsIgnoreCase("y"));

		System.out.println("Oodbyegay.");

	}

	private static boolean isUpperCase(String word) {

		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);

			if (!Character.isUpperCase(currentChar)) {

				return false;
			}

		}

		return true;

	}

	private static boolean isLowerCase(String word) {

		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);

			if (!Character.isLowerCase(currentChar)) {

				return false;
			}

		}

		return true;
	}

	private static boolean isTitleCase(String word) {
		char firstLetter = word.charAt(0);
		String otherLetters = word.substring(1);

		if (!Character.isUpperCase(firstLetter) && !isLowerCase(otherLetters)) {
			return false;
		}

		return true;
	}

	private static boolean isNotEmpty(String word) {

		if ((word.length() > 0) != true) {
			return false;
		}
		return true;
	}

	private static String parseString(String word) {
		
		String firstLetter = word.substring(0, indexOfFirstVowel(word));
		String parsedWord = word.substring(indexOfFirstVowel(word));
		String latinWord = parsedWord + firstLetter;
		
		if (indexOfFirstVowel(word) == 0 && isUpperCase(word)) {
			return word + "WAY";
		}
		else if (indexOfFirstVowel(word) == 0 && isLowerCase(word)) {
			return word + "way";
		}
		else if (indexOfFirstVowel(word) == 0 && isTitleCase(word)) {
			return word + "way";
		}
		else if (isUpperCase(word)) {
			return latinWord + "AY";
		}
		else if (isLowerCase(word)) {
			return latinWord + "ay";
		}
		else if (isTitleCase(word)) {
			char newFirst = Character.toUpperCase(latinWord.charAt(0));
			String newLatin = latinWord.substring(1);
			
			return newFirst + newLatin.toLowerCase() + "ay";		
		}
			
		return word;

	}

	private static int indexOfFirstVowel(String word) {

		for (int i = 0; i < word.length(); i++) {
			char currentIndex = word.charAt(i);
			String currentChar = Character.toString(currentIndex);

			if (currentChar.equalsIgnoreCase("a")) {
				return i;
			} else if (currentChar.equalsIgnoreCase("e")) {
				return i;
			} else if (currentChar.equalsIgnoreCase("i")) {
				return i;
			} else if (currentChar.equalsIgnoreCase("o")) {
				return i;
			} else if (currentChar.equalsIgnoreCase("u")) {
				return i;
			}

		}
		return word.length();
	}

	private static boolean isWord(String word) {

		for (int i = 0; i < word.length(); i++) {
			char charIsLetter = word.charAt(i);
			if (Character.isLetter(charIsLetter) != true) {
				String apostrophe = Character.toString(charIsLetter);
				if (apostrophe.equals("'")) {
					return true;
				}

				return false;
			}
		}

		return true;
	}

}
