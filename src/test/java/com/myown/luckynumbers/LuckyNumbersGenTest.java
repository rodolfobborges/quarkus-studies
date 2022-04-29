package com.myown.luckynumbers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    void shouldReturnACollectionWithMoreThanOneSequenceOfSixSortedRandomIntegersTillSixty() {

        HashMap<Integer, List> sequences = gen.moreThanOneSixSortedRandomIntegersUpToSixty(2);
        assertEquals(2, sequences.size());
        assertEquals(6, sequences.get(0).size());
        assertEquals(6, sequences.get(1).size());
    }
}