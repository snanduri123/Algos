import java.util.HashMap;

public class Logger {

    HashMap<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    //Time complexity: O(n)
    //Space complexity: K
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message) || (timestamp >= map.get(message)) ){
            map.put(message, timestamp + 10);
        }
        else{
            if(timestamp < map.get(message))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Logger l = new Logger();
        //1.
//        System.out.println(l.shouldPrintMessage(1, "foo")); //true . timestamp for "foo" will be 1 + 10 = 11
//        System.out.println(l.shouldPrintMessage(2, "bar")); //true. timestamp for "bar" is 2 + 10 = 12
//        System.out.println(l.shouldPrintMessage(3, "foo")); //false //3 < 11
//        System.out.println(l.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
//        System.out.println(l.shouldPrintMessage(10, "foo")); // 10 < 11, return false
//        System.out.println(l.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, nex

        //2.
//        System.out.println(l.shouldPrintMessage(100, "bug"));
//        System.out.println(l.shouldPrintMessage(111, "bug"));

        //3. scenario where one message (Eg: "A") was first printed, then not printed because of less wait time
        // and then printed because now wait time was sufficient
        System.out.println(l.shouldPrintMessage(0,"A")); //true, A -> 0 + 10 = 11
        System.out.println(l.shouldPrintMessage(0,"B")); //true, B -> 0 + 10 = 11
        System.out.println(l.shouldPrintMessage(0,"C")); //true, C -> 0 + 10 = 11
        System.out.println(l.shouldPrintMessage(0,"A")); //0 < 11 - false
        System.out.println(l.shouldPrintMessage(0,"B")); //0 < 11 - false
        System.out.println(l.shouldPrintMessage(0,"C")); //0 < 11 - false
        System.out.println(l.shouldPrintMessage(11,"A"));//11 = 11 - true
        System.out.println(l.shouldPrintMessage(11,"B"));//11 = 11 - true
        System.out.println(l.shouldPrintMessage(11,"C"));//11 = 11 - true
        System.out.println(l.shouldPrintMessage(11,"A"));
    }
}
