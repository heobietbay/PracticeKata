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

        Set<Character> tmpChs = new HashSet<>();

        for(int i = 0 , j = i+1;
            i < chArray.length -1 && j < chArray.length ;
            j++)
        {
            // check the portion from (i , j] for duplicate char
            for(int idx = i ; idx <= j; idx++) {
                /*
                'A': 65
                'a': 97
                */
                Character chTemp = Character.valueOf(chArray[idx]);
                if(tmpChs.contains(chTemp))
                {
                    longest = longest < tmpChs.size() ? tmpChs.size() : longest;
                    i++;
                    // reset tmpChs
                    tmpChs.clear();
                    break;
                }
                else {
                    tmpChs.add(chTemp);
                }
                if(idx == j){
                    longest = longest < tmpChs.size() ? tmpChs.size() : longest;
                    // reset tmpChs
                    tmpChs.clear();
                }
            }
        }
        return longest;
    }
}
