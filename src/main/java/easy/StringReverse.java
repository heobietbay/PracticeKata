package easy;

import java.util.Scanner;

/**
 * Created by khoa on 2/7/2016.
 */
public class StringReverse {

    /*
    A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.(Wikipedia)
    Given a string A, print "Yes" if it is a palindrome, print "No" otherwise. The strings will consist lower case english letters only.
    The strings will have at most 50 characters.
    Some examples of palindromes are "madam", "anna", "reviver".

    Sample Input

    madam
    Sample Output

    Yes
    */public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String res = "Yes";
        for(int i = 0 ; i < A.length()/2 ; i ++)
        {
            char c = A.charAt(i);
            char mirror = A.charAt(A.length() - i -1);
            if(c!=mirror)
            {
                res = "No";
                break;
            }
        }
        System.out.println(res);
    }
}
