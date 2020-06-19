package BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class _207_CourseSchedule {

    //We regard those have 0 prerequisites classes as start classes.
    //We poll them from the queue, say course1, and check who's prerequisites include course1. We minus one for that class's prerequisites class number
    //if we get 0 after minus, we put it into the queue.
    //Finally we check if there exists any class that still has prerequisites. If so, then it is impossible to finish.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) inDegree[prerequisites[i][0]]++; //this will record class `prerequisites[i][0]` has how many prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i); //add those have 0 prerequisites to the queue;
            }
        }

        while (!queue.isEmpty()) {
            int startCourse = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (startCourse == prerequisites[i][1]) {
                    if (--inDegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]); // after taking `startCourse`, if some classes have no prerequisites, we add them into the queue.
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
