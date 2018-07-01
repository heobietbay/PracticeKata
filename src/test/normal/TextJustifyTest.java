package normal;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TextJustifyTest {
    @Test
    public void testSuccess()
    {
        List<String> inp = Arrays.asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog");
        List<String> outp = TextJustify.solution(inp, 16);
        Assert.assertEquals(3, outp.size());
        Assert.assertEquals("the  quick brown",outp.get(0));
        Assert.assertEquals("fox  jumps  over",outp.get(1));
        Assert.assertEquals("the   lazy   dog",outp.get(2));
    }
}
