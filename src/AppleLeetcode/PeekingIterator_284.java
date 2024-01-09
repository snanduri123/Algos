package AppleLeetcode;

/*

Code

Testcase
Testcase
Test Result

284. Peeking Iterator
Medium
Topics
Companies
Hint
Design an iterator that supports the peek operation on an existing iterator in addition to the hasNext and the next operations.

Implement the PeekingIterator class:

PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator iterator.
int next() Returns the next element in the array and moves the pointer to the next element.
boolean hasNext() Returns true if there are still elements in the array.
int peek() Returns the next element in the array without moving the pointer.
Note: Each language may have a different implementation of the constructor and Iterator, but they all support the int next() and boolean hasNext() functions.



Example 1:

Input
["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 2, 2, 3, false]

Explanation
PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
peekingIterator.hasNext(); // return False


Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
All the calls to next and peek are valid.
At most 1000 calls will be made to next, hasNext, and peek.


Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */

import java.util.Iterator;

public class PeekingIterator_284 implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer next;
    boolean isUsable = false;

    public PeekingIterator_284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!isUsable) { //If cursor has not started yet OR cursor is at curr value because we did next() previously and can't be used because we need to give next element i.e, peek()
           next = iterator.next();   //iterator ACTUALLY moves onetime and we store the value and keep returning as many times as peek() is called simultaneously. So when we call next() after peek(), there we do not move the iterator FIRST TIME (by calling next()) instead we give this value for that ONE TIME.
           isUsable = true;  //we can return this value if we do again peek() any number of times after or do next() one time after.
        }
        return next;     //if previously
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(!isUsable) {  //cursor did not move to next element because peek() is not called previously. Cursor is at current place organically because of previous next() calls.
            next = iterator.next();  //so to get the next element, do next() simply.
        }
        isUsable = false;     //this current value can't be used to return for peek() or next() calls later (because for both peek() and next() we need to return next element not curr element) that we do after this operation.
        return next;     //if peek() was called before this then we do not iterate like above, instead we just turn off isUsable and return what peek() already got.
    }

    @Override
    public boolean hasNext() {
        if (isUsable) {  //if you did peek() previously then you already know that there is next element (and ofcourse virtually the iterator is also pointing to that next element)
            return true;
        }
        return iterator.hasNext();
    }

}
