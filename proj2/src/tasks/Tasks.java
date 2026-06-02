package tasks;

import java.util.*;

public class Tasks {
    private int numTasks;
    private List<List<Integer>> dependencies;

    // Initializes use with multiple tasks
    public Tasks(int num) {
        this.numTasks = num;
        this.dependencies = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            this.dependencies.add(new ArrayList<>());
        }
    }

    // The system is forced to implement the dependency that says task1 cannot be executed before task2.
    // If task1 or task2 are not valid task numbers, it will return false, otherwise true
    public boolean dependsOn(int task1, int task2) {
        if (task1 < 0 || task1 >= numTasks || task2 < 0 || task2 >= numTasks) {
            return false;
        }
        // Add the dependency to the system
        dependencies.get(task1).add(task2);
        return true;
    }

    public int[] order() {
        // Perform a topological sort to determine the order of tasks
        int[] inDegree = new int[numTasks];
        for (int i = 0; i < numTasks; i++) {
            for (int dep : dependencies.get(i)) {
                inDegree[dep]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numTasks; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numTasks];
        int index = 0;

        while (!queue.isEmpty()) {
            int task = queue.poll();
            result[index++] = task;

            for (int dep : dependencies.get(task)) {
                inDegree[dep]--;
                if (inDegree[dep] == 0) {
                    queue.offer(dep);
                }
            }
        }

        if (index != numTasks) {
            return null;
        }

        return result;
    }
}
