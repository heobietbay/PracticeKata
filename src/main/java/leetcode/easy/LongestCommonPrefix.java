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

        solution = solution(new String[]{"dog","racecar","car"});
        System.out.println(solution);

        solution = solution(new String[]{"aa","a"});
        System.out.println(solution);
    }

    /**
     * As the problem state, we need to find the common prefix of ALL element in a array.
     * So we can just stop at the very first string that does not match the criteria.
     * We can use the first string as a base, and work from there.
     * @param strs
     * @return
     */
    public static String solution(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder("");
        String base = strs[0];

        outer:
        for(int i = 0; i < base.length(); i++)
        {
            char ch = base.charAt(i);
            for (int j = 1; j < strs.length; j++)
            {
                String temp = strs[j];
                if(i >= temp.length())
                    break outer;
                if(temp.charAt(i) != ch)
                    break outer;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
