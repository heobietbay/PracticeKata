package easy;

/**
 * Created by khoa on 2/13/2016.
 */
public class ArraySort {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};

        insertionSort(arr);

        for(int i : arr)
        {
            System.out.println(i);
        }
    }

    static void insertionSort(int[] arr)
    {
        for(int i = 1 ; i < arr.length; i++)
        {
            // inner loop, to insert an item to its correct pos
            for(int j = i; j > 0 ; j--)
            {
                if(arr[j] > arr[j-1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}
