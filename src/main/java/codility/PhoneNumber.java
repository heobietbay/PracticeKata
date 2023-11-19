package codility;

/**
 * We are given a string S representing a phone number, which we would like to reformat. String S consists of N characters: digits, spaces and/or dashes.
 * It contains at least two digits.
 *
 * Spaces and dashes in string S can be ignored.
 * We want to reformat the given phone number in such a way that the digits are grouped in blocks of length three, separated by single dashes.
 * If necessary, the final block or the last two blocks can be of length two.
 *
 * For example, given string S = "00-44 48 5555 8361", we would like to format it as "004-448-555-583-61".
 *
 * Write a function that, given a string S representing a phone number, returns this phone number reformatted as described above.
 *
 * For example, given S = "00-44 48 5555 8361", the function should return "004-448-555-583-61". Given S ="0 - 22 1985--324",the function should return "022-198-53-24".
 * Given S = "555372654", the function should return "555-372-654".
 *
 * Assume that N is an integer within the range [2..100]; string S consists only of digits (0?9), spaces and/or dashes (-); string S contains at least two digits.
 */
public class PhoneNumber {

    public static void main(String[] args) {
        System.out.println(solution("0 - 22 1985--324"));
        System.out.println(solution("555372654"));
        System.out.println(solution("00-44 48 5555 8361"));
    }

    private static String solution(String inp) {
        // step 1: remove non digit char
        char[] digitChars = inp.replaceAll(REGEX_NON_DIGIT,"").toCharArray();
        StringBuilder formattedNumSb = new StringBuilder();

        int blockSize = BLOCK_SIZE_3;
        int start = 0;
        int len = digitChars.length;
        // Step 2: greedy loop and append, each time append blockSize chars
        //    change blockSize if needed
        while (len > 0)
        {
            formattedNumSb.append(digitChars, start,  blockSize);
            formattedNumSb.append("-");
            start += blockSize;
            len -= blockSize;
            if(blockSize > len && len != 0) {
                int temp = blockSize;
                blockSize = SUM_BLOCK_SIZE - blockSize;
                if(blockSize > len) {
                    // revert process
                    // delete `-` of line 41
                    formattedNumSb.deleteCharAt(formattedNumSb.length() - 1);

                    // delete last temp char
                    formattedNumSb.delete(formattedNumSb.length() - temp, formattedNumSb.length());
                    start = start - temp;
                    len += temp;
                }
            }
        }
        formattedNumSb.deleteCharAt(formattedNumSb.length()-1); // delete the dash
        return formattedNumSb.toString();
    }

    private static String readInput(String[] args) {
        return "555372654";
    }

    static final String REGEX_NON_DIGIT = "[^0-9]";
    static final int SUM_BLOCK_SIZE = 5;           // we have block size 3 and 2, so sum would be 5;
    static final int BLOCK_SIZE_3 = 3;
}

