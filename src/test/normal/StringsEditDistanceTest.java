package normal;

import org.junit.Assert;
import org.junit.Test;

public class StringsEditDistanceTest {

    @Test
    public void test(){
        String s1 = "kitten";
        String s2 = "sitting";
        Assert.assertEquals(3, StringsEditDistance.solution(s1,s2));
    }
}
