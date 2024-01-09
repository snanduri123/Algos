import java.util.PriorityQueue;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.


Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // 8,5,4,3,2        ---> return 4
kthLargest.add(5);   // 8,5,5,4,3,2      ---> return 5
kthLargest.add(10);  // 10,8,5,5,4,3,2   ---> return 5
kthLargest.add(9);   // 10,8,8,5,5,4,3,2 ---> return 8
kthLargest.add(4);   // 10,8,8,5,5,4,4,3,2 ---> return 8


Constraints:

1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
It is guaranteed that there will be at least k elements in the array when you search for the kth element.

 */

//Time : O(nlogn)
//Space: O(k)
public class PQ_Kth_Largest_Element_in_a_Stream_703 {

    int k;
    PriorityQueue<Integer> pq = new PriorityQueue(); //ascending order. Small numbers will be at the front of queue to be popped out.

    public PQ_Kth_Largest_Element_in_a_Stream_703(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            pq.add(num);   //first add the element
            if (pq.size() > k)  // if PQ has an extra element than required k size then remove the smallest.
                pq.poll();  //top (smallest) number will be removed.
        }
    }

    public int add(int val) {

        for(Integer num : pq){
            System.out.println(num);
        }
        pq.add(val);
        if (pq.size() > k)
            pq.poll();
        return pq.peek(); // top element is returned.
    }

    public static void main(String[] args) {
        //1.
        PQ_Kth_Largest_Element_in_a_Stream_703 k = new PQ_Kth_Largest_Element_in_a_Stream_703(3, new int[]{4, 5, 8, 2});  //8 5 4
        System.out.println(k.add(3)); // 8 5 4 --> 4
        System.out.println(k.add(5)); // 8 5 5 --> 5 //so if number is already present then it is still inserted and considered.
        System.out.println(k.add(10)); // 10 8 5 --> 5
        System.out.println(k.add(9)); // 10 9 5 --> 5
        System.out.println(k.add(4)); // 10 9 5 --> 5

        System.out.println("--------------");
        PQ_Kth_Largest_Element_in_a_Stream_703 k2 = new PQ_Kth_Largest_Element_in_a_Stream_703(1, new int[]{});  //
        System.out.println(k2.add(-3)); // -3 --> -3
        System.out.println(k2.add(-2)); // -3 --> -3 //so if number is already present then it is still inserted and considered.
        System.out.println(k2.add(-4)); // -4 --> -4
        System.out.println(k2.add(0)); // 0 --> 0
        System.out.println(k2.add(4)); // 4 --> 4

    }
}
