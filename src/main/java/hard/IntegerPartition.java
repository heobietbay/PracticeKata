package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Requirement can be found under IntegerPartition.txt.
 */
public class IntegerPartition {
    public static void main(String[] args) {
        partition(4);
       ArrayList<List<Integer>> partitionList = partitionList(4);
        partitionList.forEach(partition ->{
            System.out.println(Arrays.toString(partition.toArray()));
        });
    }
    private static ArrayList<List<Integer>> partitionList(int inpNum) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        partitionList(inpNum, inpNum, lists);
        return lists;
    }

    private static void partitionList(int inpNum, int max, ArrayList<List<Integer>> lists) {
        if (inpNum == 0) {
            lists.add(new ArrayList<>());
            return;
        }
        for (int i = Math.min(max, inpNum); i >= 1; i--) {
            int index = lists.size() - 1;
            lists.get(index).add(i);
            partitionList(inpNum-i, i, lists);
        }
    }

    private static void partition(int inpNum) {
        partition(inpNum, inpNum, "");
    }

    private static void partition(int inpNum, int max, String prefix) {
        if (inpNum == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = Math.min(max, inpNum); i >= 1; i--) {
            String prefix1 = prefix + " " + i;
            partition(inpNum-i, i, prefix1);
        }
    }

}
