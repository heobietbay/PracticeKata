package normal;
import java.util.*;

public class JavaDeque_HackerRank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;
        Set<Integer> uniqueNums = new LinkedHashSet<>(m);
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            /*if(!deque.contains(num) //TODO: Improve this
                    && maxUnique<m)
            {
                maxUnique++;
            }
            if(deque.size() == m){
                deque.removeFirst();
            }
            deque.addLast(num);*/

            deque.addLast(num);
            if(deque.size() == m){
                uniqueNums = new LinkedHashSet<>(deque);
                if(maxUnique < uniqueNums.size())
                {
                    maxUnique = uniqueNums.size();
                }
                deque.removeFirst();
            }
        }
        System.out.println(""+maxUnique);
    }
}
