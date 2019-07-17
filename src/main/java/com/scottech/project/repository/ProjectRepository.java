package com.scottech.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scottech.project.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
