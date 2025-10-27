package ru.mfa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true,  nullable = false)
    private String name;

    @Column(unique = true,  nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private GroupEntity group;

    @ManyToOne(fetch = FetchType.LAZY)
    private CourseEntity additionalCourse;

}
