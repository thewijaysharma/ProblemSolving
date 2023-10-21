package ProblemSolving;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    static class Triple{
        int first;
        int second;
        int third;

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public int getThird() {
            return third;
        }

        public Triple(Integer first, Integer second, Integer third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    static class Pair{

        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
    public static int orangesRotting(int[][] grid) {

        Queue<Triple> queue = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];

        List<Pair> newPositions = new ArrayList<>();
        newPositions.add(new Pair(0,1));
        newPositions.add(new Pair(-1,0));
        newPositions.add(new Pair(0,-1));
        newPositions.add(new Pair(1,0));

        int maxTime = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[i].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Triple(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()){
            Triple curr = queue.poll();

            for (Pair position : newPositions) {
                int row = position.getFirst() + curr.getFirst();
                int col = position.getSecond() + curr.getSecond();
                if (isValidCoordinate(row, col, grid) && visited[row][col] != 1) {
                    int timeTaken = curr.getThird() + 1;
                    maxTime = Math.max(timeTaken, maxTime);
                    queue.add(new Triple(row, col, curr.getThird() + 1));
                    visited[row][col] = 1;
                }
            }
        }


        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[i].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    return -1;
                }
            }
        }

        return maxTime;
    }

    private static boolean isValidCoordinate(int i, int j, int[][] grid){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1;
    }

    public static void main(String[] args) {
        int ans = orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}});
        System.out.println("Ans is "+ans);
    }
}
