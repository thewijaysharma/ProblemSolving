package ProblemSolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LibraryFine {

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

        Calendar dueDay = Calendar.getInstance();
        Calendar returnedDay = Calendar.getInstance();

        returnedDay.set(y1, m1, d1);
        dueDay.set(y2, m2, d2);

        LocalDate returnDate = LocalDate.of(y1, m1, d1);
        LocalDate dueDate = LocalDate.of(y2, m2, d2);

        if(returnDate.isAfter(dueDate)){

            if(y1 > y2){
                return 10000;
            }else if(m1>m2){
                return 500*(m1-m2);
            }else{
                return 15*(d1-d2);
            }
        }else {
            return 0;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OutputFile.txt"));

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
