package AppleLeetcode;

import java.util.*;

public class GroupAnagrams_49 {

    //Time : nwords * O(wordlen)
    //Space: n * O(wlen)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Bucket sort to find the key
            char[] ch = new char[26];   //remember its not int[]
            for (char c : s.toCharArray()) {
                ch[c - 'a']++;
            }
            String key = String.valueOf(ch);    //***/converts array to string ****

            if(!map.containsKey(key)){//add key to map along with the string as value
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }else{   //add string to existing list of the key.
                map.get(key).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }


    //Time : O(n^2)
    //Space:  m * (chars of eachString)  + m * (chars of eachString) = m * hashmap1Size + m * hashmap2Size
    //For large input (10^4, it gives TLE)
    public List<List<String>> groupAnagrams_BadApproach(String[] strs) {

        boolean[] isVisited = new boolean[strs.length];
        List<List<String>> anagramsGroups = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if (!isVisited[i]) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(strs[i]);
                HashMap<Character, Integer> s1map = getCharCount(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (!isVisited[j] && isAnagram(s1map, strs[j])) {
                        anagrams.add(strs[j]);
                        isVisited[j] = true;
                    }
                }
                anagramsGroups.add(anagrams);
                isVisited[i] = true;
            }
        }
        return anagramsGroups;
    }

    public HashMap<Character, Integer> getCharCount(String s1) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public boolean isAnagram(HashMap<Character, Integer> s1map, String s2) {

        HashMap<Character, Integer> s2map = new HashMap<>();

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (s2map.containsKey(c)) {
                s2map.put(c, s2map.get(c) + 1);
            } else {
                s2map.put(c, 1);
            }
        }

        if (s1map.size() != s2map.size()) {  //s2 could be subset of s1 Eg: ac , c
            return false;
        }

        for (Map.Entry<Character, Integer> pair : s2map.entrySet()) {
            if (!s1map.containsKey(pair.getKey()) || s1map.get(pair.getKey()) != pair.getValue()) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        GroupAnagrams_49 g = new GroupAnagrams_49();
//        System.out.println(g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})); //[[eat, tea, ate], [tan, nat], [bat]]
//        System.out.println(g.groupAnagrams(new String[]{""})); //[[]]
//        System.out.println(g.groupAnagrams(new String[]{"a"})); //[[a]]
//        System.out.println(g.groupAnagrams(new String[]{"ac", "c"})); //[[ac], [c]]
//        System.out.println(g.groupAnagrams(new String[]{"ddddddddddg", "dgggggggggg"})); //[["dgggggggggg"],["ddddddddddg"]]
//
          char  ch[] = new char[]{'g','o','d'};
          System.out.println(String.valueOf(ch));

        char  ch2[] = new char[]{'g','o','o','d'};
        System.out.println(String.valueOf(ch2));

        char  ch3[] = new char[26];

        String s = "god";
        for (char c : s.toCharArray()) {
            ch[c - 'a']++;
        }
        System.out.println(String.valueOf(ch3));
        System.out.println(ch3);
    }
}
