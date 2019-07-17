package com.scottech.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.scottech.task.model.Task;

import lombok.Data;

@Entity
@Table(name = "project")
@Data
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	
	private String projectName;
	
	private String projectDescription;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_task",
			joinColumns = {@JoinColumn(name = "project_id")},
			inverseJoinColumns = {@JoinColumn(name="task_id")}
			)
	private List<Task> task;
}
