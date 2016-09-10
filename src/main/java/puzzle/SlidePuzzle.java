package puzzle;

/**
 * Created by khoa on 2/10/2016.
 */
public class SlidePuzzle {

    public static void main(String[] args) {
        printPuzzle(SAMPLE_1);
        System.out.println(isSolved(SAMPLE_1));

        System.out.println();
        printPuzzle(SAMPLE_2);
        System.out.println(isSolved(SAMPLE_2));
    }

    static void solve(SlidePuzzle puzzle)
    {
        int maxAttempt = 1000;
        int count = 0 ;

        while(!isSolved(puzzle) && count < maxAttempt)
        {
            int pos = blankPos(puzzle);
            if(pos==-1)
            {
                break;
            }
            int col = pos % 3;
            int row = pos / 3;
            count++;
        }
    }
    static void swap(int[][] blocks, int a, int b)
    {

    }
    static int blankPos(SlidePuzzle puzzle)
    {
        for(int rowIdx = 0 ; rowIdx < puzzle.blocks.length ; rowIdx++)
        {
            int[] row = puzzle.blocks[rowIdx];

            for(int colIdx = 0 ; colIdx < row.length; colIdx++)
            {
                int val = row[colIdx];
                if(val == 0 )
                {
                    return (rowIdx* row.length)  + colIdx ;
                }
            }
        }
        return -1;
    }
    static boolean isSolved(SlidePuzzle puzzle)
    {
        for(int rowIdx = 0 ; rowIdx < puzzle.blocks.length ; rowIdx++)
        {
            int[] row = puzzle.blocks[rowIdx];

            for(int colIdx = 0 ; colIdx < row.length; colIdx++)
            {
                int val = row[colIdx];
                if(val == 0 )
                {
                    if(colIdx!= row.length -1 && rowIdx != puzzle.blocks.length -1)
                    {
                        return false;
                    }
                }
                else
                {
                    int rightVal = (rowIdx* row.length)  + colIdx + 1;
                    if(val != rightVal)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static void printPuzzle(SlidePuzzle puzzle)
    {
        for(int[] row: puzzle.blocks)
        {
            for(int col : row)
            {
                System.out.print("_" + col + "_ ");
            }
            System.out.println();
        }
    }
    int[][] blocks = new int [3][3];

    static SlidePuzzle SAMPLE_1 = new SlidePuzzle();
    static SlidePuzzle SAMPLE_2 = new SlidePuzzle();
    static SlidePuzzle SAMPLE_3 = new SlidePuzzle();
    static {
        SAMPLE_1.blocks = new int[][]{{8, 4, 1}, {6, 3, 2}, {7, 5, 0}};
        SAMPLE_2.blocks = new int[][]{{2, 3, 1}, {0, 5,7}, {8, 4, 6}};
        SAMPLE_3.blocks = new int[][]{{1, 2, 3}, {4, 5,6}, {7, 8, 0}};
    }
}
