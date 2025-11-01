CREATE TABLE IF NOT EXISTS users
(
    id                     UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    name                   VARCHAR(255),
    email                  VARCHAR(255) NOT NULL UNIQUE,
    password               VARCHAR(255) NOT NULL,
    role                   VARCHAR(32)  NOT NULL CHECK (role IN ('USER', 'ADMIN')),
    is_account_expired     BOOLEAN      NOT NULL DEFAULT FALSE,
    is_account_locked      BOOLEAN      NOT NULL DEFAULT FALSE,
    is_credentials_expired BOOLEAN      NOT NULL DEFAULT FALSE,
    is_disabled            BOOLEAN      NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS groups
(
    id   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS courses
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(255) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE IF NOT EXISTS students
(
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name                 VARCHAR(255) NOT NULL,
    email                VARCHAR(255) UNIQUE,
    group_id             UUID REFERENCES groups (id),
    additional_course_id UUID REFERENCES courses (id)
);

-- many-to-many:
CREATE TABLE IF NOT EXISTS group_courses
(
    group_id  UUID NOT NULL REFERENCES groups (id) ON DELETE CASCADE,
    course_id UUID NOT NULL REFERENCES courses (id) ON DELETE CASCADE,
    PRIMARY KEY (group_id, course_id)
);