/*
Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5


Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
 */

import java.util.Stack;

public class Stack_OnlineStockSpan_901 {

    Stack<Stock> stack;
    class Stock{
        int price;
        int days = 0;
        public Stock(int price){
            this.price = price;
        }
    }
    //Time:O(n)
    //Space: O(n)
    public Stack_OnlineStockSpan_901() {
         stack = new Stack<>();
    }

    public int next(int price) {

        Stock stock = new Stock(price);
        if(stack.isEmpty() || stack.peek().price > price){
            stock.days = 1;
            stack.add(stock);
            return 1;
        }else{
            int totSmallPriceDays = 0;
            while(!stack.isEmpty() && stack.peek().price <= price) {
                totSmallPriceDays = totSmallPriceDays + stack.pop().days;
            }
            stock.days = totSmallPriceDays + 1;
            stack.add(stock);
            return stock.days;
        }

    }

    public static void main(String[] args) {
        Stack_OnlineStockSpan_901 stockSpanner = new Stack_OnlineStockSpan_901();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6

    }
}
