package normal;

import java.util.Arrays;

/**
 * This problem was asked by Amazon.
 *
 * <p>
  Run-length encoding is a fast and simple method of encoding strings.
  The basic idea is to represent repeated successive characters as a single count and character.
  <pre>For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".</pre>
  </p>
 * Implement run-length encoding and decoding.
  <li>You can assume the string to be encoded have no digits and consists solely of alphabetic characters. </li>
  <li>You can assume the string to be decoded is valid.</li>
 */
public class RunlengthEncoding {
    public static void main(String[] args) {
        System.out.println(solution("AAAABBBCCDAA"));
        System.out.println(solution("ABBBAACCDEE"));
    }

    public static String solution(String inp)
    {
        int tmpCount = 0;
        char curChar = inp.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(char c : inp.toCharArray())
        {
            if(curChar == c)
            {
                tmpCount++;
            }
            else
            {
                sb.append(tmpCount + "" + curChar);
                tmpCount = 1;
                curChar = c;
            }
        }
        sb.append(tmpCount + "" + curChar);
        return sb.toString();
    }

    private static int[] charCounts = new int[26];
    static {
        Arrays.fill(charCounts,0);
    }
}
