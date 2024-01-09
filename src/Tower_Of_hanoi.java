/*
Tower of Hanoi is a mathematical puzzle where we have three pegs and n disks. The objective of the puzzle is to move the entire stack to another peg, obeying the following simple rules:

Only one disk can be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
No disk may be placed on top of a smaller disk.
Given n denoting the number of disks in the first peg, return all the steps required to move all disks from the first peg to the third peg in minimal number of steps.

Example
{
"n": 4
}
Output:

[
[1, 2],
[1, 3],
[2, 3],
[1, 2],
[3, 1],
[3, 2],
[1, 2],
[1, 3],
[2, 3],
[2, 1],
[3, 1],
[2, 3],
[1, 2],
[1, 3],
[2, 3]
]
Following steps:

[1, 2] = Shift top disk of the first peg to top of the second peg.
Picture after this step will be:
First peg: 2 3 4
Second peg: 1
Third peg: Empty

[1, 3] = Shift top disk of the first peg to top of the third peg.
Picture after this step will be:
First peg: 3 4
Second peg: 1
Third peg: 2

Similarly after following remaining steps, the final configuration will be:
First peg: Empty
Second peg: Empty
Third peg: 1 2 3 4

Hence, our objective is achieved.

Notes
Return a 2d integer array containing all the steps taken to move all n disks from the first peg to the third peg in minimal number of steps. Each row will have two integers denoting from peg and to peg, for example, if the ith row is [2, 3], then it means in this step, we moved the top disk on peg 2 to peg 3.
Constraints:

1 <= n <= 20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tower_Of_hanoi {

    ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
    static List<String> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> tower_of_hanoi(Integer n) {

        helper(n, 1, 2, 3, answer);
        return answer;
    }

    //Time: O(2^n). At each level there are 2^level nodes working .
    //      For level 1, there are n disks to be moved by the manager.
    //      For level 2, there are 2 employees trying to move (n-1) disks - 1 employee from src to aux, 1 employee from aux to dest (in between also current employee moves the last disk from src to dest)
    //      For level 3, there are 4 employees trying to move (n-2) disks - 2 employees to move
    //Space: O(n)
    public void helper(Integer n, int src, int aux, int dest,
                       ArrayList<ArrayList<Integer>> answer) {

        if(n == 1){  //if there is only one disc in src then the move is src to dest.
            ArrayList<Integer> currMove = new ArrayList<>();
            currMove.add(src);
            currMove.add(dest);
            answer.add(currMove);
            return;
        }

        helper(n-1, src, dest, aux, answer); // first move (n-1) disks from src to aux (so aux becomes dest and dest is used as aux)
        ArrayList<Integer> currMove = new ArrayList<>();  // move the remaining last disk from src to dest
        currMove.add(src);
        currMove.add(dest);
        answer.add(currMove);
        helper(n-1, aux, src, dest, answer);  //move back (n-1) disks from aux to dest
    }

    public static void main(String[] args){
        Tower_Of_hanoi n = new Tower_Of_hanoi();
        System.out.println(Arrays.deepToString(n.tower_of_hanoi(4).toArray()));
    }
}
