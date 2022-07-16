package Group20SpringBoot.Group20.task.service;

import Group20SpringBoot.Group20.task.entity.TaskModel;
import Group20SpringBoot.Group20.task.repository.TaskRepository;
import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements ITaskService{

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserService userService;

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
    public boolean assignTask(int taskId, String email) {
        TaskModel task = null;
        boolean result = false;

        Optional<TaskModel> optionalTaskModel = taskRepository.findById(taskId);
        if (optionalTaskModel.isPresent()){
            task = optionalTaskModel.get();
            UserModel assignee = userService.findUserByEmail(email);

            if (assignee != null) {
                task.setAssigneeId(assignee.getFirstName() + " " + assignee.getLastName());
                taskRepository.save(task);
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean changeStatus(int taskId, String status) {
        TaskModel task = null;
        boolean result = false;

        Optional<TaskModel> optionalTaskModel = taskRepository.findById(taskId);
        if (optionalTaskModel.isPresent()){
            task = optionalTaskModel.get();
            task.setStatus(status);
            taskRepository.save(task);
            result = true;
        }

        return result;
    }
}
