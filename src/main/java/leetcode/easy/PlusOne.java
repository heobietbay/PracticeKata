package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Integer[] addedArr = solution(array);
        String result = toStr(addedArr);
        System.out.println(result);

        int[] array2 = {4, 3, 2, 1};
        addedArr = solution(array2);
        result = toStr(addedArr);
        System.out.println(result);

        int[] array3 = {9};
        addedArr = solution(array3);
        result = toStr(addedArr);
        System.out.println(result);

        int[] array4= {9,9};
        addedArr = solution(array4);
        result = toStr(addedArr);
        System.out.println(result);

    }
    static Integer[] solution(int[] digits) {
        int[] tmps = Arrays.copyOf(digits, digits.length);
        List<Integer> lst = new ArrayList<>();
        int carrier = 1;
        for(int i = tmps.length -1; i >= 0 ; i--) {
            int res = tmps[i] + carrier;
            if(res >= 10) {
                carrier = 1;
                res -= 10;
            } else {
                carrier = 0;
            }
            tmps[i] = res ;
        }
        if(carrier == 1) {
            lst.add(0, carrier);
        }
        for(int i: tmps) {
            lst.add(i);
        }
        return lst.toArray(new Integer[0]);
    }

    private static String toStr(Integer[] addedArr) {
        return Arrays.stream(addedArr)
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
