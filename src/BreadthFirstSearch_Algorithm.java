/*                A
          /       |        \
        B         C          D
    /      \   /     \     /    \
    E      F  G      H --> I     j
                     \
                      K
 print - A B C D E F G H I J K
 visit A
 visit A's children - B C D
                      visit B's children - E F
                      visit C's children - G H
                      visit D's children - I J
                            visit E's children - null
                            visit F's children - null
                            visit G's children - null
                            visit H's children - K
                            visit I's children - null
                            visit J's children - null



 ( I is pointed by both D and H but it is printed only once as a child of D , K is printed last)

                   1
          /       |        \
        2         3          4
    /      \   /     \     /    \
    5      6  7      8 --> 9     10
                     \
                      11

        */

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch_Algorithm {

    public static void main (String[] args){
        BreadthFirstSearch_Algorithm B = new BreadthFirstSearch_Algorithm();
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);
        GraphNode node8 = new GraphNode(8);
        GraphNode node9 = new GraphNode(9);
        GraphNode node10 = new GraphNode(10);
        GraphNode node11 = new GraphNode(11);
        node1.children = new GraphNode[] {node2,node3, node4};
        node2.children = new GraphNode[] {node5,node6};
        node3.children = new GraphNode[] {node7,node8};
        node4.children = new GraphNode[] {node9,node10};
        node8.children = new GraphNode[] {node9,node11};
        B.printNodesInGraph_BFS(node1);
    }

    public void printNodesInGraph_BFS(GraphNode node) {

        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        System.out.print(node.val + " ");
        while (!queue.isEmpty()) {
            node = queue.remove();
            if(node.children != null) {
                for (GraphNode child : node.children) {
                    ((LinkedList<GraphNode>) queue).addLast(child);
                    child.isVisited = true;
                    System.out.print(child.val + " ");
                }
            }

        }
    }
}
