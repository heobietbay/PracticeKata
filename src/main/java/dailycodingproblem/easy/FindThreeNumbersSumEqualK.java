package dailycodingproblem.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * This problem was asked by Microsoft.
 <pre>
 * Given an array of numbers and a number k,
 *   determine if there are three entries in the array which add up to the specified number k.
 * For example, given [20, 303, 3, 4, 25] and k = 49, return true as 20 + 4 + 25 = 49.
 </pre>
 */
public class FindThreeNumbersSumEqualK {
    public static void main(String[] args) {
        boolean hasSuchThreeEls = solution(new int[] {20, 303, 3, 4, 25}, 49);
        System.out.println(hasSuchThreeEls);

        hasSuchThreeEls = solution(new int[] { 4, 25}, 50);
        System.out.println(hasSuchThreeEls);

        hasSuchThreeEls = solution(new int[] { 4,25, 25}, 50);
        System.out.println(hasSuchThreeEls);
    }


    public static boolean solutionSorted(int[] numbers, int k)
    {

        return false;
    }

    /**
     *
     * This solution utilizes Set.
     <ol>
         <li>populate the set of all numbers</li>
         <li><pre>populate an temp array, same size of the input numbers
             each element will be: k - numbers[i];
              because if a + b + c = k => a + b = k - c
     </pre>
         </li>
         <li>check if such triple number exist</li>
     </ol>
     * @param numbers
     * @param k
     * @return
     */
    public static boolean solution(int[] numbers, int k)
    {
        Set<Integer> integerSet = new HashSet<>();

        // 1st run: populate the set
        for(int num : numbers)
        {
            integerSet.add(num);
        }

        //2nd run: populate an temp array, same size of the input numbers
        // each element will be: k - numbers[i];
        // because if a + b + c = k => a + b = k - c
        int[] possibleSumOfTwoArr = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++)
        {
            possibleSumOfTwoArr[i] = k - numbers[i]; // each num will represent a possible a + b
        }

        // finally: check if such triple number exist
        for(int i = 0; i < possibleSumOfTwoArr.length; i++)
        {
            for(int j = 0 ; j < numbers.length; j++)
            {
                int toFind = possibleSumOfTwoArr[i] - numbers[j];
                if(integerSet.contains(toFind))
                    return true;
            }
        }
        return false;
    }
}
