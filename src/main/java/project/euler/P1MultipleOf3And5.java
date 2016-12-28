package project.euler;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class P1MultipleOf3And5 {

    static Integer solve(Integer inp)
    {
        Integer res = 0;
        while(--inp > 2)
        {
            if(inp % 3 == 0 || inp % 5 == 0)
            {
                res += inp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solve(INPUT));
        System.out.println(solve(10));
    }

    static final int INPUT = 1000;
}
