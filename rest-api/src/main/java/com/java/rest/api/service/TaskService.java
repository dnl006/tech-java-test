package com.java.rest.api.service;

import com.java.rest.api.dto.request.CreateTaskRequest;
import com.java.rest.api.dto.response.TaskResponse;
import com.java.rest.api.model.Task;
import com.java.rest.api.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskResponse createTask(CreateTaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());
        task.setCompleted(false);  // default
        Task saved = repository.save(task);
        return TaskResponse.from(saved);
    }

    public TaskResponse completeTask(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));

        task.setCompleted(true);
        task.setCompletedAt(LocalDateTime.now());

        Task updated = repository.save(task);
        return TaskResponse.from(updated);
    }

    public Page<TaskResponse> getAllTasks(Boolean completed, Pageable pageable) {
        Page<Task> page = (completed != null)
                ? repository.findByCompleted(completed, pageable)
                : repository.findAll(pageable);

        return page.map(TaskResponse::from);
    }
}
