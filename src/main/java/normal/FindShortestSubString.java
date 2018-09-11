package normal;

/**
 * This problem was asked by Square.
 <p>
 * Given a string and a set of characters, return the shortest substring containing all the characters in the set.
  <pre>
 * For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".
 </pre>
 * If there is no substring containing all the characters in the set, return null.
 </p>
 */
public class FindShortestSubString {
    public static void main(String[] args) {
        String case1 = solution("figehaeci", new char[]{'a', 'e', 'i'});
        System.out.println(case1);
        String case2 = solution("figehaeci", new char[]{'e', 'a', 'i'});
        System.out.println(case2);
    }

    public static String solution(String inp, char[] charSet)
    {
        Integer foundIdx = null;
        StringBuilder res = new StringBuilder();
        Integer rangeStart = null;
        Integer rangeEnd = null;
        for(int charIdx = 0 ; charIdx < charSet.length; charIdx++)
        {
            char toFindCh = charSet[charIdx];
            for(int i = 0 ; i < inp.length(); i++)
            {
                char ci = inp.charAt(i);
                if(toFindCh == ci)
                {
                    if(foundIdx == null || foundIdx < i)
                    {
                        foundIdx = i;
                    }
                }
            }
            if(foundIdx == null){
                return null;
            }
            else
            {
                if(rangeStart == null){
                    rangeStart = foundIdx;
                }
                else if(foundIdx > rangeStart)
                {
                    rangeEnd = foundIdx; // TODO: should we update rangeEnd everytime????
                }
                foundIdx = null;
            }
        }
        return inp.substring(rangeStart,rangeEnd+1);
    }
}
