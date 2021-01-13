package com.krystian.tasklist.service;

import com.krystian.tasklist.controller.TaskNotFoundException;
import com.krystian.tasklist.domain.Task;
import com.krystian.tasklist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBservice {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    public Task getTaskById(final Long id) throws TaskNotFoundException {
        return taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }

    public Task saveTask(final Task task)
    {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id)
    {
        taskRepository.deleteById(id);
    }
}
