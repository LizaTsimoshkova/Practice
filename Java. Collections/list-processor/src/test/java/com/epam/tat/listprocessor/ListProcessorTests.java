package com.epam.tat.listprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

class ListProcessorTests extends AbstractTest {

    @Test
    void shouldChangeByPlacesFirstAndLastLettersInEachSecondStringOfList() {
        List<String> inputList = asList("bb", "ab1", "b", "Bab3", "bb333B", "bB333", "b3b", "bb", "b3b", "b");
        List<String> expectedList = asList("bb", "1ba", "b", "3abB", "bb333B", "3B33b", "b3b", "bb", "b3b", "b");

        List<String> actualString = testClass.changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(inputList);

        Assertions.assertEquals(expectedList, actualString, "Wrong result of method");
    }

    @Test
    void shouldReverseStringsOfList() {
        List<String> inputList = asList("bb", "ab1", "b", "Bab3", "bb33 3B", "bB333", "b3b");
        List<String> expectedList = asList("bb", "1ba", "b", "3baB", "B3 33bb", "333Bb", "b3b");

        List<String> actualString = (List<String>) testClass.reverseStringsOfList(inputList);

        Assertions.assertEquals(expectedList, actualString, "Wrong result of method");
    }

    @Test
    void shouldFindSecondStringByLength() {
        List<String> inputList = asList("a", "aa", "a3a", "aa333", "aa1", "aa333", "aa33", "aa3", "1234567890", "aa");

        String expectedString = "aa333";

        String actualString = testClass.getSecondStringByLength(inputList);

        Assertions.assertEquals(expectedString, actualString, "Wrong result of method");
    }

    @Test
    void shouldSortListByCountOfConsonants() {
        List<String> inputList = asList("bb", "ab1", "b", "Bb3", "bb333B", "bB333", "b3b", "bb");
        List<String> expectedList = asList("ab1", "b", "Bb3", "b3b", "bB333", "bb", "bb", "bb333B");

        List<String> actualString = testClass.getSortedListByCountOfConsonants(inputList);

        Assertions.assertEquals(expectedList, actualString, "Wrong result of method");
    }

    @Test
    void shouldSortListByCountOfVowels() {
        List<String> inputList = asList("aA33", "aa", "ba1", "a", "Aa3", "aa333A", "aA332", "a3a", "aa");
        List<String> expectedList = asList("a", "ba1", "Aa3", "a3a", "aA33", "aA332", "aa", "aa", "aa333A");

        List<String> actualString = testClass.getSortedListByCountOfVowels(inputList);

        Assertions.assertEquals(expectedList, actualString, "Wrong result of method");
    }

    @Test
    void shouldSortListByLength() {
        List<String> inputList = asList("aa", "a", "a3a", "aa333", "ba1", "aa333", "aa33", "Aa3", "aa");
        List<String> expectedList = asList("a", "aa", "aa", "a3a", "ba1", "Aa3", "aa33", "aa333", "aa333");

        List<String> actualString = testClass.getSortedListByLength(inputList);

        Assertions.assertEquals(expectedList, actualString, "Wrong result of method");
    }
}
