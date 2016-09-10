package easy;

/**
 * Created by khoa on 2/10/2016.
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search2(SAMPLE_3, 1)); //5,4,3,0,1,2
        System.out.println(search2(SAMPLE_4, 1)); //5,4,3,0,0,1,2
        System.out.println(search2(SAMPLE_3, 2)); //5,4,3,0,1,2
        System.out.println(search2(SAMPLE_3, 0)); //5,4,3,0,1,2
        System.out.println(search2(SAMPLE_3, 3)); //5,4,3,0,1,2
        System.out.println(search2(SAMPLE_3, 4)); //5,4,3,0,1,2
        System.out.println(search2(SAMPLE_3, 5)); //5,4,3,0,1,2

        System.out.println(search2(SAMPLE_3, 6)); //5,4,3,0,1,2
        System.out.println(search2(SAMPLE_3, -1)); //5,4,3,0,1,2
    }

    static int search2(int[] arr, int inp) {
        int midVal = arr[arr.length / 2];
        if (inp == midVal) {
            return arr.length / 2;
        } else {
            int start = 0;
            int end = arr.length - 1;

            while (start <= end) {
                int pos = (start + end) / 2;
                midVal = arr[pos];
                if (pos < arr.length - 1 && arr[pos] <= arr[pos + 1])
                {
                    if (midVal > inp) {
                        end = pos - 1;
                    } else if (midVal < inp) {
                        start = pos + 1;
                    } else {
                        return (start + end) / 2;
                    }
                }
                else
                {
                    if (midVal < inp) {
                        end = pos - 1;
                    } else if (midVal > inp) {
                        start = pos + 1;
                    } else {
                        return (start + end) / 2;
                    }
                }


            }
            return -1;
        }
    }

    static int search(int[] arr, int inp) {
        int midVal = arr[arr.length / 2];
        if (inp == midVal) {
            return arr.length / 2;
        } else {
            int start = 0;
            int end = arr.length - 1;

            while (start <= end) {
                int pos = (start + end) / 2;
                midVal = arr[pos];
                if (midVal > inp) {
                    end = pos - 1;
                } else if (midVal < inp) {
                    start = pos + 1;
                } else {
                    return (start + end) / 2;
                }

            }
            return -1;
        }
    }

    static int[] SAMPLE_1 = {0, 1, 2, 3, 4, 5};

    static int[] SAMPLE_2 = {8, 13, 17, 23, 24, 25};

    static int[] SAMPLE_3 = {5, 4, 3, 0, 1, 2};
    static int[] SAMPLE_4 = {5, 4, 3, 0, 0, 1, 2};
}
