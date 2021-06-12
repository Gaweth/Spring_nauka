package com.example.repository;

import com.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasksRepository extends JpaRepository {
    List<Task> findAll();
    Task save(Task entity);
    Task findById(Long id);

}

