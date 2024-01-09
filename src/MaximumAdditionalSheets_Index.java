//There is array of values, each represent how many additional sheets the student at that index can return
// when teacher comes to his position after that value of time.
//Eg:  {1,3,2,7,4 }
//idx   0,1,2,3,4
// In this array when teacher starts from index 0 and moves to index 1, teacher can't collect 3 additional sheets from index 1 because by that time
// he reaches there its only 2 units of time

//NOTE: Think that students are sitting in circular table at equidistant
// and if teacher starts at index 2 then she has to comeback to index 1 to cover all students.
public class MaximumAdditionalSheets_Index {

    static int max = 0;
    static int idx = 0;

    public int findIndex(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = 0; //minutes
            int sum = 0; //total additional sheets

            // move from current index to end of the array. Eg: 1,2,3,4,5.  If you start from 3 then you should move till 5.
            for (int j = i; j < a.length; i++) {
                if (a[j] <= min) {
                    sum = sum + a[j];
                }
                min++;
            }

            // move from starting until current index Eg: 1,2,3,4,5.  If you start from 3 then you should also cover 1 and 2.
            for (int k = 0; k < i - 1; k++) {
                if (a[k] <= min) {
                    sum = sum + a[k];
                }
                min++;
            }

            if (sum > max) {
                idx = i;
            }
        }
        return idx;
    }
}
