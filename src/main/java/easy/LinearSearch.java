package easy;

/**
 * Created by khoa on 3/3/2016.
 */
public class LinearSearch {

    public static void main(String[] args) {
        System.out.println(search(SAMPLE_2,13));
    }

    /**
     * This search function assume we always find the desired item in a list.
     * By placing it at the end of the arr.
     * This way, we always get the item index, and then we check if that idx satisfy our condition.
     * Doing this way eliminates the need to check every time we loop when finding item.
     * @param arr input array
     * @param inp item to find
     * @return idx of the item, or -1 if not found
     */
    static int search(int[] arr, int inp) {

        int last = arr[arr.length - 1];
        arr[arr.length - 1] = inp;
        int i = 0 ;
        while (arr[i] != inp)
        {
            i++;
        }
        arr[arr.length - 1] = last;
        if(i < arr.length - 1 || arr[arr.length - 1] == inp )
        {
            return i;
        }
        return -1;
    }

    static int[] SAMPLE_1 = {0, 1, 2, 3, 4, 5};

    static int[] SAMPLE_2 = {8, 13, 17, 23, 24, 25};
}
