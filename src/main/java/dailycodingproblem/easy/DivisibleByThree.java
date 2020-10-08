package dailycodingproblem.easy;

public class DivisibleByThree {
    public static void main(String[] args) {
        String s = "022";
        int count = solution(s);
        System.out.println(count);
    }

    private static int solution(String s) {
        int res = 0;
        if(Integer.parseInt(s) %3 == 0)
            res++;
        for(char c = '0' ; c <= '9'; c++)
        {
            char[] sArr = s.toCharArray();
            for(int ci = 0 ; ci < s.length(); ci++)
            {
                if(sArr[ci] == c)
                    continue;
                char backup = sArr[ci];
                sArr[ci] = c;
                int num = Integer.parseInt(String.valueOf(sArr));
                if(num %3 == 0) {
                    res++;
                }
                sArr[ci] = backup;
            }
        }
        return res;
    }
}
