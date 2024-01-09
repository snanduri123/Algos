package AppleLeetcode;

import java.util.Arrays;

public class BoatsToSavePeople_881 {

    //Time: O(nlogn) //sorting and reading input.
    //Space: O(logn) //sorting.
    //Greedy approach with 2 pointers/ two pointers. left and right.
    public int numRescueBoats(int[] people, int limit) {

      int i=0;
      int j=people.length-1;
      Arrays.sort(people);
      int boats = 0;

      while(i < j){
          if( people[i] + people[j] > limit){  // heaviest one will take a boat and leave, so decrement j;
              boats++;
              j--;
          }else if(people[i] + people[j] <= limit){ //at most only 2 can fit in a boat,so if totweight is <= limit
              boats++;                              // both lightest and heaviest will take boat and leave,
              i++;                                  //so decrement both i and j;
              j--;
          }
      }
      if(i==j)
          boats++;
      return boats;
    }

    public static void main (String args[]){
        BoatsToSavePeople_881 b = new BoatsToSavePeople_881();
        System.out.println(b.numRescueBoats(new int[]{1,2}, 3)); // 1 boat  (1, 2)
        System.out.println(b.numRescueBoats(new int[]{3,2,2,1}, 3)); // 3 boats (1, 2), (2) and (3)
        System.out.println(b.numRescueBoats(new int[]{3,5,3,4}, 5)); // 4 boats (3), (3), (4), (5)
        System.out.println(b.numRescueBoats(new int[]{5,1,4,2}, 6)); // 2 boats**  (5,1), (4,2)
        System.out.println(b.numRescueBoats(new int[]{3,2,3,2,2}, 6)); // 3 boats**  (3), (3), (2,2,2)
        System.out.println(b.numRescueBoats(new int[]{2,2,2,2,2}, 10)); // 1 boats**  (2,2,2,2,2)
    }
}
