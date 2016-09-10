package easy;

/**
 * Created by khoa on 8/14/2016.
 */
public class ArrayRemoveZeros {

    public static void main(String[] args) {
        int[] inp = new int [] {4, 6, 0,0, 5, 13};

        System.out.println("Input array: ");
        for(int num : inp)
        {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        int[] res = removeZeros(inp);
        System.out.println("After processed: ");
        for(int num : res)
        {
            System.out.print(num + " ");
        }
    }

    /**
     Write a function that takes an array of values and moves all elements that are zero to the end of the array, otherwise preserving the order of the array.
     The zero elements must also maintain the order in which they occurred.
     For example, the following array

     [7, 2, 3, 0, 4, 6, 0, 0, 13, 0, 78, 0, 0, 19, 14]

     is transformed into

     [7, 2, 3, 4, 6, 13, 78, 19, 14, 0, 0, 0, 0, 0, 0]

     Zero elements are defined by either 0 or "0". Some tests may include elements that are not number literals.

     You are NOT allowed to use any temporary arrays or objects. You are also not allowed to use any Array.prototype or Object.prototype methods.
    */
    private static int[] removeZeros(int[] array)
    {
        for(int i = 0 , len = array.length; i < len; i++)
        {
            if(array[i] == 0)
            {
                for(int j = i + 1 ; j < len; j++)
                {
                    if(array[j] == 0)
                    {
                        continue;
                    }
                    int temp = array[j];
                    array[j] =  array[i];
                    array[i] = temp;
                    break; // need to break as soon as 0 and first non 0 is swapped, if not the order will not be maintained
                }
            }
        }
        return array;
    }
}
