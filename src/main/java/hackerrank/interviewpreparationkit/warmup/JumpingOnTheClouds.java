package hackerrank.interviewpreparationkit.warmup;

public class JumpingOnTheClouds {

    public static void main(String[] args) {
        int[] clouds = new int[] {0, 0, 1, 0, 0, 1, 0};
        int minStep = solution(clouds);
        System.out.println(minStep);

        clouds = new int[] {0, 0, 0, 0, 1, 0};
        minStep = solution(clouds);
        System.out.println(minStep);
    }

    public static int solution(int[] clouds) {
        int count = 0;
        int i = 0;
        while(i < clouds.length-1)
        {
            if( i + JUMP_TWO < clouds.length && clouds[i + JUMP_TWO] != THUNDER_CLOUD){
                i = i + JUMP_TWO;
                count++;
            }
            else {
                i++;
                count++;
            }
        }
        return count;
    }

    private static final int THUNDER_CLOUD = 1;
    private static final int JUMP_TWO = 2;
    private static final int JUMP_ONE = 1;
}
