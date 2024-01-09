import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pathscount797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Queue<LinkedList<Integer>> queue = new LinkedList<>();

        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        queue.add(path);

        List<List<Integer>> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            LinkedList<Integer> aPath = queue.poll();
            Integer lastNode = aPath.getLast();
            for (Integer next : graph[lastNode]) {
                LinkedList newPath = new LinkedList(aPath);
                newPath.addLast(next);
                if (next == graph.length - 1) {
                    ans.add(newPath);
                } else {
                    queue.add(newPath);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        List<List<Integer>> paths = new Pathscount797().allPathsSourceTarget(new int[][]{{1,2}, {2,3}, {3}, {4}, {}});
        for (List<Integer> path : paths) {
            for (Integer a : path) {
                System.out.print(a);
            }
            System.out.println();
        }
    }
}