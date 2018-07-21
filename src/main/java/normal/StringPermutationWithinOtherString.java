package normal;

import java.util.*;

/**
 * Given a smaller string <font color='blue'>s</font> and a bigger string <b>b</b>, design an algorithm to find
 * all permutations of the shorter string within the longer one. Print the location of each permutation.
 */
public class StringPermutationWithinOtherString {
    public static void main(String[] args) {
        List<Integer> idxs = solution_HashMap("abbc","cbabadcbbabbcbabaabccbabc");
        idxs.forEach( idx -> System.out.println(idx));
        idxs = solution_Sort("abbc","cbabadcbbabbcbabaabccbabc");
        idxs.forEach( idx -> System.out.println(idx));
    }
    private static List<Integer> solution_Sort(String s, String b)
    {
        if(s == null || b == null || s.length() >= b.length())
        {
            throw new IllegalArgumentException("Input not valid. s and b must be provided and s < b.");
        }
        char[] sortedS = s.toCharArray();
        Arrays.sort(sortedS);

        List<Integer> lst = new ArrayList<>();
        int sLen = s.length();
        for(int i = 0 ; i <= b.length() - sLen; i++)
        {
            String tmp = b.substring(i, i+sLen);
            char[] sortedTmp = tmp.toCharArray();
            Arrays.sort(sortedTmp);
            if(Arrays.equals(sortedS,sortedTmp))
            {
                lst.add(i);
            }
        }
        return lst;
    }
    private static List<Integer> solution_HashMap(String s, String b)
    {
        if(s == null || b == null || s.length() >= b.length())
        {
            throw new IllegalArgumentException("Input not valid. s and b must be provided and s < b.");
        }
        List<Integer> lst = new ArrayList<>();
        int sLen = s.length();
        for(int i = 0 ; i <= b.length() - sLen; i++)
        {
            String temp = b.substring(i, i+sLen);
            if(isPermutationOf_HashMap(s,temp))
            {
                lst.add(i);
            }
        }
        return lst;
    }

    private static boolean isPermutationOf_HashMap(String s, String temp) {
        Map<Character,Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray())
        {
            if(!countMap.containsKey(Character.valueOf(c)))
                countMap.put(Character.valueOf(c),1);
            else
                countMap.put(Character.valueOf(c),countMap.get(Character.valueOf(c)) + 1);
        }
        for(char c : temp.toCharArray())
        {
            if(countMap.containsKey(Character.valueOf(c)))
            {
                countMap.put(Character.valueOf(c),countMap.get(Character.valueOf(c)) - 1);
            }
            else
            {
                return false;
            }
        }
        return !countMap.values().stream().filter( x -> x!= 0).findFirst().isPresent();
    }
}
