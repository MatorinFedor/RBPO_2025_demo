package ru.mfa.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mfa.model.Student;
import ru.mfa.service.StudentService;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Student> getStudent(
            @RequestParam(required = true) @Size(min = 3, max = 255) String name) {
        return ResponseEntity
                .ok()
                .body(studentService.getStudent(name));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(
            @Valid @RequestBody Student student) {
        try {
            return ResponseEntity
                    .status(CREATED)
                    .header("X-USER-ID", student.getEmail())
                    .body(studentService.addStudent(student));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body(null);
        }

    }

    @DeleteMapping("/by-name/{name}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable String name) {
        studentService.removeStudent(name);
        return ResponseEntity.noContent().build();
    }
}
