import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

    public static void main(String[] args) {
        System.out.println(isIsomorphic2("add", "egg")); //true
        System.out.println(isIsomorphic2("aaa", "bbb")); //true
        System.out.println(isIsomorphic2("ab", "aa"));  //false
        System.out.println(isIsomorphic2("abyyzz", "aaddpz")); //true
    }
    public static boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey((s.charAt(i)))) { //if same key ("s")is present in the map then value should be same
                Character val = map.get(s.charAt(i));
                if (t.charAt(i) != val) {
                    return false;
                }
            } else if (map.containsValue((t.charAt(i)))) { // if same key ( "s") does not present then check if value ("t") is already by any other key
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

}