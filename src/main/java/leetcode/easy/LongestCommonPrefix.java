package leetcode.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 Note:
 All given inputs are in lowercase letters a-z.
 <pre>
 Example 1:

 Input: ["flower","flow","flight"]
 Output: "fl"

 Example 2:

 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 </pre>
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String solution = solution(new String[]{"flower", "flow", "flight"});
        System.out.println(solution);
    }

    public static String solution(String[] strs) {
        return "";
    }
}
