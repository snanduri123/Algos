import java.util.HashMap;

public class FirstUniqueCharacter {

    //Time Complexity: O(n) + O(n)
    //Time Complexity: K
    public int firstUniqChar(String s) {

        if (s == null || s.length() == 0)
            return -1;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(int i=0; i< s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter t = new FirstUniqueCharacter();
        System.out.println(t.firstUniqChar("leetcode")); //0
        System.out.println(t.firstUniqChar("loveleetcode")); //2
        System.out.println(t.firstUniqChar("aabb")); //-1
    }
}
