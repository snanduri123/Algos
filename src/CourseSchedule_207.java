import java.util.*;

public class CourseSchedule_207 {


    //Time: O(n)
    //Space: O(n) isvisited + O(n) visitng

    public boolean canFinish(int numCourses, int[][] prerequisites) { //using hashset outside of dfs loop.
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean[] isVisited = new boolean[numCourses];

        for (int[] pair : prerequisites) {
            if (map.containsKey(pair[1])) {
                map.get(pair[1]).add(pair[0]); //key is prereq, value is list of courses you can do using this prereq.
            } else {
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(pair[0]);
                map.put(pair[1], lst);
            }
        }

        Set<Integer> visiting = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {

            if (!dfs(i, visiting, isVisited, map))
                return false;
        }
        return true;
    }

    //if there is a cycle in the prerequisites then the course can't be finished.
    public boolean dfs(int course, Set<Integer> visiting, boolean[] isVisited, Map<Integer, ArrayList<Integer>> map) {
        if (visiting.contains(course)) { //there is cycle in the path of prerequisites. visiting same course again
            return false;
        }
        visiting.add(course);

        if (map.containsKey(course)) {
            for (int childCourse : map.get(course)) {
                if (!isVisited[childCourse]) {   //only process unvisited children (irrespective of culprit or not the result of that child is already known. The visited culprit child would have already returned false.
                    if (!dfs(childCourse, visiting, isVisited, map))  //if childcourse has cycle i.e, again seeing a course that has been already seen (in visiting) so far in this path.
                        return false;
                }
            }
        }
        //need to remove current node from "visiting" bcoz, in the outer loop(above method) when
        // again for a new node the dfs is called (means it is searching for a new path) where this node could be child node in that path
        // which is yet to be "visiting" for that new path to check if there  is cycle.
        visiting.remove(course); //remove after finished working on one node(along with its neighbours/children)
        isVisited[course] = true;  //curr course and all its children are visited and have no cycle problem.
        return true;                  // So next time we see this course, we do not process at all.
    }


    public static void main(String[] args) {
        CourseSchedule_207 c = new CourseSchedule_207();
         /*
           prereq course
           1       0
         */
        System.out.println(c.canFinish(2, new int[][]{{1, 0}}));//true

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
        // 3 needs 2,
        // 1,4 need 3,
        //  0 needs 1, but again 1 need 3,  3 need 2, 2 need 0 and so on)

    }

}
