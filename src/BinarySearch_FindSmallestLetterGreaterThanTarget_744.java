/*
You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.



Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
Example 3:

Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].


Constraints:

2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.
 */
public class BinarySearch_FindSmallestLetterGreaterThanTarget_744 {

    //Time: O(logn)
    //Space: O(1)
    public char nextGreatestLetter(char[] letters, char target) {
        //return binarySearchRightMost(letters, target, 0, letters.length - 1);
        return binarySearchRightMost_Iterative(letters, target, 0, letters.length - 1);
        //return findRightMostIdxOfTarget(letters, target, 0, letters.length - 1);
    }

    public char binarySearchRightMost_Iterative(char[] letters, char target, int start, int end) {
        while (start <= end) {  // if target is not found and
            int mid = (start + end) / 2;
            if (target >= letters[mid]) {  //if target found (to skip its duplicates) or > midVal then continue searching right side
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start < letters.length) {
            return letters[start];
        } else {
            return letters[0];
        }
    }

    public char binarySearchRightMost(char[] letters, char target, int start, int end) {

        if (start > end) {  // if target is not found and
            if (start < letters.length) {  //if the target could be within the range of letters then return val at start index. Eg: tar=9 , [2,3,5,6,8,10]. startIdx= 5, endIdx = 4. So answer is 10 (index 5)
                return letters[start];    //Eg2:  tar=1 , [2,3,5,6,8,10]. startIdx= 0, endIdx = -1. So answer is 2 (startIdx= 0)
            } else   //if the target is out of range Eg: tar=11,[1,3,5,6,8,10]. startIdx=6, endIdx=5. So ans is 1 (0 first idx)
                return letters[0];
        }
        int mid = (start + end) / 2;

        if (target >= letters[mid]) {  //if target found (skip duplicates) or > midVal then continue searching right side
            return binarySearchRightMost(letters, target, mid + 1, end);
        } else {
            return binarySearchRightMost(letters, target, start, mid - 1);
        }
    }

    public char findRightMostIdxOfTarget_recursion2(char[] letters, char target, int start, int end) {
        if (start > end) {
            if (start < letters.length)
                return letters[start];
            else {
                return letters[0];
            }
        }

        int mid = (start + end) / 2;

        if (target == letters[mid]) {
            start = mid + 1;
        } else if (target < letters[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return findRightMostIdxOfTarget_recursion2(letters, target, start, end);
    }

    public static void main(String[] args) {
        BinarySearch_FindSmallestLetterGreaterThanTarget_744 b = new BinarySearch_FindSmallestLetterGreaterThanTarget_744();
        System.out.println(b.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')); // f
        System.out.println(b.nextGreatestLetter(new char[]{'e', 'e', 'g', 'g'}, 'g')); // e
        System.out.println(b.nextGreatestLetter(new char[]{'a', 'b', 'd', 'e', 'f', 'g'}, 'c')); // d // start becomes > end
        System.out.println(b.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')); // c
        System.out.println(b.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k')); // c
        System.out.println(b.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j')); // c
        System.out.println(b.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g')); // j   //end becomes < start

    }

}
