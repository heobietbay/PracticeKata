package leetcode.interview.classic.array;

/**
 *
 Given an array, rotate the array to the right by k steps, where k is non-negative.
<pre>
 Example 1:

 Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]

 Example 2:

 Input: [-1,-100,3,99] and k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]
 </pre>
 Note:

 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 Could you do it in-place with O(1) extra space?

 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        //solution(nums,3);
        solution_ExtraArray(nums,3);
        for(int i = 0 ; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * <pre>
     We use an extra array in which we place every element of the array at its correct position
     i.e. the number at index i in the original array is placed at the index (i+k).
     Then, we copy the new array to the original one.
     </pre>
     <pre>
     <b>Complexity Analysis</b>
     Time complexity : O(n). One pass is used to put the numbers in the new array. And another pass to copy the new array to the original one.
     Space complexity : O(n). Another array of the same size is used.
     </pre>
     * @param nums nums
     * @param k original how many rotation
     */
    public static void solution_ExtraArray(int[] nums, int k) {

        int howManyRotate = k % nums.length;
        int[] tmpArr = new int[nums.length];

        // first: copy last howManyRotate items in reversed order.
        for(int i = 0 ; i < howManyRotate; i++)
        {
            tmpArr[howManyRotate-1 - i] = nums[nums.length-1 - i];
        }

        // 2nd: copy next original howManyRotate items to the tmp array
        for(int i = howManyRotate ; i < nums.length; i++)
        {
            tmpArr[i] = nums[i-howManyRotate];
        }

        //finally copy to original nums
        for(int  i = 0 ; i < nums.length; i++)
        {
            nums[i] = tmpArr[i];
        }
    }

    /**
     *
     <pre> This approach is based on the fact that when we rotate the array k times,
     * k elements from the back end of the array come to the front and the rest of the elements from the front shift backwards.
     *
     * In this approach, we firstly reverse all the elements of the array.
     * Then, reversing the first k elements followed by reversing the rest n - k elements gives us the required result.

     Let n=7 and k=3.

     Original List                   : 1 2 3 4 5 6 7
     After reversing all numbers     : 7 6 5 4 3 2 1
     After reversing first k numbers : 5 6 7 4 3 2 1
     After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result

     </pre>
     * @param nums
     * @param k
     */
    public static void solution_Reverse(int[] nums, int k) {

        int howManyRotate = k % nums.length;

        reverseArray(nums,0,nums.length-1);
        reverseArray(nums,0,howManyRotate-1);
        reverseArray(nums,howManyRotate,nums.length-1);
    }

    private static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * First calculate exactly how many times we need to rotate.
     * Observe that the actual rotation time X = k % nums.length.
     * Then call rotateRight X times.
     * @param nums nums
     * @param k original how many rotation
     */
    public static void solution_Bruteforce(int[] nums, int k) {

        int howManyRotate = k % nums.length;
        for(int i = 0 ; i < howManyRotate; i++)
            rotateRight(nums);
    }

    /**
     * Shift right the array one time.
     * Doing in place replace.
     * @param nums nums
     */
    public static void rotateRight(int[] nums)
    {
        int last = nums[nums.length -1];
        int before = nums[0];
        for(int i = 1 ; i< nums.length; i++)
        {
            int tmp = nums[i];
            nums[i] = before;
            before = tmp;
        }
        nums[0] = last;
    }
}
