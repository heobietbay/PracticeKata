package normal;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SlidingWindowMaximumTest {

    @Test
    public void testSuccess()
    {
        List<Integer> input = Arrays.asList(8, 5, 10, 7, 9, 4, 15, 12, 90, 13);
        int subSize = 4;
        List<Integer> maximums = SlidingWindowMaximum.solution(input,subSize);
        Integer[] expected = {10, 10, 10, 15, 15, 90, 90};
        Assert.assertTrue(Arrays.equals(maximums.toArray(),expected));

        input = Arrays.asList(1, 2, 3, 1, 4, 5, 2, 3, 6);
        subSize = 3;
        maximums = SlidingWindowMaximum.solution(input,subSize);
        expected = new Integer[]{3,3, 4, 5, 5, 5, 6};
        Assert.assertTrue(Arrays.equals(maximums.toArray(),expected));

        input = Arrays.asList(1,3,-1,-3,5,3,6,7);
        subSize = 3;
        maximums = SlidingWindowMaximum.solution(input,subSize);
        expected = new Integer[]{3,3,5,5,6,7};
        Assert.assertTrue(Arrays.equals(maximums.toArray(),expected));

        input = Arrays.asList(7,2,4);
        subSize = 2;
        maximums = SlidingWindowMaximum.solution(input,subSize);
        expected = new Integer[]{7,4};
        Assert.assertTrue(Arrays.equals(maximums.toArray(),expected));
    }
}
