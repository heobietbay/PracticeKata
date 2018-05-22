package easy;

public class LargePositiveIntegerAddition {

    public static void main(String[] args) {
        String numStr1 = "1200000";
        String numStr2 = "77";
        System.out.println(add(numStr1,numStr2));
    }
    private static String add(String numStr1,String numStr2)
    {
        if(numStr1 == null || numStr1.length() == 0 || numStr2 == null || numStr2.length() == 0)
        {
            throw new IllegalArgumentException("Invalid input number.");
        }

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        // loop from the end of each string, and do basic math addition
        for(int i = numStr1.length() - 1, j = numStr2.length() - 1; i >= 0 || j >= 0; i--, j--)
        {
            int num1LastDigit = i < 0 ? 0 : Character.getNumericValue(numStr1.charAt(i));
            int num2LastDigit = j < 0 ? 0 :  Character.getNumericValue(numStr2.charAt(j));
            int sum = num1LastDigit + num2LastDigit + carry;
            if(sum > 9)
            {
                carry = 1;
                sum -= 10;
            }
            else
            {
                carry = 0;
            }
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}
