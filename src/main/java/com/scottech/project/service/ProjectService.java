package com.scottech.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scottech.project.dto.ProjectDto;
import com.scottech.project.model.Project;


@Service("projectService")
public interface ProjectService {
	
	public String addProject(ProjectDto projectDto);
	
	public List<Project> getAllProject();
	
	public Project getSingleProject(int projectId);

}
