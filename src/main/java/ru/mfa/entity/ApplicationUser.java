package ru.mfa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mfa.model.enums.ApplicationUserRole;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private ApplicationUserRole role;

    private boolean isAccountExpired;

    private boolean isAccountLocked;

    private boolean isCredentialsExpired;

    private boolean isDisabled;

}
