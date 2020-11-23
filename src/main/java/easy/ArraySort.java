package easy;

import java.util.Comparator;

/**
 * Created by khoa on 2/13/2016.
 */
public class ArraySort {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8,-8,-7,-6,-4,-3};

        insertionSort_NegativeIncreasePositiveDecrease(arr);

        for(int i : arr)
        {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    static void insertionSortDescending(int[] arr)
    {
        insertionSort(arr,Comparator.naturalOrder());
    }
    static void insertionSort_NegativeIncreasePositiveDecrease(int[] arr)
    {
        Comparator<Integer> comparator = (a1, a2) -> {
            if(a1 <0 && a2 < 0)
                return a2.compareTo(a1);
            return a1.compareTo(a2);
        };
        insertionSort(arr,comparator);
    }
    static void insertionSort(int[] arr, Comparator<Integer> comparator)
    {
        for(int i = 1 ; i < arr.length; i++)
        {
            // inner loop, to insert an item to its correct pos
            for(int j = i; j > 0 ; j--)
            {
                if(comparator.compare(arr[j] , arr[j-1]) > 0)
                {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
