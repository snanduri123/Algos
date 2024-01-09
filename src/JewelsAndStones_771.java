import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
S and J will consist of letters and have length at most 50.
The characters in J are distinct.
*/
public class JewelsAndStones_771 {

    public static void main(String[] args) {
        JewelsAndStones_771 j = new JewelsAndStones_771();
        System.out.println(j.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(j.numJewelsInStones("z", "ZZ"));
    }

    //Time: O(J.length+S.length)
    //Space: O(j.length)  -- set for jewels
    public int numJewelsInStones(String jewels, String stones) {

        int count =0;

        HashSet<Character> jewelsSet = new HashSet<>();

        for(Character jewel : jewels.toCharArray()){
            jewelsSet.add(jewel);
        }

        for(Character stone : stones.toCharArray()){
            if(jewelsSet.contains(stone)){
                count++;
            }
        }

        return count;
    }

    public static int numJewelsInStones2(String J, String S) {
        int num = 0;

        List<Character> charObjectArrayS = S.chars().mapToObj(c -> (char) c).collect(Collectors.toList()); //ArrayUtils.toObject(charArrayS);

        List<Character> charObjectArrayJ = J.chars().mapToObj(c -> (char) c).collect(Collectors.toList()); //ArrayUtils.toObject(J.toCharArray());

        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        for (int i = 0; i < charObjectArrayS.size(); i++) {

            if (smap.containsKey(charObjectArrayS.get(i))) {
                Integer value = smap.get(charObjectArrayS.get(i));
                smap.put(charObjectArrayS.get(i), value + 1);
            } else {
                smap.put(charObjectArrayS.get(i), 1);
            }
        }
        for (int i = 0; i < charObjectArrayJ.size(); i++) {
            if (smap.containsKey(charObjectArrayJ.get(i))) {
                num = num + smap.get(charObjectArrayJ.get(i));
            }
        }
        return num;
    }
}
