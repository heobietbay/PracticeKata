package leetcode.easy;

/**
 <pre>
 You are a product manager and currently leading a team to develop a new product.
 Unfortunately, the latest version of your product fails the quality check.
 Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

 Example:

 Given n = 5, and version = 4 is the first bad version.

 call isBadVersion(3) -> false
 call isBadVersion(5) -> true
 call isBadVersion(4) -> true

 Then 4 is the first bad version.
 </pre>
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(solution(2126753390));
    }

    public static int solution(int n) {
        // use binary search approach to find
       int start = 1;
       int end = n;
       int found = -1;
       while( start <= end )
       {
           // This is to prevent overflow
           // if we do normal (start + end)/2, we can run into INT_MAX -> overflow
           int mid = start  + ((end - start)/2);
           if(isBadVersion(mid)) {
               if(found == -1 || found > mid)
               {
                   found = mid;
               }
               end = mid -1;
           }
           else {
               start = mid + 1;
           }
       }
       return found;
    }
    static boolean isBadVersion(int version) {
        return version >= 2;
    }
}
