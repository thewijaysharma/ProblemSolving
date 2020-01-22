package ProblemSolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedStrings {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        int countInGivenString= 0 ;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a'){
                countInGivenString++;
            }
        }

        long totalCount = 0;

        if(n>=s.length()){
            long exactCompleteStrings = n/s.length();
            totalCount += exactCompleteStrings*countInGivenString;

            long remainder = n%s.length();

            for(int i=0; i<remainder; i++){
                if(s.charAt(i)=='a'){
                    totalCount+=1;
                }
            }

        }else {

            for(int i=0; i<n; i++){
                if(s.charAt(i)=='a'){
                    totalCount+=1;
                }
            }

        }

        return totalCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH.txt"));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
