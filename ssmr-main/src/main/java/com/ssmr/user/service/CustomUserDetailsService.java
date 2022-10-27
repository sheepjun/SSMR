package com.ssmr.user.service;

import com.ssmr.user.dto.User;
//import com.ssmr.user.repository.UserRepository;
import com.ssmr.user.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component("UserDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserMapper userRepository;

    @Override
    public UserDetails loadUserByUsername(final String userId) {

        log.error("loadUserByUsername: {}", userId);
        User user = userRepository.findOneWithAuthoritiesByUsername(userId);
        user.setRole("ROLE_USER");
        log.error("user : {}, {}, {}", user.getUserId(), user.getPassword(), user.getAuthorities());

        return user;
    }


}
