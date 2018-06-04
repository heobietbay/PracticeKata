package normal;


/**
In computer science, the maximum subarray problem is the task of finding the contiguous subarray
  within a one-dimensional array of numbers which has the largest sum.
For example,
for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.

The problem was first posed by Ulf Grenander of Brown University in 1977, as a simplified model for maximum likelihood
  estimation of patterns in digitized images.
A linear time algorithm was found soon afterwards by Jay Kadane of Carnegie-Mellon University (Bentley 1984).
*/
public class MaximumSubArray {

    /*
    In computer science, the maximum subarray problem is the task of finding the contiguous subarray
      within a one-dimensional array of numbers which has the largest sum.
    For example,
    for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.

    The problem was first posed by Ulf Grenander of Brown University in 1977, as a simplified model for maximum likelihood
      estimation of patterns in digitized images.
    A linear time algorithm was found soon afterwards by Jay Kadane of Carnegie-Mellon University (Bentley 1984).
    */
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maximumSubArray_SlowSolution(arr);

        arr = new int[] {-2, -4, 3, -1, 5, 6, -7, -2, 4, -3, 2 };
        System.out.println(maximumSubArray_FasterSolution(arr));

        System.out.println(maximumSubArray_KadaneFastedSolution(arr));

        arr = new int[] {1,2,-4,4,3,0 };
        System.out.println(maximumSubArray_KadaneFastedSolution(arr));

        arr = new int[] {-1,-2 };
        System.out.println(maximumSubArray_KadaneFastedSolution(arr));
    }

    static int maximumSubArray_SlowSolution(int[] arr)
    {
        int max = 0;
        for(int i = 0 ; i < arr.length; i++)
        {
            for(int j = i ; j < arr.length; j++)
            {
                int sum = 0 ;
                for(int k = i; k < j; k++ ) // this loop get every sum possible
                {
                    sum = sum + arr[k];
                }
                if(max < sum)
                {
                    max = sum;
                }
            }
        }
        return max;
    }


    static int maximumSubArray_FasterSolution(int[] arr)
    {
        int[] prefixSums = new int[arr.length];
        prefixSums[0] = arr[0];
        // init the prefix sum arr
        // for i <- 1 to n do
       //  Si ←Si−1+A[i]

        for(int i = 1 ; i < arr.length; i++)
        {
            prefixSums[i] = arr[i] + prefixSums[i-1];
        }

        int max = 0;
        for(int i = 1 ; i < arr.length; i++)
        {
            for(int j = i ; j < arr.length; j++)
            {
                int sum = prefixSums[j] - prefixSums[ i -1] ;

                if(max < sum)
                {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     *  This is based on Kadane algorithm.
     * @param arr
     * @return
     */
    static int maximumSubArray_KadaneFastedSolution(int[] arr)
    {
        int sum = arr[0];

        int max = sum;

        for(int i = 1; i < arr.length; i++)
        {
            int temp = sum + arr[i];
            if(arr[i] > temp)
            {
                sum = arr[i];
            }
            else
            {
                sum = temp;
            }

            if(max < sum)
            {
                max = sum;
            }
        }
        return max;
    }


}
