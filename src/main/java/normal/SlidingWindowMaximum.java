package normal;

import java.util.*;

/**
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 <p>
 * Examples :
 <pre>
 * Input :
 * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3
 * Output :
 * 3 3 4 5 5 5 6
 *
 * Input :
 * arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 * k = 4
 * Output :
 * 10 10 10 15 15 90 90
 </pre>
 </p>
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(8, 5, 10, 7, 9, 4, 15, 12, 90, 13);
        int subSize = 4;
        List<Integer> maximums = solution(input,subSize);
        System.out.println(Arrays.toString(maximums.toArray()));

        input = Arrays.asList(1, 2, 3, 1, 4, 5, 2, 3, 6);
        subSize = 3;
        maximums = solution(input,subSize);
        System.out.println(Arrays.toString(maximums.toArray()));

        input = Arrays.asList(1,3,-1,-3,5,3,6,7);
        subSize = 3;
        maximums = solution(input,subSize);
        System.out.println(Arrays.toString(maximums.toArray()));
    }
    public static List<Integer> solution(List<Integer> input,int subSize) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        TreeSet<Integer> orderSet = new TreeSet<>();
        for(int i = 0 ; i < input.size(); i++)
        {
            Integer num = input.get(i);
            queue.addLast(num);
            orderSet.add(num);
            if(queue.size() == subSize)
            {
                result.add(orderSet.last());
                Integer firstNumberInDeque = queue.removeFirst();
                //if the number we remove - at the first - is not unique in old deque
                if (!queue.contains(firstNumberInDeque)) {
                    orderSet.remove(firstNumberInDeque);
                }
            }
        }
        return result;
    }
}
