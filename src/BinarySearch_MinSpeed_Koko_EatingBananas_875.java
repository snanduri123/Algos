/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23


Constraints:

1 <= piles.length <= 10^4
piles.length <= h <= 10^9
1 <= piles[i] <= 10^9
 */

public class BinarySearch_MinSpeed_Koko_EatingBananas_875 {


    //Time: O(n * log(max))
    //Space: O(1)
    public int minEatingSpeed(int[] piles, int h) {

        //Because at a time only 1 pile can be eaten. So the maximum Koko can eat in an hour is the pile that has maximum bananas.
        int maxSpeed =0;
        for(int i : piles){
            if( i > maxSpeed){
                maxSpeed = i;
            }
        }

        return minEatingSpeed( piles,  h,  1, maxSpeed); // we try to see which speed (1 banana/hr or  1000 bananas/hr or 2356 bananas/hr ..etc which speed is better)
    }

    public int minEatingSpeed(int[] piles, int h, int start, int end){

        int minSpeed = -1;

        while(start <= end) {  // find the leftmost (minimum) possible K

            int mid = start + (end - start) / 2;

            if (isKSpeedPossible(piles, h, mid)) {
                minSpeed = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
       return minSpeed;
    }

    public boolean isKSpeedPossible(int[] piles,int h,int k){
        int timeInHrs=0; //time took to finish all bananas in all piles.
        for(int p:piles) {
            timeInHrs += (p / k + (p % k == 0 ? 0 : 1)); //each pile how much time it takes.
            if(timeInHrs > h)
               return false;
        }
        return true;  //In h hrs, at K speed (Eg: k bananas/hr 10 bananas/hr) all bananas in piles can be finished.
    }



   public static void main(String[] args){
       BinarySearch_MinSpeed_Koko_EatingBananas_875 b = new BinarySearch_MinSpeed_Koko_EatingBananas_875();
       System.out.println(b.minEatingSpeed(new int[] {3,6,7,11}, 8)); //4
       System.out.println(b.minEatingSpeed(new int[] {30,11,23,4,20}, 5)); //30
       System.out.println(b.minEatingSpeed(new int[] {873375536,395271806,617254718,970525912,634754347,824202576,694181619,20191396,886462834,442389139,572655464,438946009,791566709,776244944,694340852,419438893,784015530,588954527,282060288,269101141,499386849,846936808,92389214,385055341,56742915,803341674,837907634,728867715,20958651,167651719,345626668,701905050,932332403,572486583,603363649,967330688,484233747,859566856,446838995,375409782,220949961,72860128,998899684,615754807,383344277,36322529,154308670,335291837,927055440,28020467,558059248,999492426,991026255,30205761,884639109,61689648,742973721,395173120,38459914,705636911,30019578,968014413,126489328,738983100,793184186,871576545,768870427,955396670,328003949,786890382,450361695,994581348,158169007,309034664,388541713,142633427,390169457,161995664,906356894,379954831,448138536}, 943223529)); //30

   }
}