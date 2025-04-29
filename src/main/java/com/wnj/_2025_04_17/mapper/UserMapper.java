package com.wnj._2025_04_17.mapper;

import com.wnj._2025_04_17.entity.BatchResetPwdDTO;
import com.wnj._2025_04_17.entity.PageDTO;
import com.wnj._2025_04_17.entity.Result;
import com.wnj._2025_04_17.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserEntity> findAllOrByCondition(PageDTO pageDTO);

    @Insert("insert into user values(#{user.username},#{user.id},#{user.pwd})")
    @Options(keyProperty="user.id",useGeneratedKeys=true)
    Integer addUser(@Param("user")UserEntity user);

    @Delete("delete from user where id=#{id}")
    Integer delUser(@Param("id") int id);


    @Update("update user set username=#{user.username},pwd=#{user.pwd} where id=#{user.id}")
    Integer updateUser(@Param("user")UserEntity user);

    @Select("select * from user where username = #{user.username}")
    List<UserEntity> login(@Param("user")UserEntity user);

    @Select("select * from user where username like CONCAT('%', #{user.username}, '%') and status = #{user.status}")
    List<UserEntity> findByCondition(@Param("user")UserEntity user);

    @Update("update user set status=#{user.status} where id=#{user.id}")
    Integer updateStatus(@Param("user")UserEntity user);

    @Update("update user set username=#{user.username},pwd=#{user.pwd},status=#{user.status} where id=#{user.id}")
    Integer updateUserData(@Param("user")UserEntity user);

    Integer handleBatchDelete(List<UserEntity> userEntities);

    Integer handleBatchResetPwd(@Param("dto") BatchResetPwdDTO dto);

    Integer handleBatchToggleStatus(@Param("dto")BatchResetPwdDTO dto);

    @Delete("delete from user where  id = #{user.id}")
    Integer deleteSimpleUser(@Param("user") UserEntity user);
}
