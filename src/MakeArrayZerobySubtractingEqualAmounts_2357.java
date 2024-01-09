/*
You are given a non-negative integer array nums. In one operation, you must:

Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
Subtract x from every positive element in nums.
Return the minimum number of operations to make every element in nums equal to 0.



Example 1:

Input: nums = [1,5,0,3,5]
Output: 3
Explanation:
In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].
Example 2:

Input: nums = [0]
Output: 0
Explanation: Each element in nums is already 0 so no operations are needed.


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
 */

import java.util.HashSet;
import java.util.PriorityQueue;

public class MakeArrayZerobySubtractingEqualAmounts_2357 {


    //Time O(n)
    //Space O(n)

    //Same elements, always take same iterations to become 0 --> so  Deduplicate
    //Different elements, are always different until 0  -->  Counts unique elements
    //
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }


    //Time complexity : O(n) + sorting (nlogn) = nlogn
//Space complexity : O(n)
    public int minimumOperations2(int[] nums) {

       // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //use natural ascending order so that on top of queue smaller elementa are present


        for(int num : nums){
            if(num > 0) {
                pq.add(num);
            }
        }

        int count = 0;
        int toSubtractForNextNum = 0;

        while(!pq.isEmpty()){
            if(pq.peek() == 0) {
                pq.poll();
            }
            else{
                if(pq.peek() - toSubtractForNextNum > 0) {
                    // if condition helps if there are duplicates then we do not have to take iteration to subtract.
                    // They all become zero in one iteration only
                    toSubtractForNextNum = toSubtractForNextNum + (pq.peek() - toSubtractForNextNum); //keep track of the value to be subtracted for next number
                    count++;
                }
                pq.poll();
            }
        }
     return count;
    }


    public static void main(String[] args) {
        MakeArrayZerobySubtractingEqualAmounts_2357 m = new MakeArrayZerobySubtractingEqualAmounts_2357();
        System.out.println(m.minimumOperations(new int[] {1,5,0,3,5})); // 3
        System.out.println(m.minimumOperations(new int[] {0})); // 0
    }
}
