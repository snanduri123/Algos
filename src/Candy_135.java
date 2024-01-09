import java.util.Arrays;

/*There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.

*/
public class Candy_135 {


    public static void main(String[] args) {

        int[] ratings1 = {2, 3, 4, 3, 1, 2, 5, 4};
        int[] ratings2 = {4, 1, 8, 5, 7};
        int[] ratings3 = {2, 3, 3, 3, 1, 2, 2, 0};
        int[] ratings4 = {8, 3, 2, 5, 1, 6};
        int[] ratings5 = {0, 1, 2, 3, 4, 3, 6, 5}; //
        int[] ratings6 = {2, 2, 1, 3, 3}; //9
        int[] ratings7 = {3, 3, 4, 4}; //6
        int[] ratings8 = {2, 2, 2, 2, 2}; //5
        int[] ratings9 = {1,0,2}; // 5

        int output;

        System.out.println("1 input : " + Arrays.toString(ratings1));
        output = distributeCandies(ratings1);
        System.out.println("output " + output);

        System.out.println("------------------------------");

        System.out.println("2 input : " + Arrays.toString(ratings2));
        output = distributeCandies(ratings2);
        System.out.println("output " + output);

        System.out.println("------------------------------");

        System.out.println("3 input : " + Arrays.toString(ratings3));
        output = distributeCandies(ratings3);
        System.out.println("output " + output);

        System.out.println("------------------------------");

        System.out.println("4 input : " + Arrays.toString(ratings4));
        output = distributeCandies(ratings4);
        System.out.println("output " + output);

        System.out.println("------------------------------");

        System.out.println("5 input : " + Arrays.toString(ratings5));
        output = distributeCandies(ratings5);
        System.out.println("output " + output);

        System.out.println("------------------------------");

        System.out.println("6 input : " + Arrays.toString(ratings6));
        output = distributeCandies(ratings6);
        System.out.println("output " + output);

        System.out.println("------------------------------");

        System.out.println("7 input : " + Arrays.toString(ratings7));
        output = distributeCandies(ratings7);
        System.out.println("output " + output);

        System.out.println("------------------------------");

        System.out.println("8 input : " + Arrays.toString(ratings8));
        output = distributeCandies(ratings8);
        System.out.println("output " + output);

        System.out.println("9 input : " + Arrays.toString(ratings8));
        output = distributeCandies(ratings9);
        System.out.println("output " + output);

    }

    public static int distributeCandies(int[] ratings) {

        int[] lowsAndHighs = new int[ratings.length];

        int[] choc = new int[ratings.length];

        int totalChocolates = 0;

        if (ratings.length == 0) {
            return 0;
        }

        if (ratings.length == 1) {
            return 1;
        }

        if (ratings[0] > ratings[1]) {
            lowsAndHighs[0] = 1;
        } else if (ratings[0] < ratings[1]) {
            lowsAndHighs[0] = -1;
        } else {// if both are equal
            choc[0] = 1;
            totalChocolates++;
        }

        if (ratings[ratings.length - 1] > ratings[ratings.length - 2]) {
            lowsAndHighs[ratings.length - 1] = 1;
        } else if (ratings[ratings.length - 1] < ratings[ratings.length - 2]) {
            lowsAndHighs[ratings.length - 1] = -1;
        } else {// if both are equal
            choc[ratings.length - 1] = 1;
        }


        //identify the highs and lows of the ratings. highs are indicated by 1 and lows by -1
        for (int i = 1; i <= ratings.length - 2; i++) {

            if (ratings[i] > ratings[i - 1] && ratings[i] > ratings[i + 1]) { // both sides of current rating are low then that curr rate is high rating
                lowsAndHighs[i] = 1;
            } else if (ratings[i] < ratings[i - 1] && ratings[i] < ratings[i + 1]) { // both sides of current rating are higher then that curr rate is high rating
                lowsAndHighs[i] = -1;
            } else  {// if current rating is greater than its left rating and smaller than right rating then
                // it is neither high nor low
                lowsAndHighs[i] = 0; // int array default stores 0, so this else code is not required.

            }
        }

        System.out.println("lowsAndHighs : " + Arrays.toString(lowsAndHighs));

        //give chocolates by starting from low index each time.
        for (int i = 0; i < ratings.length; i++) {

            if (lowsAndHighs[i] == -1) {
                choc[i] = 1;
                //give chocolates on left side of low Idx until a high is reached.
                for (int j = i - 1; j >= 0; j--) {
                    if (choc[j] < choc[j + 1] + 1) { // if choc[j] is already calculated from its left side then check its value is greater than the value it may get from its right side
                        choc[j] = choc[j + 1] + 1;
                        totalChocolates++;
                    }
                    if (lowsAndHighs[j] == 1)
                        break;
                }

                //give chocolates on right side of low Idx until a high is reached.
                for (int j = i + 1; j < lowsAndHighs.length; j++) {
                    if (choc[j] < choc[j - 1] + 1) { // if choc[j] is already calculated from its right side then check its value is greater than the value it may get from its left side
                        choc[j] = choc[j - 1] + 1;
                        totalChocolates++;
                    }
                    if (lowsAndHighs[j] == 1)
                        break;

                }
            }
        }

        System.out.println("chocolates distribution : " + Arrays.toString(choc));
        return totalChocolates;

    }


}
