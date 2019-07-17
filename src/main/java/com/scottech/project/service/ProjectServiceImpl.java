package com.scottech.project.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottech.project.dto.ProjectDto;
import com.scottech.project.model.Project;
import com.scottech.project.repository.ProjectRepository;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProjectRepository projectrepository;

	@Override
	public String addProject(ProjectDto projectDto) {
		Project project = modelMapper.map(projectDto, Project.class);
		projectrepository.save(project);
		return "Project Added";
	}

	@Override
	public List<Project> getAllProject() {
		List<Project> projects = projectrepository.findAll();
		return projects;
	}

	@Override
	public Project getSingleProject(int projectId) {
		Optional<Project> project = projectrepository.findById(projectId);
		return project.get();
	}

}
