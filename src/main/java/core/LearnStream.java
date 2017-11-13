package core;

import core.model.Investor;

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
    }
}
