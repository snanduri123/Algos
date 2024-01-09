package AppleLeetcode;

import java.util.*;

public class TopKFreqWords_PQ {

    class Obj{
        String word;
        int freq;
        public Obj(String w, int f){
            word = w;
            freq = f;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {

       // PriorityQueue<Obj> pq = new PriorityQueue<>((a, b) -> a.freq != b.freq ? a.freq- b.freq : b.word.compareTo(a.word));

        PriorityQueue<Obj> pq = new PriorityQueue<>((a, b) -> a.freq == b.freq ? b.word.compareTo(a.word) : a.freq- b.freq) ;

        HashMap<String,Integer> map = new HashMap<>();
        List<String> answer = new ArrayList();

        for(String word: words){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }else{
                map.put(word, 1);
            }
        }

        for(Map.Entry<String,Integer> pair: map.entrySet()){
            Obj obj = new Obj(pair.getKey(), pair.getValue());
            pq.add(obj);
            if(pq.size() > k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            answer.add(0,pq.poll().word);
        }
        return answer;
    }
}
