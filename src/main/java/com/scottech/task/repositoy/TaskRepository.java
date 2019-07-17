package com.scottech.task.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scottech.task.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
