package ru.mfa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mfa.entity.ApplicationUser;
import ru.mfa.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       ApplicationUser user = userRepository.findByEmail(email)
               .orElseThrow(() -> new UsernameNotFoundException(email));
       return fromApplicationUser(user);
    }

    private UserDetails fromApplicationUser(ApplicationUser user) {
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRole().getGrantedAuthorities())
                .accountLocked(user.isAccountLocked())
                .accountExpired(user.isAccountExpired())
                .credentialsExpired(user.isCredentialsExpired())
                .disabled(user.isDisabled())
                .build();
    }
}
