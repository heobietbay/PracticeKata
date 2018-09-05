package easy;

/**
 * Created by khoa on 2/6/2016.
 */
public class StringProcess {

    public static void main(String[] args) {

        String longInput = buildLongString(1_000_000,"This ,is a vaery looooooooooooooongggggggggggggggggggggggggg long worddddddddddddddddd.");
        longestStringSlow(longInput);
    }
    private static void longestStringSlow(String longInput) {
        long start1 = System.currentTimeMillis();
        String s1 = searchLongestStringBySplit(longInput);
        System.out.println((System.currentTimeMillis() - start1));
        System.out.println(s1);
    }
    static String searchLongestStringBySplit(String inp)
    {
        String regex =  "[" + new String(excludeChars) + "]";

        String[] temps = inp.split(regex);

        String flag = null;

        for(String t : temps)
        {
            if(flag == null ||  flag.length() < t.length())
            {
                flag = t;
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
    static void splitWordInString(String input) {

        StringBuilder temp = new StringBuilder("");
        boolean wordEncounter = false; //each time we encounter a word, we increase the count
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isExcludeChar(c)) {
                if (wordEncounter) {
                    wordEncounter = false;
                    System.out.println(temp);
                    temp = new StringBuilder();
                }
            } else {
                wordEncounter = true;
                temp.append(c);
            }
        }
        if(wordEncounter) // EOF
        {
            System.out.println(temp);
        }
    }
    static int countWordInString(String input) {

        int count = 0;
        boolean wordEncounter = false; //each time we encounter a word, we increase the count
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isExcludeChar(c)) {
                if (wordEncounter) {
                    count++;
                    wordEncounter = false;
                }
            } else {
                wordEncounter = true;
            }
        }
        if(wordEncounter) // EOF
        {
            count++;
        }
        return count;
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
