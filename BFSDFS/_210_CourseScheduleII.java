package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class _210_CourseScheduleII {
    // same logic with 207, just put the startCourse which is polled from the queue into the res array;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int idx = 0;
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) inDegree[prerequisites[i][0]]++;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int startCourse = queue.poll();
            res[idx++] = startCourse;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == startCourse) {
                    if (--inDegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return idx == numCourses ? res : new int[0];
    }
}
