package ProblemSolving;

public class ClimbingStairs {

    public static int climbStairs(int n) {

        if(n == 1) return 1;
        if(n == 2) return 2;

        int prev = 2;
        int prev2 = 1;
        int curr = 0;
        for(int i=3; i<=n; i++){
            curr = prev2 + prev;

            prev2 = prev;
            prev = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        int ans = climbStairs(4);
        System.out.println("Ans is : "+ans);
    }

}
