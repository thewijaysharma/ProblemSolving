package ProblemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 */
public class CourseSchedule2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(3, new int[][]{{0, 1}, {0, 2}, {1, 2}})));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {


        int[] answer = new int[numCourses];

        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                answer[i] = i;
            }
            return answer;
        }

        int[] indegrees = new int[numCourses];
        int answerIndex = 0;

        ArrayList<LinkedList<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(i, new LinkedList<>());
        }

        for (int[] row : prerequisites) {
            adjList.get(row[1]).add(row[0]);
            indegrees[row[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        if (queue.size() == 0) {
            return new int[]{};
        }

        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            answer[answerIndex] = currCourse;
            answerIndex += 1;

            for (int course : adjList.get(currCourse)) {
                indegrees[course] -= 1;
                if (indegrees[course] == 0) {
                    queue.add(course);
                }

            }
        }

        if (answerIndex == numCourses) {
            return answer;
        } else {
            return new int[]{};
        }
    }

}
