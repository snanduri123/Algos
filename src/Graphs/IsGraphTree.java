package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
Output: true.
Example 2:

Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
Output: false.

 */
public class IsGraphTree {

    boolean isVisited[];
    public boolean validTree(int n, int[][] edges) {
        isVisited = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];


        for(int i=0; i< n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
        }

        for(int i=0; i< n; i++){
            HashSet<Integer> isVisiting = new HashSet<>();
            if(!isVisited[i]){
                if(!dfs( i,  graph, isVisiting))
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, List<Integer>[] graph, HashSet<Integer> isVisiting){

        isVisiting.add(i);

        for(Integer neighbor: graph[i]) {
            if(isVisiting.contains(neighbor)){
                return false;
            }
            if(!dfs(neighbor, graph, isVisiting)){
                return false;
            }
        }
        isVisited[i] = true;
        isVisiting.remove(i);
        return true;
    }

    public static void main(String[] args){
        IsGraphTree i = new IsGraphTree();
        int[][] edges1 = new int[][]{{0,1}, {0, 2}, {0, 3}, {1, 4}}; //true
        System.out.println(i.validTree(5,edges1));

        int[][] edges2 = new int[][]{{0,1}, {1, 2}, {2, 3}, {3, 1},{1,4}}; //false
        System.out.println(i.validTree(5,edges2));

    }
}
