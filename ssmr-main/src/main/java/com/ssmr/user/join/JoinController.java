package com.ssmr.user.join;


import com.ssmr.user.auth.User;
import com.ssmr.util.ResponseDto;
import com.ssmr.util.ResponseUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@ComponentScan
@RestController
@AllArgsConstructor
public class JoinController {
    @Autowired
    private JoinService joinService;


    /**
     *
     * @param user
     * @return
     * 작성자: 양희준
     * 기능 : 회원가입
     */
    @PostMapping("/signup")
    public ResponseDto<User> signup(@Valid @RequestBody User user) {

        log.error("password: {}", user.getEmail());
//        user.setRole("ROLE_USER");
        joinService.signup(user);

        return ResponseUtil.SUCCESS("회원가입", user);

    }

   /* private JoinDto joinDto;

    @PostMapping("/join/joinUser")
    public void joinUser(JoinDto joinDto){

        //비밀번호 암호화(시큐리티 필요)
        joinService.ryptPw(joinDto);

    }*/

    /*
     * 기능 : 회원가입 아이디 중복 검사
     * 작성자: 고종윤
     * 내용: 회원가입 아이디 중복검사
     */
    @GetMapping("/join/checkId")
    public ResponseDto checkId(String USER_ID){
        return ResponseUtil.SUCCESS(joinService.checkId(USER_ID),null);
    }

}
