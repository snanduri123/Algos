package Graphs;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponent {

    boolean isVisited[];
    public int computeCC(int n, int[][] edges) {
        isVisited = new boolean[n];
        int count = 0;
         List<Integer>[] graph = new ArrayList[n];

         for(int i=0; i< n; i++){
             graph[i] = new ArrayList<>();
         }

        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for(int i=0 ; i< n; i++){
            if(!isVisited[i]) {
                dfs(i, graph);
                count++;
            }

        }
        return count;
    }

    public void dfs(int vertex, List<Integer>[] graph){
        isVisited[vertex] = true;
        for(Integer connectedVertex : graph[vertex]){
            if(!isVisited[connectedVertex]) {
                dfs(connectedVertex, graph);
            }
        }
    }
}
