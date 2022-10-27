package com.ssmr.user.service;


import com.ssmr.exception.DuplicateMemberException;
import com.ssmr.user.dto.User;
import com.ssmr.user.repository.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public void signup(User userDto) {
        if (userMapper.findOneWithAuthoritiesByUsername(userDto.getUserId()) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }
        log.error("service Password: {}", userDto.getPassword());
//        User user = new User();
//        user.setUserId(userDto.getUserId());
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setRole(userDto.getRole());

        userMapper.save(userDto);
    }
}
