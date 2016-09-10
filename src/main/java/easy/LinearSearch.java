package easy;

/**
 * Created by khoa on 3/3/2016.
 */
public class LinearSearch {

    public static void main(String[] args) {
        System.out.println(search(SAMPLE_2,13));
    }

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
