package normal;

import java.util.*;

/**
 * Given an array of string, find the duplicated elements.
 */
public class StringArrayFindDuplicate {
    public static void main(String[] args) {
        String[] arrayString = new String[] {"abc","def","de","zzzz","111","de","5555","x","abc","de"};
        List<String> duplicateElements = findDuplicate(arrayString);
        System.out.println(Arrays.toString(duplicateElements.toArray()));
    }

    private static List<String> findDuplicate(String[] arrayString) {
        Set<String> stringSet = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(String s : arrayString)
        {
            if(!stringSet.contains(s))
            {
                stringSet.add(s);
            }
            else
            {
                res.add(s);
            }
        }
        return res;
    }
}
