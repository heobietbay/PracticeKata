package codility;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
  Given 4 integer digits only, each digit is within range [0 ... 9].
  The task is to return the total 24 hour time that can be formed using the digits from the 4 digits.
  Note that the minimum time in 24 hour format is 00:00, and the maximum is 23:59. If a valid time cannot be formed then return 0
 * </pre>
 */
public class ClockCombinationCounts {

    public static void main(String[] args) {
        System.out.println(solution(1,8,3,2));// 12 38, 13 28, 18 23, 18 32, 21 38, 23 18
        System.out.println(solution(2,3,3,2));
        System.out.println(solution(6,2,4,7));
        System.out.println(solution(1,2,1,2)); // 12 12, 12 21, 21 12, 21 21, 11 22, 22 11
    }

    public static int solution(int A, int B, int C, int D)
    {
        List<Integer> lst = Arrays.asList(A,B,C,D);

        // let say the format  is  h1h2:m1m2
        // if THERE IS NO restriction on the value of each element, then in theory
        // the total combination would be 4 * 3 * 2 *1 = 4! = 24

        // h1 can be 0,1,2                     -> 3
        // h2 can be [0,1,2,3] if h1 is 2
        // or        [0 ... 9] if h1 is [0,1]  -> still 3, because above analysis, when we choose h1, h2 cannot be same as h1, hence 3 choice
        // m1 can be 0,1,2,3,4,5               -> still 2
        // m2 can be in [0 ... 9]              -> 1

        int MAX_H1 = (int) lst.stream().filter(x -> x<3).distinct().count();
        int MAX_H2 = 3;
        int MAX_M1 = 2;

        int actualH1 = MAX_H1;

        int actualH2 = MAX_H2;
        if(!lst.contains(0) && !lst.contains(1)) {
            actualH2 =  Math.min (MAX_H2, (int) lst.stream().filter(x -> x < 4).count());
        }

        int actualM1 = Math.min(MAX_M1, (int) (lst.stream().filter(x -> x<5).count()));
        return (actualH1 * actualH2 * actualM1)/1;
    }
}
