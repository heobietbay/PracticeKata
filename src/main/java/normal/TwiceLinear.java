package normal;

import org.junit.Assert;
import org.junit.Test;

/**
 Consider a sequence u where u is defined as follows:

 The number u(0) = 1 is the first one in u.
 For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
 There are no other numbers in u.
 Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]

 1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and 22 and so on...

 #Task: Given parameter n the function dbl_linear (or dblLinear...) returns the element u(n) of the ordered (with <) sequence u.

 #Example: dbl_linear(10) should return 22

 #Note: Focus attention on efficiency

 */
public class TwiceLinear {


    private static int dblLinear(int n)
    {
        return 1;
    }

    @Test
    public void testTwiceLinear()
    {
        Assert.assertEquals(22,dblLinear(10));
        Assert.assertEquals(57,dblLinear(20));
        Assert.assertEquals(91,dblLinear(30));
        Assert.assertEquals(175,dblLinear(50));
        Assert.assertEquals(447,dblLinear(100));
    }
}
