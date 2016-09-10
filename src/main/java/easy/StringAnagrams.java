package easy;

import java.util.*;

/**
 * Created by khoa on 2/7/2016.
 */
public class StringAnagrams {
    /*
    Two strings A and B are called anagrams if they consist same characters, but may be in different orders. So the list of anagrams of CAT are "CAT", "ACT" , "TAC", "TCA" ,"ATC" and "CTA".

    Given two strings, print "Anagrams" if they are anagrams, print "Not Anagrams" if they are not. The strings may consist at most 50 english characters, the comparison should NOT be case sensitive.

    This exercise will verify that you are able to sort the characters of a string, or compare frequencies of characters.

    Sample Input 1

    anagram
    margana
    Sample Output 1:

    Anagrams

    Sample Input 2
    anagramm
    marganaa

    Sample Output 2:
    Not Anagrams
    */
    static boolean isAnagram(String A, String B) {
        //Complete the function
        if(A.length() != B.length())
        {
            return false;
        }
        char[] charA = A.toUpperCase().toCharArray();
        char[] charB = B.toUpperCase().toCharArray();

        List<Character> listA = new LinkedList<>();
        for(char c : charA)
        {
            listA.add(c);
        }

        List<Character> listB = new LinkedList<>();
        for(char c : charB)
        {
            listB.add(c);
        }

        Collections.sort(listA);
        Collections.sort(listB);
        for(int i = 0 ; i < listA.size(); i++)
        {
            if(listA.get(i) != listB.get(i))
            {
                return false;
            }
        }
        return true;
    }

    static boolean isAnagramByCounting(String A, String B) {
        int[] count = new int[26]; // if we only consider a to z. A = A.toLowerCase(); B = B.toLowerCase();
        int lenA = A.length();
        int lenB = B.length();

        if (lenA != lenB) return false;

        // initial count to 0.
        for (int i = 0; i < 26; i++)
        {
            count[i] = 0;
        }

        // count letter frequency in A
        for (int i = 0; i < lenA; i++)
        {
            int k = A.charAt(i) - 'a';
            count[k]++;
        }

        // minus letter frequency in B
        for (int i = 0; i < lenB; i++)
        {
            int k = B.charAt(i) - 'a';
            count[k]--;
            if (count[k] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        boolean ret=isAnagram(A,B);
        if(ret)
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");
    }
}
