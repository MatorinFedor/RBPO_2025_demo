-- Группы
INSERT INTO groups (id, name)
VALUES ('11111111-1111-1111-1111-111111111111', 'Group A'),
       ('22222222-2222-2222-2222-222222222222', 'Group B')
ON CONFLICT (id) DO NOTHING;

-- Курсы
INSERT INTO courses (id, name, description)
VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Mathematics', 'Basic math course'),
       ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'Physics', 'Intro to physics'),
       ('cccccccc-cccc-cccc-cccc-cccccccccccc', 'History', 'World history overview')
ON CONFLICT (id) DO NOTHING;

-- Студенты
INSERT INTO students (id, name, email, group_id, additional_course_id)
VALUES ('99999999-9999-9999-9999-999999999999', 'Alice', 'alice@example.com',
        '11111111-1111-1111-1111-111111111111', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
       ('88888888-8888-8888-8888-888888888888', 'Bob', 'bob@example.com',
        '11111111-1111-1111-1111-111111111111', 'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb'),
       ('77777777-7777-7777-7777-777777777777', 'Charlie', 'charlie@example.com',
        '22222222-2222-2222-2222-222222222222', 'cccccccc-cccc-cccc-cccc-cccccccccccc')
ON CONFLICT (id) DO NOTHING;

-- Курсы для групп (many-to-many)
INSERT INTO group_courses (group_id, course_id)
VALUES ('11111111-1111-1111-1111-111111111111', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
       ('11111111-1111-1111-1111-111111111111', 'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb'),
       ('22222222-2222-2222-2222-222222222222', 'cccccccc-cccc-cccc-cccc-cccccccccccc')
ON CONFLICT DO NOTHING;