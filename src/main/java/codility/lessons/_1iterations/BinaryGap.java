package codility.lessons._1iterations;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(binaryGap(65));
        System.out.println(binaryGap(129));
        System.out.println(binaryGap(257));
        System.out.println(binaryGap(513));
        System.out.println(binaryGap(4105));
    }

    private static int binaryGap(int n) {
        String sb = toBinaryString(n);
        System.out.println(sb);
        int temp = n;
        int maxLen = 0;
        int first1 = -1;
        int last1 = -1;
        for(int i = 0; temp > 0; i++) {
            int remain = temp % 2;
            temp = temp / 2;
            if(remain == 1) {
                if(first1 == -1) {
                    first1 = i;
                } else {
                    int len = (i - first1) - 1;
                    maxLen = Math.max(maxLen, len);
                }
                if(temp == 0) {
                    last1 = i;
                } else {
                    first1 = i;
                }
            }
        }
        if(last1 != -1 && first1 != -1) {
            int len = (last1 - first1) - 1;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    private static String toBinaryString(int n) {
        StringBuffer sb = new StringBuffer();
        int temp = n;
        while (temp > 0) {
            int quotient = temp / 2;
            int remain = temp % 2;
            sb.append(remain);
            temp = quotient;
        }
        return sb.reverse().toString();
    }
}
