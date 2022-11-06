package com.ssmr.user.join;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class JoinDto {
    private String USER_ID;
    private String EMAIL;
    private String USER_NAME;
    private String NICKNAME;
    private String USER_TYPE;
    private String GENDER;
    private String BIRTHDAY;
    private String PASSWORD;
}
