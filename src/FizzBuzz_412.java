/*
412. Fizz Buzz
Easy
1.9K
261
company
Amazon
JPMorgan
company
Google
Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.


Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
Example 3:

Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]


Constraints:

1 <= n <= 104
 */

import java.util.*;

public class FizzBuzz_412 {

    //Time: O(n)
    //Space: O(1)
    //faster approach. but not scalable if more divisors are added.
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for(int i = 1  ; i <= n; i++){
            if(i%3 == 0 && i%5 == 0)
                answer.add("FizzBuzz");
            else if(i%3 ==0)
                answer.add("Fizz");
            else if(i%5 ==0)
                answer.add("Buzz");
            else
                answer.add(String.valueOf(i));
        }
        return answer;
    }

    //Time: O(n*m) - everytime we divide with all the 3 options.
    //Space: O(m)   no. of divisors.
    //Not faster but using LinkedHashMap for optimization incase in future if there are more divisors so that only map is changed.
    // LinkedHashMap also help to get the divisors in insertion order so that
    // values can be appended in the order of the divisors.
    public List<String> fizzBuzz2(int n) {
        LinkedHashMap<Integer,String> map = new LinkedHashMap<>(){{
            put(3, "Fizz");
            put(5, "Buzz");
        }};
        List<String> answer = new ArrayList<>();
        for(int i=1; i<=n; i++){
            StringBuilder ans = new StringBuilder();
            for(Integer divisor : map.keySet()){
                if(i%divisor ==0){
                    ans.append(map.get(divisor));
                }
            }
            if(ans.length() == 0){
                ans.append(String.valueOf(i));
            }
            answer.add(ans.toString());
        }
        return answer;
    }
}
