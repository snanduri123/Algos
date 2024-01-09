/*
An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.

Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.



Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Example 3:

Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
Output: false


Constraints:

rec1.length == 4
rec2.length == 4
-109 <= rec1[i], rec2[i] <= 109
rec1 and rec2 represent a valid rectangle with a non-zero area.
 */

public class RectangleOverlap_836 {


    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        return !(rec1[0] >=rec2[2] || rec2[0]>=rec1[2] || rec1[1]>=rec2[3] || rec2[1]>=rec1[3]); //return false
    }


    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if (rec1[0]>=rec2[2])
            return false;
        if (rec2[0]>=rec1[2])
            return false;
        if (rec1[1]>=rec2[3])
            return false;
        if (rec2[1]>=rec1[3])
            return false;
        return true;
    }

    //Time :O(n) - read elements for constant times.
    //Space: O(1)
    public boolean isRectangleOverlap3(int[] rec1, int[] rec2) {

        int[] first = rec1;
        int[] sec = rec2;
        if(rec1[0] > rec2[0]) {  // making the left most rectangle as the first rectangle
            first = rec2;
            sec = rec1;
        }

        if(     ((sec[0] > first[0]) && (sec[1] > first[1]) && (sec[0] < first[2]) && (sec[1] < first[3])) || //If left bottom corner (x1,y1), is in the first rectangle
                ((sec[2] > first[0]) && (sec[3] > first[1]) && (sec[0] < first[2]) && (sec[3] < first[3])) || //If right upper corner (x2,y2), is in the first rectangle
                ((sec[2] > first[0]) && (sec[1] > first[1]) && (sec[2] < first[2]) && (sec[1] < first[3])) || //If right bottom corner(x1,y2), is in the first rectangle
                ((sec[0] > first[0]) && (sec[3] > first[1]) && (sec[0] < first[2]) && (sec[3] < first[3])) || //If left upper corner (x2,y1), is in the first rectangle
                ((sec[0] == first[0]) && (sec[2] > first[1] && sec[2] < first[3])) ||    //if both have same x1 then check if y1 of sec rectangle is overlapping (in between y1 and y2 of first rectangle)
                ((sec[0] == first[0]) && (sec[3] > first[1] && sec[2] < first[3])) ||   //if both have same x1 then check if y2 of sec rectangle is overlapping (in between y1 and y2 of first rectangle)
                ((sec[0] == first[0]) && (first[1] > sec[1] && first[1] < sec[3])) ||    //if both have same x1 then check if y1 of first rectangle is overlapping (in between y1 and y2 of sec rectangle)
                ((sec[0] == first[0]) && (first[3] > sec[1] && first[3] < sec[3])) ||   //if both have same x1 then check if y2 of first rectangle is overlapping (in between y1 and y2 of sec rectangle)
                ((sec[2] == first[2]) && (sec[2] > first[1] && sec[2] < first[3])) ||   //if both have same x2 then check if y1 of sec rec overlaps
                ((sec[2] == first[2]) && (sec[3] > first[1] && sec[2] < first[3])) ||   //if both have same x2 then check if y1 of sec rec overlaps
                ((sec[1] == first[1]) && (sec[0] > first[0] && sec[0] < first[2])) ||   //if both have same y1 then check if x1 overlaps
                ((sec[1] == first[1]) && (sec[2] > first[0] && sec[2] < first[2])) ||   //if both have same y1 then check if x2 overlaps
                ((sec[3] == first[3]) && (sec[0] > first[0] && sec[0] < first[2])) ||   //if both have same y2 then check if x1 overlaps
                ((sec[3] == first[3]) && (sec[2] > first[0] && sec[2] < first[2])) ||  //if both have same y2 then check if x2 overlaps)
                ((sec[0] > first[0]) && (sec[2] < first[2]) && (sec[1] < first[1]) && (sec[3] > first[3]))) // if 2 rectangles make like plus then they have common area too.
             {
                 return true;
             }
        return false;
    }

    public static void main(String[] args){
        RectangleOverlap_836 r = new RectangleOverlap_836();
        System.out.println(r.isRectangleOverlap(new int[]{3,3,4,4}, new int[]{1,1,2,2})); //true
        System.out.println(r.isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3})); //true
        System.out.println(r.isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1})); //false
        System.out.println(r.isRectangleOverlap(new int[]{0,0,1,1}, new int[]{2,2,3,3})); //false
        System.out.println(r.isRectangleOverlap(new int[]{4,4,14,7}, new int[]{4,3,8,8})); //true
        System.out.println(r.isRectangleOverlap(new int[]{5,15,8,18}, new int[]{0,3,7,9})); //false
        System.out.println(r.isRectangleOverlap(new int[]{-7,-3,10,5}, new int[]{-6,-5,5,10})); //true  //rectangles like plus
    }
}
