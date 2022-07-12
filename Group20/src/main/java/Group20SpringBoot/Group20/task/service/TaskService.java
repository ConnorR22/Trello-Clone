package Group20SpringBoot.Group20.task.service;

import Group20SpringBoot.Group20.task.entity.TaskModel;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements ITaskService{
    @Override
    public TaskModel createTask(TaskModel taskModel) {
        return null;
    }

    @Override
    public TaskModel findTaskByID(int taskId) {
        return null;
    }

    @Override
    public boolean assignTask(int taskId, int userId) {
        return false;
    }

    @Override
    public boolean changeStatus(int taskId, String status) {
        return false;
    }
}
