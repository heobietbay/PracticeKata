package normal;
import java.util.*;

public class JavaDeque_HackerRank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int total = in.nextInt();
        int subArraySize = in.nextInt();
        int maxUnique = 0;
        // to store the current unique number of the current subarray
        Set<Integer> uniqueNums = new LinkedHashSet<>(subArraySize);
        for (int i = 0; i < total; i++) {
            int number = in.nextInt();
            deque.addLast(number);
            uniqueNums.add(number);

            // Ok, is the subarray reaching maximum size
            if (deque.size() == subArraySize) {

                if (uniqueNums.size() > maxUnique) {
                    maxUnique = uniqueNums.size();
                }

                Integer firstNumberInDeque = (Integer)deque.removeFirst();
                //if the number we remove - at the first - is not unique in old deque
                if (!deque.contains(firstNumberInDeque)) {
                    uniqueNums.remove(firstNumberInDeque);
                }
            }
        }
        System.out.println(""+maxUnique);
    }
}
