package normal;

import java.util.*;
import java.util.stream.IntStream;

/**
 John and Mary want to travel between a few towns A, B, C ...
 Mary has on a sheet of paper a list of distances between these towns. <pre>ls = [50, 55, 57, 58, 60]. </pre>
 John is tired of driving and he says to Mary that he doesn't want to drive more than t = 174 miles and he will visit only 3 towns.

 Which distances, hence which towns, they will choose so that
 the sum of the distances is the biggest possible to please Mary - but less than t - to please John- ?

 <p>Example:</p>

 With list ls and 3 towns to visit they can make a choice between:
 <pre>[50,55,57],[50,55,58],[50,55,60],[50,57,58],[50,57,60],[50,58,60],[55,57,58],[55,57,60],[55,58,60],[57,58,60].</pre>

 The sums of distances are then: <pre>162, 163, 165, 165, 167, 168, 170, 172, 173, 175.</pre>

 The biggest possible sum taking a limit of <b>174</b> into account is then <font color='blue'>173</font>
 and the distances of the 3 corresponding towns is <pre>[55, 58, 60].</pre>

 The function <i><b>chooseBestSum</b></i> (or choose_best_sum or ... depending on the language)
 will take as parameters
 <li><font color='blue'><b>t</b></font> (maximum sum of distances, integer >= 0), </li>
 <li><font color='blue'><b>k</b></font> (number of towns to visit, k >= 1) and </li>
 <li><font color='blue'><b>ls</b></font> (list of distances, all distances are positive or null integers and this list has at least one element).</li>

 The function returns the "best" sum ie the biggest possible sum of <font color='blue'><b>k</b></font> distances
 less than or equal to the given limit <font color='blue'><b>t</b></font>, if that sum exists,
 or otherwise <i>nil, null, None, Nothing</i>, depending on the language. With C++, C, Rust, Swift, Go, Kotlin return -1.

 <p>Examples:</p>

     <pre>ts = [50, 55, 56, 57, 58] choose_best_sum(163, 3, ts) -> 163</pre>
     <pre>xs = [50] choose_best_sum(163, 3, xs) -> nil (or null or ... or -1 (C++, C, Rust, Swift, Go)</pre>
     <pre>ys = [91, 74, 73, 85, 73, 81, 87] choose_best_sum(230, 3, ys) -> 228 </pre>
 */
public class SumOfK {

    public static void main(String[] args) {
        /*List<int[]> partitionsOfList = partitionsOfList(Arrays.asList(1, 2, 3,4), 3);
        partitionsOfList.forEach( partition -> {
            System.out.println(Arrays.toString(partition));
        });*/
        System.out.println(chooseBestSum(163,3, Arrays.asList(50,55,56,57,58)));
        System.out.println(chooseBestSum(230,3, Arrays.asList(91, 74, 73, 85, 73, 81, 87)));
    }

    public static Integer chooseBestSum_Recursion(int t, int k, List<Integer> ls) {
        int result = -1;
        for (int i=0; i<ls.size(); ++i){
            if (ls.get(i)<=t){
                if(k==1){
                    result=Math.max(result, ls.get(i));
                }
                else{
                    Integer temp = chooseBestSum(t-ls.get(i),k-1,ls.subList(i+1, ls.size()));
                    if (temp!=null){
                        result=Math.max(result, ls.get(i)+temp);
                    }
                }
            }
        }

        if (result<0) return null;
        return result;
    }

    /**
     * This to me seems like {@link MaximumSubArray} problem variation.
     * @param targetSum
     * @param allowSums
     * @param ls
     * @return
     */
    public static Integer chooseBestSum(int targetSum, int allowSums, List<Integer> ls) {
        if(ls.size() < allowSums)
            return null;

        int res = 0;
        List<int[]> partitionsOfList = partitionsOfList(ls, allowSums);
        for(int[] partition : partitionsOfList)
        {
            int tmp = IntStream.of(partition).sum();
            if(tmp == targetSum)
            {
                res = tmp;
                break;
            }
            else if(tmp < targetSum && tmp > res)
            {
                res = tmp;
            }
        }
        return res;
    }

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

     * @param sourceLst
     * @param partitionSize
     * @return
     */
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
