package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You have an array of numbers from 0 to n-1, one of the numbers is removed,
 * and replaced with a number already in the array which makes a duplicate of that number. How can we detect this duplicate in time O(n)?
 */
public class IntegerArrayFindDuplicate {
    public static void main(String[] args) {
        int[] arrayInteger = new int[] {0,1,2,3,4,5,6,7,8,9,5,11,12,13}; // missing 10, dup is 5
        List<Integer> duplicateElements = findDuplicate_UsingBitArray(arrayInteger);
        System.out.println(Arrays.toString(duplicateElements.toArray()));

        arrayInteger = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,9,13}; // missing 12, dup is 9
        duplicateElements = findDuplicate_UsingBitArray(arrayInteger);
        System.out.println(Arrays.toString(duplicateElements.toArray()));

        arrayInteger = new int[] {0,1,2,3,4,5,6,7,7,9,10,11,9,13}; // missing 12 and 8, dup is 9,7
        duplicateElements = findDuplicate_UsingBitArray(arrayInteger);
        System.out.println(Arrays.toString(duplicateElements.toArray()));

        System.out.println("Find missing value");
        System.out.println(findMissingValue_UseMath(new int[]{0,1,2,3,4,5,6,7,9,10,11,12,13}));
    }

    /**
     * Because in this puzzle, the list is ordered from 0 to n-1, we can use this bit array technique.
     * This technique can detect more than 1 missing value.
     * @param arrayInteger arrayInteger
     * @return the duplicate values.
     */
    private static List<Integer> findDuplicate_UsingBitArray(int[] arrayInteger) {

        boolean[] bitArray = new boolean[arrayInteger.length];
        // first, fill the bit array with false value
        Arrays.fill(bitArray,false);

        List<Integer> res = new ArrayList<>();
        // then for each item in the source array
        for(int val : arrayInteger)
        {
            if( !bitArray[val] ) // that bit[val] is not visited
            {
                bitArray[val] = true; // mark this bit[Val] as we visited
            }
            else // put to the list result
            {
                res.add(val);
            }
        }
        return res;
    }
    /**
     * Utilize sum of 1 to n formula: S = n(n+1)/2.
     * First we find S, then we deduct all values in the input array, the result is the missing value.
     * This technique can ONLY detect 1 missing value.
     * @param arrayInteger arrayInteger
     * @return the missing value.
     */
    private static Integer findMissingValue_UseMath(int[] arrayInteger) {
        int sum = arrayInteger.length * ((arrayInteger.length + 1 )/2);
        // then for each item in the source array
        for(int val : arrayInteger)
        {
            sum -= val;
        }
        return sum;
    }
}
