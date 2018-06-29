package normal;

/**
 * This problem was asked by Amazon.
 *
 * <p>
  Run-length encoding is a fast and simple method of encoding strings.
  The basic idea is to represent repeated successive characters as a single count and character.
  <pre>For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".</pre>
  </p>
 * Implement run-length encoding and decoding.
  <li>You can assume the string to be encoded have no digits and consists solely of alphabetic characters. </li>
  <li>You can assume the string to be decoded is valid.</li>
 */
public class RunlengthEncoding {
    public static void main(String[] args) {
        System.out.println(solution("AAAABBBCCDAA"));
    }

    private static String solution(String inp)
    {
        return inp;
    }
}
