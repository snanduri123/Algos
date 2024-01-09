/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.



Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:

Input: n = 1, bad = 1
Output: 1


Constraints:

1 <= bad <= n <= 231 - 1
 */

public class BinarySearch_First_BadVersion_278 {

    //Time : O(logn)
    //Space: O(1)
    public int firstBadVersion(int n) {
        return searchFirstBadVersion( 0,  n);
    }

    public int searchFirstBadVersion(int start, int end) { //iterative white loope

        int leftMostBadVersion = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2; //to avoid TLE

            if (isBadVersion(mid)) {
                leftMostBadVersion = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return leftMostBadVersion;
    }

    public int searchFirstBadVersion2(int start, int end) { //recursion

        if(start > end)
            return start;

        int mid = start + ( end - start ) / 2; //to avoid TLE

        if(isBadVersion(mid)){
            return searchFirstBadVersion( start, mid - 1);
        }else{
            return searchFirstBadVersion(mid + 1, end);
        }
    }

    public boolean isBadVersion(int ver) { // for testing purpose hard coded the bad version.
        if(ver == 4 || ver >= 1702766719)
            return true;
        else return false;
    }

    public static void main(String[] args) {

        BinarySearch_First_BadVersion_278 b = new BinarySearch_First_BadVersion_278();
        System.out.println(b.firstBadVersion(5)); // 4  //so input state of isbadver false, false, false, true, true
        System.out.println(b.firstBadVersion(4)); // 4
        System.out.println(b.firstBadVersion(2126753390)); // 1702766719 //TLE test case
    }
}
