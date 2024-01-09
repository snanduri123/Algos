import java.util.ArrayList;

public class String_Compression_443 {


    public int compress(char[] chars) {


        ArrayList<String> s = new ArrayList<>();

        s.add(Character.toString(chars[0]));

        int i = 1;
        int count = 1;

        while (i < chars.length) {

            System.out.println("chars[i]" + chars[i]);
            System.out.println("chars[i-1]" + chars[i-1]);

            int a = chars[i];
            int b = chars[i-1];

            System.out.println("a" + a);
            System.out.println("b" + a);

//            System.out.println("Character.toString(chars[i]" + Character.toString(chars[i]));
//            System.out.println("Character.toString(chars[i]" + Character.toString(chars[i - 1]));
//            if (chars[i] != chars[i - 1]) {
            if (a!=b) {
                if (count != 1) {
                    String number = String.valueOf(count);
                    char[] numbers = number.toCharArray();
                    for (char num : numbers) {
                        s.add(Character.toString(num));
                    }
                    count = 1;
                }
                s.add(Character.toString(chars[i]));
            } else {
                count++;
            }
            i++;
        }

        if (count != 1) {
            String number = String.valueOf(count);
            char[] numbers = number.toCharArray();
            for (char num : numbers) {
                s.add(Character.toString(num));
            }
            count = 1;
        }

        int j =0;
        for(String str : s) {
           chars[j] =  str.charAt(0);
           j++;
        }
      return s.size();
    }




    public static void main(String[] args){

        String_Compression_443 s = new String_Compression_443();
//        char[] c = {'a','b','b','b','b','b','b','b','b','b','b'};
//        System.out.println(s.compress(c));

        char[] c2 = {'a','a','b','b','c','c','c'};

        System.out.println(s.compress(c2));
    }

}
