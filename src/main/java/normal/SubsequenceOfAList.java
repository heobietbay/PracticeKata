package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A subsequence is a sequence that can be derived from another sequence by zero or more elements,
 *   without changing the order of the remaining elements.
 * For <b>[1, 2, 3, 4]</b> example, there are 15 sub-sequences.
 * They are (1), (2), (3), (4), (1,2), (1,3),(1,4), (2,3), (2,4), (3,4), (1,2,3), (1,2,4), (1,3,4), (2,3,4), (1,2,3,4).
 * More generally, we can say that for a sequence of size n, we can have (2n-1) non-empty sub-sequences in total.
 *
 * <p>
 This is a well-studied problem of generating all k-subsets, or k-combinations, which can be easily done without recursion.

 <pre>
 The idea is to have array of size k keeping sequence of indices of elements from the input array
 (which are numbers from 0 to n - 1) in increasing order.
 (Subset then can be created by taking items by these indices from the initial array.)
 So we need to generate all such index sequences.</pre>
 <pre>
 First index sequence will be [0, 1, 2, ... , k - 1], on the second step it switches to [0, 1, 2,..., k],
 then to [0, 1, 2, ... k + 1] and so on.
 The last possible sequence will be [n - k, n - k + 1, ..., n - 1].</pre>
 <pre>
 On each step, algorithm looks for the closest to the end item which can be incremented,
 increments it and fills up items right to that item.</pre>

 </p>
 */
public class SubsequenceOfAList {
    public static void main(String[] args) {
        List<int[]> partitionsOfList = partitionsOfList(Arrays.asList(1, 2, 3,4), 3);
        partitionsOfList.forEach( partition -> {
            System.out.println(Arrays.toString(partition));
        });
    }
    private static List<int[]> partitionsOfList(List<Integer> sourceLst, int partitionSize)
    {
        List<int[]> res = new ArrayList<>();
        int[] s = new int[partitionSize];  // here we'll keep indices pointing to elements in input array
        if (partitionSize <= sourceLst.size()) {
            // first index sequence: 0, 1, 2, ...
            for (int i = 0; (s[i] = i) < partitionSize - 1; i++);
            res.add(getSubset(sourceLst, s));
            while(true) {
                int i;
                // find position of item that can be incremented
                for (i = partitionSize - 1; i >= 0 && s[i] == sourceLst.size() - partitionSize + i; i--);
                if (i < 0) {
                    break;
                }
                s[i]++;                    // increment this item
                for (++i; i < partitionSize; i++) {    // fill up remaining items
                    s[i] = s[i - 1] + 1;
                }
                res.add(getSubset(sourceLst, s));
            }
        }
        return res;
    }

    // generate actual subset by index sequence
    private static int[] getSubset(List<Integer> sourceLst, int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; i++)
            result[i] = sourceLst.get(subset[i]);
        return result;
    }
}
