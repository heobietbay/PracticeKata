package easy;

import java.util.Scanner;

public class Array2D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(max(arr,6,6));
        in.close();
    }

    static int max(int arr[][], int colLen, int rowLen)
    {
        Integer res = null;
        for(int r = 0 ; r < rowLen - 2; r++)
        {
            for(int i=0; i < colLen - 2; i++)
            {
                int sum =  arr[r][i] + arr[r][i+1]     + arr[r][i+2]
                                     + arr[r+1][i+1]
                         + arr[r+2][i] + arr[r+2][i+1] + arr[r+2][i+2] ;

                if(res == null || sum > res )
                {
                    res = sum;
                }
            }
        }
        return res;
    }
}
