package com.example.repository;

import com.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TasksRepository extends JpaRepository<Task, Long> {

    List<Task> findAll();
    Task save(Task entity);
    Optional<Task> findById(Long id);

}
