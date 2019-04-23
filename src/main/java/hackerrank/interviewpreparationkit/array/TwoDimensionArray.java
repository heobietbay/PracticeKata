package hackerrank.interviewpreparationkit.array;

public class TwoDimensionArray {

    public static void main(String[] args) {

    }

    static int solution(int arr[][], int colLen, int rowLen)
    {
        Integer res = null;
        for(int r = 0 ; r < rowLen - 2; r++)
        {
            for(int i=0; i < colLen - 2; i++)
            {
                int sum =  arr[r][i] + arr[r][i+1]     + arr[r][i+2]
                                     + arr[r+1][i+1]
                       + arr[r+2][i] + arr[r+2][i+1]   + arr[r+2][i+2] ;

                if(res == null || sum > res )
                {
                    res = sum;
                }
            }
        }
        return res;
    }
}
