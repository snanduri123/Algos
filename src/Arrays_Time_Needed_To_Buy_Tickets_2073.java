/*
There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line.

You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would like to buy is tickets[i].

Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy, the person will leave the line.

Return the time taken for the person at position k (0-indexed) to finish buying tickets.



Example 1:

Input: tickets = [2,3,2], k = 2
Output: 6
Explanation:
- In the first pass, everyone in the line buys a ticket and the line becomes [1, 2, 1].
- In the second pass, everyone in the line buys a ticket and the line becomes [0, 1, 0].
The person at position 2 has successfully bought 2 tickets and it took 3 + 3 = 6 seconds.
Example 2:

Input: tickets = [5,1,1,1], k = 0
Output: 8
Explanation:
- In the first pass, everyone in the line buys a ticket and the line becomes [4, 0, 0, 0].
- In the next 4 passes, only the person in position 0 is buying tickets.
The person at position 0 has successfully bought 5 tickets and it took 4 + 1 + 1 + 1 + 1 = 8 seconds.


Better
Explanation: Input: tickets = [3,2,4,5,2,8], k = 4
              1. That means every person in front of him (tickets[4] = 2)
                    if they are buying 2 or >2 tickets then each of them have to take minimum 2 turns each. (or)
                    if they are buying <2 tickets each of them will get as many turns as they have to buy
              2. Every person after him
                    if they are buys 2 or > 2 tickets then each of them get 1 lesser turn than him because he gets to finish buying first.
                    if they are buying <2 tickets each of them will get as many turns as they have to buy
              3. Himself needs 2 turns

              So for [3,  2,  4,  5,  2,  8]
                                      ^
                      2 + 2 + 2 + 2 + 2 + 1     = 10
               -----------------       -----------------          -----------------
               Input: tickets = [1,2,4,5,2,8,1], k = 4 =====>Output:  1+2+2+2+2+2+1+1 = 13
                                         ^
               -----------------       -----------------          -----------------
               Input: tickets = [1,2,4,5,3,2,8,1], k = 5 =====>Output:  1+2+2+2+2+2+2+1 = 14
                                         ^
               -----------------       -----------------          -----------------


Constraints:

n == tickets.length
1 <= n <= 100
1 <= tickets[i] <= 100
0 <= k < n
 */

public class Arrays_Time_Needed_To_Buy_Tickets_2073 {


    //Time : O(n), space: O(1)
    public int timeRequiredToBuy(int[] tickets, int k){

        int count = 0;

        for(int i=0; i< tickets.length; i++){
            if(tickets[i] < tickets[k]) {  // if they are buying < tickets[k] then each of them will get as many turns as they have to buy
                count = count + tickets[i];
            }
            else{
                if(i <= k) {  //HIMSELF buying or any person BEFORE him buys tickets more than him then they have to wait until k finishes buying.
                    count = count + tickets[k];
                }
                else{
                    count = count + (tickets[k] -1); // any person AFTER him but buying more tickets will get 1 lesser turn than him until he finishes buying.
                }
            }

        }
        return count;
    }

    public static void main(String[] args){
        Arrays_Time_Needed_To_Buy_Tickets_2073 t = new Arrays_Time_Needed_To_Buy_Tickets_2073();
        System.out.println(t.timeRequiredToBuy(new int[] {2,3,2},2)); // 6
        System.out.println(t.timeRequiredToBuy(new int[] {5,1,1,1},0)); // 8
        System.out.println(t.timeRequiredToBuy(new int[] {3,2,4,5,2,8},4)); //11
        System.out.println(t.timeRequiredToBuy(new int[] {1,2,4,5,2,8,1},4)); //23
        System.out.println(t.timeRequiredToBuy(new int[] {1,2,4,5,3,2,8,1},5)); //13
    }
}
