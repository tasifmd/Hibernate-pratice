package com.scottech.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scottech.task.dto.TaskDto;
import com.scottech.task.model.Task;

@Service("taskService")
public interface TaskService {
	
	public String addTask(TaskDto taskDto);
	
	public String addTaskToProject(int projectId,int taskId);
	
	public List<Task> getAllTask();
	
	public Task getsingleTask(int taskId);
}
