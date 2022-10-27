package com.ssmr.user.repository;

import com.ssmr.user.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinRepository {

    String checkId(String userId);

    User login(User user);
    void insertId();
}
