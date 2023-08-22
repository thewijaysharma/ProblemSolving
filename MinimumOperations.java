package ProblemSolving;

public class MinimumOperations {

    public int minOperation(int n) {
        if (n == 0) {
            return 0;
        }

        int curr = n;
        int steps = 0;

        while (curr > 0) {
            if (curr % 2 == 0) { //even
                curr = curr / 2;
            } else {
                curr -= 1;
            }
            steps++;
        }

        return steps;
    }

}
