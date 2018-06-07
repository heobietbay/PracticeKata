package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the first recurring character in the given string.
 * If there is no recurring character -> return null
 * <p>Example
 * <ul>
      <li>ABCA -> A</li>
      <li>BCABA -> B</li>
      <li>BACAB -> A</li>
      <li>ABC -> null</li>
 * </ul>
 * </p>
 */
public class FirstRecurringCharacter {
    public static void main(String[] args) {
        System.out.println(solution_nestedLoop("ABCA"));
        System.out.println(solution_nestedLoop("BCABA"));
        System.out.println(solution_nestedLoop("BACAB"));
        System.out.println(solution_nestedLoop("BCCAB"));
        System.out.println(solution_nestedLoop("ABC"));

        System.out.println(solution_usingSet("ABCA"));
        System.out.println(solution_usingSet("BCABA"));
        System.out.println(solution_usingSet("BACAB"));
        System.out.println(solution_usingSet("BCCAB"));
        System.out.println(solution_usingSet("ABC"));
    }

    private static Character solution_usingSet(String inp)
    {
        Set<Character> characterSet = new HashSet<>();
        for(char c : inp.toCharArray())
        {
            if(characterSet.contains(c))
            {
                return c;
            }
            characterSet.add(c);
        }
        return null;
    }
    private static Character solution_nestedLoop(String inp)
    {
        Integer firstReoccurPos = null;
        Character res = null;
        for(int i = 0; i < inp.length(); i++)
        {
            char ci = inp.charAt(i);
            if(Character.valueOf(ci) == res)
            {
                continue;
            }
            // loop through i+1 to end to find reoccur
            for(int j = i +1; j < inp.length(); j++)
            {
                char cj = inp.charAt(j);
                if(ci == cj)
                {
                    if(firstReoccurPos == null || firstReoccurPos > j)
                    {
                        firstReoccurPos = j;
                        res = Character.valueOf(ci);
                    }
                    break;
                }
            }
        }
        return res;
    }
}
