package normal;

/**
 * This problem was asked by Facebook.
 * <p>
 *     Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 *
 *    For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 *    You can assume that the messages are decodable. For example, '001' is not allowed.
 * </p>
 */
public class HowManyWaysToDecode {

    public static void main(String[] args) {
        System.out.println(solution("1222"));
        System.out.println(solution_B("1222"));
    }
    private static int solution_B(String inp)
    {
        return countDecoding_BottomUp(inp.toCharArray(),inp.length());
    }
    private static int solution(String inp)
    {
        return countDecoding_Recursive(inp.toCharArray(),inp.length());
    }

    private static int countDecoding_Recursive(char[] digits, int n){
        if (n == 0 || n == 1)
            return 1;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = countDecoding_Recursive(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recursive call
        if (digits[n - 2] == '1' ||
                (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding_Recursive(digits, n - 2);

        return count;
    }

    private static int countDecoding_BottomUp(char[] digits, int n){
        int[] count = new int [n+1]; // A table to store results of subproblems
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            count[i] = 0;

            // If the last digit is not 0, then last digit must add to
            // the number of words
            if (digits[i-1] > '0')
                count[i] = count[i-1];

            // If second last digit is smaller than 2 and last digit is
            // smaller than 7, then last two digits form a valid character
            if (digits[i-2] == '1' || (digits[i-2] == '2' && digits[i-1] < '7') )
                count[i] += count[i-2];
        }
        return count[n];
    }


}
