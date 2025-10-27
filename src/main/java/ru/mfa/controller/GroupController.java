package ru.mfa.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mfa.entity.GroupEntity;
import ru.mfa.model.GroupDto;
import ru.mfa.service.GroupService;
import ru.mfa.util.MappingUtils;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    private final MappingUtils mappingUtils;

    /**
     * Пример тела запроса:
     * {
     *     "name": "Group NEW",
     *     "students": [
     *         {
     *             "name": "student2",
     *             "email": "student2@example.com",
     *             "group": "Group NEW",
     *             "additionalCourse": "Mathematics"
     *         },
     *         {
     *             "name": "student3",
     *             "email": "student3@example.com",
     *             "group": "Group NEW",
     *             "additionalCourse": "Physics"
     *         }
     *     ],
     *     "courses": [
     *         {
     *             "name": "Mathematics",
     *             "description": "Basic math course"
     *         },
     *         {
     *             "name": "Physics",
     *             "description": "Intro to physics"
     *         }
     *     ]
     * }
     *
     */
    @PostMapping
    public ResponseEntity<GroupDto> createGroup(@Valid @RequestBody GroupDto dto) {
        GroupEntity saved = groupService.createGroupWithStudentsAndCourses(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mappingUtils.toDto(saved));
    }
}
