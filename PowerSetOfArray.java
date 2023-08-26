package ProblemSolving;

import java.util.ArrayList;

public class PowerSetOfArray {


    public static void main(String[] args) {
        generatePowerSet(0, new int[]{1,5}, new ArrayList<>());
    }

    static void generatePowerSet(int index, int[] mainArray, ArrayList<Integer> seq){

        if(index >= mainArray.length){
            for (Integer integer : seq) {
                System.out.print(integer + "\t");
            }
            System.out.print("\n");
            return;
        }

        seq.add(mainArray[index]);
        generatePowerSet(index+1, mainArray, seq);
        seq.remove(seq.size()-1);
        generatePowerSet(index+1, mainArray, seq);
    }

}
