package normal;

import java.util.Arrays;
import java.util.List;

/**
 * This problem was asked by Palantir.
 *
 * Write an algorithm to justify text. Given a sequence of words and an integer line length <font color='blue'>k</font>,
 * return a list of strings which represents each line, fully justified.
 *
 * More specifically, you should have as many words as possible in each line.
   <ul>
      <li>There should be at least one space between each word.</li>
       <li>Pad extra spaces when necessary so that each line has exactly length <font color='blue'>k</font>.</li>
       <li>Spaces should be distributed as equally as possible, with the extra spaces, if any,
       distributed starting from the left.</li>
       <li>If you can only fit one word on a line, then you should pad the right-hand side with spaces.</li>
   </ul>
 *
 * Each word is guaranteed not to be longer than <font color='blue'>k</font>.
  <pre>
  For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
  and <font color='blue'>k = 16</font>, you should return the following:
 *
 * ["the  quick brown", # 1 extra space on the left
 * "fox  jumps  over", # 2 extra spaces distributed evenly
 * "the   lazy   dog"] # 4 extra spaces distributed evenly
 </pre>
 */
public class TextJustify {
    public static void main(String[] args) {
        List<String> inp = Arrays.asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog");
        List<String> outp = solution(inp,16);
    }

    public static List<String> solution(List<String> inp, int k) {
        return null;
    }
}
