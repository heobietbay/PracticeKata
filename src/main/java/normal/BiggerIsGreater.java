package normal;

import java.util.Arrays;

/**
 * Created by khoa on 9/10/2016.
 */
public class BiggerIsGreater {
    /*
    Given a word , rearrange the letters of  to construct another word  in such a way that  is lexicographically greater than .
    In case of multiple possible answers, find the lexicographically smallest one among them.

    Input Format

    The first line of input contains , the number of test cases. Each of the next  lines contains .

    Constraints

     will contain only lower-case English letters and its length will not exceed .
    Output Format

    For each testcase, output a string lexicographically bigger than  in a separate line.
    In case of multiple possible answers, print the lexicographically smallest one, and if no answer exists, print no answer.

    Sample Input

    5
    ab
    bb
    hefg
    dhck
    dkhc


    Sample Output

    ba
    no answer
    hegf
    dhkc
    hcdk
    Explanation

    Test case 1:
    There exists only one string greater than ab which can be built by rearranging ab. That is ba.

    Test case 2:
    Not possible to rearrange bb and get a lexicographically greater string.

    Test case 3:
    hegf is the next string lexicographically greater than hefg.

    Test case 4:
    dhkc is the next string lexicographically greater than dhck.

    Test case 5:
    hcdk is the next string lexicographically greater than dkhc.
    */


    public static void main(String[] args) {
        System.out.println(nextPermutation("dkhc".toCharArray()));
    }

    /*
    The following algorithm generates the next permutation lexicographically after a given permutation. It changes the given permutation in-place.
    1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
    2. Find the largest index l greater than k such that a[k] < a[l].
    3. Swap the value of a[k] with that of a[l].
    4. Reverse the sequence from a[k + 1] up to and including the final element a[n].
 */
    static char[] nextPermutation(char[] input)
    {
        char[] res = Arrays.copyOfRange(input,0,input.length);

      // 1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
        int k = -1;
        for(int i = 0 ; i < res.length - 1; i++)
        {
            char c1 = res[i];
            char c2 = res[i+1];
            if(c1 < c2)
            {
                k = i;
            }
        }
        if(k == -1)
            return res;
        else
        {
            // 2. Find the largest index l greater than k such that a[k] < a[l].
            int l = k;
            for(int i = k + 1 ; i < res.length; i++)
            {
                char c1 = res[i];
                if(res[k] < c1)
                {
                    l = i;
                }
            }

            //3. Swap the value of a[k] with that of a[l].
            char temp = res[k];
            res[k] = res[l];
            res[l] = temp;

            // 4. Reverse the sequence from a[k + 1] up to and including the final element a[n].
            StringBuilder sb = new StringBuilder();
            sb.append(Arrays.copyOfRange(res,0,k+1));

            for(int i = res.length - 1; i > k; i--)
            {
                sb.append(res[i]);
            }
            return sb.toString().toCharArray();
        }
    }
}
