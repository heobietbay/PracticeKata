package normal;

import org.junit.Assert;
import org.junit.Test;

public class FindElementInRotatedSortedArrayTest {

    @Test
    public void testSuccess()
    {
        Assert.assertTrue(FindElementInRotatedSortedArray.solution(new int[]{13, 18, 25, 2, 8, 10},8) == 4);
        Assert.assertTrue(FindElementInRotatedSortedArray.solution(new int[]{ 18, 25, 2, 8, 10},8) == 3);
        Assert.assertTrue(FindElementInRotatedSortedArray.solution(new int[]{ 25, 2, 8, 10},8) == 2);
        Assert.assertTrue(FindElementInRotatedSortedArray.solution(new int[]{ 2, 8, 10},8) == 1);
        Assert.assertTrue(FindElementInRotatedSortedArray.solution(new int[]{ 8, 10},8) == 0);
        Assert.assertNull(FindElementInRotatedSortedArray.solution(new int[]{ 8, 10},9));
        Assert.assertNull(FindElementInRotatedSortedArray.solution(new int[]{ 10},8));


        Assert.assertTrue(FindElementInRotatedSortedArray.solution(new int[]{13, 18, 25, 2, 8, 10},18) == 1);
        Assert.assertTrue(FindElementInRotatedSortedArray.solution(new int[]{13, 18, 25, 2, 8, 10},13) == 0);
        Assert.assertTrue(FindElementInRotatedSortedArray.solution(new int[]{13, 18, 25, 2, 8, 10},25) == 2);
        Assert.assertTrue(FindElementInRotatedSortedArray.solution(new int[]{13, 18, 25, 2, 8, 10},2) == 3);
    }
}
