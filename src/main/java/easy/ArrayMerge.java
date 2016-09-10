package easy;

/**
 * Created by khoa on 2/12/2016.
 */
public class ArrayMerge {

    public static void main(String[] args) {
       // int[] res = merge(SAMPLE2,SAMPLE1);

        int[] res = mergeSort(new int[] {1,4,5,0,9,8,7,-1,99,100,200,3,-2,0});

        for(int i: res)
        {
            System.out.println(i);
        }
    }
    static int[] mergeSort(int[] arr)
    {
        if(arr.length == 1)
        {
            return arr;
        }
        else if(arr.length == 2)
        {
            if(arr[0] > arr[1])
            {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
            return arr;
        }

        int mid = arr.length /2;

        int[] leftAr = new int[mid];
        System.arraycopy(arr,0,leftAr,0,mid);
        // Sort half left
        leftAr = mergeSort(leftAr);

        int[] rightAr = new int[arr.length - mid];
        System.arraycopy(arr,mid,rightAr,0,arr.length - mid);

        // Sort half right
        rightAr = mergeSort(rightAr);

        return merge(leftAr,rightAr);
    }

    static int[] merge(int[] arrL, int[] arrR)
    {
        int len1 = arrL.length;
        int len2 = arrR.length;

        int[] res = new int[len1 + len2];

        int countL = 0;
        int countR = 0;
        int i = 0;
        while(countL < arrL.length && countR < arrR.length)
        {
            if(arrL[countL] < arrR[countR])
            {
                res[i] = arrL[countL];
                countL++;
            }
            else
            {
                res[i] = arrR[countR];
                countR++;
            }
            i++;
        }

        // maybe we have some remain

        while(countL < arrL.length)
        {
            res[i++] = arrL[countL++];
        }
        while(countR < arrR.length)
        {
            res[i++] = arrR[countR++];
        }

        return res;
    }


    static int[] SAMPLE1 = {5,6,7,8,9};
    static int[] SAMPLE2 = {0,1,2,3,4};
}
