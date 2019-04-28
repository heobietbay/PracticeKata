package easy;

/**
 * You are given an array of <b>n + 1</b> elements.
 * All elements of the array are in range <b>1 to n</b>.
 * And all elements occur once except <font color = 'red'>a number</font> which occur <font color = 'red'>twice</font>.
 * Find the repeating number.
 * <pre>
 * For example, array = {4, 2, 5, 2, 3, 1} and n = 5
 *
 * The above array has n + 1 = 6 elements with all elements occurring once except 2 which occurs twice.
 * So the output should be 2.
 * </pre>
 */
public class FindDuplicateInteger_UsingXOR {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 2, 3, 1};
        int repeatedNumber = solution(arr,5);
        System.out.println(repeatedNumber);
    }

    /**
     * XOR rules:
     * <ol>
     *     <li>A XOR 0 = A</li>
     *     <li>A XOR A = 0</li>
     *     <li>(A XOR B) XOR C = A XOR (B XOR C)</li>
     *     <li>(B XOR A) XOR A = B XOR 0 = B</li>
     * </ol>
     *
     * We can see that if there NO duplicate, then the array XOR each of each element will return 0.
     * A XOR A = 0;
     * Knowing this, we can detect the only duplicate by XORing each of array element with 1...n
     <pre> For ex, given an array:
               4, 2, 5, 2, 3, 1
               n = 5
     (4 ^ 2 ^ 3 ^ 1 ^ 2)  ^ (1 ^ 2 ^ 3 ^ 4) returns 2 as the only duplicate
     </pre>
     * @param arr
     * @param n
     * @return
     */
    public static int solution(int[] arr, int n)
    {
        int seed = 0 ;
        for(int i = 1; i <=n ; i++)
        {
            seed = seed ^ i;
        }
        for (int el : arr)
        {
            seed = seed ^ el;
        }
        return seed;
    }
}
