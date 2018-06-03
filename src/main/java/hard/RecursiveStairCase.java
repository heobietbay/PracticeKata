package hard;

/**
 * There are <font color='blue'>n</font> stairs, a person standing at the bottom wants to reach the top.
 * The person can climb <b>k</b> stairs at a time, k belongs to a set of integers.
 * <pre>Count the number of ways, the person can reach the top.</pre>
 *
 * <p> Examples
 <pre>
 Input: n = 1, k in [1,2]
 Output: 1
 There is only one way to climb 1 stair
 </pre>

 <pre>
 Input: n = 2, k in [2]
 Output: 1
 There is only way:(2)
 </pre>

 <pre>
 Input: n = 4, k in [1,2,3]
 Output: 7
 (1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2), (3,1), (1,3)
 </pre>
 * </p>
 */
public class RecursiveStairCase {

    public static void main(String[] args) {
        int[] kSteps = new int[] {1,2,3};
        System.out.println(numWays_Loop(4,kSteps));
        System.out.println(numWays_Loop(2,kSteps));
    }

    /**
     * Bottom-up approach of the same stair case problem.
     * @param nStair
     * @return
     */
    private static int numWays_Loop(int nStair, int[] kSteps){
        int[] cases = new int[nStair + 1];
        cases[0] = 1;

        for(int i = 1; i <= nStair; i++)
        {
            int total = 0;
            for (int stepSize: kSteps)
            {
                if(i - stepSize < 0)
                {
                    continue;
                }
                total += cases[i-stepSize];
            }
            cases[i] = total;
        }
        return cases[nStair];
    }

}
