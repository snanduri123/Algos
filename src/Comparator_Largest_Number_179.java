/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.



Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109 */

import java.util.Arrays;
import java.util.Comparator;

public class Comparator_Largest_Number_179 {

    //Time : O(nlogn)  - sorting
    //Space: O(n)
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        //sort numbers such that bignumber comes first
        public int compare(String a, String b) {  // 3, 30
            String order1 = a + b;  //330
            String order2 = b + a;  //303
            return order2.compareTo(order1); // a+b (order1) > a-b(order2) which is +ve, that means a will be right and b will be left which becomes 303. If a+b >  b+a then we want b to be left and a to be on right. So we do order2.compareTo(order1), means b+a > a+b gives -ve and hence a remains on left, b remains on right i.e, 330.
        }
    }

    public String largestNumber(int[] nums) {
        StringBuilder answer = new StringBuilder();
        String[] numStrs = new String[nums.length];
        int i =0;
        for(int num : nums){
            numStrs[i++] = String.valueOf(num);
        }
        //Arrays.sort(numStrs, new LargerNumberComparator());
        Arrays.sort(numStrs, ((a,b) -> (b+a).compareTo(a+b)));
        if(numStrs[0].equals("0")) { //after sorting, if the largest number is `0`, the entire number is zero. //Eg: input [0,0]
            return "0";
        }
        for(String numStr : numStrs){
            answer.append(numStr);
        }
        return answer.toString();
    }
}
