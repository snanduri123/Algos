/*
A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.



Example 1:

Input: n = 1, headID = 0, manager = [-1], informTime = [0]
Output: 0
Explanation: The head of the company is the only employee in the company.
Example 2:


Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
Output: 1
Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform them all.
The tree structure of the employees in the company is shown.


Constraints:

1 <= n <= 105
0 <= headID < n
manager.length == n
0 <= manager[i] < n
manager[headID] == -1
informTime.length == n
0 <= informTime[i] <= 1000
informTime[i] == 0 if employee i has no subordinates.
It is guaranteed that all the employees can be informed.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeNeededToInformAllEmployees_1376 { //Medium
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    //Time: O(rows*col) or O(n) - n elements are visited 1 time.
    //Space: O(1)
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        for(int i = 0; i< manager.length; i++){
            if(map.containsKey(manager[i])){
                map.get(manager[i]).add(i);
            }
            else{
                ArrayList<Integer> lst = new ArrayList();
                lst.add(i);
                map.put(manager[i], lst);
            }
        }

        return dfs(headID, map, informTime);
    }


    public int dfs(int mgr, HashMap<Integer, ArrayList<Integer>> map, int[] informTime){
        if(!map.containsKey(mgr)){
            return 0;
        }

        int max = 0;

        for(int emp : map.get(mgr)){
            int timeByEmployees = dfs(emp, map, informTime);
            max = Math.max(max, timeByEmployees +  informTime[mgr]);
        }
        return max;

    }


    public static void main(String[] args){
        TimeNeededToInformAllEmployees_1376 t = new TimeNeededToInformAllEmployees_1376();
        System.out.println(t.numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0})); //1

        /*
        mgr  Employees         Time taken by mgr to inform his employees in min
         2   0,1,3,4,5     -   1
        -1   2
         1   6             -   2
         3   7             -   3
         7   8             -   4


         Max Time taken by mgr to inform his employees and his employees to their employees.

         for manager 2  -
              max time taken by employee 0 = 0 min
              max time taken by employee 1 and his empl 6  = 2min (1) + 0min (6) = 2 min
              max time taken by employee 3 and his empl 7 and his empl 8 = 3min (3) + 4min (7) -> 0min (8) = 7 min
              max time taken by employee 4 = 0 min
              max time taken by employee 5 = 0 min

               total time = 7 min (max of his employees) + 1 min (himself informtime)  = 8 min.

         */
        System.out.println(t.numOfMinutes(9, 2, new int[]{2,2,-1,2,2,2,1,3,7}, new int[]{2,0,1,3,0,0,0,4,0})); //8
    }
}
