/*
here are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 */

import java.util.*;

public class CourseScheduleII_210 {

    public int[] findOrder (int numCourses, int[][] prerequisites){

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        boolean isVisited[] = new boolean[numCourses];
        HashSet<Integer> isVisiting = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        for(int[] prereq : prerequisites){

            if(!map.containsKey(prereq[1])){
                map.put(prereq[1], new ArrayList<>());   //key is prereq, value is list of courses you can do using this prereq.
            }
            map.get(prereq[1]).add(prereq[0]);
        }

        for(int i=0; i< numCourses;i++){
            if(!isVisited[i]) {
                if(!dfs(map, i, isVisited, isVisiting, answer))
                    return new int[0]; // if there is cycle then return empty array.
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(HashMap<Integer,List<Integer>> map, int course, boolean[] isVisited, HashSet<Integer> isVisiting, List<Integer> answer)
    {
        if(isVisiting.contains(course))
            return false; // there is cycle

        isVisiting.add(course);

        if(map.containsKey(course)) { // some courses are not prereq (may be just child) and not in the map.
            for (Integer childCourse : map.get(course)) {
                if (!isVisited[childCourse]) {
                    if (!dfs(map, childCourse, isVisited, isVisiting, answer))
                        return false;
                }
            }
        }

        isVisited[course] = true;
        isVisiting.remove(course);
        answer.add(0,course);
        return true;
    }

    public static void main(String[] args) {

        //1. +ve test case. No cycle but one course has two prereq (so answer cna have two possibilities)
        CourseScheduleII_210 c1 = new CourseScheduleII_210();
        /*
             0   (prereq for 1, 2)
           /   \
           1   2 (prereq for 3)
            \  /
              3
              --no cycle here. And the order can be 0,1,2,3 or 0,2,1,3
         */
        System.out.println(Arrays.toString(c1.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}))); //[0,2,1,3]

        //2. 2 independent course paths but answers returned as one list.
          /*
             0   (prereq for 1, 2)             4
           /   \                        and     \
           1   2 (prereq for 3)                 5
            \  /                                \
              3                                 6
              --no cycle here. But 2 independent course paths. And the order can be 4,5,6,0,1,2,3 or 4,5,6,0,2,1,3 or
         */

        CourseScheduleII_210 c2 = new CourseScheduleII_210();
        System.out.println(Arrays.toString(c2.findOrder(7, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {5,4}, {6,5}}))); //[0,2,1,3]


        /*
             0   (prereq for 1, 2)
           /   \
           1   2 (prereq for 3, 4)
            \  / \
              3   4
              --no cycle here. And the order can be 0,2,4,1,3 or 0,1,3,2,4
         */
        CourseScheduleII_210 c3 = new CourseScheduleII_210();
        System.out.println(Arrays.toString(c3.findOrder(5, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {4,2}}))); // //[0,2,4,1,3 ]
    }

}
