package ru.mfa.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mfa.entity.StudentEntity;
import ru.mfa.model.StudentDto;
import ru.mfa.sevrice.StudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentEntity> addStudent(
            @Valid @RequestBody StudentDto studentDto,
            @RequestHeader("X-USER-ID") String id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("X-USER-ID", studentDto.getName())
                .body(studentService.addStudent(studentDto));
    }

    @GetMapping
    public ResponseEntity<StudentEntity> getStudent(
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
