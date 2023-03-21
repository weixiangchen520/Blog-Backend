package com.weixiangchen.blog.mapper;

import org.apache.ibatis.annotations.*;

import com.weixiangchen.blog.domain.User;

@Mapper
public interface UserMapper {
    @Select("select id, username, password, email from user where id = #{id}")
    User findUserById(@Param("id") Long id);

    @Delete("delete from user where id = #{id}")
    void deleteUserById(@Param("id") Long id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into  user(username, password, email) values (#{username}, #{password}, #{email})")
    void createUser(User user);
}
