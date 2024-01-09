/*
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.



Example 1:
  1              3        3         2      1
    \           /        /        /  \      \
     3        2         1        1    3      2
    /       /            \                    \
   2      1               2                    3

Input: n = 3
Output: 5


Example 2:
Input: n = 1
Output: 1


Constraints:

1 <= n <= 19

 */

public class BinarySearchTree_Recur_Unique_BST_Count_96 {


    //Time: O(n * 2^n) ..Because it is binary search tree(not every element can be on left side and not every element can be on right side)
    //      it is not exactly 2^n , it is in the order of 2^n . If n =3 , it is not 2^3 = 8, it is 5.
    //Space: O(1)
    public int numTrees(int n) {
       return numTrees( 1,  n);
    }

    public int numTrees(int start, int end) {
        int count = 0;

        // Eg: n=3.  1,2,3. If start is at 1 then while checking its left subtrees, end becomes -1 (< start)
        //                  If start is at 2 then to find left subtrees you check below 2 , start = 1, end=1 and you can form only 1 tree with one element.
        if(start > end){  // > or >= both works
            return 1;  // (start == end) if there is only 1 number, then only one tree can be formed.
                       // (end < start) that means there are no elements to form tree, so return just 1 so that when it is multiplied below the value does not change.
        }
//        if(end-start == 1){ //if there are 2 numbers then there can be 2 trees formed.
//            return 2;     // this code is optional
//        }
        for(int i=start; i<= end; i++){
            int leftTrees = numTrees( start,  i-1);
            int rightTrees = numTrees( i+1,  end);
            count += leftTrees *  rightTrees; //count of trees on left side * count of trees on right side.
        }
        return count;
    }

    public static void main(String[] args){
        BinarySearchTree_Recur_Unique_BST_Count_96 r = new BinarySearchTree_Recur_Unique_BST_Count_96();
      //  System.out.println(r.numTrees(3));
        System.out.println(r.numTrees(5));
    }
}
