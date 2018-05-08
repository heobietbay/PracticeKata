package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Find the second maximum value in an array.
 */
public class SecondMaximumValueInArray {
    public static void main(String[] args) {
        SolutionFinder<Integer> solutionFinderFinder = new SolutionFinder<>(createSampleIntegerList());
        System.out.println(solutionFinderFinder.findSecondMaximumValue());
    }

    private static List<Integer> createSampleIntegerList() {
        List<Integer> lst = new ArrayList<>();
        lst.add(5);
        lst.add(4);
        lst.add(0);
        lst.add(99);
        lst.add(0);
        lst.add(-100);
        lst.add(-10);
        lst.add(18);
        lst.add(18);
        lst.add(5);
        return lst;
    }

    static class SolutionFinder<T extends Comparable<T>>
    {
        /**
         * The idea is to loop through the array, and
         * every time we find the value that is greater than the current flag
         * that means the current value could be the second maximum.
         * <p>At the end of the loop, we would have the biggest + 2nd biggest number.</p>
         * <p>We can do sorting, then use inputList.get(1), but that solution could be more than O(N).</p>
         * @return the found item.
         */
        public T findSecondMaximumValue()
        {
            T secondMaximum = inputList.get(0);

            // will always be the biggest
            T max = inputList.get(0);
            for(T val : inputList)
            {
                // we found item that is bigger than the biggest
                // that means biggest num now is 2nd big -> update these values
                if(val.compareTo(max) > 0)
                {
                    secondMaximum = max;
                    max = val;
                }
                // Still, this value could be bigger than our second biggest
                else if(val.compareTo(secondMaximum) > 0)
                {
                    secondMaximum = val;
                }
            }
            return secondMaximum;
        }

        public SolutionFinder(List<T> inputList) {
            Objects.requireNonNull(inputList);
            if(inputList.isEmpty())
                throw new IllegalArgumentException("Input array is empty");
            this.inputList = inputList;
        }

        private List<T> inputList;

    }
}
