package com.ssmr.mail.controller;

import com.ssmr.mail.controller.dto.MailDto;
import com.ssmr.mail.service.MailService;
import com.ssmr.util.ResultDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class MailController {

    @Autowired
    private MailService mailService;
    /*
     * 기능 : 회원가입 이메일 인증
     * 작성자: 고종윤
     * 내용: 인증키 이메일 발송
     * 비고: (이 url을 무차별적으로 계속해서 호출한다면 이메일 폭탄을 맞을 수 있고 서버다운의 위험이 있음, 생각해보자 )
     */
    @GetMapping("/sendMail")
    public ResultDto SendmailAuthKey(@RequestParam("userEmail") String userEmail, HttpSession session){
        ResultDto resultDto = new ResultDto();
        // 디비에 이메일이 있는지 확인한다.
        int a= 1;
        if(a == 1){//가입된 이메일이 없는경우
            //주소/제목/내용을 실어넣는다.
            String authKey = mailService.createAuthKey();  // 인증번호 생성
            session.setAttribute("authKey",authKey); // 세션에 생선한 인증번호 저장
            MailDto mailDto = mailService.creteMailInfo(userEmail,authKey);
            //maildto에 세팅된 객체로 이메일 인증번호 보내기
            mailService.sendMail(mailDto);

            resultDto.setCode("SUCCESS");
            return resultDto;
        }
        else { // 기존에 가입된 이메일이 있는경우
            resultDto.setCode("FALSE");
            return resultDto;
        }
    }

    @GetMapping("/CertiMail")
    public ResultDto CertiMail(String authKey, HttpSession session){
        String sAuthKey = (String)session.getAttribute("authKey");
        ResultDto resultDto = new ResultDto();
        if(authKey.equals(sAuthKey)){
            resultDto.setCode("SUCCESS");
        }else{
            resultDto.setCode("FALSE");
        }
        return resultDto;
    }

}
