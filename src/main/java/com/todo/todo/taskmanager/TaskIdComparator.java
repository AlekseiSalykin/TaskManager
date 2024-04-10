package com.todo.todo.taskmanager;

import java.util.Comparator;

public class TaskIdComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        int id1 = task1.getId();
        int id2 = task2.getId();

        if(id1 < id2){
            return -1;
        } else if(id1 > id2){
            return 1;
        } else {
            return 0;
        }
    }
}
