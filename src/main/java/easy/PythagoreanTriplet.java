package easy;

import java.util.Arrays;

/**
 * This problem was asked by Netflix.
 * <br>
 * Given an array of integers, determine whether it contains a Pythagorean triplet.
 * Recall that <code>a Pythogorean triplet (a, b, c) is defined by the equation a2+ b2 = c2</code>.
 */
public class PythagoreanTriplet {

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,6,8,9};
        boolean containTriplet = solutionSortAndBinarySearch(arr);
        System.out.println(containTriplet);

        arr = new int[]{13, 84, 0,5,8,85};
        containTriplet = solutionSortAndBinarySearch(arr);
        System.out.println(containTriplet);
    }

    /**
     * Naive solution: check every possible triplet.
     * Complexity would be O(N3).
     * @param arr
     * @return true if found.
     */
    private static boolean solution(int[] arr) {
        int[] squaredMap = Arrays.stream(arr).map( i -> i*i).toArray();
        for(int i = 0 ; i < squaredMap.length; i++)
        {
            int c2 = squaredMap[i];
            for(int j = 0 ; j < squaredMap.length-1; j++)
            {
                if(j == i)
                    continue;

                int a2 = squaredMap[j];

                for(int k = 0 ; k < squaredMap.length; k++)
                {
                    if(k == j)
                        continue;

                    int b2 = squaredMap[k];
                    if(a2 + b2 == c2)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * We can solve this in O(n2) time by sorting the array first.
     *
     * <pre>
     * 1) Do square of every element in input array. This step takes O(n) time.
     * 2) Sort the squared array in increasing order. This step takes O(nLogn) time.
     * 3) To find a triplet (a, b, c) such that a2 = b2 + c2, do following.
          1.Fix 'a' as last element of sorted array.
          2.Now search for pair (b, c) in subarray between first element and 'a'.
             A pair (b, c) with given sum can be found in O(n) time using binarySearch similar approach.
          3.If no pair found for current 'a', then move 'a' one position back and repeat step 3.2.
     *  </pre>
     * @param arr
     * @return
     */
    private static boolean solutionSortAndBinarySearch(int[] arr) {
        int[] squaredSortedArr = Arrays.stream(arr)
                                 .map( i -> i*i)
                                 .sorted()
                                 .toArray();
        for (int i = squaredSortedArr.length-1; i >= 2; i--)
        {
            // To find the other two elements, start two index
            // variables from two corners of the array and move
            // them toward each other
            int left = 0; // index of the first element in arr[0..i-1]
            int right = i-1; // index of the last element in arr[0..i-1]
            while (left < right)
            {
                // A triplet found
                if (squaredSortedArr[left] + squaredSortedArr[right] == squaredSortedArr[i])
                    return true;

                // Else either move 'l' or 'r'
                if (squaredSortedArr[left] + squaredSortedArr[right] < squaredSortedArr[i])
                    left++;
                else
                    right--;
            }
        }
        return false;
    }
}
