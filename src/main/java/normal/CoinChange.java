package normal;

/**
 * Given an integer representing a given amount of change, write a
 * function to <b>compute the total number of coins required </b>to make
 * that amount of change.
 * You can assume that there is always a 1$ coin.
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1,5,10,25};
        System.out.println(solution(1,coins));
    }

    public static int solution(int money, int[] coins) {
        return solutionRecursive(money,coins);
    }

    private static int solutionRecursive(int money, int[] coins) {
        if (money == 0)
            return 0;
        int minCoins = Integer.MAX_VALUE;
       // Try removing each coin from the total and see how many more coins are required
        for (int coin : coins) {
        // Skip a coin if it’s value is greater than the amount remaining
            if (money - coin >= 0) {
                int currMinCoins = solutionRecursive(money - coin,coins);
                if (currMinCoins < minCoins)
                    minCoins = currMinCoins;
            }
        }
        // Add back the coin removed recursively
        return minCoins + 1;
    }
}
