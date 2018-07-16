package normal;

import java.util.*;

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
        List<List<Integer>> lists = solutionRecursive(Arrays.asList(1, 2, 3));
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

    private static List<List<Integer>>  solutionRecursive(List<Integer> originalSet) {
        List<List<Integer>> sets = new ArrayList<>();
        if (originalSet.isEmpty()) {
            sets.add(new ArrayList<>());
            return sets;
        }
        List<Integer> list = originalSet;
        // Add the first element in the lst
        Integer head = list.get(0);
        // now, find every possible combination of head + rest
        List<Integer> rest = new ArrayList<>(list.subList(1, list.size()));
        for (List<Integer> set : solutionRecursive(rest)) {
            List<Integer> newSet = new ArrayList<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
