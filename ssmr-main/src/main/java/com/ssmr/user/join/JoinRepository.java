package com.ssmr.user.join;

import com.ssmr.user.auth.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinRepository {

    String checkId(String USER_ID);
    void insertId();

    User findOneWithAuthoritiesByUsername(String userId);

    void save(User user);
}
