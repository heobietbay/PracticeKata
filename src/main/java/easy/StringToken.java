package easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by khoa on 9/12/2016.
 */
public class StringToken {
    /*
    Given a string s , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens.
    We define a token to be one or more consecutive English alphabetic letters. Then, print the number of tokens, followed by each token on a new line.

    Input Format

    A single string, s.

    Constraints
    1 <= length of s <= 4*10^5
    s is composed of English alphabetic letters, blank spaces, and any of the following characters: !,?._'@

    Output Format

    On the first line, print an integer, n denoting the number of tokens in string s(they do not need to be unique).
    Next, print each of the n tokens on a new line in the same order as they appear in input string s.

    Sample Input

    He is a very very good boy, isn't he?

    Sample Output

    10
    He
    is
    a
    very
    very
    good
    boy
    isn
    t
    he
    Explanation

    We consider a token to be a contiguous segment of alphabetic characters.
    There are a total of 10 such tokens in string s, and each token is printed in the same order in which it appears in string s.

    */

    static void tokenize(String s)
    {
        /*
        String regex = "[!,?._ \\'@]";
        String[] temp = s.split(regex);
        System.out.println(temp.length);
        for(String t: temp)
        {
            System.out.println(t);
        }*/

        // Doing this way to avoid leading empty string
        // more here http://stackoverflow.com/questions/25451331/how-to-remove-empty-results-after-splitting-with-regex-in-java
        Pattern p = Pattern.compile("[A-Za-z]+");
        Matcher m = p.matcher(s);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            count++;
            sb.append(m.group()).append("\n");
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        tokenize("He is a very very good boy, isn't he?");
    }
}
