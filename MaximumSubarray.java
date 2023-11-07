package ProblemSolving;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int currSum = nums[0];
        int maxSum = currSum;

        if(nums.length == 1){
            return maxSum;
        }

        for(int i=1; i< nums.length; i++){
            currSum = Integer.max( currSum + nums[i], nums[i]);
            maxSum = Integer.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
