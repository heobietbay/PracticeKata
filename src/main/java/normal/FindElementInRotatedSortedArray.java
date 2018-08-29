package normal;

import java.util.Arrays;

/**
 * This problem was asked by Amazon.
 <pre>
 * An sorted array of integers was rotated an unknown number of times.
 *
 * Given such an array, find the index of the element in the array in <b>faster than linear time</b>.
 * If the element doesn't exist in the array, return null.
 *
 * For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).
 *
 * You can assume all the integers in the array are unique.
 </pre>
 */
public class FindElementInRotatedSortedArray {
    public static void main(String[] args) {
        //TODO
        int[] inpArr = new int[] {13, 18, 25, 2, 8, 10};
        Integer foundIdx = solution(inpArr, 8);
        System.out.println(foundIdx);
    }

    /**
     * This assumes the array is ascending.
     <pre>
     * The idea is to find the pivot point first.
     * Since that point to end of array, everything is sorted.
     * Use binary search to find the idx of the item.
     </pre>
     * @param inpArr
     * @param x
     * @return null if not found, element idx otherwise.
     */
    public static Integer solution(int[] inpArr, int x) {
        int pivotPoint = findPivotPoint(inpArr);
        int firstPhase = Arrays.binarySearch(inpArr, pivotPoint, inpArr.length - 1, x);
        //if at first you dont succeed try again
        int found = firstPhase >= 0 ? firstPhase : Arrays.binarySearch(inpArr, 0, pivotPoint, x);
        return found >= 0 ? found : null;
    }

    /**
     * This assumes the array is ascending. Find the point that splits the array into 2 ordered array.
     * @param inpArr
     * @return
     */
    private static int findPivotPoint(int[] inpArr) {
        int start = 0;
        int end = inpArr.length - 1;
        int mid = (start + end)/2;
        while( mid >0 && inpArr[mid] >= inpArr[mid-1] && start != mid)
        {
            start = mid;
            mid = (start + end)/2;
        }
        return mid;
    }

}
