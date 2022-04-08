package com.epam.tat.listprocessor.impl;

import com.epam.tat.listprocessor.IListProcessor;
import com.epam.tat.listprocessor.exception.ListProcessorException;

import java.util.*;

/**
 * Function Description:
 * Complete the functions below. All methods must work with list of String.
 *
 * In case of incorrect input values or inability to perform an action, the method should throw an appropriate
 * exception.
 *
 */
public class ListProcessor implements IListProcessor {
	private static final String NULL_LIST = "The list is null";
	private static final String EMPTY_LIST = "The list is empty";
	private static final String ONE_STRING_LIST = "The list has only one string";

	/**
	 * Find the second by length string in a list.
	 *
	 * Ex.:
	 * From list:
	 * {"a", "aa", "aaaaa", "aaaa", "aaa"}
	 * will be return "aaaa"
	 *
	 * @param list - input data
	 * @return second by length string in the input list
	 */
	@Override
	public String getSecondStringByLength(List<String> list) {
		if (list == null) {
			throw new ListProcessorException(NULL_LIST);
		}
		if (list.isEmpty()) {
			throw new ListProcessorException(EMPTY_LIST);
		}
		if (list.size()<2) {
			throw new ListProcessorException(ONE_STRING_LIST);
		}
		list.sort(((o1, o2) -> o2.length() - o1.length()));
		if (list.get(0).equals(list.get(1))) {
			throw new ListProcessorException("IdenticalValues");
		}
		return list.get(1);
	}

	/**
	 * Sort list by string length.
	 *
	 * Ex.:
	 * From list:
	 * {"a", "aa", "aaA", "aAa", "aaa", "Aa"}
	 * will be return
	 * {"a", "Aa", "aa", "aAa", "aaA", "aaa"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> getSortedListByLength(List<String> list) {
		if (list == null) {
			throw new ListProcessorException(NULL_LIST);
		}
		if (list.isEmpty()) {
			throw new ListProcessorException(EMPTY_LIST);
		}
		list.sort((Comparator.comparingInt(String::length)));
		return list;
	}

	public static int getCountOfVowels(String word) {
		int count = 0;
		List<String> vowels = Arrays.asList("a" , "e" , "i" , "o" , "u" , "y");
		for (String letter : word.split("")) {
			if (vowels.contains(letter.toLowerCase())) {
				count++;
			}
		}
		return count;
	}
	/**
	 * Sort list or array by count of vowels in string.
	 * If the number of vowels in several words is the same, the order is alphabetical.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Nike", "Puma", "Adidas", "Timberland"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> getSortedListByCountOfVowels(List<String> list) {
		if (list == null) {
			throw new ListProcessorException(NULL_LIST);
		}
		if (list.isEmpty()) {
			throw new ListProcessorException(EMPTY_LIST);
		}
		int countOfVowels = 0;
		for (String words: list) {countOfVowels += getCountOfVowels(words);
		}
		if (countOfVowels ==0) { throw new ListProcessorException("The count of vowels is 0");
		}
		list.sort(Comparator.comparing(ListProcessor::getCountOfVowels).thenComparing(String::compareTo));
		return list;
	}

	public static int getCountOfConsonants(String word) {
		int count = 0;
		List<String> consonants = Arrays.asList("b" , "c" , "d" , "f" , "g" , "h" , "j" , "k" , "l" , "m" , "n" , "p" , "q" , "r" , "s" , "t" , "v" , "w" , "x" , "z");
		for (String letter : word.split("")) {
			if (consonants.contains(letter.toLowerCase())) {
				count++;
			}
		}
		return count;
	}
	/**
	 * Sort list or array by count of consonants in string.
	 * If the number of consonants in several words is the same, the order is alphabetical.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Nike", "Puma", "Adidas", "Timberland"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> getSortedListByCountOfConsonants(List<String> list) {
		if (list == null) {
			throw new ListProcessorException(NULL_LIST);
		}
		if (list.isEmpty()) {
			throw new ListProcessorException(EMPTY_LIST);
		}
		int countOfConsonants = 0;
		for (String words: list) {countOfConsonants += getCountOfConsonants(words);
		}
		if (countOfConsonants ==0) { throw new ListProcessorException("The count of consonants is 0");
		}
		list.sort(Comparator.comparing(ListProcessor::getCountOfConsonants).thenComparing(String::compareTo));
		return list;
	}

	public static String changeByPlacesFirstAndLastSymbols(String words) {
		StringBuilder word = new StringBuilder(words);
		char firstSymbol = word.charAt(0);
		char lastSymbol = word.charAt(word.length() - 1);
		word.setCharAt(0 , lastSymbol);
		word.setCharAt(word.length() - 1 , firstSymbol);
		return word.toString();
	}

	public static int findStringLength (String words) {
		return words.length();
	}



	/**
	 * Change by places first and last symbols in each second string of list.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"Puma", "eikN", "Timberland", "sdidaA"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list) {
		if (list == null) {
			throw new ListProcessorException(NULL_LIST);
		}
		if (list.isEmpty()) {
			throw new ListProcessorException(EMPTY_LIST);
		}
		if (list.size()<2) {
			throw new ListProcessorException(ONE_STRING_LIST);
		}
		for (String words: list) {
			int i = list.indexOf(words);
			if (i % 2 != 0) {
				int stringLength = findStringLength(words);
				if (stringLength < 2)
					continue;
				list.set(i , changeByPlacesFirstAndLastSymbols(words));
			}
		}
		return list;
	}

	public static String reverseString(String words) {
		StringBuilder word = new StringBuilder(words);
		return word.reverse().toString();
	}

	/**
	 * Revert strings of list.
	 *
	 * Ex.:
	 * From list:
	 * {"Puma", "Nike", "Timberland", "Adidas"}
	 * will be return
	 * {"amuP", "ekiN", "dnalrebmiT", "sadidA"}
	 *
	 * @param list - input data
	 * @return sort list by string length
	 */
	@Override
	public List<String> reverseStringsOfList(List<String> list) {
		if (list == null) {
			throw new ListProcessorException(NULL_LIST);
		}
		if (list.isEmpty()) {
			throw new ListProcessorException(EMPTY_LIST);
		}
		for (String words : list) {
			int i = list.indexOf(words);
			list.set(i , reverseString(words));
		}

		return list;
	}
}
