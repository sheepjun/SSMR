package com.ssmr.user.service;


import com.ssmr.user.dto.User;
import com.ssmr.user.repository.JoinRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JoinService {

    @Autowired
    JoinRepository joinRepository;

//    public void ryptPw(User joinDto){
//        // 시큐리티에서 제공하는 암호화 로직 필요
//        //BCryptPasswordEncoder encoder = new BCrpyPasswordEncoder;
//
//    }

    public String checkId(String userId) {
        String check = joinRepository.checkId(userId);
        if(!(check ==null)) check="EXIST";
        else check="NOT EXIST";
        return check;
    }
}
