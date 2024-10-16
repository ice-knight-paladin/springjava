package com.example.test.api.controllers.helpers;


import com.example.test.api.exceptions.NotFoundException;
import com.example.test.store.entities.ProjectEntity;
import com.example.test.store.entities.TaskStateEntity;
import com.example.test.store.repositories.ProjectRepository;
import com.example.test.store.repositories.TaskStateRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
@Transactional
public class ControllerHelper {

    ProjectRepository projectRepository;

    TaskStateRepository taskStateRepository;

    public ProjectEntity getProjectOrThrowException(Long projectId) {
        return projectRepository
                .findById(projectId)
                .orElseThrow(() -> new NotFoundException(String.format("Project with \"%s\" doesnt exists.", projectId)));
    }

    public TaskStateEntity getTaskStateEntityOrThrow(Long taskStateId){
        return taskStateRepository
                .findById(taskStateId)
                .orElseThrow(()->new NotFoundException(String.format("Task state with %s doesnt exists.", taskStateId)));
    }
}
