package easy;

import java.util.LinkedList;
import java.util.List;
/**
 * Created by khoa on 2/7/2016.
 */
public class StringCompare {
    /*
Given a string, find out the lexicographically smallest and largest substring of length k.

[Note: Lexicographic order is also known as alphabetic order dictionary order. So "ball" is smaller than "cat", "dog" is smaller than "dorm". Capital letter always comes before smaller letter, so "Happy" is smaller than "happy" and "Zoo" is smaller than "ball".]

Input Format

First line will consist a string containing english alphabets which has at most 1000 characters. 2nd line will consist an integer k.

Output Format

In the first line print the lexicographically minimum substring. In the second line print the lexicographically maximum substring.

Sample Input

welcometojava
3
Sample Output

ava
wel
Explanation

Here is the list of all substrings of length 3:

wel
elc
lco
com
ome
met
eto
toj
oja
jav
ava
Among them ava is the smallest and wel is the largest.
* */
    public static void main(String[] args) {

        String inp = "welcometojava";
        int len = 3;

        List<String> list = new LinkedList<>();

        String biggest = inp.substring(0,len);
        String smallest = biggest;  // actually inp.substring(0,len), but this is same anyway.

        for(int i = 0 ; i <= inp.length() - len; i++)
        {
            String s = inp.substring(i,i+len);
            if(biggest.compareTo(s) < 0)
            {
                biggest = s;
            }
            if(smallest.compareTo(s) > 0)
            {
                smallest = s;
            }
        }

        System.out.println(smallest);
        System.out.println(biggest);
    }
}
