package easy;

import java.util.Scanner;

public class NegativeSubArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int elementCount = in.nextInt();
        int[] numArray = new int[elementCount];
        for(int i = 0 ; i < elementCount; i++)
        {
            numArray[i] = in.nextInt();
        }
        System.out.println(countNegativeSubArray(numArray,elementCount));
    }

    private static int countNegativeSubArray(int[] numArray, int elementCount) {
        int count = 0;
        for(int i = 0 ; i < elementCount; i++)
        {
            int sum = numArray[i];
            // count the individual
            if(sum < 0)
            {
                count++;
            }
            for(int j = i+1; j < elementCount ; j++)
            {
                int nextEl = numArray[j];
                sum += nextEl;
                if(sum < 0)
                    count++;
            }
        }
        return count;
    }
}
