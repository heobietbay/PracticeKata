package easy;

import java.util.*;

/**
 * Given 2 separate arrays, write a method to find the values that exist in both arrays and return them.
 */
public class ArrayFindSameValues {
    public static void main(String[] args) {
        int[] array1 = new int[] {1, 2, 3, 4, 5};
        int[] array2 = new int[] {4, 5,6,7,8,9,1};
        int[] sameValueArray = findSameValues_Better(array1,array2);

        System.out.println(Arrays.toString(sameValueArray));


        array1 = new int[] {1, 2, 3, 4, 5,10};
        array2 = new int[] {3,4, 5,6,7,8,9,10};
        sameValueArray = findSameValues_WhenBothArraysAreSorted(array1,array2);

        System.out.println(Arrays.toString(sameValueArray));
    }

    /**
     * Naive solution, probably O(n * m).
     * @param array1
     * @param array2
     * @return
     */
    private static int[] findSameValues(int[] array1, int[] array2) {
        List<Integer> tempLst = new ArrayList<>();
        for (int valArray1 : array1 ) {
            for(int val2 : array2)
            {
                if(valArray1 == val2)
                {
                    tempLst.add(valArray1);
                    break;
                }
            }
        }
        int[] res = new int[tempLst.size()];
        int idx = 0;
        for(Integer val : tempLst)
        {
            res[idx++] = val;
        }
        return res;
    }
    private static int[] findSameValues_Better(int[] array1, int[] array2) {
        Set<Integer> tempSet = new HashSet<>();
        for(int val : array1)
            tempSet.add(val);

        List<Integer> tempLst = new ArrayList<>();
        for(int val2 : array2)
        {
            if(tempSet.contains(val2))
            {
                tempLst.add(val2);
            }
        }
        int[] res = new int[tempLst.size()];
        int idx = 0;
        for(Integer val : tempLst)
        {
            res[idx++] = val;
        }
        return res;
    }

    private static int[] findSameValues_WhenBothArraysAreSorted(int[] array1, int[] array2)
    {
        Set<Integer> tempSet = new HashSet<>();

        int idxAr1 = 0;
        int idxAr2 = 0;
        while(idxAr1 < array1.length && idxAr2 < array2.length){
            if(array1[idxAr1] < array2[idxAr2])
            {
                idxAr1++;
            }
            else if(array1[idxAr1] > array2[idxAr2])
            {
                idxAr2++;
            }
            else
            {
                tempSet.add(array1[idxAr1]);
                idxAr1++;
                idxAr2++;
            }
        }

        int[] res = new int[tempSet.size()];
        int idx = 0;
        for(Integer val : tempSet)
        {
            res[idx++] = val;
        }
        return res;
    }
}
