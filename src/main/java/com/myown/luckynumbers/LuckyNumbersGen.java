package com.myown.luckynumbers;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class LuckyNumbersGen {

    public static final Integer MAX_SEQUENCES = 60;

    public List<Integer> sixSortedRandomIntegersUpToSixty(){

        return
            new Random().ints(18,1, 61)
                    .distinct()
                    .limit(6)
                    .sorted()
                    .boxed()
                    .collect(Collectors.toList());
    }

    public Map<Integer, List<Integer>> moreThanOneSixSortedRandomIntegersUpToSixty(final Integer howMany){

        if (howMany > MAX_SEQUENCES)
            throw new IllegalArgumentException(String.format(
                    "Max of how many 6 random integers sequences is %1s", MAX_SEQUENCES));

        Map<Integer, List<Integer>> sequences = new HashMap<>();

        for (int i = 0; i < howMany; i++)
            sequences.put(i, sixSortedRandomIntegersUpToSixty());

        return sequences;
    }

    public List<Integer> fillUpUntilSixSortedRandomIntegersUpToSixty(final String numbers) {

        List<Integer> convertedNumbers;
        try {
            convertedNumbers =
                    Arrays.stream(numbers.split(","))
                            .map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must to be just numbers");
        }
        return fillUpUntilSixSortedRandomIntegersUpToSixty(convertedNumbers);
    }

    public  List<Integer> fillUpUntilSixSortedRandomIntegersUpToSixty(final List<Integer> numbers) {

        if (numbers.size() > 6) {
            throw new IllegalArgumentException("The max numbers provided must be 6");
        }

        if (numbers.stream().max(Integer::compare).get() > 60) {
            throw new IllegalArgumentException("Numbers can't be higher than 60");
        }

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
