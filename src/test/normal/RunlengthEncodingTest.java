package normal;

import org.junit.Assert;
import org.junit.Test;

public class RunlengthEncodingTest {

    @Test
    public void testSuccess()
    {
        Assert.assertEquals("4A3B2C1D2A",RunlengthEncoding.solution("AAAABBBCCDAA"));
        Assert.assertEquals("1A3B2A2C1D2E",RunlengthEncoding.solution("ABBBAACCDEE"));
        Assert.assertEquals("12W1B12W3B24W1B14W",RunlengthEncoding.solution("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW"));
    }
}
