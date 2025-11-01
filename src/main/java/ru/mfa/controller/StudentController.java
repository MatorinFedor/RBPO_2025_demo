package ru.mfa.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mfa.model.StudentDto;
import ru.mfa.service.StudentService;
import ru.mfa.util.MappingUtils;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final MappingUtils mappingUtils;

    @GetMapping
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity<StudentDto> getStudent(
            @RequestParam @Size(min = 3, max = 255) String name) {
        return ResponseEntity.ok()
                .body(mappingUtils.toDto(studentService.getStudent(name)));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDto> addStudent(
            @Valid @RequestBody StudentDto student,
            @RequestHeader(value = "X-USER-ID", required = false) String id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("X-USER-ID", student.getEmail())
                .body(mappingUtils.toDto(studentService.addStudent(student)));
    }

    @DeleteMapping("/by-name/{name}")
    @PreAuthorize("hasAuthority('modify')")
    public ResponseEntity<Void> removeStudent(
            @PathVariable String name) {
        studentService.removeStudent(name);
        return ResponseEntity.noContent().build();
    }

}
