package com.myown.luckynumbers;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@ApplicationScoped
public class LuckyNumbersGen {

    public static final Integer HOW_MANY_MAX = 60;

    public List<Integer> sixSortedRandomIntegersUpToSixty(){

        return
            new Random().ints(18,1, 61)
                    .distinct()
                    .limit(6)
                    .sorted()
                    .boxed()
                    .collect(Collectors.toList());
    }

    public HashMap<Integer, List<Integer>> moreThanOneSixSortedRandomIntegersUpToSixty(final Integer howMany){

        if (howMany > HOW_MANY_MAX)
            throw new IllegalArgumentException(String.format("Max of how many 6 random integers sequences is %1s", HOW_MANY_MAX));

        HashMap<Integer, List<Integer>> sequences = new HashMap<>();

        for (int i = 0; i < howMany; i++)
            sequences.put(i, sixSortedRandomIntegersUpToSixty());

        return sequences;
    }

    public  List<Integer> fillUpUntilSixSortedRandomIntegersUpToSixty(final List<Integer> numbers) {

        List<Integer> sequence =
                new Random().ints(18, 1, 61)
                        .boxed()
                        .collect(Collectors.toList());

        sequence.addAll(0, numbers);
        return sequence.stream()
                .distinct()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }
}
