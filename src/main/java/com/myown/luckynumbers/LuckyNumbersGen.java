package com.myown.luckynumbers;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class LuckyNumbersGen {

    public List<Integer> sixSortedRandomIntegersTillSixty(){

        Set<Integer> theSix = new HashSet<>();
        var count = 0;
        while (count < 6)
            if (theSix.add(new Random().nextInt(60)))
                count++;

        List<Integer> sortedSix = new ArrayList<>(theSix);
        Collections.sort(sortedSix);
        return sortedSix;
    }
}
