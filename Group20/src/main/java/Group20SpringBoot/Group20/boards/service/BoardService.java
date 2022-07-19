package Group20SpringBoot.Group20.boards.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.boards.repository.BoardRepository;
import Group20SpringBoot.Group20.task.entity.TaskModel;
import Group20SpringBoot.Group20.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService implements IBoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    TaskService taskService;

    @Override
    public BoardModel createBoard(@RequestBody BoardModel boardModel) {
        return boardRepository.save(boardModel);
    }

    @Override
    public BoardModel findBoardByID(int boardId) {
        BoardModel boardModel = null;

        Optional<BoardModel> optionalBoardModel = boardRepository.findById(boardId);
        if(optionalBoardModel.isPresent())
        {
            boardModel = optionalBoardModel.get();
        }

        return boardModel;
    }


    @Override
    public void deleteBoard(int boardId) {
        boardRepository.deleteById(boardId);
    }


    @Override
    public boolean addTaskToBoard(int boardId, int taskId) {
        BoardModel updatedBoard = null;
        Optional<BoardModel> optionalBoardModel = null;
        boolean result = false;

        try {
            optionalBoardModel = boardRepository.findById(boardId);
            if (optionalBoardModel.isPresent()){
                updatedBoard = optionalBoardModel.get();
                TaskModel task = taskService.findTaskByID(taskId);

                List<TaskModel> tasks = updatedBoard.getTasks();
                if (tasks == null){
                    tasks = new ArrayList<>();
                }

                tasks.add(task);
                updatedBoard.setTasks(tasks);

                boardRepository.save(updatedBoard);

                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<TaskModel> getTasks(int boardId) {
        BoardModel board = findBoardByID(boardId);
        return board.getTasks();
    }

    @Override
    public List<TaskModel> getDateFiltered(int boardId, int when) {
        BoardModel board = null;
        Optional<BoardModel> optionalBoardModel = boardRepository.findById(boardId);

        if (optionalBoardModel.isPresent()){
            board = optionalBoardModel.get();

            List<TaskModel> tasks = board.getTasks();
            LocalDate today = LocalDate.now();

            // Overdue - 0
            if (when == 0){
                return overDueTasks(tasks, today);
            }
            // Due Today - 1
            if (when == 1){
                return todayDueTasks(tasks, today);
            }
            // Due This Week - 2
            if (when == 2){
//                return overDueTasks(tasks, today);
            }

//            System.out.println(date);
        }


        return null;
    }

    private List<TaskModel> todayDueTasks(List<TaskModel> tasks, LocalDate today) {
        return tasks.stream().filter(
                task -> Instant.ofEpochMilli(task.getDueDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate()
                        .isEqual(today)).toList();
    }

    private List<TaskModel> overDueTasks(List<TaskModel> tasks, LocalDate today) {
        return tasks.stream().filter(task -> Instant.ofEpochMilli(task.getDueDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate().isBefore(today)).toList();
    }

    @Override
    public List<TaskModel> getNameFiltered(int boardId, String filter) {
        BoardModel board = null;
        Optional<BoardModel> optionalBoardModel = boardRepository.findById(boardId);

        if (optionalBoardModel.isPresent()){
            board = optionalBoardModel.get();

            List<TaskModel> tasks = board.getTasks();
            return tasks.stream().filter(task -> task.getTaskTitle().contains(filter)).toList();
        }

        return null;
    }

}
