/*
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.



Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.


Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]


Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 */

import java.util.*;

public class PQ_TopKFrequentWords_692 {  //Medium

    PriorityQueue<StrFreq> pq = new PriorityQueue<>((a,b) -> (a.freq != b.freq) ?  a.freq - b.freq  : b.str.compareTo(a.str));
    List<String> ans = new ArrayList<>();

    public List<String> topKFrequent(String[] words, int k){

        HashMap<String, Integer> map = new HashMap<>();

        for(String s : words) {
            map.put(s, map.getOrDefault(s,0) + 1);
        }

        for(Map.Entry<String,Integer> pair : map.entrySet()){
            pq.add(new StrFreq(pair.getKey(), pair.getValue()));

            if(pq.size() > k){
                pq.remove();
            }
        }

        while (!pq.isEmpty()) {
            ans.add(0, pq.poll().str);
        }

        return ans;

    }

    class StrFreq {
        String str;
        Integer freq;

        public StrFreq(String s, Integer f){
            str = s;
            freq = f;
        }
    }

    public static void main(String[] str){
        //PQ_TopKFrequentWords_692 p1 = new PQ_TopKFrequentWords_692();
        //System.out.println(p1.topKFrequent(new String[] {"i","love","leetcode","i","love","coding"}, 2));  // "i","love"


        PQ_TopKFrequentWords_692 p2 = new PQ_TopKFrequentWords_692();
        System.out.println(p2.topKFrequent(new String[] {"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"}, 14));  // "the","is","sunny","day"

    }

}
