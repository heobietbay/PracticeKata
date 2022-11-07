package leetcode.easy;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 *
 * You MUST NOT use any built-in exponent function or operator.
    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

 Example 1:
 Input: x = 4
 Output: 2
 Explanation: The square root of 4 is 2, so we return 2.

 Example 2:
 Input: x = 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

 Constraints:
 0 <= x <= 2^31 - 1

 */
public class SquareRoot {
    public static void main(String[] args) {
//        System.out.println(solution(4));
//        System.out.println(solution(9));
//        System.out.println(solution(16));
//        System.out.println(solution(24));
        System.out.println(solution(2147483647));
    }

    /**
     * As per the repeated subtraction method, if a number is a perfect square, then we can determine its square root by:
     *
     *     Repeatedly subtracting consecutive odd numbers from it
     *     Subtract till the difference is zero
     *     Number of times we subtract is the required square root
     *
     * For example, let us find the square root of 25.
     *
     *     25 – 1 = 24
     *     24 – 3 = 21
     *     21 – 5 = 16
     *     16 – 7 = 9
     *     9 – 9 = 0
     *
     * Since, the subtraction is done for 5 times, hence the square root of 25 is 5.
     * @param x
     * @return
     */
    static int solution (int x) {
        if(x == 0)
            return 0;
        if(x < 4)
            return 1;
        int count = 0;
        int sub = 1;
        int tmp = x;
        while(tmp > 0) {
            tmp -= sub;
            sub += 2;
            count++;
        }
        long multi = (long)count * count;
        if(multi > x)
            count -= 1;
        return count;
    }
}
