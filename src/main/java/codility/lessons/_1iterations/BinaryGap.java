package codility.lessons._1iterations;

public class BinaryGap {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(binaryGap(n));
    }

    private static int binaryGap(int n) {
        String sb = toBinaryString(n);
        System.out.println(sb);
        return 0;
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
