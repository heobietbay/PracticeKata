package easy;

public class LargePositiveIntegerAddition {

    public static void main(String[] args) {
        String numStr1 = "871782912000";
        String numStr2 = "435891456000";
        //correct is 1_307_674_368_000
        System.out.println(add(numStr1,numStr2));
    }
    public static String add(String numStr1,String numStr2)
    {
        if(numStr1 == null || numStr1.length() == 0 || numStr2 == null || numStr2.length() == 0)
        {
            throw new IllegalArgumentException("Invalid input number.");
        }

        StringBuilder sb = new StringBuilder();
        // loop from the end of each string, and do basic math addition
        for(int i = numStr1.length() - 1, j = numStr2.length() - 1, carry = 0;
            i >= 0 || j >= 0 || carry != 0;
            i--, j--)
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
