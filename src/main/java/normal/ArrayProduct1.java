package normal;

import java.util.Arrays;

/**
 Given an array of numbers, nums, return an array of numbers products, where products[i] is the product of all nums[j], j != i.

 Input : [1, 2, 3, 4, 5]
 Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)]
 = [120, 60, 40, 30, 24]
 You must do this in O(N) without using division.
 */
public class ArrayProduct1 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        int[] subProductArrays = buildSubProductArray(nums);
        System.out.println(Arrays.toString(subProductArrays));
    }

    /**
     *  The idea is to construct the arrays (in the case for 4 elements) like below
     *  <p>
     *      <p>
     {              1,         a[0],    a[0]*a[1],    a[0]*a[1]*a[2],  }
           </p>
           <p>
     { a[1]*a[2]*a[3],    a[2]*a[3],         a[3],                 1,  }
           </p>
     *  </p>
     *  <p>Both of which can be done in O(n) by starting at the left and right edges respectively.
     Then multiplying the two arrays element by element gives the required result</p>
     * @param nums
     * @return
     */
    private static int[] buildSubProductArray(int[] nums) {
        int flag = 1;
        int[] productsBelow = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            productsBelow[i]=flag;
            flag*=nums[i];
        }

        int[] productsAbove = new int[nums.length];
        // reset the flag
        flag=1;
        for(int i=nums.length-1;i>=0;i--) {
            productsAbove[i]=flag;
            flag*=nums[i];
        }

        int[] res = new int[nums.length]; // This is the result
        for(int i=0;i<nums.length;i++) {
            res[i]=productsBelow[i]*productsAbove[i];
        }
        return res;
    }
}
