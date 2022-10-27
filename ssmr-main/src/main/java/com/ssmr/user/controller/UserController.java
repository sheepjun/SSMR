package com.ssmr.user.controller;


import com.ssmr.user.dto.MemberLoginDto;
import com.ssmr.user.dto.User;
import com.ssmr.user.service.JoinService;
import com.ssmr.user.service.UserService;
import com.ssmr.util.ResponseDto;
import com.ssmr.util.ResponseUtil;
import com.ssmr.util.ResultDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;


    @PostMapping("/hello")
    public ResponseDto<MemberLoginDto> hello(@Valid @RequestBody MemberLoginDto memberLoginDto) {

        log.debug("###");
        return ResponseUtil.SUCCESS("성공", memberLoginDto);
    }

    @PostMapping("/signup")
    public ResponseDto<User> signup(@Valid @RequestBody User user) {

        log.error("password: {}", user.getEmail());
//        user.setRole("ROLE_USER");
        userService.signup(user);

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
//    @PostMapping("/checkId")
//    public String checkId(@ModelAttribute String userId) {
//
//    }

}
