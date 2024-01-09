/*
There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.

Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.



Example 1:

Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
Example 2:

Input: heights = [4,3,2,1]
Output: [0,1,2,3]
Explanation: All the buildings have an ocean view.
Example 3:

Input: heights = [1,3,2,4]
Output: [3]
Explanation: Only building 3 has an ocean view.


Constraints:

1 <= heights.length <= 105
1 <= heights[i] <= 109
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack_Buildings_with_OceanView_1762 {

    public int[] findBuildings(int[] heights) { //start from right side and track only that are taller than previous max height
        List<Integer> answer = new ArrayList<>();
        int maxHeight = heights.length-1;
        answer.add(heights.length-1);
        for(int i =heights.length-2; i >=0;i--){
            if(heights[i] >  heights[maxHeight]) {
                answer.add(0,i);
                maxHeight = i;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    //Time: O(n)
    //Space: Stack :  O(n)
    public int[] findBuildings2(int[] heights) {

        int[] answer;
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i< heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]){
                stack.pop();
            }
            stack.add(i);
        }

        answer = new int[stack.size()];
        int idx = 0;
        for(int i : stack){
            answer[idx++] = i;
        }
    return answer;
    }

}
