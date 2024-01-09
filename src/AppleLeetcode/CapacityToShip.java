package AppleLeetcode;

public class CapacityToShip {

    public int shipWithinDays(int[] weights, int days) {

        int maxWeight = 0;
        int minWeight = Integer.MIN_VALUE;

        for(int i=0; i< weights.length; i++){
            maxWeight = maxWeight + weights[i];
            minWeight = Math.max(minWeight, weights[i]);
        }

        int answerMinWeight = 0;
        while(minWeight <= maxWeight){
            int midWeight = minWeight + (maxWeight - minWeight)/2;
            if(canShip( weights,  days,  midWeight)){
                answerMinWeight = midWeight;
                maxWeight = midWeight - 1;
            }else{
                minWeight = midWeight + 1;
            }
        }
        return answerMinWeight;
    }

    public boolean canShip(int[] weights, int days, int minShipWeight){
        int daysTaken = 0;
        int currWeight = 0;
        for(int i =0; i< weights.length; i++){
//            if(weights[i] > minShipWeight){  //short circuit case (optional)
//                return false;
//            }
            currWeight = currWeight + weights[i];
            if(currWeight > minShipWeight){
                daysTaken++;
                currWeight = weights[i];
            }else if(currWeight == minShipWeight){
                daysTaken++;
                currWeight = 0;
            }
        }

        if(currWeight >0){
            daysTaken++;
        }

        return daysTaken <= days;
    }

    public static void main(String[] args) {
        CapacityToShip b = new CapacityToShip();
        System.out.println(b.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)); //15
        System.out.println(b.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1)); //55  //In 1 day all parcels have to be shipped.
        System.out.println(b.shipWithinDays(new int[]{8, 2, 4, 3, 1, 5, 7}, 4)); //9
        System.out.println(b.shipWithinDays(new int[]{3,2,2,4,1,4}, 3)); //6
        System.out.println(b.shipWithinDays(new int[]{3,2,2,4,1,4}, 5)); //4
        System.out.println(b.shipWithinDays(new int[]{1,2,3,1,1}, 4)); //3


    }
}
