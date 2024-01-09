package AppleLeetcode;
/*
An array arr is a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.



Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1


Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.
 */
public class PeakIndexInMountainArray_852 {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start + 1 < end){  //having 3 elements always in the check;
            int mid = start + (end-start)/2;
            if((arr[mid-1] < arr[mid]) && (arr[mid] > arr[mid+1])){
                return mid;
            }
            if(arr[mid+1] > arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        if(start == end){ //one element left
            return start;
        } else{ //two elements left, which ever is greater return that element
            return (arr[start] > arr[end]) ? start : end;
        }
    }

    public static void main(String[] args){
        PeakIndexInMountainArray_852 p = new PeakIndexInMountainArray_852();
        System.out.println(p.peakIndexInMountainArray(new int[]{0,1,0})); //1 //return 2nd element when there are 3 elements
        System.out.println(p.peakIndexInMountainArray(new int[]{0,2,1,0}));//1  //first mid (index= (0+3)/2 = 1) is the answer
        System.out.println(p.peakIndexInMountainArray(new int[]{3,4,5,1})); //2 //mid found sec time on right side
        System.out.println(p.peakIndexInMountainArray(new int[]{0,1,5,4,3,2,0})); //2 //only one (5) left after while loop binary search (start == end), so return start.
        System.out.println(p.peakIndexInMountainArray(new int[]{3,5,3,2,0})); //1 //two elements (3,5) left after while loop binary search, (start < end) so return end index.
        System.out.println(p.peakIndexInMountainArray(new int[]{3,4,5,1})); //2 //two elements (5,1) left after while loop binary search (start > end), so return start index.
    }
}
