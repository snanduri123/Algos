import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.



Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.


Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */
public class Stack_Asteroid_Collision_735 {

    //Time: O(n)
    //Space: O(n)
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();
        int[] ans;


        for (int i = 0; i < asteroids.length; i++) {

            boolean addAsteroid = true;

            //if top element in stack is -ve (moving left) and new asteroid is +ve (moving right)
            //then they will not collide, so while loop is skipped.
            while (!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0) {
                if (Math.abs(asteroids[i]) > Math.abs(st.peek())) {  //if new asteroid is big then top element is crushed.
                    st.pop();
                } else if (Math.abs(asteroids[i]) == Math.abs(st.peek())) { //if new asteroid is same as top element then both are crushed.
                    st.pop();
                    addAsteroid = false; //new asteroid is crushed, so no need to add to stack.
                    break;
                } else if (Math.abs(asteroids[i]) < Math.abs(st.peek())) {
                    addAsteroid = false;  //new asteroid is smaller than top element so it gets crushed and not added to stack
                    break;
                }
            }

            if (addAsteroid)
                st.add(asteroids[i]);
        }

        ans = new int[st.size()];
        for (int i = st.size() -1; i >=0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        Stack_Asteroid_Collision_735 s = new Stack_Asteroid_Collision_735();
        //  System.out.println(Arrays.toString(s.asteroidCollision(new int[]{5, 10, -5}))); //[5,10]
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{8, -8}))); //[]
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{10, 2, -5}))); //[10]
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2,-1,1,2}))); //[-2,-1,1,2]
    }
}
