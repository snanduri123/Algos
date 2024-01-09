
/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.



Example 1:
           0   ----   1
            \        /
             \      /
                2


Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
Example 2:

            1             3
          /               |  \
         0                |   5
          \               |  /
           2              4


Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph_Path_Exists_1971 {

    //Time : O(n)
    //Space: O(n)
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());    //created entry for each vertex/node with empty list in map.
        }
        for (int[] edge : edges) {              //edge eg: [0,1], [0,2].... 0 is parent and its children are 1 and 2. So 0 -> [1,2]
            graph.get(edge[0]).add(edge[1]);    //key is the first value of edge and the value (list) contains the second value of edge
            graph.get(edge[1]).add(edge[0]);
        }

        return dfs(isVisited, graph,  source,  destination);
    }

    public boolean dfs(boolean[] isVisited, HashMap<Integer, List<Integer>> map, int source, int destination){

        if(source == destination)
            return true;

        isVisited[source] = true;

        for(Integer node : map.get(source)){
            if(!isVisited[node] && dfs(isVisited, map, node, destination))
                return true;
        }

        return false;
    }

    public static void main(String[] args){
        Graph_Path_Exists_1971 g = new Graph_Path_Exists_1971();

        /*
            0   ----   1
            \        /
             \      /
                2
         */
        int[][]edges1 = {{0,1},{1,2},{2,0}};
        System.out.println(g.validPath(3,  edges1, 0, 2)); //true;


        /*
           1             3
          /               |  \
         0                |   5
          \               |  /
           2              4

         */
        int[][]edges2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(g.validPath(6,  edges2, 0, 5)); //false;
        System.out.println(g.validPath(6,  edges2, 1, 4)); //false;
        System.out.println(g.validPath(6,  edges2, 4, 3)); //true;

    }
}
