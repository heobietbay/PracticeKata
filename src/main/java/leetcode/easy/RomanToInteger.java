package leetcode.easy;

public class RomanToInteger {

    public static void main(String[] args) {
        String inp = "III";
        int val = solution(inp);
        System.out.println(val);
    }

    private static int solution(String inp) {
        return 0;
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
        RomanNumChar fromChar(char ch)
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
