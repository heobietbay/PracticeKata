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

        System.out.println( solution(gridCh, "SAM"));

        System.out.println( solution(gridCh, "FACI"));
        System.out.println( solution(gridCh, "OBQP"));
        System.out.println( solution(gridCh, "ANOB"));
        System.out.println( solution(gridCh, "MASS"));

        System.out.println( solution(gridCh, "FOAM"));
        System.out.println( solution(gridCh, "ABNA"));
        System.out.println( solution(gridCh, "CQOS"));
        System.out.println( solution(gridCh, "IPBS"));

        System.out.println( solution(gridCh, "FOA"));
        System.out.println( solution(gridCh, "FA"));;
        System.out.println( solution(gridCh, "AC"));
        System.out.println( solution(gridCh, "BS"));
        System.out.println( solution(gridCh, "BQ"));
        System.out.println( solution(gridCh, "OB"));
        System.out.println( solution(gridCh, "ABN"));
        System.out.println( solution(gridCh, "ANO"));
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
                if(row >= word.length() -1 )
                {
                    int start = row - (word.length() - 1);
                    for(int v = start; v < start + word.length(); v++)
                    {
                        tmpCh[v-start] = gridCh[v][col];
                    }
                    if(Arrays.equals(tmpCh,targetChs))
                        return true;
                }
            }
        }

        return false;
    }
}
