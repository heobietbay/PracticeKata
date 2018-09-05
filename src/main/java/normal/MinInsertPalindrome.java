package normal;

import java.util.Arrays;

/**
 * This problem was asked by Quora.
 * <p>
 *  Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word.
 *  If there is more than one palindrome of minimum length that can be made,
 *  return the lexicographically earliest one (the first one alphabetically).</p>
 *
 * <p>
 *  For example, given the string "race", you should return "ecarace", since we can add three letters to it
 *  which is the smallest amount to make a palindrome). There are seven other palindromes that can be made from "race"
 *  by adding three letters, but "ecarace" comes first alphabetically.
 * </p>
 * As another example, given the string "google", you should return "elgoogle".
 */
public class MinInsertPalindrome {

    public static void main(String[] args) {
        //TODO
        System.out.println(isPalindrome("race"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("elgoogle"));
        System.out.println(isPalindrome("ecarace"));
        System.out.println(isPalindrome("ab"));
    }

    static boolean isPalindrome(String input){
        char[] charArray = input.toCharArray();
        for(int i = 0 ; i < charArray.length/2 ; i++)
        {
            char cs = charArray[i]; // start
            char ce = charArray[charArray.length-i -1]; // end
            if(ce != cs)
                return false;
        }
        return true;
    }
}
