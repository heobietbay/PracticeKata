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
 * <p>Please read MinimumEditDistance.pdf - within this folder - for study about and applications of this</p>
 */
public class StringsEditDistance {
    public static void main(String[] args) {
        String s1 = "kitten";
        String s2 = "sitting";
        int distance = solution(s1,s2);
        System.out.println(distance);
        System.out.println(solution("geek","gesek"));
        System.out.println(solution("sunday","saturday"));
        System.out.println(solution("nothing","o"));
        System.out.println(solution("ATCAT","ATTATC"));
    }

    /**
     * @param s1
     * @param s2
     * @return
     */
    public static int solution(String s1, String s2) {
        int maxEditDistance = s1.length() > s2.length() ? s1.length() : s2.length();
        /*
        int lastIntersectPoint = 0;
        for(int i = 0; i < s1.length() ; )
        {
            char c1 = s1.charAt(i);
            for(int j = lastIntersectPoint ; j < s2.length(); j++)
            {
                char c2 = s2.charAt(j);
                if(c1 == c2)
                {
                    maxEditDistance -= 1 ;
                    lastIntersectPoint = j + 1;
                    break;
                }
            }
            i++;
        }*/
        return maxEditDistance;
    }
}
