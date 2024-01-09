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
import java.util.List;

public class Rename_BinaryString_of_n_length {
    static List<String> ans = new ArrayList<>();

    public List<String> binString(Integer n) {
        binStr(n, "");
        return ans;
    }

    //Time: n * O(2^n).
    //Space: O(n)

    public void binStr(int n, String str){
        if(str.length() == n){  // or use (n == 0) while n is decremented (n-1) in every call.
            ans.add(str);
            return;
        }

        for(String bin : new String[] {"0","1"}){
            //str = str + bin;
            binStr( n,  str + bin);
           // str = str.substring(0, str.length()-1);
        }
    }

    public static void main(String[] args){
        Rename_BinaryString_of_n_length n = new Rename_BinaryString_of_n_length();
        n.binStr( 2,  "");
        System.out.println(ans); //[00, 01, 10, 11]

        ans.clear();

        Rename_BinaryString_of_n_length n2 = new Rename_BinaryString_of_n_length();
        n2.binStr( 3,  "");
        System.out.println(ans); //[00, 01, 10, 11, 000, 001, 010, 011, 100, 101, 110, 111]
    }
}
