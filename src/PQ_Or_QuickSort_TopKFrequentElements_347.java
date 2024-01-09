/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.*;

public class PQ_Or_QuickSort_TopKFrequentElements_347 {
    //Time: O(nlogk)
    //Space: O(k) + O(n)
    public int[] topKFrequent2(int[] nums, int k) {
        int[] answer = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int[] numFreq = new int[2];
            numFreq[0] = pair.getKey();
            numFreq[1] = pair.getValue();
            pq.add(numFreq);
            if (pq.size() > k) {  // This will restrict size of pq and helps algorithm to be of logk instead of logn
                pq.poll();
            }
        }
        int count = 0;
        while (!pq.isEmpty()) {
            answer[count] = pq.poll()[0];
            count++;
        }
        return answer;
    }


    //Time: O(n) - best case and n^2 in worst case
    //Space: O(k) + O(n)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans;
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int i = 0;
        int[] arr = new int[map.size()];

        for(Integer num : map.keySet()){
            arr[i] = num;
            i++;
        }
        quickSort(arr, 0, arr.length -1 , map, k);

        ans = new int[k];
        int count = 0;
        for(int idx= arr.length -1 ; count < k ; idx--, count++){
            ans[count] = arr[idx];
        }
        return ans;
    }

    public void quickSort(int[] nums, int start, int end, HashMap<Integer,Integer> map, int k){

        if(start >= end)
            return;
        Random random = new Random();
        int pivot = start + random.nextInt(end - start);
        int j = pivot - 1;
        for(int i =start; i<=end;i++) {
            if(map.get(nums[i]) <= map.get(nums[pivot])){
                int temp = nums[j+1];
                nums[j+1] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        int temp = nums[j];
        nums[j] = nums[pivot];
        nums[pivot] = temp;
        quickSort(nums, start, j-1, map, k);
        quickSort(nums, j+1, end, map, k);
    }
    public static void main(String[] args) {
        PQ_Or_QuickSort_TopKFrequentElements_347 t = new PQ_Or_QuickSort_TopKFrequentElements_347();
//        System.out.println(Arrays.toString(t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); // 1,2
//        System.out.println(Arrays.toString(t.topKFrequent(new int[]{1}, 1))); // 1
//        System.out.println(Arrays.toString(t.topKFrequent(new int[]{1, 1, 1, 1, 1, 2, 2, 3, 3, 3}, 2))); // 1,3
        System.out.println(Arrays.toString(t.topKFrequent(new int[]{ 4,1,-1,2,-1,2,3}, 2))); // -1,2


    }
}
