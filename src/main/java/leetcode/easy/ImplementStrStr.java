package leetcode.easy;

/**
 * <pre>
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * </pre>
 * <pre>
  Example 1:
  Input: haystack = "hello", needle = "ll"
  Output: 2
 * </pre>
 * <pre>
 Example 2:
 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 * </pre>
 * <pre>
 <b>Clarification:</b>
 What should we return when needle is an empty string? This is a great question to ask during an interview.
 For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * </pre>
 *
 */
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if("".equals(needle))
            return 0;

        if(needle.length() > haystack.length())
            return -1;

        char[] needleArr = needle.toCharArray();
        int nidx = 0;  //needle runner
        int hdx = 0;// haystack runner
        while(nidx < needleArr.length && hdx < haystack.length())
        {
            //keep advance when matching char found
            if(needleArr[nidx] == haystack.charAt(hdx))
            {
                nidx++;
            }
            // else, reset the needle runner, and back the nidx step for the haystack runner
            else if(nidx != 0) {
                hdx -= nidx;
                nidx = 0;
            }
            hdx++;
        }
        if(nidx == needleArr.length && hdx!= 0) // we gothrough the needle len, and haystack
            return hdx - nidx;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello","el"));
        System.out.println(strStr("hello","he"));
        System.out.println(strStr("hello","lo"));
        System.out.println(strStr("aaaaa","bba"));
        System.out.println(strStr("",""));
        System.out.println(strStr("hellohenlo","henlo"));
    }
}
