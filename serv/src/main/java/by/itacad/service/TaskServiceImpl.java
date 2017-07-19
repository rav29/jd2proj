package by.itacad.service;

import by.itacad.dao.TaskDao;
import by.itacad.entities.Task;
import by.itacad.service.Common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Radion on 18.07.2017.
 */
@Service
@Transactional
public class TaskServiceImpl extends BaseServiceImpl<Task> implements TaskService{

    private final TaskDao taskDao;

    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

}
