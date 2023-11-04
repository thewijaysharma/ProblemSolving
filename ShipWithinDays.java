package ProblemSolving;

public class ShipWithinDays {

    public int shipWithinDays(int[] weights, int days) {

        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        int ans = -1;
        int l = 0;
        int r = sum;

        while(l <= r){

            int mid = (l+r)/2;

            if(isPossible(weights, days, mid)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return ans;
    }

    static boolean isPossible(int[] weights, int givenDays, int mid){

        int currDay = 1;
        int currWeightSum = 0;

        for(int i = 0; i < weights.length; i++){

            if(weights[i] > mid) return false;

            currWeightSum += weights[i];

            if(currWeightSum > mid){
                currWeightSum = weights[i];
                currDay++;

                if(currDay > givenDays){
                    return false;
                }
            }
        }

        return true;
    }

}
