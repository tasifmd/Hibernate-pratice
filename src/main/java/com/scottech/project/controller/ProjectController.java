package com.scottech.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scottech.project.dto.ProjectDto;
import com.scottech.project.model.Project;
import com.scottech.project.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping
	public ResponseEntity<String> addProject(@RequestBody ProjectDto projectDto) {
		String responseStatus = projectService.addProject(projectDto);
		return new ResponseEntity<String>(responseStatus, HttpStatus.OK);
	}

	@GetMapping
	public List<Project> getAllProjects() {
		List<Project> projects = projectService.getAllProject();
		return projects;
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<Project> getSingleProject(@PathVariable int projectId) {
		Project project = projectService.getSingleProject(projectId);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
}
