package com.scottech.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scottech.task.dto.TaskDto;
import com.scottech.task.model.Task;
import com.scottech.task.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public ResponseEntity<String> addTask(@RequestBody TaskDto taskDto) {
		String responseStatus = taskService.addTask(taskDto);
		return new ResponseEntity<String>(responseStatus,HttpStatus.OK);
	}
	
	@GetMapping
	public List<Task> getAllTask(){
		List<Task> task = taskService.getAllTask();
		return task;
	}
	
	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getSingleTask(@PathVariable int taskId){
		Task task = taskService.getsingleTask(taskId);
		return new ResponseEntity<Task>(task,HttpStatus.OK);
	}
	
	@PutMapping("/addtasktoproject")
	public ResponseEntity<String> addTaskToProject(@RequestParam int taskId,@RequestParam int projectId) {
		String responseStatus = taskService.addTaskToProject(projectId, taskId);
		return new ResponseEntity<String>(responseStatus,HttpStatus.OK);
	}
}
