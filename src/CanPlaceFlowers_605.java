public class CanPlaceFlowers_605 {


    //Time:O(n)
    //Space: O(1)
    public boolean Arrays_canPlaceFlowers_Greedy(int[] flowerbed, int n) {

        int zeroesStretch=0;

        for(int i=0; i < flowerbed.length;i++){
            //we need 3 continuous zeroes or 2 zeroes at left most side or right most side.
            if (flowerbed[i] == 0 &&  //current idx value is 0
                    (i==0 || flowerbed[i - 1] ==0) && //left idx is 0 or left idx value is 0
                    (i == flowerbed.length -1 || flowerbed[i+1] ==0)) { //right idx is 0 or right idx value is 0
                flowerbed[i] = 1; //place the flower so that from next index this can be identified as non-zero.
                zeroesStretch++;
            }
        }
        if(n <= zeroesStretch)
            return true;
        else
            return false;
    }

    //Time:O(n)
    //Space: O(1)
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {  //soln - input array is not modified.

        int zeroesStretch=0;

        for(int i=0; i < flowerbed.length;){
            //we need 3 continuous zeroes or 2 zeroes at left most side or right most side.
            if (flowerbed[i] == 0 &&  //current idx value is 0
                    (i==0 || flowerbed[i - 1] ==0) && //left idx is 0 or left idx value is 0
                    (i == flowerbed.length -1 || flowerbed[i+1] ==0)) { //right idx is 0 or right idx value is 0
                zeroesStretch++;
                i = i + 2; //In test case 4 {1,0,0,0,0,1} - there are 4 zeroes. But only 1 flower can be placed.
                           //After processing 0 at flowerbed[2] to place a flower successfully, if we process 0 at flowerbed[3]
                            // then because all above conditions can pass it thinks that another flower can be placed at flowerbed[3].
                           // So to avoid this, shift i by 2 places or
                           // update the input array with 1 when a place is identified i.e., flowerbed[2] = 1.
            }else{
                i++;
            }
        }
        if(n <= zeroesStretch)
            return true;
        else
            return false;
    }

    public static void main(String[] arg){
        CanPlaceFlowers_605 c = new CanPlaceFlowers_605();
        System.out.println("1."+ c.Arrays_canPlaceFlowers_Greedy(new int[]{1,0,0,0,1}, 1)); //true. [1,0,1,0,1]
        System.out.println("2."+c.Arrays_canPlaceFlowers_Greedy(new int[]{1,0,0,0,1}, 2)); //false. only 1 flower can be placed, not 2.
        System.out.println("3."+c.Arrays_canPlaceFlowers_Greedy(new int[]{1,0,0,0,0,0,0,1}, 2)); //true.
        System.out.println("3b."+c.Arrays_canPlaceFlowers_Greedy(new int[]{1,0,0,0,0,0,1}, 2)); //true. only 1 flower can be placed, not 2.
        System.out.println("4."+c.Arrays_canPlaceFlowers_Greedy(new int[]{1,0,0,0,0,1}, 2)); //false. only 1 flower can be placed, not 2.
        System.out.println("5."+c.Arrays_canPlaceFlowers_Greedy(new int[]{1,0,0}, 1)); //true
        System.out.println("6."+c.Arrays_canPlaceFlowers_Greedy(new int[]{0,0,1}, 1)); //true
        System.out.println("7."+c.Arrays_canPlaceFlowers_Greedy(new int[]{0,1,0}, 1)); //false
        System.out.println("8."+c.Arrays_canPlaceFlowers_Greedy(new int[]{0,0,0}, 1)); //true
        System.out.println("9."+c.Arrays_canPlaceFlowers_Greedy(new int[]{0,0}, 1)); //true
        System.out.println("10."+c.Arrays_canPlaceFlowers_Greedy(new int[]{1,0}, 1)); //false
    }
}
