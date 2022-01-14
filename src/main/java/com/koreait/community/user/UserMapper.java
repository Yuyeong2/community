package com.koreait.community.user;

import com.koreait.community.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserEntity entity);
    UserEntity selUser(UserEntity entity);
    int updUser(UserEntity entity);
}
