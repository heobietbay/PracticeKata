package codility.lessons._2array;

import java.util.Arrays;

/**
 * Rotate an array to the right by a given number of steps.
 */
public class CyclicRotation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(solution(new int[]{0, 0, 0}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, 4)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, 2)));
    }
    public static int[] solution(int[] A, int K) {
        if(K == 0 || K == A.length) {
            return A;
        }

        int[] ints = new int[A.length];

        int right = K;
        int left = A.length - right;

        System.arraycopy(A, left, ints, 0, right);
        System.arraycopy(A, 0, ints, right, left);
        return ints;
    }
}
