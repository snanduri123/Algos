import java.util.*;

public class TheKWeakestRowsinAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i< mat.length; i++){
            int strength = getStrength_using_BinarySearch(mat[i], 1);
        }
        return result;
    }
    public int getStrength_using_BinarySearch(int[] row, int key){
        int start = 0;
        int end = row.length -1;
        while (start < end){
            int mid = (start + end)/2;
            if(row[mid] == key){
                start = mid;
            }
            else {
                end = mid;
            }
        }
        return start;
    }

    //Time :  : (all rows + all columns) + sorted datastructures treemap and treeset
    //           O(r + c) + O(rlogn) + O(clogn) = O(n) + O(nlogn) //i.e.,(r,c ~ n)
    //Space : O(n) -
    public int[] kWeakestRows2(int[][] mat, int k) {
        int[] result = new int[k];
         TreeMap<Integer, TreeSet<Integer>> strengthIndexesMap = new TreeMap<>();
        // Convert hashmap to Treemap to convert to descending order if we need k strongest instead of k weakest army indexes.
        //TreeMap<Integer, TreeSet<Integer>> strengthIndexesMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < mat.length; i++) {
            int strength = 0;
            int j = 0;
            while (j < mat[i].length && mat[i][j] != 0) {
                strength++;
                j++;
            }
            TreeSet<Integer> existingIndexes;
            if (strengthIndexesMap.containsKey(strength)) {
                existingIndexes = strengthIndexesMap.get(strength);
            } else {
                existingIndexes = new TreeSet<>();
            }
            existingIndexes.add(i);
            strengthIndexesMap.put(strength, existingIndexes);
        }
        int i = 0;
        for (Map.Entry<Integer, TreeSet<Integer>> strengthIndexes : strengthIndexesMap.entrySet()) {
            for (Integer index : strengthIndexes.getValue()) {
                if (i < k) {
                    result[i] = index;
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TheKWeakestRowsinAMatrix t = new TheKWeakestRowsinAMatrix();
        int[][] mat1 = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        System.out.println(Arrays.toString(t.kWeakestRows(mat1, 3))); //[2,0,3]

        int[][] mat2 = {{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}};

        System.out.println(Arrays.toString(t.kWeakestRows(mat2, 2))); //[0,2]
    }

}
