package com.todo.todo.taskmanager;

import java.time.LocalDateTime;
import java.util.Comparator;

public class TaskIdComparator implements Comparator<Task> {
    @Override
    public int compare(Task taskOne, Task taskTwo) {
        LocalDateTime time1 = taskOne.getCreationTime();
        LocalDateTime time2 = taskTwo.getCreationTime();

        if (time1.isBefore(time2)) {
            // time1 раньше time2
            return -1;
        } else if (time1.isAfter(time2)) {
            // time1 позже time2
            return 1;
        } else {
            // time1 и time2 равны
            return 0;
        }
    }
}
