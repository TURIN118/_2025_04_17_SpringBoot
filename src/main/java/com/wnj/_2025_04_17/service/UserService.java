package com.wnj._2025_04_17.service;

import com.github.pagehelper.PageInfo;
import com.wnj._2025_04_17.entity.BatchResetPwdDTO;
import com.wnj._2025_04_17.entity.PageDTO;
import com.wnj._2025_04_17.entity.Result;
import com.wnj._2025_04_17.entity.UserEntity;

import java.util.List;

public interface UserService {
    PageInfo<UserEntity> findAllOrByCondition(PageDTO pageDTO);

    Integer addUser(UserEntity user);

    Integer delUser(int id);

    Integer updateUser(UserEntity user);

    boolean login(UserEntity user);

    List<UserEntity> findByCondition(UserEntity user);

    Integer updateStatus(UserEntity user);

    Integer updateUserData(UserEntity user);

    Result handleBatchDelete(List<UserEntity> userEntities);

    Result handleBatchResetPwd(BatchResetPwdDTO batchResetPwdDTO);

    Result handleBatchToggleStatus(BatchResetPwdDTO batchResetPwdDTO);

    Result deleteSimpleUser(UserEntity user);
}
