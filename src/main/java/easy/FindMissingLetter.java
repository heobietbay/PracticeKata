package easy;

/**
 * Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter in the array.
 *
 * You will always get an valid array. And it will be always exactly one letter be missing. The length of the array will always be at least 2.
 * The array will always contain letters in only one case.
 *
 * <p>
 * Example:
 *
 * <p>['a','b','c','d','f'] -> 'e'</p>
 * <p>['O','Q','R','S'] -> 'P'</p>
 * </p>
 * (Use the English alphabet with 26 letters!)
 */
public class FindMissingLetter {
    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[]{'a','b','d','e','f'}));
    }

    public static char findMissingLetter(char[] array){
        char expectableLetter = array[0];
        for(char letter : array){
            if(letter != expectableLetter)
                break;
            expectableLetter++;
        }
        return expectableLetter;
    }

    public static char findMissingLetter_UseSum(char[] array)
    {
        // sum of array [x, x + k]
        // is the [0,...x+k] - [0,...,x-1]
        int maxCharCode = array[array.length - 1];
        int minCharCode = array[0] - 1; // need to calculate from range [x,...x+k]

        int sumMax = maxCharCode*(maxCharCode+1)/2;
        int sumMin = minCharCode*(minCharCode+1)/2;

        int rangeMinMax = sumMax - sumMin;

        for(char c : array)
        {
            rangeMinMax -= (int)c;
        }
        return (char)rangeMinMax;
    }
}
