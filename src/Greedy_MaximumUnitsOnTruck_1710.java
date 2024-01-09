/*
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.



Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
Example 2:

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91

 */


import java.util.Arrays;

public class Greedy_MaximumUnitsOnTruck_1710 {

    //Time : O(nlogn) + O(n) = O(nlogn) - sorting and reading
    //Space: O(K) - constant space
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        int units = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); //sort in decreasing order of number of units.
                                                      //If the number of units is same for 2 elements they can be in any order.

        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {

            if ((truckSize - boxTypes[i][0]) >= 0) {
                truckSize = truckSize - boxTypes[i][0];
                units = units + (boxTypes[i][0] * boxTypes[i][1]);
            } else //(boxTypes[i][0] > truckSize)  //if next item's number of boxes is more than truck space then
            {                               //take boxes only as much as truck can fit.
                units = units + truckSize * boxTypes[i][1];
                truckSize = 0;
            }
        }

        return units;
    }

    public static void main(String[] args) {
        Greedy_MaximumUnitsOnTruck_1710 M = new Greedy_MaximumUnitsOnTruck_1710();
        System.out.println(M.maximumUnits(new int[][]{{2, 1}, {4, 4}, {3, 1}, {4, 1}, {2, 4}, {3, 4}}, 13));
//        System.out.println(M.maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4)); // 8
//        System.out.println(M.maximumUnits(new int[][]{{5,10},{2,5},{4,7}, {3,9}}, 10)); // 91
//        System.out.println(M.maximumUnits(new int[][]{{2, 1}, {4, 4}, {3, 1}, {4, 1}, {2, 4}, {3, 4}}, 13));
//        System.out.println(M.maximumUnits(new int[][]{{2, 1}, {4, 4}, {3, 1}, {4, 1}, {2, 4}, {3, 4}, {1, 3}, {4, 3}, {5, 3}, {5, 3}}, 13)); //48
    }
}
