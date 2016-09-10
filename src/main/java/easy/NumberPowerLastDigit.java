package easy;

import java.util.List;

/**
 * Created by khoa on 8/14/2016.
 */
public class NumberPowerLastDigit {
    /**
     *
     For a given list [x1, x2, x3, ..., xn] compute the last (decimal) digit of x1 ^ (x2 ^ (x3 ^ (... ^ xn))).
     E. g.,
     lastDigit([3, 4, 2]) === 1
     because 3 ^ (4 ^ 2) = 3 ^ 16 = 43046721.

     Beware: powers grow incredibly fast. For example, 9 ^ (9 ^ 9) has more than 369 millions of digits. lastDigit has to deal with such numbers efficiently.

     Corner cases: we assume that 0 ^ 0 = 1 and that lastDigit of an empty list equals to 1.
     */

    private static int lastDigit(List<Integer> list)
    {
        if(list.isEmpty())
        {
            return 1;
        }

        return 0;
    }
    public static void main(String[] args) {

    }
}
