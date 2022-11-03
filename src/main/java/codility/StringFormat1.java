package codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Prepare a notification of the given message which will be displayed on a mobile device.
The message is made of words separated by single spaces.
The length of the notification is limited to K characters.
If the message is too long to be displayed fully, some words from the end of the message should be cropped, keeping in mind that:
  the notification should be as long as possible;
  only whole words can be cropped;
  if any words are cropped, the notification should end with "..."; the dots should be separated from the last word by a single space;
  the notification may not exceed the K-character limit, including the dots.

If all the words need to be cropped, the notification is "..." (three dots without a space).

For example, for message = "And now here is my secret" and K = 15, the notification is "And now ...". Note that:
  the notification "And ..." would be incorrect, because there is a longer correct notification;
  the notification "And now her ..." would be incorrect, because the original message is cropped through the middle of a word;
  the notification "And now ... " would be incorrect, because it ends with a space;
  the notification "And now here..." would be incorrect, because there is no space before the three dots;
  the notification "And now here ..." would be incorrect, because it exceeds the 15 characters limit.

Write a function:

class Solution { public String solution (String message, int K); }

that, given a string message and an integer K, returns the notification to display, which has no more than K characters, as described above.

Examples:
1. For message = "And now here is my secret" and K = 15, the function should return "And now ...", as explained above.
2. For message = "There is an animal with four legs" and K = 15, the function should return
   "There is an ...".
3. For message = "super dog" and K = 4, the function should return "...".
4. For message = "how are you" and K = 20, the function should return "how are you"
*/
public class StringFormat1 {
    public static void main(String[] args) {
        System.out.println(solution("And now here is my secret", 15));
        System.out.println(solution("There is an animal with four legs", 15));
        System.out.println(solution("super dog", 4));
        System.out.println(solution("how are you", 20));
    }
    public static String solution (String message, int K) {
        if(K >= message.length())
            return message;

        String[] words = message.split(" ");

        if(words[0].length() > K)
            return "...";

//        List<String> lst = Arrays.asList(words);
//        int max = K;
//        for(int i = 0 ; i < words.length; i++) {
//            max = max - words[i].length() - 1; // 1 is whitespace
//            if(max <= 3) {
//                int to = max == 3 ? i + 1 : i;
//                String res = lst.subList(0, to).stream().collect(Collectors.joining(" "));
//                return res + " " + "...";
//            }
//        }

        int lastWhiteSpacePos = -1;
        for(int i = 0 ; i < message.length() ; i++) {
            if(message.charAt(i) == ' ') {
                if( i <= K - 3) {
                    lastWhiteSpacePos = i;
                }
            }
        }
        if(lastWhiteSpacePos != -1 ) {
           return message.substring(0, lastWhiteSpacePos) + " ...";
        }
        return message;
    }
}
