package ru.mfa.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mfa.model.Student;
import ru.mfa.sevrice.StudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(
            @Valid @RequestBody Student student,
            @RequestHeader("X-USER-ID") String id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("X-USER-ID", student.getName())
                .body(studentService.addStudent(student));
    }

    @GetMapping
    public ResponseEntity<Student> getStudent(
            @RequestParam(required = true)
            @Size(min = 3, max = 255) String name) {
        return ResponseEntity.ok()
                .body(studentService.getStudent(name));
    }

    @DeleteMapping("/by-name/{name}")
    public ResponseEntity<Void> removeStudent(
            @PathVariable String name) {
        studentService.removeStudent(name);
        return ResponseEntity.noContent().build();
    }

}
