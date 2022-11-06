package com.ssmr.user.mail;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class MailService {

    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "rhwhddbs12@naver.com";

    /*
     * 기능 : 이메일
     * 작성자: 고종윤
     * 내용: 이메일 정보 생성 및 메일 발송
     */
    public void sendMail(com.ssmr.user.mail.MailDto mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());
        System.out.println(message.getTo());
        System.out.println(message.getFrom());
        System.out.println(message.getSubject());
        System.out.println(message.getText());
        mailSender.send(message);
    }
    /*
     * 기능 : 이메일
     * 작성자: 고종윤
     * 내용: 이메일 인증
     */


    public String CertiEmail(String CertiKey){
        String Certi = "false";

        return Certi;
    }

    /*
     * 기능 : 이메일
     * 작성자: 고종윤
     * 내용: 메일 DTO 객체 데이터 생성
     */
    public MailDto creteMailInfo(String userEmail, String authKey) {

        MailDto mailDTO = new MailDto();
        mailDTO.setAddress(userEmail);   // 발신 할 이메일 주소
        mailDTO.setTitle("땡리단길 인증번호 안내 이메일 입니다."); // 이메일 제목
        mailDTO.setMessage("안녕하세요. 땡리단길 인증번호 안내 이메일 입니다. 인증번호는  "
                + authKey + " 입니다."); // 이메일 내용
        return mailDTO;

    }
    /*
     * 기능 : 이메일
     * 작성자: 고종윤
     * 내용: 이메일 인증번호 난수 생성
     */
    public String createAuthKey() {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < 6) {
            int num = ran.nextInt(9);
            sb.append(num);
        }
        // 숫자/대문자/소문자 조합
      /*  int num = 0;
        do {
            num = ran.nextInt(75) + 48;
            if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                sb.append((char) num);
            } else {
                continue;
            }
        } while (sb.length() < 6);*/
        System.out.println("인증번호: "+sb.toString());
        return sb.toString();
    }

}
