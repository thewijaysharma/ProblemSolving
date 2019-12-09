package ProblemSolving;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class AppendAndDelete {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {

        if(k >= s.length() + t.length()){
            return "Yes";
        }

        int pointer;

        int bound = Math.min(s.length(), t.length());

        for(pointer=0; pointer<bound; pointer++)
        {
            if(s.charAt(pointer) != t.charAt(pointer)){
                break;
            }
        }


        if(k == (s.length()-pointer + t.length()-pointer)){
            return "Yes";
        }else if(k > (s.length()-pointer + t.length()-pointer)){
            int left = k - s.length()-pointer + t.length()-pointer;
            if(left%2 == 0){
                return "No";
            }

        }

        if(s.equals(t) && (k%2==0)){
            return "Yes";
        }



        return "No";


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OutputFile.txt"));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
