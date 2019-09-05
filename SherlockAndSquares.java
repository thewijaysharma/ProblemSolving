package ProblemSolving;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class SherlockAndSquares {

    // Complete the squares function below.
    static int squares(int a, int b) {

        int count = 0;

        int firstSqRoot = 0;
        int firstPerfectSq = 0;

        for(int i=a; i<=b; i++){

             double sqrtNum = Math.sqrt(i);
             if(Math.floor(sqrtNum) == sqrtNum){ //perfect square
                 firstSqRoot = (int)Math.floor(sqrtNum);
                 firstPerfectSq = i;
                 count++;
                 break;
             }

        }

        if(count==0){
            return 0;
        }

        int nextPerfectSq = firstPerfectSq + (firstSqRoot * 2 + 1);
        int nextSqRoot = (int)Math.sqrt(nextPerfectSq);

        while(nextPerfectSq <= b){

            count++;
            nextPerfectSq = nextPerfectSq + (nextSqRoot *2 +1);
            nextSqRoot = (int)Math.sqrt(nextPerfectSq);

        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OutputFile.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
