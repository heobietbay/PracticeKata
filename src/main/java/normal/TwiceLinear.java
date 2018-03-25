package normal;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

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

    /**
     * Follow somewhat similar to this approach
     -----------------
     <p>https://stackoverflow.com/questions/46167878/twice-linear-java</p>
     You'll want to create the set u() in an already sorted order, instead of sorting it after the fact.
     You'll want to use a Set, rather than a List, to make the adding of members without duplicating them trivial.
     The most efficient sorted Set you can use would be the BitSet.
     Start by initializing u(1) in the set, then...
       Search for the next unprocessed u(x) value, and add u(2x+1) and u(3x+1) to the set.
       Searching for the next unprocessed value is easy with nextSetBit.
     -----------------
     * @param n the n position of the number we want to find
     * @return the found number
     */
    public static int dblLinear(int n) {
        Map<Integer, Boolean> map = new TreeMap<>();
        map.put(1, false);
        int[] arr = new int[n+1];
        int count = 0;
        while (count <= n) {
            for (Map.Entry<Integer, Boolean> x : map.entrySet()) {
                if (!x.getValue()) {
                    map.put(x.getKey() * 2 + 1, false);
                    map.put(x.getKey() * 3 + 1, false);
                    arr[count++] = x.getKey();
                    map.remove(x.getKey());
                    break;
                }
            }
        }
        return arr[n];
    }

    /**
     * This implementation use a TreeSet, so the set
     *   <ul>
     *       <li>Each member is unique</li>
     *       <li>Number is unique</li>
     *   </ul>
     * @param n the n position of the number we want to find
     * @return the found number
     */
    public static int dblLinear2(int n) {
        if (n == 0) return 1;
        SortedSet<Integer> numberSet = new TreeSet<>();
        numberSet.add(1);
        for(int i=0; i<n; i++) {
            int x = numberSet.first();
            numberSet.add(x*2+1);
            numberSet.add(x*3+1);
            // we dont need that any more
            numberSet.remove(x);
        }
        return numberSet.first();
    }

    @Test
    public void testTwiceLinear()
    {
        Assert.assertEquals(22,dblLinear(10));
        Assert.assertEquals(57,dblLinear(20));
        Assert.assertEquals(91,dblLinear2(30));
        Assert.assertEquals(175,dblLinear2(50));
        Assert.assertEquals(447,dblLinear(100));
    }
}
