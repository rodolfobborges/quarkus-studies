package com.myown.luckynumbers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
}