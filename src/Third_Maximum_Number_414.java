/*Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

        Example 1:
        Input: [3, 2, 1]
        Output: 1
        Explanation: The third maximum is 1.

        Example 2:
        Input: [1, 2]
        Output: 2
        Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

        Example 3:
        Input: [2, 2, 3, 1]
        Output: 1
        Explanation: Note that the third maximum here means the third maximum distinct number.
        Both numbers with value 2 are both considered as second maximum.
        */

import java.util.TreeSet;

public class Third_Maximum_Number_414 {
    //Time : O(N)
    // Space: O(1)
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE; //first highest
        long second = Long.MIN_VALUE; //second highest
        long third = Long.MIN_VALUE; //third highest
        for (int i : nums) {
            if (i == first || (i == second) || (i == third))  {
                //continue. do nothing for duplicates.
                //If duplicates have to be considered then we can use priorityqueue -> Eg: Kth_Largest_element_in_a_Stream_703
            }
            else if (i > first) {
                third = second;
                second = first;
                first = i;
            }
            else if (i > second) {
                third = second;
                second = i;
            }
            else if (i > third) {
                third = i;
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }

    //
    public int thirdMax2_wrong(int[] nums) {
       TreeSet<Integer> set = new TreeSet<>((a,b)->b-a); //first element to be fetched is the largest
       for(int num : nums){

           if(set.size() == 3){ //limit the set size to 3
               if(num > set.first()){
                   set.pollLast();
               }
           }
           set.add(num);
       }
       return (set.size()<3) ? set.first() : set.last();
    }

    //using treeSet
    public int thirdMax2(int[] nums) {
        // Sorted set to keep elements in sorted order.
        TreeSet<Integer> sortedNums = new TreeSet<Integer>();

        // Iterate on all elements of 'nums' array.
        for (int num : nums) {
            // Do not insert same element again.
            if (sortedNums.contains(num)) {
                continue;
            }

            // If sorted set has 3 elements.
            if (sortedNums.size() == 3) {
                // And the smallest element is smaller than current element.
                if (sortedNums.first() < num) {
                    // Then remove the smallest element and push the current element.
                    sortedNums.pollFirst();
                }
            }
            sortedNums.add(num);
        }

        // If sorted set has three elements return the smallest among those 3.
        if (sortedNums.size() == 3) {
            return sortedNums.first();
        }

        // Otherwise return the biggest element of nums array.
        return sortedNums.last();
    }


    public static void main (String[]args){
        Third_Maximum_Number_414 T = new Third_Maximum_Number_414();
        System.out.println(T.thirdMax(new int[] {3,2,1})); // 1
        System.out.println(T.thirdMax(new int[] {2,2,3,1})); // 1 // if there are duplicate numbers then consider only distinct numbers only.
        System.out.println(T.thirdMax(new int[] {1,2})); // 2
        System.out.println(T.thirdMax(new int[] {1,1,2})); // 2
        System.out.println(T.thirdMax(new int[] {1,2,-2147483648})); // -2147483648 -> sames as INTEGER.MIN_VALUE
        System.out.println(T.thirdMax(new int[] {4,3,1,2})); // 2

    }
}
