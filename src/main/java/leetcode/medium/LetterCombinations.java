package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <pre>
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 2 - abc
 3 - def
 4 - ghi
 5 - jkl
 6 - mno
 7 - pqrs
 8 - tuv
 9 - wxyz

 Example:
 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 * </pre>
 */
public class LetterCombinations {

    public static void main(String[] args) {
        System.out.println(solution("5678"));
    }

    public static List<String> solution(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return result;
        else if (digits.length() == 1)
        {
            return numberCharacterMap.get(digits.charAt(0)).stream().map(character -> character.toString()).collect(Collectors.toList());
        }
        List<Character> initialChars = numberCharacterMap.get(digits.charAt(0));

        for(Character ch : initialChars)
        {
            List<String> strings = generateWords(digits, 1);
            for(String st : strings)
            {
                result.add(ch + st);
            }
        }
        return result;
    }

    private static List<String> generateWords( String digitArray, int startFrom) {
        List<Character> initialChars = numberCharacterMap.get(digitArray.charAt(startFrom));
        if(startFrom == digitArray.length() - 1)
        {
            return initialChars.stream().map(character -> character.toString()).collect(Collectors.toList());
        }
        List<String> temp = new ArrayList<>();
        List<String> words = generateWords(digitArray, startFrom + 1);
        for(Character initial : initialChars)
        {
            for(String w : words)
            {
                temp.add(initial + w);
            }
        }
        return temp;
    }


    static Map<Character,List<Character>> numberCharacterMap = new HashMap<>();
    static {
        numberCharacterMap.put('2', Arrays.asList('a','b','c'));
        numberCharacterMap.put('3', Arrays.asList('d','e','f'));
        numberCharacterMap.put('4', Arrays.asList('g','h','i'));
        numberCharacterMap.put('5', Arrays.asList('j','k','l'));
        numberCharacterMap.put('6', Arrays.asList('m','n','o'));
        numberCharacterMap.put('7', Arrays.asList('p','q','r','s'));
        numberCharacterMap.put('8', Arrays.asList('t','u','v'));
        numberCharacterMap.put('9', Arrays.asList('w','x','y','z'));
    }
}
