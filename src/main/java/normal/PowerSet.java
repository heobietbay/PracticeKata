package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This problem was asked by Google.
 <p>
 * The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.
 </p>
 <pre>
  For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
  You may also use a list or array to represent a set.
 </pre>
 Please read file PowerSet.pdf for in-depth analysis and possible solutions.
 */
public class PowerSet {
    public static void main(String[] args) {
        List<List<Integer>> lists = solutionBitMask(Arrays.asList(1, 2, 3));
        if(lists != null && !lists.isEmpty())
        {
            lists.forEach(lst -> System.out.println(Arrays.toString(lst.toArray())));
        }
    }

    private static List<List<Integer>> solutionBitMask(List<Integer> inpSet) {
        List<List<Integer>> res = new ArrayList<>();
        int totalSubSet = (int) Math.pow(2,inpSet.size());
        for(int i = 0 ; i < totalSubSet; i++)
        {
            if(i == 0)
            {
                res.add(Arrays.asList());
            }
            else
            {
                int mask = 1;
                List<Integer> lst = new ArrayList<>();
                for(int j = 0 ; j < inpSet.size();j++ )
                {
                    if( (mask & i) != 0)
                    {
                        lst.add(inpSet.get(j));
                    }
                    mask = mask << 1;
                }
                res.add(lst);
            }
        }
        return res;
    }

}
