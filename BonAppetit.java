package ProblemSolving;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

public class BonAppetit {

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {

        int totalAmount = 0;

        for (Integer aBill : bill) {
            totalAmount = totalAmount + aBill;
        }

        int fairAmount = (totalAmount - bill.get(k))/2;

        if(fairAmount == b){
            System.out.print("Bon Appetit");
        }else {
            System.out.println(bill.get(k)/2);
        }



    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
