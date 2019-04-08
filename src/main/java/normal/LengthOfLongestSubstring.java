package normal;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *     LeetCode.
 Given a string, find the length of the longest substring without repeating characters.

 Example 1:

 Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.

 Example 2:

 Input: "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.

 Example 3:

 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * </pre>
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int longest = solutionUsingSet("pwwkew");
        System.out.println(longest);

        longest = solutionUsingSet("abcabcbb");
        System.out.println(longest);

        longest = solutionUsingSet("bbbbb");
        System.out.println(longest);

        longest = solutionUsingSet(" ");
        System.out.println(longest);

        longest = solutionUsingSet("au");
        System.out.println(longest);

        longest = solutionUsingSet("bwf");
        System.out.println(longest);
    }

    /**
     * @param s
     * @return
     */
    public static int solutionUsingSet(String s) {
        if(s.length() < 2)
            return s.length();
        int longest = 0;
        char[] chArray = s.toCharArray();

        Set<Character> chSet = new HashSet<>();

        for(int i = 0 ;
            i < chArray.length -1 ;
            )
        {
            chSet.add(chArray[i]);
            // check the portion from (i , j] for duplicate char
            for(int j = i +1 ; j < chArray.length; j++) {
                if(chSet.contains(chArray[j]))
                {
                    longest = longest < chSet.size() ? chSet.size() : longest;
                    chSet.clear();
                    i++;
                    break;
                }
                chSet.add(chArray[j]);
            }
        }
        return longest;
    }
}
