package ru.mfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mfa.entities.GroupEntity;

import java.util.UUID;

@Repository
public interface GroupRepository
        extends JpaRepository<GroupEntity, UUID> {

    GroupEntity findByName(String name);

}
