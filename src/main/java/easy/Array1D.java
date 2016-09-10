package easy;

import java.util.Scanner;

/**
 * Created by khoa on 2/8/2016.
 */
public class Array1D {
    /*
    Array is a very simple data structure which is used to store a collection of data, for example roll number of all the students in a class or name of all the countries in the world. To create an array of integer that can hold 10 values, you can write code like this:

    int[] myList = new int[10];
    This problem will test your knowledge on java array.
    You are given an array of n integers. A sub-array is "Negative" if sum of all the integers in that sub-array is negative. Count the number of "Negative sub-arrays" in the input array.

    Note: Subarrays are contiguous chunks of the main array. For example if the array is {1,2,3,5} then some of the subarrays are {1}, {1,2,3}, {2,3,5}, {1,2,3,5} etc. But {1,2,5} is not an subarray as it is not contiguous.

            Input Format

    The first line consists an integer n. The next line will contain n space separated integers. Value of n will be at most 100. The numbers in the array will range between -10000 to 10000.

    Output Format

    Print the answer to the problem.

    Sample Input

    5
            1 -2 4 -5 1
    Sample Output

    9

    Explanation

    These are the ranges of the 9 negative subarrays in this sample:

            [0:1]
            [0:3]
            [0:4]
            [1:1]
            [1:3]
            [1:4]
            [2:3]
            [3:3]
            [3:4]
    Assume that the index is 0 based.
    */


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;
        while(count < n)
        {
            arr[count++] = sc.nextInt();
        }

        int subArrCount = 0;

        for(int i = 0 ; i < count ; i++)
        {
            int sum = arr[i];
            if(sum < 0)
            {
                subArrCount++;
            }
            for(int j = i + 1; j < count; j++)
            {
                sum = sum  + arr[j];
                if(sum < 0)
                {
                    subArrCount++;
                }
            }
        }
        System.out.println(subArrCount);
    }
}
