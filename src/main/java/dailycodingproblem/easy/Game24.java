package dailycodingproblem.easy;

/**
 * This problem was asked by Twitter.
 * <p></p>
 * The 24 game is played as follows.
 <pre>
 * You are given a list of <b>four</b> integers, each <b>between 1 and 9</b>, in a fixed order.
 * By placing the operators +, -, *, and / between the numbers, and grouping them with parentheses,
 *  determine whether it is possible to reach the value 24.
 *
 * For example, given the input [5, 2, 7, 8], you should return True, since (5 * 2 - 7) * 8 = 24.
 </pre>

 * Write a function that plays the 24 game.
 */
public class Game24 {

    public static void main(String[] args) {
        boolean possible = solution(new int[] {5, 2, 7, 8}, 24);
        System.out.println(possible);
    }

    public static boolean solution(int[] arr, int target)
    {
        return false;
    }

}
