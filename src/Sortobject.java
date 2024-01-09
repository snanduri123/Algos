import java.util.*;

public class Sortobject {
    public int num;
    public int freq;

    public Sortobject(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }


    public static void main(String[] args) {

        //1. Sorting Array Integers using comparator
        Integer[] arr = {2, 3, 1, 7, 6, 5};
        // Integer[] arr = {1, 2, 3, 4, 5, 6} ;
        System.out.println("actual array before sorting \n" + Arrays.toString(arr) + "\n ----------------");
        Arrays.sort(arr, new sortNumbersAscending()); //[1, 2, 3, 5, 6, 7]
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new sortNumbersDescending()); //[7, 6, 5, 3, 2, 1]
        System.out.println(Arrays.toString(arr));

        //2. Sorting Array Integers using lambda and Comparator
        Arrays.sort(arr, (Comparator.comparingInt(a -> a))); //[1, 2, 3, 5, 6, 7]
        System.out.println(Arrays.toString(arr));

        //3. Sorting Array Integers using lambda
        Arrays.sort(arr, ((a,b) -> a-b)); //[1, 2, 3, 5, 6, 7]
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, ((a,b) -> b-a)); //[1, 2, 3, 5, 6, 7]
        System.out.println(Arrays.toString(arr));

        //4. Sorting objects based on two values
        Sortobject s1 = new Sortobject(1, 2);
        Sortobject s2 = new Sortobject(2, 3);
        Sortobject s3 = new Sortobject(3, 1);
        Sortobject s4 = new Sortobject(4, 2);

        /* print in ascending frequency of number and if it is equal then descending order of number
           Eg: 1 1 2 2 2 3 4 4 4   ---> 3 4 4 1 1 2 2 2
               ---------------
               |  num |  freq  |
               |----------------
               |  1   |     2  |   --> a
               |  2   |     3  |
               |  3   |     1  |
               |  4   |     2  |   --> b
               -----------------
         */

        ArrayList<Sortobject> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        Collections.sort(list, new Sortobjects());  // now we got 3,4,1,2
        //*** code is pending to print answer ->3 4 4 1 1 2 2 2

    }
}

//sortNumbersAscending using a > b condition to return +ve so that
//system thinks a > b because you returned +ve value for a > b
//   and hence it puts b on left and a on right in the collection
//1. If 1,4 are passed as a and b to this method then it returns -ve so
// system will place 1 left and 4 right.
//2. If 4,1 are passed as a and b to this method then it returns +ve so
// system will place 1 left and 4 right.

class sortNumbersAscending implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {

         return Integer.compare(a, b); // best single line for below code.

        /*if (a > b)
            return 1;
        else if (a < b)
            return -1;
        else
            return 0; // both numbers are same, so they can be placed in any order
         */
    }
}


//sortNumbersDescending using a>b condition to return -ve
//system thinks a < b and puts a on left and b on right in the collection
class sortNumbersDescending implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
         return Integer.compare(b, a);  // best single line for below code.
       /* if (a > b)
            return -1;
        else if (a < b)
            return 1;
        else
            return 0;

        */
    }
}

class Sortobjects implements Comparator<Sortobject> {
    @Override
    public int compare(Sortobject a, Sortobject b) {
        //return ((a.freq == b.freq) ? (b.num - a.num) : (a.freq - b.freq)); // not used because overflow happens if one value is INTEGER.MIN_VALUE and another is INTEGER.MAX_VALUE
        return ((a.freq == b.freq) ? Integer.compare(b.num,a.num) : Integer.compare(a.freq,b.freq));
    }

}

