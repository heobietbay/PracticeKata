package hard;

/**
 * There are <font color='blue'>n</font> stairs, a person standing at the bottom wants to reach the top.
 * The person can climb either <b>1 stair</b> or <b>2 stairs</b> at a time.
 * <pre>Count the number of ways, the person can reach the top.</pre>
 *
 * <p> Examples
 <pre>
 Input: n = 1
 Output: 1
 There is only one way to climb 1 stair
 </pre>

 <pre>
 Input: n = 2
 Output: 2
 There are two ways: (1, 1) and (2)
 </pre>

 <pre>
 Input: n = 4
 Output: 5
 (1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)
 </pre>
 * </p>
 */
public class OneTwoRecursiveStairCase {

    public static void main(String[] args) {
        System.out.println(numWays_Recursive(4));
        System.out.println(numWays_Loop(4));
        System.out.println(numWays_Loop(2));
    }

    /**
     * Bottom-up approach of the same stair case problem.
     * <quote>The person can climb either <b>1 stair</b> or <b>2 stairs</b> at a time.</quote>
     * <p>This can be same as fibonacci problem solving</p>
     * To save space, we only need to hold n-1 and n-2.
     * @param nStair
     * @return
     */
    private static int numWays_Loop(int nStair){
        int[] cases = new int[] {1,1};
        for(int i = 2; i <= nStair; i++)
        {
           int tmp = cases[1];
           cases[1] = cases[0] + tmp;
           cases[0] = tmp;
        }
        return cases[1];
    }

    /**
     * This looks like fibonacci number, because as the problem stated:
      <quote>The person can climb either <b>1 stair</b> or <b>2 stairs</b> at a time.</quote>
     * @param nStair
     * @return
     */
    private static int numWays_Recursive(int nStair){
        if(nStair == 1 || nStair == 0)
            return 1;
        return numWays_Recursive(nStair - 1) + numWays_Recursive(nStair - 2);
    }
}
