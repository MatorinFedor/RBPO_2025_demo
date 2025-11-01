package ru.mfa.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permissions {
    READ("read"),
    MODIFICATION("modify");

    private final String permission;
}
