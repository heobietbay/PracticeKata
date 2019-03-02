package normal;

import java.util.*;

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
        String case2 = solution("aecifigeh", new char[]{'e', 'a', 'i'});
        System.out.println(case2);
        String case3 = solution("cifiaegeh", new char[]{'e', 'a', 'i'});
        System.out.println(case3);
    }
    public static String solution(String inp, char[] charSet)
    {
        // for each char, find where it appears
        Map<Character, List<Integer>> characterPosMap = new HashMap<>();
        for(int charIdx = 0 ; charIdx < charSet.length; charIdx++)
        {
            char toFindCh = charSet[charIdx];
            for(int i = 0 ; i < inp.length(); i++)
            {
                char ci = inp.charAt(i);
                if(toFindCh == ci)
                {
                    if(characterPosMap.get(toFindCh) == null)
                    {
                        ArrayList<Integer> posLst = new ArrayList<>();
                        characterPosMap.put(toFindCh, posLst);
                        posLst.add(i);
                    }
                    else
                    {
                        characterPosMap.get(toFindCh).add(i);
                    }
                }
            }
        }
        // not every character has a position in the input -> return null
        if(characterPosMap.keySet().size() != charSet.length)
            return null;

        characterPosMap.forEach( (ch,pos) -> {
            System.out.println(ch+"_"+ Arrays.toString(pos.toArray()));
        } );
        return null;
    }
    public static String solutionOld(String inp, char[] charSet)
    {
        Integer foundIdx = null;
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
