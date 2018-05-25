package normal;

import java.util.*;

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
       whoIsNext(names, n) --> "Sheldon"
       </code>
   </p>

   <p>
     <code>
     int n = 6;
     whoIsNext(names, n) --> "Sheldon"
     </code>
   </p>

   <p>
      <code>
      int n = 52;
      whoIsNext(names, n) --> "Penny"
      </code>
   </p>
   <p>
     <code>
     int n = 7230702951;
     whoIsNext(names, n) --> "Leonard"
     </code>
    </p>
 </p>
 */
public class DoubleCola {
    public static void main(String[] args) {
        System.out.println(whoIsNext(names,28643950));
    }

    private static String whoIsNext(String[] names, int n)
    {
        List<String> tmp = new ArrayList<>(Arrays.asList(names));
        //List<String> tmp = new ArrayList<>();
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
    private static String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
}
