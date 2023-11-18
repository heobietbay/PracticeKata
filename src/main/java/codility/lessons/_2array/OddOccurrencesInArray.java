package codility.lessons._2array;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,3,9,3,9,7,9}));
    }
    public static int solution(int[] arr) {
        int found = 0;
        for(int i = 0; i < arr.length; i++) {
            found = found ^ arr[i];
        }
        return found;
    }
}
