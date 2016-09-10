package easy;

/**
 * Created by khoa on 2/18/2016.
 */
public class ArrayReverse {
    /*
    Given an array,A, describe an efficient algorithm for reversing A. For example,
    if A=[3, 4, 1, 5], then its reversal is A=[5, 1, 4, 3]. You can only use O(1)
    memory in addition to that used by A itself. What is the running time of your
    algorithm?
    * */

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6};
        reverse(arr);
        for(int a : arr)
        {
            System.out.println(a);
        }

        arr = new int[] {3, 4, 1, 5};
        reverse(arr);
        for(int a : arr)
        {
            System.out.println(a);
        }
    }
    static void reverse(int[] arr)
    {
        for(int i = 0 ; i < arr.length /2 ; i ++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}
