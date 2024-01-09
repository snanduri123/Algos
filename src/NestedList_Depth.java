//if list = [[1,2],1,[1,[2,3]] then print sum = 1*2 + 2*2 + 1*1 + 1*2 + 2*2 +3*2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedList_Depth {


    public static void main(String[] args) {
        List<Object> l = new ArrayList<>();
        //Object ob = l;

        l.add(Arrays.asList(1,2));
        l.add(3);
        l.add(Arrays.asList(3, Arrays.asList(5,6)));

        System.out.println(findDepth(l, 0));
    }

    /*public static int findDepth(Object ob, int depth) {

        int sum = 0;

        for (int i = 0; i < ls.size() ; i++) {

            Object ob = ls.get(i);

            if (ob instanceof Integer) {
                sum += (Integer) ob * depth;
            } else {
                depth = depth + 1;
                sum += findDepth(ob, depth);


                }

        }
        sum = sum + temp;
        return sum;
    }*/

    public static int findDepth(Object ob, int depth) {

        int sum = 0;

        if (ob instanceof Integer) {
            return (Integer) ob * depth;
        } else {
            List<Object> list = (List<Object>) ob;

            int newDepth = depth + 1;
            for (int i = 0; i < list.size() ; i++) {
                sum += findDepth(list.get(i), newDepth);
            }
        }

        return sum;
    }
}
