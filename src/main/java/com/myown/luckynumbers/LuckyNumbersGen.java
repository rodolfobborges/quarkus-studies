package com.myown.luckynumbers;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class LuckyNumbersGen {

    public List<Integer> sixSortedRandomIntegersUpToSixty(){

        Set<Integer> theSix = new HashSet<>();
        var count = 0;
        while (count < 6)
            if (theSix.add(new Random().nextInt(60)))
                count++;

        List<Integer> sortedSix = new ArrayList<>(theSix);
        Collections.sort(sortedSix);
        return sortedSix;
    }

    public HashMap<Integer, List> moreThanOneSixSortedRandomIntegersUpToSixty(final Integer howMany){
        final Integer HOW_MANY_MAX = 60;
        if (howMany > HOW_MANY_MAX)
            throw new IllegalArgumentException(String.format("Max of how many 6 random integers sequences is %1s", HOW_MANY_MAX));

        HashMap<Integer, List> sequences = new HashMap<>();

        for (int i = 0; i < howMany; i++)
            sequences.put(i, sixSortedRandomIntegersUpToSixty());

        return sequences;
    }
}
