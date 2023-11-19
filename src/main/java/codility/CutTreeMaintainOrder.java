package codility;

import java.util.Arrays;

public class CutTreeMaintainOrder {
    public static void main(String[] args) {
        System.out.println(solutionNaive(new int[] {3, 4, 5, 4}));
        System.out.println();

        System.out.println(solutionNaive(new int[] {1,2,3,4,5}));
        System.out.println();

        System.out.println(solutionNaive(new int[] {4,5,2,3,4}));
        System.out.println();

        System.out.println(solutionNaive(new int[] {1, 5, 6, 5}));
        System.out.println();

        System.out.println(solutionNaive(new int[] {1, 1, 9, 1, 1}));
    }

    /**
     * Simplest solution.
     * Cut every tree and see if remaining arrays is ordered.
     * @param trees
     * @return
     */
    private static int solutionNaive(int[] trees) {
        int count = 0;
        System.out.println("Input: " + Arrays.toString(trees));
        int[] temps = new int[trees.length - 1];
        for(int i = 0 ; i < trees.length; i++) {
            int idx = 0;
            for(int j = 0; j < trees.length; j++) {
                if(j == i) {
                    continue;
                }
                temps[idx] = trees[j];
                if(idx != 0  && temps[idx] < temps[idx - 1]) {
                    break;
                }
                idx++;
            }
            if(idx == trees.length - 1) {
                count++;
                System.out.println("Cut tree " + trees[i] + " at index " + i);
            }
        }
        return count;
    }
}
