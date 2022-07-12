package Group20SpringBoot.Group20.task.service;

import Group20SpringBoot.Group20.task.entity.TaskModel;

public interface ITaskService {

    TaskModel createTask(TaskModel taskModel);

    TaskModel findTaskByID(int taskId);

    boolean assignTask(int taskId, int userId);

    boolean changeStatus(int taskId, String status);

}
