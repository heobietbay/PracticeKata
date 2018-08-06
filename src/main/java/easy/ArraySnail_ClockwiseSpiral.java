package easy;

import java.util.List;

/**
 * This problem was asked by Amazon.
 <pre>
 * Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.
 *
 * For example, given the following matrix:
 *
 * [[1,  2,  3,  4,  5],
 *  [6,  7,  8,  9,  10],
 *  [11, 12, 13, 14, 15],
 *  [16, 17, 18, 19, 20]]
 * You should print out the following:
 *
 * 1
 * 2
 * 3
 * 4
 * 5
 * 10
 * 15
 * 20
 * 19
 * 18
 * 17
 * 16
 * 11
 * 6
 * 7
 * 8
 * 9
 * 14
 * 13
 * 12
 </pre>
 */
public class ArraySnail_ClockwiseSpiral {
    public static void main(String[] args) {
        int[][] array2d = { {1,  2,  3,  4,  5},
                            {6,  7,  8,  9,  10},
                            {11, 12, 13, 14, 15},
                            {16, 17, 18, 19, 20}
                          };
        solution(array2d);
    }
    /**
     *
     <pre>
     Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.
     array = [[1,2,3],
             [4,5,6],
             [7,8,9]]
     snail(array) #=> [1,2,3,6,9,8,7,4,5]
     For better understanding, please follow the numbers of the next array consecutively:
     array = [[1,2,3],
             [8,9,4],
             [7,6,5]]
     snail(array) #=> [1,2,3,4,5,6,7,8,9]
     NOTE: The idea is not sort the elements from the lowest value to the highest;
     the idea is to traverse the 2-d array in a clockwise snailshell pattern.
     NOTE 2: The 0x0 (empty matrix) is represented as [[]]
     </pre>
     */
    public static void solution(int[][] array2d)
    {
        int col = 0;
        int row = 0;

        int colLen = array2d[0].length; // assuming every row have the same col
        int rowLen = array2d.length;

        int i;

        while (row < rowLen && col < colLen)
        {
            // Print the first row from the remaining rows
            for (i = col; i < colLen; ++i)
            {
                System.out.print(array2d[row][i]+" ");
            }
            row++;

            // Print the last column from the remaining columns
            for (i = row; i < rowLen; ++i)
            {
                System.out.print(array2d[i][colLen-1]+" ");
            }
            colLen--;

            // Print the last row from the remaining rows */
            if ( row < rowLen)
            {
                for (i = colLen-1; i >= col; --i)
                {
                    System.out.print(array2d[rowLen-1][i]+" ");
                }
                rowLen--;
            }

            // Print the first column from the remaining columns */
            if (col < colLen)
            {
                for (i = rowLen-1; i >= row; --i)
                {
                    System.out.print(array2d[i][col]+" ");
                }
                col++;
            }
        }
    }
}
