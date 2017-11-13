package core;

import core.model.Investor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * The purpose of this class is to explore what Java8 stream has to offer.
 * This may demonstrate from basic to intermediate level.
 */
public class LearnStream {

    public static void main(String[] args) {

        Stream<Investor> investorStream = Investor.INVESTOR_LIST.stream();
        //1. Stream can only be used once.
        investorStream.forEach(investor -> System.out.println(investor));
          // throw error here
          // investorStream.forEach(investor -> System.out.println(investor));

        // 2. Stream is readonly, you cannot add/remove/update any element in a stream
        // these are INVALID
        //  investorStream.add(...), investorStream.remove(....), ....

        //3. stream is "deferred"
        System.out.println("\n---------DEMO DEFERRED---------");
        List<Investor> lst1 = cloneInvestorList();
        Stream<Investor> investorStreamDefer = lst1.stream();
         // I can add more investor to lst1
        lst1.add(Investor.createInvestor("demoDefer","demoDefer",999,70));
         // Now when I use investorStreamDefer to print all, can see new demoDefer
        investorStreamDefer.forEach(investor -> System.out.println(investor));

        System.out.println("\n---------DEMO CREATE OTHER STREAM---------");
        //4. Stream can produce other streams
          // filter, distinct,map, flatMap
         // limit, skip, sorted, peek
        Stream<Investor> investorStreamParent = lst1.stream();
        Stream<Integer> fx = investorStreamParent.filter(investor -> investor.getLastName().length() > 4) // only those with lastName len > 4
                            .skip(1) // skip the first result
                            .limit(2) // only get 2 records
                            .map(investor -> investor.getAge()) // I only interested in the age
                            .distinct(); // only get unique records
        fx.forEach(investor -> System.out.println(investor));

        //5. Stream can return terminal result right away
          // findAny, findFirst, forEach, allMatch, anyMatch
          // reduce, count, toArray, min, max, collect
        System.out.println("\n---------DEMO TERMINAL RESULT---------");
        investorStream = Investor.INVESTOR_LIST.stream().filter(investor -> investor.getAge() > 50);
        investorStream.findFirst().ifPresent(investor -> System.out.println(investor));
    }

    private static List<Investor> cloneInvestorList() {
        List<Investor> lst1 = new ArrayList<>();
        lst1.addAll(Investor.INVESTOR_LIST);
        return lst1;
    }
}
