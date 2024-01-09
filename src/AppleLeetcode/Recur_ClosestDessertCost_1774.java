package AppleLeetcode;

public class Recur_ClosestDessertCost_1774 {
    int minDiffCost;
    int answerCost;

    //Time: O(n * 3^m) //for n bases, each n base has m (topping) choices and each choice has again 3 options - do not take, 1 time topping 2 times topping.
    //Space: only stack memory is needed for recursion to store the arguments.
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
         minDiffCost = Integer.MAX_VALUE;
         answerCost = 0;

        for (int i = 0; i < baseCosts.length; i++) {
            findClosesCost(baseCosts[i], 0, toppingCosts, target);
        }
        return answerCost;
    }

    public void findClosesCost(int currCost, int toppingIdx, int[] toppingCosts, int target) {

        int diff = Math.abs(currCost - target);
        if (diff < minDiffCost || (diff == minDiffCost && currCost < answerCost)) {
            answerCost = currCost;
            minDiffCost = diff;
        }
        if (minDiffCost == 0) {
            return;
        }

        if (toppingIdx >= toppingCosts.length || currCost > target) {
            return;
        }

        findClosesCost(currCost, toppingIdx + 1, toppingCosts, target);
        findClosesCost(currCost + toppingCosts[toppingIdx], toppingIdx + 1, toppingCosts, target);
        findClosesCost(currCost + 2 * toppingCosts[toppingIdx], toppingIdx + 1, toppingCosts, target);
    }

    public static void main(String[] args) {
        Recur_ClosestDessertCost_1774 r = new Recur_ClosestDessertCost_1774();
        System.out.println(r.closestCost(new int[]{2,3}, new int[]{4, 5, 100}, 18)); //17
        System.out.println(r.closestCost(new int[]{1, 7}, new int[]{3,4}, 10)); //10
        System.out.println(r.closestCost(new int[]{3,10}, new int[]{2,5}, 9)); //8
        System.out.println(r.closestCost(new int[]{1}, new int[]{8,10}, 10)); //9 (9 and 11 both are close but 9 is the lowest close one)
    }
}
