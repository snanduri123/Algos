import java.util.PriorityQueue;

/*
Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).


Example 1:

Input: nums = [3,4,5,2]
Output: 12
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
Example 2:

Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
Example 3:

Input: nums = [3,7]
Output: 12


Constraints:

2 <= nums.length <= 500
1 <= nums[i] <= 10^3
 */

public class MaximumProductOfTwoElementsInArray_PrQue_1464 {

    //Time complexity : O(n)
    //Space complexity: O(K) - constant size of priority queue. We are keeping at most 2 pieces of data in PriorityQueue.
    public int maxProduct(int[] nums) {

        // Create a Priority Queue that holds 2 indexes which has the highest value, because if we know what are maximum values then automatically their product is also maximum.
        //PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { return (a[1] - b[1]);}); //another way of writing compare function.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < nums.length; i++) {
            int[] idx_val = new int[2];
            idx_val[0] = i;
            idx_val[1] = nums[i];
            pq.add(idx_val);
            if (pq.size() > 2) { // we want pq to hold only 2 objects that are having high value.
                pq.poll();
            }
        }

        int prod = 1;

        while (!pq.isEmpty()) {
            prod = prod * (pq.peek()[1] - 1);
            pq.poll();
        }

        return prod;
    }

    public static void main(String[] args){

        MaximumProductOfTwoElementsInArray_PrQue_1464 m = new MaximumProductOfTwoElementsInArray_PrQue_1464();
        System.out.println(m.maxProduct(new int[]{3,4,5,2})); //(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
        System.out.println(m.maxProduct(new int[]{1,5,4,5})); // 16
        System.out.println(m.maxProduct(new int[]{3,7})); //12

    }
}
