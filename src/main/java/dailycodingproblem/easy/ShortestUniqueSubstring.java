package dailycodingproblem.easy;

import java.util.*;

public class ShortestUniqueSubstring {
    public static void main(String[] args) {
        String inp = "zyzyzyz";
        String shortestSubStr = solution(inp);
        System.out.println(shortestSubStr);
    }

    private static String solution(String inp) {
        Map<String, Integer> stringMap = new HashMap<>();
        for (int i = 0 ; i < inp.length()-1; i++)
        {
            for(int j = i + 1; j < inp.length(); j++)
            {
                String substring = inp.substring(i, j + 1);
                int count = stringMap.containsKey(substring) ? stringMap.get(substring) : 0;
                stringMap.put(substring, count + 1);
            }
        }
        String res = inp;
        for(Map.Entry<String, Integer> entry : stringMap.entrySet())
        {
            if(entry.getValue() == 1)
            {
                if(res.length() > entry.getKey().length())
                    res = entry.getKey();
            }
        }
        return res;
    }


}
