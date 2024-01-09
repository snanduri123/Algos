package Graphs;

import java.util.*;

public class courscheduleII {

    Set<Integer> isVisited;
    List<Integer> answer ;
    public int[] findOrder(int numCourses, int[][] prerequisites){
        isVisited = new HashSet<>(numCourses);
        answer = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int[] prereq : prerequisites){
            Integer course = prereq[0];
            if(!map.containsKey(course)){
                map.put(course, new ArrayList<>());  //key is course, value is list of prereq courses
            }
            map.get(course).add(prereq[1]);
        }

        for(int course=0; course<numCourses; course++){
            if(!isVisited.contains(course)){
                if(!dfs(course, map, new HashSet<>()))
                    return new int[0];
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
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
        answer.add(course);
        return true;
    }

    public static void main(String[] args) {

        //1. +ve test case. No cycle but one course has two prereq (so answer cna have two possibilities)
        courscheduleII c1 = new courscheduleII();
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

        courscheduleII c2 = new courscheduleII();
        System.out.println(Arrays.toString(c2.findOrder(7, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {5,4}, {6,5}}))); //[0,2,1,3]


        /*
             0   (prereq for 1, 2)
           /   \
           1   2 (prereq for 3, 4)
            \  / \
              3   4
              --no cycle here. And the order can be 0,2,4,1,3 or 0,1,3,2,4
         */
        courscheduleII c3 = new courscheduleII();
        System.out.println(Arrays.toString(c3.findOrder(5, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {4,2}}))); // //[0,2,4,1,3 ]
    }

}
