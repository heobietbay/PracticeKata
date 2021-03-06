package dailycodingproblem.easy;

/**
 * This problem was asked by Jane Street.
 <pre>
   Given integers M and N, write a program that counts how many positive integer pairs (a, b) satisfy the following conditions:
 *     a + b = M
 *     a XOR b = N
 </pre>
 */
public class CountPositiveIntegerPairs {

    public static void main(String[] args) {
        System.out.println(solution(5,5));
    }

    public static int solution(int M, int N) {
        int count = 0;
        // We can have a starting from 0 to M/2
        // because a + b = M -> b = M - a
        // and since (a,b) is same as (b,a), we just need to loop through M/2
        for(int i = 0 ; i < M / 2; i++)
        {
            int a = i;
            int b = M - a;
            if( (a^b) == N )
                count ++;
        }
        return count;
    }
}
