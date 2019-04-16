package easy;

import java.util.Arrays;

/**
 * Given an array of integers of size <i>'n'</i>.
 * Our aim is to calculate the <font color ='red'>maximum sum </font> possible for <b>'k'</b> consecutive elements in the array.
 <pre>
  Input : arr[] = {100, 200, 300, 400}
  k = 2
  Output : 700
 </pre>
 */
public class SlidingWindow_KConsecutiveSum {

    public static void main(String[] args) {

        int sum = solution(new int [] {100, 200, 300, 400},2);
        System.out.println(sum);
    }

    /**
     * This is the intro to sliding window problem.
     * <ol>
          <li>Generate the 'base window' sum, starting from 0 to 0 + k element.</li>
          <li>Slide the 'base window' to the right one element of a time.
               <ul>
                  <li>a.Sum the k number. Can quickly do that by subtract the previous element, then add the next element.</li>
                  <li>b.Check and update maximum sum.</li>
               </ul>
          </li>
     * </ol>
     * @param arr  array of integer
     * @param k    k consecutive elements
     * @return max sum
     */
    public static int solution(int[] arr, int k)
    {
        int res = 0;

        // step 1: generate the 'base window' sum
        // starting from 0 to 0 + k element
        int maxTemp = Arrays.stream(arr).limit(k).sum(); // just fancy java 8 way

        res = maxTemp;

        // step 2: slide the base window to the right
        // one element of a time

        for(int i = 1; i <= arr.length - k; i++)
        {
            int prev = arr[i - 1];
            int next = arr[i - 1 + k];
            maxTemp = (maxTemp - prev) + next;

            //step 3: check and update res
            res = res > maxTemp ? res : maxTemp;
        }

        return res;
    }
}
