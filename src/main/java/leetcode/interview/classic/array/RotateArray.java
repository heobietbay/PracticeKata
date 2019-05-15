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
        solution(nums,3);
        for(int i = 0 ; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * First calculate exactly how many times we need to rotate.
     * Observe that the actual rotation time X = k % nums.length.
     * Then call rotateRight X times.
     * @param nums nums
     * @param k original how many rotation
     */
    public static void solution(int[] nums, int k) {

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
