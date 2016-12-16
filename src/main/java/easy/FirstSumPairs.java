package easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by khoa on 12/11/2016.
 */
public class FirstSumPairs {
     /*
    You are given an array of n integers: a0,a1,... an-1 , and a positive integer,k . Find and print the number of (i,j) pairs
    where ai + aj equals k.

    Note that the list may be sorted, may be not.

    Input Format

    The first line contains 2 space-separated integers, n and k, respectively.
    The second line contains n space-separated integers describing the respective values of a0, a1, .... an-1.

    Constraints

    2 <= n <= 100
    1 <= k <= 100
    1 <= ai <= 100

    Output Format

    Print the first pair of (i,j) where ai + aj equals k.

    Sample Input

      6 3
      1 3 2 6 1 2

    Sample Output

    [0,2]

    Explanation

    Here are the first pair:

    (0,2) -> a0 + a2 = 1 + 2 = 3


    Sample Input

      4 8
      1 3 2 6

    Sample Output

    [2,3]

    Explanation

    Here are the first pair:

    (2,3) -> a2 + a3 = 2 + 6 = 8

    */


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int inputArr[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            inputArr[a_i] = in.nextInt();
        }
        printSumPairs(inputArr,sum);
    }

    public static void printSumPairs(int[] inputArr, int sum) {

        int[] result;

        // approach 1: 2 nested loop
        result = nestedLoop(inputArr,sum);

        // approach 2: using binary search if array is sorted
        // in this code, do a sort to make sure
        result = binarySearch(inputArr,sum);


        // approach 3: using "narrowSearch" if array is sorted
        // in this code, do a sort to make sure
        result = narrowSearch(inputArr,sum);
        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }

    /**
     * This only applies for sorted array.
     * The algo is another variation of the binary search.
     * It works by summing the first (low) and last(hi) item in the array.
     * If the total equals to the sum -> return low and hi.
     * If not, repeat below steps until low meets hi.
     *   - If total > sum -> move back from the end -> hi--;
     *   - Else (total < sum) -> move forth from the start -> low++;
     *
     * @param inputArr
     * @param sum
     * @return
     */
    private static int[] narrowSearch(int[] inputArr, int sum) {

        int[] result = new int[2];

        Arrays.sort(inputArr);
        System.out.println("List after sorted:");
        for(int e : inputArr)
        {
            System.out.print(e + " ");
        }
        System.out.println();
        int low = 0;
        int hi = inputArr.length - 1;
        boolean found = false;
        while(!found && low != hi)
        {
            int ai = inputArr[low];
            int aj = inputArr[hi];
            if(ai + aj == sum)
            {
                result[0] = low;
                result[1] = hi;
                found = true;
            }
            else if( ai + aj > sum)
            {
                hi--;
            }
            else
            {
                low++;
            }
        }

        return result;
    }

    /**
     * If the given array is sorted, then we just need a single loop to loop through each element - ai,
     * and for each element we will use binary search to find the (sum - ai) element.
     * @param inputArr
     * @param sum
     * @return
     */
    private static int[] binarySearch(int[] inputArr, int sum) {
        int[] result = new int[2];

        Arrays.sort(inputArr);
        System.out.println("List after sorted:");
        for(int e : inputArr)
        {
            System.out.print(e + " ");
        }
        System.out.println();
        for(int i = 0 ; i < inputArr.length - 1; i++)
        {
            int ai = inputArr[i];

            int match = sum - ai;

            int matchPos = Arrays.binarySearch(inputArr,match);
            if(matchPos >= 0)
            {
                result[0] = i;
                result[1] = matchPos;
                break;
            }
        }

        return result;
    }

    private static int[] nestedLoop(int[] inputArr, int sum) {

        int[] result = new int[2];

        outter:
        for(int i = 0 ; i < inputArr.length - 1; i++)
        {
            int ai = inputArr[i];
            for (int j = i + 1; j < inputArr.length; j++) {
                int aj = inputArr[j];
                if(ai + aj == sum)
                {
                    result[0] = i;
                    result[1] = j;
                    break outter;
                }
            }
        }

        return result;
    }


}
