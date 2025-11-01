package ru.mfa.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum ApplicationUserRole {
    USER(Set.of(Permissions.READ)),
    ADMIN(Set.of(Permissions.READ, Permissions.MODIFICATION)),;

    private final Set<Permissions> permissions;

    public Set<GrantedAuthority> getGrantedAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return grantedAuthorities;
    }
}
