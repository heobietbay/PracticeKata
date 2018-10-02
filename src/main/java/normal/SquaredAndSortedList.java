package normal;

import easy.ArrayMerge;

import java.util.Arrays;

/**
 * This problem was asked by Google.
 *
 * Given a sorted list of integers, square the elements and give the output in sorted order.
 <pre>For example, given [-9, -2, 0, 2, 3], return [0, 1, 4, 4, 9, 81].</pre>

 */
public class SquaredAndSortedList {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{-9, -2, -1, 0, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{ -3,-2, -1})));
        System.out.println(Arrays.toString(solution(new int[]{-9,-8,-7,-6,-5,-4,-3,-2, -1, 0, 2, 3})));
    }

    /**
     * The idea is:
     * <ol>
     <li>Find the idx that separate the array, one part negative, one part non-negative.</li>
     <li>Then, square them arrays.</li>
     <li>Then combine the array (kind of like merge sort last step).</li>
     </ol>
     This can be improved by utilize binary search to find the split point.
     * @param inpSortedArr
     * @return
     */
    public static int[] solution(int[] inpSortedArr)
    {
        int splitIdx = findSplitPoint(inpSortedArr);
        if(splitIdx <= 0){ // so we either got an all-negative array, or non-negative array
            if(inpSortedArr[0] < 0) // all negative array
            {
                int[] squareArray = squareArray(inpSortedArr);
                //reverse it
                return reverse(squareArray);
            }
            // other case: just need to square
            return squareArray(inpSortedArr);
        }
        int[] leftArr = buildLeftArray(inpSortedArr,splitIdx);
        int[] rightArr = new int[inpSortedArr.length - splitIdx];
        System.arraycopy(inpSortedArr,splitIdx,rightArr,0,inpSortedArr.length - splitIdx);
        return  ArrayMerge.merge(squareArray(leftArr),squareArray(rightArr));
    }

    private static int[] reverse(int[] inpArray){
        int[] reversedArr = new int[inpArray.length];
        for(int i = 0 ; i < inpArray.length; i++)
        {
            reversedArr[i] = inpArray[inpArray.length-i-1];
        }
        return reversedArr;
    }
    /**
     * The input is the sorted array, and the split point that separate array into negative and non negative.
     * From 0 to split point, we have all elements negative.
     * Go from left to right, so the result array would already sorted.
     * @param inpSortedArr
     * @param splitIdx
     * @return
     */
    private static int[] buildLeftArray(int[] inpSortedArr, int splitIdx) {
        int[] res = new int[splitIdx];
        for(int i = splitIdx-1; i>= 0; i--)
        {
            res[splitIdx-i-1] = inpSortedArr[i];
        }
        return res;
    }

    private static int[] squareArray(int[] inpArray){
        int[] squaredArr = new int[inpArray.length];
        for(int i = 0 ; i < inpArray.length; i++)
        {
            squaredArr[i] = inpArray[i] * inpArray[i];
        }
        return squaredArr;
    }

    /**
     * TODO: implement binary search for better performance
     * @param inpSortedArr
     * @return
     */
    private static int findSplitPoint(int[] inpSortedArr) {
        int idx = 0;
        while(idx < inpSortedArr.length)
        {
            if(inpSortedArr[idx] < 0)
                idx++;
            else
                return idx;
        }
        return -1;
    }
}
