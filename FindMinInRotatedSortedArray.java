package ProblemSolving;

public class FindMinInRotatedSortedArray {

    public static int findMin(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[low] <= nums[mid]){ // left part is sorted
                min = Integer.min(min, nums[low]);
                low = mid+1;
            }else{
                min = Integer.min(min, nums[mid+1]);
                high = mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,1}));
    }

}
