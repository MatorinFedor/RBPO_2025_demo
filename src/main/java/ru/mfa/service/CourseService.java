package ru.mfa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mfa.entity.CourseEntity;
import ru.mfa.repository.CourseRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public CourseEntity findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public CourseEntity findByName(String name) {
        return repository.findByName((name));
    }
}