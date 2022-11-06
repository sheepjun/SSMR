package com.ssmr.user.join;


import com.ssmr.exception.DuplicateMemberException;
import com.ssmr.user.auth.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class JoinService {

    @Autowired
    JoinRepository joinRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public void ryptPw(JoinDto joinDto){
        // 시큐리티에서 제공하는 암호화 로직 필요
        //BCryptPasswordEncoder encoder = new BCrpyPasswordEncoder;

    }

    /**
     *
     * @param userDto
     * 1. 가입되어 있는 유저인지 DB조회를 통해 확인한다.
     * 2. 가입되어 있지 않다면, 입력받은 비밀번호를 암호화를 해준다.
     * 3. 회원가입 성공(실패 Exception 추가 개발 해야 됨)
     */
    public void signup(User userDto) {
        if (joinRepository.findOneWithAuthoritiesByUsername(userDto.getUserId()) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }
        log.error("service Password: {}", userDto.getPassword());
//        User user = new User();
//        user.setUserId(userDto.getUserId());
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setRole(userDto.getRole());

        joinRepository.save(userDto);
    }

    public String checkId(String USER_ID) {
        String check = joinRepository.checkId(USER_ID);
        if(!(check ==null)) check="EXIST";
        else check="NOT EXIST";
        return check;
    }
}
