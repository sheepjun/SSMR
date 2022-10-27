package com.ssmr.user.repository;


import com.ssmr.user.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    User findOneWithAuthoritiesByUsername(String userId);

    void save(User user);
}
