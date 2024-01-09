package Graphs;

/*
Convert the given edge list to the adjacency list of an undirected connected graph.
An adjacency list represents a graph as a list of lists. The list index represents a vertex, and each element in its inner list represents the other vertices that form an edge with the vertex.

Example
{
"n": 5,
"edges": [
[0, 1],
[1, 4],
[1, 2],
[1, 3],
[3, 4]
]
}
Output:

[
[1],
[0, 2, 3, 4],
[1],
[1, 4],
[1, 3]
]
Notes
There are n nodes in the graph, and each node has a distinct value from 0 to n - 1.
Edges are given as a list of pairs. Each pair [u, v] represents an undirected edge between node u and node v.
The list won't contain duplicate edges. That is, if [u, v] is present, then there will be no other occurrence of [u, v] or [v, u].
Every inner list of the output list should hold the nodes in ascending order.
Constraints:

1 <= n <= 103
0 <= number of edges <= (n * (n - 1)) / 2
0 <= value of each node <= n - 1
The graph won't contain self loops.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConvertEdgeListToAdjacencyMatrix {

    static ArrayList<ArrayList<Boolean>> convert_edge_list_to_adjacency_list(Integer n, ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<Boolean>> adjacentMatrix = new ArrayList<>(n);


        //create empty lists for answer - adjacentLists.
        for (int i = 0; i < n; i++) {
            ArrayList<Boolean> adjacentList = new ArrayList<>(Collections.nCopies(n, Boolean.FALSE));
            adjacentMatrix.add(adjacentList);
        }

        for (int i = 0; i < edges.size(); i++) {
            List<Integer> edge = edges.get(i);
            if (edge.size() != 0) {
                //Each edge has 2 vertices. So 2nd vertex is adjacent to first vertex. So add 2nd vertex to the existing list for firstvertex(in its index)
                ArrayList<Boolean> adjacentList = adjacentMatrix.get(edge.get(0));
                Integer pos = edge.get(1);
                adjacentList.set(pos,Boolean.TRUE);

                //So first vertex is adjacent to second vertex, so update that in the firstVertex index.
                adjacentList = adjacentMatrix.get(edge.get(1));
                pos = edge.get(0);
                adjacentList.set(pos,Boolean.TRUE);
            }
        }
        return adjacentMatrix;
    }

    public static void main(String[] args) {
        ConvertEdgeListToAdjacencyMatrix c = new ConvertEdgeListToAdjacencyMatrix();

        ArrayList<ArrayList<Integer>> edges1 = new ArrayList<>();
        ArrayList<Integer> edge1 = new ArrayList<>();
        edge1.add(0);
        edge1.add(1);
        ArrayList<Integer> edge2 = new ArrayList<>();
        edge2.add(1);
        edge2.add(4);
        ArrayList<Integer> edge3 = new ArrayList<>();
        edge3.add(1);
        edge3.add(2);
        ArrayList<Integer> edge4 = new ArrayList<>();
        edge4.add(1);
        edge4.add(3);
        ArrayList<Integer> edge5 = new ArrayList<>();
        edge5.add(3);
        edge5.add(4);
        edges1.add(edge1);
        edges1.add(edge2);
        edges1.add(edge3);
        edges1.add(edge4);
        edges1.add(edge5);

        System.out.println(Arrays.deepToString(c.convert_edge_list_to_adjacency_list(5, edges1).toArray()));

        ArrayList<ArrayList<Integer>> edges2 = new ArrayList<>();
        edge1 = new ArrayList<>();
        edges2.add(edge1);

        System.out.println(Arrays.deepToString(c.convert_edge_list_to_adjacency_list(1, edges2).toArray()));


        ArrayList<ArrayList<Integer>> edges3 = new ArrayList<>();
        edge1 = new ArrayList<>();
        edge1.add(0);
        edge1.add(1);
        edges3.add(edge1);

        System.out.println(Arrays.deepToString(c.convert_edge_list_to_adjacency_list(2, edges3).toArray()));
    }
}
