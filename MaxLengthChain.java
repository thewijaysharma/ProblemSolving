package ProblemSolving;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int[] currPair = pairs[0];
        int count = 1;

        for (int j = 1; j < pairs.length; j++) {
            int[] nextPair = pairs[j];
            if (currPair[1] < nextPair[0]) {
                currPair = nextPair;
                count++;
            }
        }
        return count;
    }

}
