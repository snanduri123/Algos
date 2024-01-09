import java.util.Stack;

public class Stack_Usage {

    public static void main (String args[]) {
        Stack s = new Stack();
        s.push("A");
        s.push("B");
        s.push("C");

        Object obj = s.pop(); //removes the object and returns

        //NOTE: no function to remove element other than the one in the top of the stack
        System.out.println(s.pop());

    }
}
