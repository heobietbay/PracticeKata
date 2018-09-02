package normal;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTest {
    @Test
    public void testSuccess()
    {
        Assert.assertEquals(1,CoinChange.solution(1,new int[]{1,5,10,25}));
        Assert.assertEquals(2,CoinChange.solution(6,new int[]{1,5,10,25}));
        Assert.assertEquals(7,CoinChange.solution(49,new int[]{1,5,10,25}));
    }
}
