package com.myown.luckynumbers;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class LuckyNumbersGen {

    private final Random random = new Random();

    public List<Integer> sixSortedRandomIntegersUpToSixty(){

        return
                random.ints(18,1, 61)
                    .distinct()
                    .limit(6)
                    .sorted()
                    .boxed()
                    .collect(Collectors.toList());
    }

    public Map<Integer, List<Integer>> moreThanOneSixSortedRandomIntegersUpToSixty(final Integer howMany){

        if (howMany > 10)
            throw new IllegalArgumentException(String.format(
                    "Max of how many 6 random integers sequences is %1s", 10));

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

        if (numbers.size() > 6)
            throw new IllegalArgumentException("The max numbers provided must be 6");

        boolean hasNegativeOrZero = numbers.stream().anyMatch(num -> num <= 0);
        if (hasNegativeOrZero)
            throw new IllegalArgumentException("Numbers must be greater than zero");

        int maxNumber = numbers.stream().max(Integer::compare).orElse(Integer.MAX_VALUE);
        if (maxNumber > 60)
            throw new IllegalArgumentException("Numbers can't be greater than 60");

        List<Integer> sequence =
                random.ints(18, 1, 61)
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
