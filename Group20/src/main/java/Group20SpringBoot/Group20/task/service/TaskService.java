package Group20SpringBoot.Group20.task.service;

import Group20SpringBoot.Group20.task.entity.TaskModel;
import Group20SpringBoot.Group20.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements ITaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public TaskModel createTask(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    @Override
    public TaskModel findTaskByID(int taskId) {
        TaskModel task = null;

        Optional<TaskModel> optionalTaskModel = taskRepository.findById(taskId);
        if (optionalTaskModel.isPresent()){
            task = optionalTaskModel.get();
        }

        return task;
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
