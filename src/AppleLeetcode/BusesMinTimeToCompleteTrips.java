package AppleLeetcode;

public class BusesMinTimeToCompleteTrips {


    //Time : arrLen * log(Integer.MAX_Value)  (using binary search, find the mintime between (0 and Integer.Math.maxValue)
    //Space: O(1)
    public long minimumTime(int[] busesTime, int totalTrips) {

        long minTime = 1;
        long maxTime = 44;// (long)1e14;  //or Long.MAX_VALUE; // for testing purpose use the small number.
        long actualMinTime = 44; //(long)1e14;

        while(minTime <= maxTime) {
            long midTime = minTime + (maxTime-minTime)/2;
            if (canFinish(busesTime, totalTrips, midTime)) {
                actualMinTime = Math.min(actualMinTime,midTime);
                maxTime = midTime - 1;
            }else{
                minTime = midTime + 1;
            }
        }
        return actualMinTime;
    }

    public boolean canFinish(int[] busesTime, long totalTrips, long minTime){
        long allBusesTrips = 0;
        for(int i=0; i< busesTime.length;i++){
            allBusesTrips = allBusesTrips + (minTime/busesTime[i]);
        }
       return allBusesTrips >= totalTrips;
    }

    public static void main(String[] args){
        BusesMinTimeToCompleteTrips b = new BusesMinTimeToCompleteTrips();
//        System.out.println(b.minimumTime(new int[]{1,2,3}, 5)); //3
//        System.out.println(b.minimumTime(new int[]{2}, 1)); //2
        System.out.println(b.minimumTime(new int[]{1}, 4)); //4
//        System.out.println(b.minimumTime(new int[]{5,10,10}, 9)); //25
//        System.out.println(b.minimumTime(new int[]{1000}, 10000000)); //10000000000
//        System.out.println(b.minimumTime(new int[]{39,82,69,37,78,14,93,36,66,61,13,58,57,12,70,14,67,75,91,1,34,68,73,50,13,40,81,21,79,12,35,18,71,43,5,50,37,16,15,6,61,7,87,43,27,62,95,45,82,100,15,74,33,95,38,88,91,47,22,82,51,19,10,24,87,38,5,91,10,36,56,86,48,92,10,26,63,2,50,88,9,83,20,42,59,55,8,15,48,25}, 4187)); //858
    }
}
