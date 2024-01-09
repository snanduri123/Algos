import java.util.*;

/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.



Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]


Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
 */
public class SortArray_By_IncreasingFrequency_1636 {

    //Time complexity : sorting + readinglist -> nlogn + n -> n
    //Space complexity: hashmap + list -> 2n -> n
    //faster than using List<List<integer>>
    public int[] frequencySort(int[] nums) {

        int[] result = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //Because hashmap does not maintain order (even after sorting), collecting all the elements into Arraylist.
        // key is the number and value is its frequency
        List<Map.Entry<Integer, Integer>> numFreqList = new ArrayList<>(map.entrySet());
        //Collections.sort(numFreqList, new sortByValue());
        Collections.sort(numFreqList, ((a,b) -> (a.getValue() == b.getValue()) ? b.getKey() - a.getKey() : a.getValue() - b.getValue()));

        int resIdx = 0;
        for (Map.Entry<Integer, Integer> numFreq : numFreqList) {
            for (int i = 0; i < numFreq.getValue(); i++) {
                result[resIdx] = numFreq.getKey();
                resIdx++;
            }
        }

        return result;
    }


    //Time complexity : reading inputArr + readingMap + sort -> n + n + nlogn =  nlogn
    //Space complexity: hashmap + list -> 2n -> n
    public int[] frequencySort1(int[] nums) {  //not as fast as the List<Map.Entry<Integer,Integer>>

        int[] ans = new int[nums.length];

        HashMap<Integer,Integer> map = new HashMap<>();

        List<List<Integer>> freq = new ArrayList<>(); // each idx in list has 2 elements - num and its frequency.

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            List<Integer> pair = new ArrayList<>();
            pair.add(0,entry.getKey());
            pair.add(1,entry.getValue());
            freq.add(pair);
        }

        Collections.sort(freq, (a, b) -> (a.get(1) == b.get(1) ? b.get(0) - a.get(0) : a.get(1) - b.get(1)));

        int idx = 0;
        for(List<Integer> pair : freq){
            int count = 0;
            while(count < pair.get(1)){
                ans[idx] = pair.get(0);
                count++;
                idx++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SortArray_By_IncreasingFrequency_1636 s = new SortArray_By_IncreasingFrequency_1636();
        System.out.println(Arrays.toString(s.frequencySort(new int[]{1, 1, 2, 2, 2, 3}))); //3,1,1,2,2,2
        System.out.println(Arrays.toString(s.frequencySort(new int[]{2, 3, 1, 3, 2}))); //1,3,3,2,2
        System.out.println(Arrays.toString(s.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1}))); //5,-1,4,4,-6,-6,1,1,1
    }
}


class sortByValue implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

        //if second (o2) element is having lesser frequency then it is placed first in the collection
        // if both (o1 and o2) elements have same frequency then whichever number is greater that is placed first in the collection

        //return (o2.getValue() < o1.getValue() ? 1 : (o1.getValue() == o2.getValue()) ? (o2.getKey() > o1.getKey() ? 1 : -1) : -1);
        //return (o1.getValue() > o1.getValue() ? 1 : (o1.getValue() == o2.getValue()) ? (o2.getKey() - o1.getKey()) : -1);
        //return ((o1.getValue() == o2.getValue()) ? (o2.getKey() - o1.getKey()) : o1.getValue() - o2.getValue()); // not used because overflow happens if one value is INTEGER.MIN_VALUE and another is INTEGER.MAX_VALUE
        return ((o1.getValue() == o2.getValue()) ? (Integer.compare(o2.getKey(),o1.getKey())) : Integer.compare(o1.getValue(),o2.getValue()));

    }

}
