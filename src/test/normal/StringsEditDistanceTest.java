package normal;

import org.junit.Assert;
import org.junit.Test;

public class StringsEditDistanceTest {

    @Test
    public void test(){
      //  Assert.assertEquals(3, StringsEditDistance.solution("kitten","sitting"));
        Assert.assertEquals(2,StringsEditDistance.solution("ATCAT","ATTATC"));
    }
}
