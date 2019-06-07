package leetcode.interview.classic.array;

/**
 <pre>
 * Given an array nums and a value val, remove all instances of that value <font color = 'red'>in-place</font> and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with <b>O(1)</b> extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 <b>Example 1:</b>
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 *
 <b>Example 2:</b>
 *
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 *
 * Note that the order of those five elements can be arbitrary.
 *
 * It doesn't matter what values are set beyond the returned length.
 *
  <b>Clarification:</b>
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 </pre>
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3};
        int newLen = solution(nums,2);
        printArr(nums,newLen);

        nums = new int[] {2,2,3};
        newLen = solution_TwoPointers(nums,3);
        printArr(nums,newLen);

        nums = new int[] {0,1,2,2,3,0,4,2};
        newLen = solution_TwoPointers_WhenElementToRemoveAreRare(nums,1);
        printArr(nums,newLen);
    }

    /**
     * <pre>
     We can keep two pointers i and j, where i is the slow-runner while j is the fast-runner.
     When nums[j] equals to the given value, skip this element by incrementing j.
     As long as nums[j]!​= val, we copy nums[j] to nums[i] and increment both indexes at the same time.
     Repeat the process until j reaches the end of the array and the new length is i.
     * </pre>
     * @param nums
     * @param val
     * @return
     */
    public static int solution_TwoPointers(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * <pre>
     Now consider cases where the array contains few elements to remove.
     For example, nums = [1,2,3,5,4], val = 4.
     The previous algorithm will do unnecessary copy operation of the first four elements.
     Another example is nums=[4,1,2,3,5], val = 4.
     It seems unnecessary to move elements [1,2,3,5] one step left as the problem description mentions that the order of elements could be changed.

     When we encounter nums[i] = val, we can swap the current element out with the last element and dispose the last one.
     This essentially reduces the array's size by 1.
     Note that the last element that was swapped in could be the value you want to remove itself.
     But don't worry, in the next iteration we will still check this element.
     * </pre>
     * @param nums
     * @param val
     * @return
     */
    public static int solution_TwoPointers_WhenElementToRemoveAreRare(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
    /**
     * First solution. 2 main steps
     * <ol>
     *     <li> First, count how many time the values needs to be delete. This need an O(n) loop.</li>
     *     <li> Then, move all the found elements to end of array.</li>
     *     <li>The final lenght is the total len - number of removed elements.</li>
     * </ol>
     * @param nums
     * @param val
     * @return
     */
    public static int solution(int[] nums, int val) {
        int howManyToDel = 0;
        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] != val)
                continue;
            howManyToDel++;
        }
        if(howManyToDel == 0)
            return nums.length;

        int res = nums.length;

        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] != val)
                continue;
            int j = i;
            while(j < nums.length && nums[i] == val)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return res - howManyToDel;
    }

    public static void printArr(int[] nums, int toIdx)
    {
        for(int i = 0 ; i < toIdx; i++)
        {
            System.out.printf(nums[i] + " ");
        }
        System.out.println();
    }
}
