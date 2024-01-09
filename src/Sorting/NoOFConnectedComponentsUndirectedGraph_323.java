package Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
In this problem, there is an undirected graph with n nodes.
There is also an edges array.
Where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.

You need to return the number of connected components in that graph.

Example1 :

Input:  3  [[0,1], [0,2]]
Output: 1

Example2 :

Input: 6 [[0,1], [1,2], [2, 3], [4, 5]]
Output: 2

 */
public class NoOFConnectedComponentsUndirectedGraph_323 {

    boolean[] isVisited;

    public int countComponents(int n, int[][] edges) {
        isVisited = new boolean[edges.length];

        //build graph

        /*Use adjacency hash map graph in case of random numbers as vertices or strings(Eg: cities) as vertices
        String[][] links = new String[n][2];
        Map<String, List<String>> g = new HashMap<>();
        for (String[] link : links) {
            g.put(link[0], new ArrayList<>());
            g.put(link[1], new ArrayList<>());
        }

        for (String[] link : links) {
            g.get(link[0]).add(link[1]);
            //g.get(link[1]).add(link[0]);
        } */

        //Build graph as adjacency lists
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int count = 0;

        //call DFS in an outerloop
        for (int i = 0 ; i < n ; i++) {
            if (!isVisited[i]) {
                dfs(i, graph);
                count++;
            }
        }
        return count;
    }

    private void dfs(int current, List<Integer>[] graph) {
        isVisited[current] = true; // mark isVisited
        for (int next : graph[current]) { // go to neigh
            if (!isVisited[next]) { // make sure they are not visited
                dfs(next, graph); // recurse
            }
        }
    }



}
