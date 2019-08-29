package ProblemSolving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BeautifulDaysAtTheMovies {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {

        int numOfBeautifulDays =0 ;

        for (int n = i; n <= j; n++) {

            int diff = Math.abs(n - reverse(n));
            if(diff % k ==0){
                numOfBeautifulDays++;
            }

        }

        return numOfBeautifulDays;

    }

    private static int reverse(int n){

        StringBuilder builder= new StringBuilder();

        while(n > 0){
            int remainder = n%10;
            builder.append(String.valueOf(remainder));
            n = n/10;
        }

        return Integer.parseInt(builder.toString());

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OutputFile.txt"));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
