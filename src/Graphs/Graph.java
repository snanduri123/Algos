package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    // No. of vertices
    private int V;

    // Adjacency Lists
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) //edge is vw. v is vertex and w is another vertex
    {
        adj[v].add(w);
    }


    // prints BFS traversal from a given source s
    public List<Integer> BFS(int source) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean isVisited[] = new boolean[V];
        List<Integer> answer = new ArrayList<>();

        // Create a queue for BFS
        LinkedList<Integer> queue
                = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        isVisited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {

            // Dequeue a vertex from queue and print it
            source = queue.poll();
            System.out.print(source + " ");
            answer.add(source);
            // Get all adjacent vertices of the dequeued
            // vertex s.
            // If an adjacent has not been visited,
            // then mark it visited and enqueue it
            for (int w : adj[source]) {
                if (!isVisited[w]) {
                    isVisited[w] = true;
                    queue.add(w);
                }
            }
        }
        return answer;
    }

    public static void main(String args[])
    {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");

        g.BFS(2);  // 2 0 3 1
    }
}