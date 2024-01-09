package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.



Example 1: (* - has apple)

                     0
                 /       \
                1          2*
             /    \      /    \
            4*     5*     3      6
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.
Example 2:


Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.
Example 3:

Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
Output: 0


Constraints:

1 <= n <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai < bi <= n - 1
hasApple.length == n

 */
public class  Minimum_Time_to_Collect_Apples_In_Tree_1433 {

    int totalSteps = 0;

    //Time: O(n)
    //Space: O(n) //recursion
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        // create graph map where key is the node/vertex and the value is list of all neighbors (children and parent)
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());    //created entry for each vertex/node with empty list in map.
        }
        for (int[] edge : edges) {              //edge eg: [0,1], [0,2].... 0 is parent and its children are 1 and 2. So 0 -> [1,2]
            graph.get(edge[0]).add(edge[1]);    //key is the first value of edge and the value (list) contains the second value of edge
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1, graph, hasApple);
        return totalSteps;
    }

    private boolean dfs(int current, int parent, Map<Integer, List<Integer>> graph, List<Boolean> hasApple) {

        /*
                     0
                 /       \
                1          2*
             /    \      /    \
            4*     5*     3      6

         */
        boolean isApple = hasApple.get(current);

        for (int child : graph.get(current)) {
            if (child != parent) {
                totalSteps++;  // Add step when going into the subtree/child node hoping that there would be apple in the subtree.
                boolean childVal = dfs(child, current, graph, hasApple);
                if (childVal) {
                    totalSteps++;  // Add step when going back up to the parent.
                } else {
                    totalSteps--;  // Subtract the parent to child step that was added before coming here because now the child has no apple, the path should not be considered.
                }
                isApple = isApple || childVal;  //if a node is apple or if it has a child node that is apple then graph related to this node is apple.
            }
        }
        return isApple;
    }


}
