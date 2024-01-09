import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class KeyboardRow {

     public static void main (String[] args){
       String[] words = new String[2];
       words[0] = "a";
       words[1] = "b";
        for (String  word : findWords(words)){
            System.out.println(word);
        }


     }
    public static String[] findWords(String[] words) {

        ArrayList<Set<Character>> keyboardAlphabetsInRows = new ArrayList<Set<Character>>();
        Set<Character> h1 = new HashSet<Character>();
        h1.add('Q');
        h1.add('W');
        h1.add('E');
        h1.add('R');
        h1.add('T');
        h1.add('Y');
        h1.add('U');
        h1.add('I');
        h1.add('O');
        h1.add('P');
        keyboardAlphabetsInRows.add(h1);

        Set<Character> h2 = new HashSet<Character>();
        h2.add('A');
        h2.add('S');
        h2.add('D');
        h2.add('F');
        h2.add('G');
        h2.add('H');
        h2.add('J');
        h2.add('K');
        h2.add('L');
        keyboardAlphabetsInRows.add(h2);

        Set<Character> h3 = new HashSet<Character>();
        h3.add('Z');
        h3.add('X');
        h3.add('C');
        h3.add('V');
        h3.add('B');
        h3.add('N');
        h3.add('M');
        keyboardAlphabetsInRows.add(h3);


        ArrayList<String> finalWords = new ArrayList<>();
        for(String word : words){
            if(findWord( word, keyboardAlphabetsInRows)){
                finalWords.add(word);
            }
        }
        return finalWords.toArray(new String[finalWords.size()]);
    }

    public static boolean findWord(String s, ArrayList<Set<Character>> keyboardAlphabetsInRows) {
        boolean b = true;
        for (int i=0; i<3 ; i ++){
            char[] arr = s.toCharArray();
            if(keyboardAlphabetsInRows.get(i).contains(Character.toUpperCase(arr[0]))){
                for(int j = 1 ; j < s.length(); j++){
                    if(!keyboardAlphabetsInRows.get(i).contains(Character.toUpperCase(s.toCharArray()[j]))){
                        b = false;
                        break;
                    }
                }
                break;
            }
        }
        return b;
    }


}
