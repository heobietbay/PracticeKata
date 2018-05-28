package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Sheldon, Leonard, Penny, Rajesh and Howard are in the queue for a "Double Cola" drink vending machine; there are no other people in the queue.
 * The first one in the queue (Sheldon) buys a can, drinks it and doubles! The resulting two Sheldons go to the end of the queue.
 * Then the next in the queue (Leonard) buys a can, drinks it and gets to the end of the queue as two Leonards, and so on.
 *
 * <p>
   For example, Penny drinks the third can of cola and the queue will look like this:
   <pre>Rajesh, Howard, Sheldon, Sheldon, Leonard, Leonard, Penny, Penny</pre>
   </p>
 *
 * Write a program that will return the name of the person who will drink the n-th cola.
 <p> Note that in the very beginning the queue looks like that:</p>
 <pre>Sheldon, Leonard, Penny, Rajesh, Howard</pre>

 <p>##Input</p>
 <p>The input data consist of an array which contains at least 1 name, and single integer n.
    <pre> (1 ≤ n ≤ 1000000000).</pre>
 </p>
 *
 <p>##Output / Examples Return the single line — the name of the person who drinks the n-th can of cola.
 The cans are numbered starting from 1.
 Please note that you should spell the names like this: "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" (without the quotes).
 In that order precisely the friends are in the queue initially.
 </p>
 <p>
    <code>
    string[] names = new string[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
    </code>

    <p>
       <code>
       int n = 1;
       whoIsNext_MySolution(names, n) --> "Sheldon"
       </code>
   </p>

   <p>
     <code>
     int n = 6;
     whoIsNext_MySolution(names, n) --> "Sheldon"
     </code>
   </p>

   <p>
      <code>
      int n = 52;
      whoIsNext_MySolution(names, n) --> "Penny"
      </code>
   </p>
   <p>
     <code>
     int n = 7230702951;
     whoIsNext_MySolution(names, n) --> "Leonard"
     </code>
    </p>
 </p>
 */
public class DoubleCola {
    public static void main(String[] args) {
       System.out.println(whoIsNext_MySolution(names,28643950));
    }

    /**
     * Calculated every possible range of appearance of a name, then check again the input n -> if n in range -> return that name.
     * @param names names
     * @param n n
     * @return the found name.
     */
    private static String whoIsNext_MySolution(String[] names, int n)
    {
        for(int i = 1 ; i <= names.length; i++)
        {
            List<List<Integer>> appearanceRange = appearanceRange(names, i, n);

            Optional<List<Integer>> first = appearanceRange.stream()
                                            .filter(range ->
                                                   (range.size() == 1 && range.get(0) == n)  || (range.size() == 2 && range.get(0) <= n && n < range.get(1)) )
                                            .findFirst();

            if(first.isPresent())
                return names[i-1];
        }
        return null;
    }

    /**
     * This looks to me like a bacteria doubles every time.
     * This is my observation for the appearance position of the string.
     *    <ul>S 1  6->7    16->19   36->43
     <li>2nd run:  6 is because after 1 is 4 elements, so starting 2-5 -> 6 is next</li>
     <li>3rd run: 16 is because we end at 7, and we have doubled of 2345, which is 22_33_44_55 -> 16</li>
     <li>4th run: 36 is because we end at 19, and we have 4 times of 2345, which is 2222_3333_4444_5555 -> 36</li>
     </ul>
     <ul>L 2  8->9    20->23   44->51
     <li>2nd run: 8 is because after 2 is 345, and 1 is doubled -> 34511 -> 8 is next</li>
     <li>3rd run: 20 is because we end at 9, and we have doubled of 345, four times 1, which is 33_44_55_1111 -> 20</li>
     <li>4th run: 44 is because we end at 23, and we have 4 times of 345, 8 times 1, which is 3333_4444_5555_11111111 -> 44</li>
     </ul>

     <ul>P 3  10->11  24->27   52->59
     <li>2nd run: 10 is because after 3 is 45, and we have 11 and 22 -> 451122 -> 10 is next</li>
     <li>3rd run: 24 is because we end at 11, and we have doubled of 45, four times 1 and four times 2 -> 44_55_1111_2222 -> 24</li>
     <li>4th run: 52 is because we end at 27, and we have 4444_5555_11111111_22222222 -> 52</li>
     </ul>

     <ul>R 4  12->13  28->31
     <li>2nd run: 12 is because after 4 is 5, and we have 11, 22 and 33 -> 5112233 -> 12 is next</li>
     <li>3rd run: 28 is because we end at 13, and we have doubled of 5, four times 1 and four times 2
     and four times 3 -> 55_1111_2222_3333 -> 28</li>
     <li>4th run: 60 is because we end at 31, and we have 5555_11111111_22222222_33333333 -> 60</li>
     </ul>

     <ul>H 5  14->15  32->35
     <li>2nd run: 14 is because after 5 we have 11 ,22 ,33 and 44, -> 14 is next</li>
     </ul>
     * @param names
     * @param pos
     * @param max
     * @return
     */
    private static List<List<Integer>> appearanceRange(String[] names, int pos, int max)
    {
        ArrayList<List<Integer>> rangeList = new ArrayList<>();
        rangeList.add(Arrays.asList(pos));
        int count = 1;
        int tmpPos = pos;
        // supposed we start from 1
        int howManyBeforePos = pos - 1;
        int howManyAfterPos = names.length - pos;
        while(tmpPos < max)
        {
            int jump = howManyBeforePos * (int) Math.pow(2,count);
            jump += howManyAfterPos * (int) Math.pow(2,count-1);

            int rangeSize = (int) Math.pow(2, count);
            List<Integer> range = new ArrayList<>(2); // only contains first and last element
            // figure out the first pos in range
            int start = tmpPos + jump + 1;
            range.add(start); // first
            range.add(start + rangeSize - 1); // first

            rangeList.add(range);
            // figure out next pos
            tmpPos = range.get(1) ;
            count++;
        }
        return rangeList;
    }

    /**
     * A naive solution, which first step is to build the whole list up to n.
     * Then get the first one.
     * @param names initial names
     * @param n  the nth pos
     * @return the nth string
     */
    private static String whoIsNextNaive(String[] names, int n)
    {
        List<String> tmp = new ArrayList<>(Arrays.asList(names));
        int i = 1 ;
        while( i < n )
        {
            String curr = tmp.get(0);
            tmp.add(curr);
            tmp.add(curr);
            i++;
            tmp.remove(0);
        }
        return tmp.get(0);
    }

    private static String whoIsNext(String[] names, int n){
        while ( n > names.length){
            n = (n - (names.length - 1)) / 2;
        }
        return names[n-1];
    }
    private static String whoIsNext2(String[] names, int n)
    {
        // starts with index 1, but we as programmers know that counting starts with 0...
        n--;
        long qlength = names.length;
        while(qlength <= n) {
            n -= qlength;
            qlength *= 2;
        }
        return names[(int)(n / (qlength / names.length))];
    }
    private static String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
}
