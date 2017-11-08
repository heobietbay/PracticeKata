package normal;

import java.util.Scanner;

/**
 * Created by khoa on 2/8/2016.
 */
public class Array1DPart2 {

    public static boolean canWin(int leap, int[] game) {
        int len = game.length;
        int currentIdx = 0;
        if( currentIdx + leap > len)
        {
            return true;
        }
        boolean canWin = true;
        // keep track of the last pos we step back
        int stepBackPos = -1;
        while (canWin && currentIdx + leap < len)
        {
            if(game[currentIdx + leap] == 0)
            {
                currentIdx = currentIdx + leap;
            }
            else if(game[currentIdx + 1] == 0)
            {
                currentIdx = currentIdx + 1;
            }
            // cannot move forth, have to step back
            else if( currentIdx != 0 && game[currentIdx - 1] == 0)
            {
                currentIdx = currentIdx - 1;
                // if we are stepping back and forth, it means we cannot move fw, so we lose
                if(currentIdx == stepBackPos)
                {
                    canWin = false;
                }
                else
                {
                    stepBackPos = currentIdx;
                }
            }
            else
            {
                canWin = false;
            }
        }
        return canWin;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
