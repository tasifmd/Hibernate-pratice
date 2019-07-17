package com.scottech.task.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottech.project.model.Project;
import com.scottech.project.repository.ProjectRepository;
import com.scottech.task.dto.TaskDto;
import com.scottech.task.model.Task;
import com.scottech.task.repositoy.TaskRepository;
@Service("taskService")
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public String addTask(TaskDto taskDto) {
		Task task = modelMapper.map(taskDto, Task.class);
		taskRepository.save(task);
		return "Task added";
	}

	@Override
	public String addTaskToProject(int projectId, int taskId) {
		Optional<Project> project = projectRepository.findById(projectId);
		Optional<Task> task = taskRepository.findById(taskId);
		project.get().getTask().add(task.get());
		if(project.get().getTask().contains(task.get())) {
			return "Task already exist";
		}
		projectRepository.save(project.get());
		return "Task added to project";
	}

	@Override
	public List<Task> getAllTask() {
		List<Task> tasks = taskRepository.findAll();
		return tasks;
	}

	@Override
	public Task getsingleTask(int taskId) {
		Optional<Task> task = taskRepository.findById(taskId);
		return task.get();
	}

}
