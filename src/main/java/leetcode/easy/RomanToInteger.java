package leetcode.easy;

public class RomanToInteger {

    public static void main(String[] args) {
        String inp = "III";
        int val = solution(inp);
        System.out.println(val);

        inp = "IV";
        val = solution(inp);
        System.out.println(val);

        inp = "IX";
        val = solution(inp);
        System.out.println(val);

        inp = "LVIII";
        val = solution(inp);
        System.out.println(val);

        inp = "MCMXCIV";
        val = solution(inp);
        System.out.println(val);
    }

    /**
     * PLEASE NOTE: This does NOT detect invalid input such as IXL.
     * Input must be correct in order for this to work.
     * @param inp the input Roman number represent as string
     * @return base 10 value.
     */
    private static int solution(String inp) {
        // first, calculate sum, not taking into special case like IV, IX, XL, XC, CD, CM
        int sum = 0;
        char[] charArray = inp.toCharArray();
        for(char ch : charArray)
        {
            int val = RomanNumChar.fromChar(ch).baseTenVal;
            sum += val;
        }
        // then, calculate special cases above, subtract each of them 2 times
        // reason: supposed we calculate IV as I + V = 6, while it should be IV = V - I = 4
        int first = 0;
        int second = 1;
        while(second < charArray.length)
        {
            char ci = charArray[first];
            char cj = charArray[second];
            if(ci == 'I')
            {
                if(cj == 'X' || cj == 'V')
                {
                    sum -= 2 * RomanNumChar.fromChar(ci).baseTenVal;
                    first = second + 1;
                    second = second + 2;
                    continue;
                }
            }
            else if(ci == 'X')
            {
                if(cj == 'L' || cj == 'C')
                {
                    sum -= 2 * RomanNumChar.fromChar(ci).baseTenVal;
                    first = second + 1;
                    second = second + 2;
                    continue;
                }
            }
            else if(ci == 'C')
            {
                if(cj == 'D' || cj == 'M')
                {
                    sum -= 2 * RomanNumChar.fromChar(ci).baseTenVal;
                    first = second + 1;
                    second = second + 2;
                    continue;
                }
            }

            first++;
            second++;
        }
        return sum;
    }

    enum RomanNumChar {
        I (1),
        V (5),
        X (10),
        L (50),
        C (100),
        D (500),
        M (1000);

        int getBaseTenVal(){
            return baseTenVal;
        }
        static RomanNumChar fromChar(char ch)
        {
            if(ch == 'I')
                return I;
            if(ch == 'V')
                return V;
            if(ch == 'X')
                return X;
            if(ch == 'L')
                return L;
            if(ch == 'C')
                return C;
            if(ch == 'D')
                return D;
            if(ch == 'M')
                return M;
            throw new IllegalArgumentException("Unknown roman character");
        }
        RomanNumChar(int val)
        {
            this.baseTenVal = val;
        }
        private int baseTenVal;
    }
}
