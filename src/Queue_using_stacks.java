/*
mplement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.


Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 */

import java.util.Stack;

public class Queue_using_stacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
//    public Queue_using_stacks() {
//        s1 = new Stack<>();
//        s2 = new Stack<>();
//    }

    //Time : O(n). Each element is pushed and popped twice (from 2 stacks together).
    //Space: O(n)
    public void push(int x) {

        // empty stack1 into stack2 to keep the first inserted element of stack1 is always in top after the below process.
        while (!s1.empty()) {
            s2.push(s1.pop()); //either add() or push() can be used
        }

        // add new element into emptied Stack1
        s1.add(x); //either add() or push() can be used

        // add all elements from stack2 to stack 1. Now the first inserted element of stack1 is on top.
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

    }

    //Time : O(1)
    public int pop() {
        return s1.pop();
    }

    //Time : O(1)
    public int peek() {
        return s1.peek();
    }

    //
    public boolean empty() {
        return s1.empty();
    }
}
