/*Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[B.length - 1]
 */

public class Valid_Mountain_Array_941 {

    public static void main(String[] args) {
        Valid_Mountain_Array_941 v = new Valid_Mountain_Array_941();
        System.out.println(v.validMountainArray(new int[] {2,0,2})); //false
        System.out.println(v.validMountainArray(new int[] {0,1,2,1,2})); //false
        System.out.println(v.validMountainArray(new int[] {0,1,2,1,0})); //true
        System.out.println(v.validMountainArray(new int[] {2,1,2,3,5,7,9,10,12,14,15,16,18,14,13})); //false
        System.out.println(v.validMountainArray(new int[] {14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3})); //false
        System.out.println(v.validMountainArray(new int[]  {2,1,2,3,5,7,9,10,12,14,15,16,18,14,13})); //false



    }
    public boolean validMountainArray2(int[] A) {
        boolean isPeakFound = false;
        if(A.length < 3)
            return false;
        for(int i=1 ; i<A.length; i++) {

            if (i +1 < A.length) {
                if ((A[i] > A[i - 1]) && (A[i] > A[i + 1])) {
                    if (isPeakFound) {
                        isPeakFound = false;
                        break;

                    } else {
                        isPeakFound = true;
                    }
                }
                if (isPeakFound && (A[i] <= A[i + 1])) {
                    isPeakFound = false;
                    break;
                }
                if ((A[i] < A[i - 1]) && (A[i] <= A[i + 1])) {
                    isPeakFound = false;
                    break;
                }
            }
            else{
                if (!(A[i] < A[i - 1])){
                    isPeakFound = false;
                    break;
                }
            }
        }
        return isPeakFound;
    }

    public boolean validMountainArray(int[] A) {
        int i = 0;

        // walk up
        while (i+1 < A.length && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == A.length-1)
            return false;

        // walk down
        while (i+1 < A.length && A[i] > A[i+1])
            i++;

        return i == A.length-1;
    }

}
