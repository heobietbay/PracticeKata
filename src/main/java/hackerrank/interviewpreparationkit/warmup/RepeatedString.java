package hackerrank.interviewpreparationkit.warmup;

public class RepeatedString {

    public static void main(String[] args) {
        String s = "aba";
        long n = 10;
        long appearFreq = solution(s,n);
        System.out.println(appearFreq);
    }

    public static long solution(String s, long n) {

        if(s.length() == 1 && s.charAt(0) == 'a')
            return n;

        // 1st: count how many time the char 'a' appears in the base string s
        int count = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == 'a')
                count++;
        }

        // 2nd: how many time does the string repear
        long timeRepeat = n / s.length();

        // 3rd: take into account the substring remains
        long remain = n - (timeRepeat*s.length());
        long appearInRemain = 0;
        for(int i = 0 ; i < remain; i++)
        {
            char ch = s.charAt(i);
            if(ch == 'a')
                appearInRemain++;
        }
        return appearInRemain + (count * timeRepeat);
    }

}
