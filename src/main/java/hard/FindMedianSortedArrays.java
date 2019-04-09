package hard;

import easy.ArrayMerge;

/**
 * <pre>
  Leetcode.
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0

 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5


 * </pre>
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(solution(nums1,nums2));

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3,4};
        System.out.println(solution(nums1,nums2));
    }

    /**
     * What is a median:
       <pre>The median is the value separating the higher half from the lower half of a data sample (a population or a probability distribution).
     For a data set, it may be thought of as the "middle" value.
     For example, in the data set {1, 3, 3, 6, 7, 8, 9}, the median is 6, the fourth largest, and also the fifth smallest, number in the sample</pre>

     * How to find it:
      <pre>
     The median of a finite list of numbers can be found by:
      1. <b>Arranging</b> all the numbers from smallest to greatest.
      2a. If there is an <font color='red'>odd </font>number of numbers, the <b>middle</b> one is picked. For example, consider the list of numbers
         1, 3, 3, 6, 7, 8, 9
      This list contains seven numbers. The median is the fourth of them, which is 6.

      2b. If there is an <font color='blue'>even</font> number of observations, then there is <b>no single middle value</b>;
         <i>the median is then usually defined to be the <b>mean of the two middle values</b></i>. For example, in the data set
         1, 2, 3, 4, 5, 6, 8, 9
         the median is the mean of the middle two numbers: this is ( 4 + 5 ) / 2 , which is 4.5
     </pre>

     * For this task, Because the inputs are two <b>SORTED</b> arrays, we can just do step merge of MergeSort algorithm to merge.
     * Then follow above formula to find the median.
     * @param nums1 a sorted array
     * @param nums2 a sorted array
     * @return median value
     */
    public static double solution(int[] nums1, int[] nums2) {
        int[] mergedArr = ArrayMerge.merge(nums1,nums2);

        if(mergedArr.length %2 == 0)
        {
           return (mergedArr[mergedArr.length/2] + mergedArr[mergedArr.length/2 - 1] ) / 2.0;
        }
        return mergedArr[mergedArr.length/2];
    }
}
