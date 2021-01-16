package com.krystian.tasklist.controller;

import com.fasterxml.jackson.annotation.JsonValue;
import com.krystian.tasklist.domain.Task;
import com.krystian.tasklist.domain.TaskDto;
import com.krystian.tasklist.mapper.TaskMapper;
import com.krystian.tasklist.service.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/task")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private DBservice dBservice;
    @Autowired
    private TaskMapper taskMapper;


    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(dBservice.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto getTask(@RequestParam Long taskId) throws TaskNotFoundException {
        //return new TaskDto(1L,"test title","test content");
        return taskMapper.mapToTaskDto(dBservice.getTaskById(taskId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(@RequestParam Long taskId) {

        dBservice.deleteTask(taskId);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return taskMapper.mapToTaskDto(dBservice.saveTask(taskMapper.mapToTask(taskDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    public void createTask(@RequestBody TaskDto taskDto) {
        dBservice.saveTask(taskMapper.mapToTask(taskDto));
    }



}
