package ru.mfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mfa.entity.CourseEntity;

import java.util.UUID;

@Repository
public interface CourserRepository
        extends JpaRepository<CourseEntity, UUID> {

    CourseEntity findByName(String name);

}