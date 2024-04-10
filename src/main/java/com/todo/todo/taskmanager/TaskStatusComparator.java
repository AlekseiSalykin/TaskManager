package com.todo.todo.taskmanager;

import java.util.Comparator;

public class TaskStatusComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        boolean status1 = task1.isStatus();
        boolean status2 = task2.isStatus();

        if (!status1 && status2) {
            return -1; // task2 идет перед task1
        } else if (status1 && !status2) {
            return 1; // task1 идет перед task2
        } else {
            return 0; // task1 и task2 имеют одинаковый статус
        }
    }
}
