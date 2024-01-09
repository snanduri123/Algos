import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.



Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.


Constraints:

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 104
All integers in nums1 and nums2 are unique.
All the integers of nums1 also appear in nums2.

 */
public class Stack_NextGreaterElement_I_496 {

    //Time complexity: O(n+n+m) = O(n)
    //Space complexity: O(n)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];

        for(int j = 0; j<nums2.length; j++ ){
            // if current array element is greater than top element in stack then remove that top element
            // and put it in map along with the current array element as its next greater element
            while(!stack.empty() && (stack.peek() < nums2[j])){
                map.put(stack.pop(),nums2[j]);
            }
            stack.add(nums2[j]);
        }

        for(int i = 0; i<nums1.length; i++ ){
            if(map.containsKey(nums1[i]))
                result[i] = map.get(nums1[i]);
            else
                result[i] = -1;
        }
        return result;
    }

    public static void main(String[] args){
        Stack_NextGreaterElement_I_496 n = new Stack_NextGreaterElement_I_496();
        System.out.println(Arrays.toString(n.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}))); //-1,3,-1
        System.out.println(Arrays.toString(n.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));// [3,-1]
        System.out.println(Arrays.toString(n.nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7}))); //[7,7,7,7,7]
        System.out.println(Arrays.toString(n.nextGreaterElement(new int[]{4,2,3,1}, new int[]{1,2,3,4}))); //-1,-1,-1, -1
        System.out.println(Arrays.toString(n.nextGreaterElement(new int[]{1,2,3,4}, new int[]{1,2,3,4}))); //2,3,4, -1
        System.out.println(Arrays.toString(n.nextGreaterElement(new int[]{1}, new int[]{1,4,3,2}))); //4
        System.out.println(Arrays.toString(n.nextGreaterElement(new int[]{1,2}, new int[]{2,1,4,3}))); //4,4. both numbers have same next greatest element.
    }
}
