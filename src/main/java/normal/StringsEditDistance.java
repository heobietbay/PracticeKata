package normal;

/**
 * This problem was asked by Google.
 *
 <p>The edit distance between two strings refers to the minimum number of character insertions,
   deletions, and substitutions required to change one string to the other.
   For example, the edit distance between <font color='blue'>"kitten"</font>
       and <font color='blue'>"sitting"</font> is three:
   substitute the <b>"k"</b> for <b>"s"</b>, substitute the <b>"e"</b> for <b>"i"</b>, and append a <b>"g"</b>.
 </p>
 * Given two strings, compute the edit distance between them.
 */
public class StringsEditDistance {
    public static void main(String[] args) {
        String s1 = "kitten";
        String s2 = "sitting";
        int distance = solution(s1,s2);
    }

    public static int solution(String s1, String s2) {
        return 0;
    }
}
