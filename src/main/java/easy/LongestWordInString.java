package easy;

import java.text.MessageFormat;

public class LongestWordInString {

    public static void main(String[] args) {
        String longInput = buildLongString(1_000_000,"This ,is a vaery looooooooooooooongggggggggggggggggggggggggg long worddddddddddddddddd.");
        System.out.println(MessageFormat.format( "Longest word is: {0}",solution(longInput)));
    }

    private static String solution(String input) {
        StringBuilder temp = new StringBuilder("");
        String flag = null;
        boolean wordEncounter = false; //each time we encounter a word, we increase the count
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isExcludeChar(c)) {
                if (wordEncounter) {
                    wordEncounter = false;
                    if(flag == null || flag.length() < temp.length())
                    {
                        flag = temp.toString();
                    }
                    temp = new StringBuilder();
                }
            } else {
                wordEncounter = true;
                temp.append(c);
            }
        }
        if(wordEncounter) // EOF
        {
            if(flag == null || flag.length() < temp.length())
            {
                flag = temp.toString();
            }
        }
        return flag;
    }

    static String buildLongString(int times,String inp)
    {
        StringBuilder stringBuilder = new StringBuilder(inp);
        int count = 0;
        while(count < times)
        {
            stringBuilder.append(" ").append(inp);
            count++;
        }
        return stringBuilder.toString();
    }

    static final char[] excludeChars = {' ', '!', '@', '.', ',','?', '\'','_'};

    static boolean isExcludeChar(char c) {
        for (int i = 0; i < excludeChars.length; i++) {
            if (c == excludeChars[i]) {
                return true;
            }
        }
        return false;
    }
}
