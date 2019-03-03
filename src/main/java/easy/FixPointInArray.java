package easy;

/**
 * This problem was asked by Apple.
 * <p>
 * A fixed point in an array is an element whose value is equal to its index.
 * Given a sorted array of distinct elements, return a fixed point, if one exists. Otherwise, return False.
 *
 * For example, given [-6, 0, 2, 40], you should return 2. Given [1, 5, 7, 8], you should return False.
 * </p>
 */
public class FixPointInArray {

    public static void main(String[] args) {
       Integer found = solutionNaive(new int[] {-6, 0, 2, 40});
       System.out.println(found == null ? "False" : found);

        found = solutionBinarySearch(new int[] {-6, 0, 2, 40});
        System.out.println(found == null ? "False" : found);

        found = solutionBinarySearch(new int[] {1, 5, 7, 8});
        System.out.println(found == null ? "False" : found);

        found = solutionBinarySearch(new int[] {-4, -3, -2, -1,4});
        System.out.println(found == null ? "False" : found);

        found = solutionBinarySearch(new int[] {0, 3, 4, 7,11});
        System.out.println(found == null ? "False" : found);
    }

    public static Integer solutionNaive(int[] sortedArr){
        for(int i = 0 ; i < sortedArr.length; i++)
        {
            if(i == sortedArr[i])
            {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    public static Integer solutionBinarySearch(int[] sortedArr){
        int val = sortedArr[sortedArr.length / 2];
        if ( (sortedArr.length / 2) == val) {
            return val;
        } else {
            int start = 0;
            int end = sortedArr.length - 1;

            while (start <= end) {
                int idx = (start + end) / 2;
                val = sortedArr[idx];
                // Val is bigger than its idx, need to search downward
                if (val > idx) {
                    end = idx - 1;
                }
                // Val is smaller than its idx, need to search upward
                else if (val < idx) {
                    start = idx + 1;
                } else {
                    return (start + end) / 2;
                }
            }
            return null;
        }
    }
}
