package codility;

import java.util.Arrays;

/**
 * <pre>
 Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 Given A = [1, 2, 3], the function should return 4.
 Given A = [−1, −3], the function should return 1.
 Given A = [2], the function should return 1.
 Given A = [1], the function should return 2.

 Write an <font color='red'>efficient algorithm</font> for the following assumptions:
       N is an integer within the range [1..100,000];  
       each element of array A is an integer within the range [−1,000,000..1,000,000]
 * </pre>
 */
public class FindSmallestPositiveNotAppearing {
    public static void main(String[] args) {
        int smallest = solution(new int[]{1,2,3});
        System.out.println(smallest);

        smallest = solution(new int[]{-1,-3});
        System.out.println(smallest);

        smallest = solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(smallest);

        smallest = solution(new int[]{1, 3, 6, 4, 1});
        System.out.println(smallest);

        smallest = solution(new int[]{2, 3, 6, 1});
        System.out.println(smallest);

        smallest = solution(new int[]{2});
        System.out.println(smallest);

        smallest = solution(new int[]{-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,8,9});
        System.out.println(smallest);
    }
    public static int solution(int[] arr){

        Arrays.sort(arr);
        int max = arr[arr.length-1] ;
        if(max < 0)
            return 1;
        // lets start with a null flag
        Integer flag = null;
       // use binary search to find if flag exists in the array
        //THIS NEEDS TO BE CORRECT FOR CASE [4, 5, 6, 2] the solution returned a wrong answer (got 3 expected 1).
        for(int i = 0 ; i < arr.length; i++)
        {
            int num = arr[i];
            int posibleFind = num + 1;
            if(posibleFind <= 0)
                continue;
            if(Arrays.binarySearch(arr,posibleFind) < 0 )
            {
                if(flag == null)
                    flag = posibleFind;
                else if(flag > posibleFind)
                    flag = posibleFind;
            }
        }

        int result = flag == null ? max + 1 : flag;
        // extreme case. the array only got 1 element
        if(arr.length == 1)
        {
            if(max >1)
                result = Math.min(1,result);
        }
        return result;
    }
}
