package com.scottech.task.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scottech.project.model.Project;

import lombok.Data;

@Entity
@Table(name = "task")
@Data
public class Task implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;
	
	private String taskName;
	
	private String taskDescription;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "task",cascade = CascadeType.ALL)
	private List<Project> project;

}
