/*
Given an integer array nums, find a
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class Maximum_Subarray_product_152 {
     /*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    */

    /*Time complexity : n
      Space complexity -  stack: 1
                          heap : n  (res array)
     */
    public int maxProduct(int[] nums) {
        int prevMin = 1;  //min prod at idx i-1.
        int prevMax = 1;  //max prod at idx i-1.
        int maxProd = Integer.MIN_VALUE;
        //3 options at every idx. For the array ending with index i,
        // num[i] itself is maximum (do not use maxProd from previous index) Eg: prevMin and PrevMax both are -ve and curr number is +ve (or vice versa), so you may just want to use by itself.
        // num[i] * prevMin  (if curr num is -ve and prevMin is -ve then prod is bigger than other two options.)
        // num[i] * prevMin
        for(int i=0; i< nums.length; i++) {
            int currMin = Math.min(nums[i], Math.min(nums[i] * prevMin, nums[i] * prevMax));
            int currMax = Math.max(nums[i], Math.max(nums[i] * prevMin, nums[i] * prevMax));
            maxProd = Math.max(maxProd, currMax);
            prevMin = currMin;
            prevMax = currMax;
        }
        return maxProd;
    }

    public static void main(String[] args) {
        Maximum_Subarray_product_152 m = new Maximum_Subarray_product_152();
        int prod;
        int[] a = {2, 3, -2, 4}; //6
        prod = m.maxProduct(a);
        System.out.println(prod);

        int[] b = {-2, 0, -1}; //0
        prod = m.maxProduct(b);
        System.out.println(prod);

        int[] b2 = {-2, 3, -4}; //all -ve numbers. -1
        prod = m.maxProduct(b2); //24
        System.out.println(prod);
    }

}
