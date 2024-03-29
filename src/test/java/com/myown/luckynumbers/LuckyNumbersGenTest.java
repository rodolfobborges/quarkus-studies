package com.myown.luckynumbers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LuckyNumbersGenTest {

    static LuckyNumbersGen gen;

    @BeforeAll
    static void setup() {
        gen = new LuckyNumbersGen();
    }

    @Test
    void shouldReturnSixSortedRandomIntegersTillSixty() {

        List<Integer> sequence = gen.sixSortedRandomIntegersUpToSixty();
        assertEquals(6, sequence.size());
        assertEquals(Collections.min(sequence), sequence.get(0));
        assertEquals(Collections.max(sequence), sequence.get(5));
    }

    @Test
    void shouldReturnACollectionWithTwoSequencesOfSixSortedRandomIntegersTillSixty() {

        Map<Integer, List<Integer>> sequences = gen.moreThanOneSixSortedRandomIntegersUpToSixty(2);
        assertEquals(2, sequences.size());
        assertEquals(6, sequences.get(0).size());
        assertEquals(6, sequences.get(1).size());
    }

    @Test
    void shouldThrowExceptionWhenRequestedSequencesPassMaximumAllowed() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gen.moreThanOneSixSortedRandomIntegersUpToSixty(100));

        assertEquals("Max of how many 6 random integers sequences is 10", exception.getMessage());
    }

    @Test
    void shouldReturnSixSortedRandomIntegersIncludingGivenNumbers() {

        List<Integer> givenNumbers = Arrays.asList(2,29,15,5,41);
        List<Integer> sequence = gen.fillUpUntilSixSortedRandomIntegersUpToSixty(givenNumbers);
        assertEquals(6, sequence.size());
        assertTrue(sequence.contains(2));
        assertTrue(sequence.contains(5));
        assertTrue(sequence.contains(15));
        assertTrue(sequence.contains(29));
        assertTrue(sequence.contains(41));
        assertEquals(Collections.min(sequence), sequence.get(0));
        assertEquals(Collections.max(sequence), sequence.get(5));
    }

    @Test
    void shouldThrowExceptionWhenNumberHigherThanSixty() {
        List<Integer> givenNumbers = Arrays.asList(2,61);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gen.fillUpUntilSixSortedRandomIntegersUpToSixty(givenNumbers));

        assertEquals("Numbers can't be greater than 60", exception.getMessage());
    }

    @Test
    void shouldReturnSixSortedRandomIntegersIncludingGivenNumbersAsText() {
        List<Integer> sequence = gen.fillUpUntilSixSortedRandomIntegersUpToSixty("2,29,15,5,41");
        assertEquals(6, sequence.size());
        assertTrue(sequence.contains(2));
        assertTrue(sequence.contains(5));
        assertTrue(sequence.contains(15));
        assertTrue(sequence.contains(29));
        assertTrue(sequence.contains(41));
        assertEquals(Collections.min(sequence), sequence.get(0));
        assertEquals(Collections.max(sequence), sequence.get(5));
    }

    @Test
    void shouldThrowExceptionWhenNonNumberProvided() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gen.fillUpUntilSixSortedRandomIntegersUpToSixty("2,X"));

        assertEquals("Input must to be just numbers", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNegativeNumberProvided() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gen.fillUpUntilSixSortedRandomIntegersUpToSixty("-3,14"));

        assertEquals("Numbers must be greater than zero", exception.getMessage());
    }

}