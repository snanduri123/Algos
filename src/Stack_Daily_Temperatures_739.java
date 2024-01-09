/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]


Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
 */

import java.util.Arrays;
import java.util.Stack;

public class Stack_Daily_Temperatures_739 {
    //Time: O(n)  --  you touch each each index a maximum of 2 times.
    //Space: O(n) (stack)
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.empty() && temperatures[i]> temperatures[stack.peek()]){
                int day = stack.pop();
                answer[day] = i - day;
            }
            stack.add(i);
        }
        return answer;

    }

    public static void main(String[] args){
        Stack_Daily_Temperatures_739 n = new Stack_Daily_Temperatures_739();
        System.out.println(Arrays.toString(n.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}))); //[1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(n.dailyTemperatures(new int[]{30,40,50,60})));// [1,1,1,0]
        System.out.println(Arrays.toString(n.dailyTemperatures(new int[]{30,60,90}))); //[1,1,0]
    }
}
