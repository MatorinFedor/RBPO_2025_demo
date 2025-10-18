package ru.mfa.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mfa.entity.StudentEntity;
import ru.mfa.model.StudentDto;
import ru.mfa.service.StudentService;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<StudentDto> getStudent(
            @RequestParam @Size(min = 3, max = 255) String name) {
        return ResponseEntity
                .ok()
                .body(toDto(studentService.getStudent(name)));
    }

    @PostMapping
    public ResponseEntity<StudentDto> addStudent(
            @Valid @RequestBody StudentDto studentDto,
            @RequestHeader("X-USER-ID") String id) {
        return ResponseEntity
                .status(CREATED)
                .header("X-USER-ID", studentDto.getEmail())
                .body(toDto(studentService.addStudent(studentDto)));
    }

    @DeleteMapping("/by-name/{name}")
    public ResponseEntity<Void> removeStudent(
            @PathVariable String name){
        studentService.removeStudent(name);
        return ResponseEntity.noContent().build();
    }

    private StudentDto toDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(studentEntity.getName());
        studentDto.setEmail(studentEntity.getEmail());
        if (studentEntity.getGroup()!=null) {
            studentDto.setGroup(studentEntity.getGroup().getName());
        }
        if (studentEntity.getAdditionalCourse() != null) {
            studentDto.setAdditionalCourse(
                    studentEntity.getAdditionalCourse().getName());
        }

        return studentDto;
    }
}
