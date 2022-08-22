package com.myown.luckynumbers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LuckyNumbersGenTest {

    static LuckyNumbersGen gen;

    @BeforeAll
    static void setup() {
        gen = new LuckyNumbersGen();
    }

    @Test
    void shouldReturnSixSortedRandomIntegersTillSixty() {

        assertEquals(6, gen.sixSortedRandomIntegersUpToSixty().size());
    }

    @Test
    void shouldReturnACollectionWithTwoSequencesOfSixSortedRandomIntegersTillSixty() {

        HashMap<Integer, List<Integer>> sequences = gen.moreThanOneSixSortedRandomIntegersUpToSixty(2);
        assertEquals(2, sequences.size());
        assertEquals(6, sequences.get(0).size());
        assertEquals(6, sequences.get(1).size());
    }

    @Test
    void shouldThrowExceptionWhenRequestedSequencesPassMaximumAllowed(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gen.moreThanOneSixSortedRandomIntegersUpToSixty(100));

        assertEquals("Max of how many 6 random integers sequences is " + LuckyNumbersGen.HOW_MANY_MAX,
                exception.getMessage());
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

        // this line is just for debugging purpose
        // gen.fillUpUntilSixSortedRandomIntegersUpToSixty(givenNumbers).forEach(System.out::println);
    }
}