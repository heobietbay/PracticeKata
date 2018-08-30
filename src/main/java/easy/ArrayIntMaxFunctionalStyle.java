package easy;

import java.util.Arrays;
import java.util.List;

/**
 * Find the max number in a list using functional style.
 * The idea is to use reduce().
 * Note: we can solve this using Collections.max, but this is about learning functional style.
 */
public class ArrayIntMaxFunctionalStyle {
    public static void main(String[] args) {

        List<Integer> numList = Arrays.asList(5,7,1,2,4,66,0,8);
        Integer max = numList.stream()
                             .reduce((num1, num2) -> num1 < num2 ? num2 : num1)
                             .get();
        System.out.println(max);
    }
}
