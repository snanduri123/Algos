package Graphs;

import java.util.*;

public class courscheduleI {

    Set<Integer> isVisited;
    public boolean canFinish(int numCourses, int[][] prerequisites){
        isVisited = new HashSet<>(numCourses);
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int[] prereq : prerequisites){
            Integer course = prereq[0];
            if(!map.containsKey(course)){
                map.put(course, new ArrayList<>());
            }
            map.get(course).add(prereq[1]);
        }

        for(int course=0; course<numCourses; course++){
            if(!isVisited.contains(course)){
                if(!dfs(course, map, new HashSet<>()))
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> map , Set<Integer> isVisiting){
        isVisiting.add(course);
        if(map.containsKey(course)) {
            for (Integer prereq : map.get(course)) {
                if (!isVisited.contains(prereq)) {
                    if (isVisiting.contains(prereq))
                        return false;
                    if (!dfs(prereq, map, isVisiting)) {
                        return false;
                    }
                }
            }
        }
        isVisiting.remove(course);
        isVisited.add(course);
        return true;
    }

    public static void main(String[] args){
        courscheduleI c = new courscheduleI();
        System.out.println(c.canFinish(2, new int[][]{{0,1}}));//true

       System.out.println(c.canFinish(2, new int[][]{{0,1}, {1,0}}));//false (cycle)

        /*
           prereq course
           0       2
           2       3
           3       1,4
           1       0   ---> (cycle)
         */

        System.out.println(c.canFinish(5, new int[][]{{2,0}, {3,2}, {1,3}, {4,3}, {0,1}}));//false (cycle formed at course 1.
        // 2 course need 0,
        // 3 needs 2, 1,4 need 3,
        //  0 needs 1, but again 1 need 3,
        //  3 need2 and so on)

    }

}
