package codility;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a string S containing lowercase English letters.
 * Your task is to calculate the minimum number of letters that need to be removed
   in order to make it possible to build a palindrome from the remaining letters.
 *  When building the palindrome, you can rearrange the remaining letters in any way.
 * A palindrome is a string that reads the same both forwards and backwards. Some examples of palindromes are: "kayak", "radar", "mom".
 * Write a function:
 * def solution(S)
 * which, given a string of length N, returns the minimum number of letters that need to be removed.
 * Examples:
 * 1. Given S = "ervervige", your function should return 2. After removing the letter "g" and one "e", we may create a word "reviver", which is a palindrome.
 * 2. Given S = "aaabab, your function should return 0. We may create a word "aabbaa", which is a palindrome and uses all the letters.
 * 3. Given S = "x", your function should return 0. String "x" is a palindrome itself, so we do not have to delete any letter.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..200,000):
 * S contains only lowercase English letters.
 */
public class StringPalindrome_MinimumRemoval {
    public static void main(String[] args) {
        List<Object[]> params = new ArrayList<>();
        params.add(new Object[]{ "xaxb", Integer.valueOf(solution("xaxb"))});
        params.add(new Object[]{ "ervervige", Integer.valueOf(solution("ervervige"))});
        params.add(new Object[]{ "aaabab", Integer.valueOf(solution("aaabab"))});
        params.add(new Object[]{ "grevivere", Integer.valueOf(solution("grevivere"))});

        params.stream().forEach( param -> {
            String msg = MessageFormat.format("{0}: {1}", param);
            System.out.println(msg);
        });
    }
    public static int solution(String inp) {
        if(isPalindrome(inp))
            return 0;
        int min = inp.length() - 1;
        StringBuilder sb = new StringBuilder(inp);
        for(int i = 0 ; i < sb.length(); i++) {
            char ci = sb.charAt(i);
            String sub = sb.deleteCharAt(i).toString();
            int count = solutionInner(sub, 1);
            if (min > count) {
                min = count;
            }
            sb.insert(i,ci);
        }
        return min;
    }

    private static int solutionInner(String inp, int curCount) {
        if(isPalindrome(inp)) {
            return curCount ;
        }
        for(int i = 0 ; i < inp.length(); i++) {
            StringBuilder sb = new StringBuilder(inp);
            String excludeI = sb.deleteCharAt(i).toString();
            if(isPalindrome(excludeI)) {
                return curCount + 1;
            }
        }
        return inp.length();
    }

    static boolean isPalindrome(String input){
        if(input.length() == 1) {
            return true;
        }
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
