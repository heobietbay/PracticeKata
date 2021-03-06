package normal;

import easy.LargePositiveIntegerAddition;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * In mathematics, the factorial of integer n is written as <code> n!</code>.
 * <p>It is equal to the product of n and every integer preceding it. For example: <code>5! = 1 x 2 x 3 x 4 x 5 = 120</code></p>
 <ul>
 Your mission is simple: write a function that takes an integer n and returns the value of n!.
     <li>You are guaranteed an integer argument.</li>
     <li>For any values outside the non-negative range, return null, nil or None (return an empty string "" in C and C++).</li>
     <li>For non-negative numbers a full length number is expected for example,
         return <code>25! = "15511210043330985984000000"</code> as a string.</li>
 * </ul>
 * For more on factorials, see http://en.wikipedia.org/wiki/Factorial
 */
public class LargeFactorials {

    public static void main(String[] args) {
        System.out.println(factorial(25));
        System.out.println(factorial(5));
        System.out.println(factorial(10));
    }

    /**
     *  Using BigInteger, we can store big integer number up to +2<sup>{@code Integer.MAX_VALUE}</sup> (exclusive).
     *  I personally think using even this solution has limit, and the {@link #factorial(int)} method can holder much bigger value.
     * @param n input num.
     * @return string represent the factorial
     */
    private static String factorialUsingBigInteger(int n) {
        return java.util.stream.IntStream.rangeClosed(1, n)
                .mapToObj(i -> BigInteger.valueOf(i))
                .reduce(BigInteger.ONE, (acc, i) -> acc.multiply(i))
                .toString();
    }

    private static String factorial(int n) {
        String tmp = "1";
        for(int i = 2; i <= n; i++)
        {
            tmp = multiply(tmp,"" + i);
        }
        return tmp;
    }

    private static String multiply(String numString1, String numString2)
    {
        if( numString1 == "0" || numString2=="0")
            return "0";
        else if( numString1== "1" || numString2=="1")
        {
            return numString1=="1" ? numString2 : numString1;
        }
        String longerNum = numString1.length() > numString2.length() ? numString1 : numString2;
        String shorterNum = numString1 == longerNum ? numString2 : numString1;

        List<String> components = new ArrayList<>();
        // for every digit in shorterNum, multiply that with whole longerNum
        // add each of the result to a temp list
        for(int i = 0; i < shorterNum.length() ; i++)
        {
            List<String> componentTmp = new ArrayList<>();
            int num1LastDigit = Character.getNumericValue(shorterNum.charAt(i));

            if(num1LastDigit == 0) // 0 * any number = 0
            {
                continue;
            }
            if(num1LastDigit == 1) // 1 * any number = any number
            {
                componentTmp.add(longerNum);
            }
            else
            {
                for(int j = 0; j < longerNum.length(); j++)
                {
                    int num2LastDigit = Character.getNumericValue(longerNum.charAt(j))  ;
                    int product = (num1LastDigit * num2LastDigit) ;

                    // num2LastDigit could be in 10s or 100s and so on
                    String zeros = new String(new char[longerNum.length() - j - 1]).replace("\0", "0");
                    String productStr = String.valueOf(product) + zeros;
                    componentTmp.add(productStr);
                }
            }
            // num1LastDigit could be in 10s or 100s and so on
            String outerZero = new String(new char[shorterNum.length() - 1 - i]).replace("\0", "0");
            String numTmp = componentTmp.stream()
                    .reduce((s, s2) -> LargePositiveIntegerAddition.add(s, s2))
                    .get() + outerZero;
            components.add(numTmp);
        }
        // then, add all, to get the final number
        String addedAllResult = components.stream()
                .reduce((s, s2) -> LargePositiveIntegerAddition.add(s, s2))
                .get();
        return addedAllResult;
    }

}
