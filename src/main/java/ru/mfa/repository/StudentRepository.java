package ru.mfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mfa.entity.StudentEntity;

import java.util.UUID;

@Repository
public interface StudentRepository
        extends JpaRepository<StudentEntity, UUID> {

    StudentEntity findByName(String name);

    @Query(value = """
            SELECT * FROM students WHERE email = :email
            """, nativeQuery = true)
    StudentEntity findByEmail(String email);

}
