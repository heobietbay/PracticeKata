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

    static Integer solveFaster(Integer inp)
    {
        Integer res = 0;

        // calculate number % 3 == 0
        int start = 3;
        while( start < inp )
        {
            res += start;
            start += 3;
        }

        // calculate number % 5 == 0
        start = 5;
        while( start < inp )
        {
            res += start;
            start += 5;
        }

        // minus the common number (they've been added twice), which is x % 15 == 0
        start = 15;
        while( start < inp )
        {
            res -= start;
            start += 15;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solve(10));
        System.out.println(solveFaster(10));
        System.out.println(solve(INPUT));
        System.out.println(solveFaster(INPUT));
    }

    static final int INPUT = 1000;
}
