/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

public class TrappingRainWater_42 {

    //Time : O(n) --> O(n) leftMaxHeight+ O(n) rightMaxHeight + O(n) (last iteration to find area)
    //Space: O(n) ---> O(n) + O(n)  --> leftMaxHeight + rightMaxHeight

    //An index can trap water if it has any tall block/wall somewhere on the left side and right side.
    //1. So find out what is the tallest wall on left side and what is the tallest wall on the right side
    // for every index.
    //2. An index can trap water as much as the height difference between minHeight of (maxleft and maxright wall and itself
    //    Eg: 7, 2, 1, 4, 3  --> At index 2 (1) the water it can trap is min(7,4) - 1 => 4 - 1 => 3
    public int trap(int[] height) { //hard

        //find the tallest wall on the left side for current index.
        int prevMaxHeight = 0;

        int[] leftMaxHeight = new int[height.length];

        for(int i=1; i< height.length; i++){  // not starting for the left most index because it can't have any previous wall and so it can't trap any water
            prevMaxHeight = Math.max(prevMaxHeight, height[i-1]);
            leftMaxHeight[i] = prevMaxHeight > height[i] ? prevMaxHeight : 0;
        }

        //find the tallest wall on the right side for current index.
         prevMaxHeight = 0;

        int[] rightMaxHeight = new int[height.length];

        for(int i= height.length-2; i>=0; i--){ // not starting for the right most index because it can't have any next wall and so it can't trap any water
            prevMaxHeight = Math.max(prevMaxHeight, height[i+1]);
            rightMaxHeight[i] = prevMaxHeight > height[i] ? prevMaxHeight : 0;
        }

        //find area of water it can trap at current index.
        int area=0;
        for(int i=1; i < height.length - 1; i++){
            if((height[i] <  leftMaxHeight[i]) && (height[i] <  rightMaxHeight[i])) {
                area = area + (Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i]);
            }
        }

        return area;
    }
    
    public static void main(String[] args){
        TrappingRainWater_42 t = new TrappingRainWater_42();
        System.out.println(t.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(t.trap(new int[] {4,2,0,3,2,5}));
    }
}
