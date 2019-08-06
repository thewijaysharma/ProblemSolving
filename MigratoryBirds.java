import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

        Map<Integer, Integer> idFreqMap = new HashMap<>();

        int id=Integer.MAX_VALUE, maxFreq=0;

        for(int bird: arr){
            if(idFreqMap.containsKey(bird)){
                int val = idFreqMap.get(bird)+1;
                idFreqMap.put(bird, val);

                if(val>maxFreq || val==maxFreq && bird<id){
                        id = bird;
                        maxFreq = val;
                }

            }else {
                idFreqMap.put(bird, 1);
            }
        }

        return id;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr.add(arrItem);
        }

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
