import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MagicSquare {

    static int[][] one =
            {{4, 9, 2},
                    {3, 5, 7},
                    {8, 1, 6}};

    static int[][] two =
            {{8, 1, 6},
                    {3, 5, 7},
                    {4, 9, 2}};

    static int[][] three =
            {{8, 3, 4},
                    {1, 5, 9},
                    {6, 7, 2}};

    static int[][] four =
            {{4, 3, 8},
                    {9, 5, 1},
                    {2, 7, 6}};

    static int[][] five =
            {{6, 1, 8},
                    {7, 5, 3},
                    {2, 9, 4}};

    static int[][] six =
            {{2, 9, 4},
                    {7, 5, 3},
                    {6, 1, 8}};

    static int[][] seven =
            {{2, 7, 6},
                    {9, 5, 1},
                    {4, 3, 8}};

    static int[][] eight =
            {{6, 7, 2},
                    {1, 5, 9},
                    {8, 3, 4}};


    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        int[][][] allMatrices = {one, two, three, four, five, six, seven, eight};

        int minCost = Integer.MAX_VALUE;

        for(int[][] magic: allMatrices){

            int diff = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    diff = diff + Math.abs(s[i][j] - magic[i][j]);
                }
            }

            if(diff  < minCost){
                minCost = diff;
            }

        }
        return minCost;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
