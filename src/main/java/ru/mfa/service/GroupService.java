package ru.mfa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mfa.entity.CourseEntity;
import ru.mfa.entity.GroupEntity;
import ru.mfa.entity.StudentEntity;
import ru.mfa.model.CourseDto;
import ru.mfa.model.GroupDto;
import ru.mfa.model.StudentDto;
import ru.mfa.repository.CourseRepository;
import ru.mfa.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;

    public GroupEntity findById(UUID id) {
        return groupRepository.findById(id).orElse(null);
    }

    public GroupEntity findByName(String name) {
        return groupRepository.findByName((name));
    }

    @Transactional
    public GroupEntity createGroupWithStudentsAndCourses(GroupDto dto) {
        GroupEntity group = new GroupEntity();
        group.setName(dto.getName());

        List<CourseEntity> courses = Optional.ofNullable(dto.getCourses())
                .orElseGet(List::of)
                .stream()
                .map(this::getOrCreateCourse)
                .toList();

        group.setCourses(new ArrayList<>(courses));

        List<StudentEntity> students = Optional.ofNullable(dto.getStudents())
                .orElseGet(List::of)
                .stream()
                .map(sdto -> toStudentEntity(sdto, group))
                .toList();

        group.setStudents(new ArrayList<>(students));

        return groupRepository.save(group);
    }

    private CourseEntity getOrCreateCourse(CourseDto cdto) {
        CourseEntity found = courseRepository.findByName(cdto.getName());
        if (found != null) return found;
        CourseEntity c = new CourseEntity();
        c.setName(cdto.getName());
        c.setDescription(cdto.getDescription());
        return courseRepository.save(c);
    }

    private StudentEntity toStudentEntity(StudentDto sdto, GroupEntity group) {
        StudentEntity s = new StudentEntity();
        s.setName(sdto.getName());
        s.setEmail(sdto.getEmail());
        s.setGroup(group);

        if (sdto.getAdditionalCourse() != null && !sdto.getAdditionalCourse().isBlank()) {
            CourseEntity course = courseRepository.findByName(sdto.getAdditionalCourse());
            if (course == null) {
                course = new CourseEntity();
                course.setName(sdto.getAdditionalCourse());
                course = courseRepository.save(course);
            }
            s.setAdditionalCourse(course);
        }
        return s;
    }
}
