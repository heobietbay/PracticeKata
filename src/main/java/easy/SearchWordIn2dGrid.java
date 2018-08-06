package easy;

import java.util.Arrays;

/**
 * This problem was asked by Microsoft.
 * <pre>
 Given a 2D matrix of characters and a target word, write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.

 For example, given the following matrix:

 [['F', 'A', 'C', 'I'],
 ['O', 'B', 'Q', 'P'],
 ['A', 'N', 'O', 'B'],
 ['M', 'A', 'S', 'S']]

 and the target word 'FOAM', you should return true, since it's the leftmost column.
 Similarly, given the target word 'MASS', you should return true, since it's the last row.
 * </pre>
 */
public class SearchWordIn2dGrid {
    public static void main(String[] args) {
       char[][] gridCh =  {{'F', 'A', 'C', 'I'},
               {'O', 'B', 'Q', 'P'},
               {'A', 'N', 'O', 'B'},
               {'M', 'A', 'S', 'S'}};

        System.out.println( solution(gridCh, "FOAM"));
        System.out.println( solution(gridCh, "FA"));;
        System.out.println( solution(gridCh, "AC"));
    }

    public static boolean solution(char[][] gridCh, String word)
    {
        char[] targetChs = word.toCharArray();
        char[] tmpCh = new char[word.length()];
        for(int row = 0 ; row < gridCh.length; row++)
        {
            char[] rowChs = gridCh[row];
            for(int col = 0 ; col < rowChs.length; col++)
            {
                // horizontal check
                if(col <= rowChs.length - word.length())
                {
                    System.arraycopy(rowChs,col,tmpCh,0,tmpCh.length);
                    if(Arrays.equals(tmpCh,targetChs))
                        return true;
                }
                // vertical check
                if(row >= word.length())
                {
                    for(int v = row; v>= row - word.length(); v--)
                    {

                    }
                }
            }
        }

        return false;
    }
}
