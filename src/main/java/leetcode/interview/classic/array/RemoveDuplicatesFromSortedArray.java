package leetcode.interview.classic.array;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <br/>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with <b>O(1)</b>extra memory.

 <p>Example 1:
 <pre>
  Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * </pre>
 </p>

 <p>Example 2:
 <pre>
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums
 *  being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
    </pre>
 </p>

 <p>
 <b>Clarification:</b> <br/>

 Confused why the returned value is an integer but your answer is an array? <br/>
 Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.<br/>
 Internally you can think of this:
 <pre>
     // nums is passed in by reference. (i.e., without making a copy)
     int len = removeDuplicates(nums);

     // any modification to nums in your function would be known by the caller.
     // using the length returned by your function, it prints the first len elements.
     for (int i = 0; i < len; i++) {
         print(nums[i]);
     }
 </pre>
 </p>
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int uniqueLen = solution(nums);
        for(int i = 0 ; i < uniqueLen; i++)
        {
            System.out.println(nums[i]);
        }
    }

    public static int solution(int[] nums){
        return approachTwoPointers(nums);
    }

    /**
     <pre>
     * Since the array is already sorted, we can keep two pointers <font color='green'>sr</font>
     * and <font color='blue'>fr</font>, where sr is the slow-runner while fr is the fast-runner.
     * As long as
     * <font color='green'>nums[sr]</font>  =  <font color='blue'>nums[fr]</font>
     , we increment fr to skip the duplicate.
     *
     * When we encounter nums[fr] != nums[sr] , the duplicate run has ended so we must copy its value to nums[sr+1].
     *  sr is then incremented and we repeat the same process again until fr reaches the end of array.
     </pre>
     * @param nums the array that will be amended.
     * @return unique length
     */
    private static int approachTwoPointers(int[] nums) {
        if (nums.length == 0)
            return 0;
        int sr = 0;
        for (int fr = 1; fr < nums.length; fr++) {
            if (nums[fr] != nums[sr]) {
                sr++;
                nums[sr] = nums[fr];
            }
        }
        return sr + 1;
    }
}
