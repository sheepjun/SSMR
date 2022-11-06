package com.ssmr.user.auth;

import com.ssmr.user.join.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Slf4j
@Component("UserDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final JoinRepository joinRepository;

    /**
     *
     * @param userId the username identifying the user whose data is required.
     * @return
     * 작성자: 양희준
     * 기능:
     * 1. 입력받은 userId가 존재하는지 체크
     */
    @Override
    public UserDetails loadUserByUsername(final String userId) {

        User user = joinRepository.findOneWithAuthoritiesByUsername(userId);
        user.setRole("ROLE_USER");

        return user;
    }


}
