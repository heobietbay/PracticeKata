package core;

import core.model.Investor;

public class LearnException {
    public static void main(String[] args) {
        Investor investor = Investor.createInvestor("Khoa", "Tran", new Integer(1), 30);
        System.out.println(investor.getAge());
        try {
            doSomething(investor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // This is now mutated, need to think about handling exception and revert object in memory to its original state
        System.out.println(investor.getAge());
    }

    private static void doSomething(Investor investor) {
        investor.setAge(25);
        throw new RuntimeException("For test");
    }
}
