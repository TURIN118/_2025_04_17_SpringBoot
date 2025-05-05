package com.wnj._2025_04_17.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wnj._2025_04_17.entity.BatchResetPwdDTO;
import com.wnj._2025_04_17.entity.PageDTO;
import com.wnj._2025_04_17.entity.Result;
import com.wnj._2025_04_17.entity.UserEntity;
import com.wnj._2025_04_17.mapper.UserMapper;
import com.wnj._2025_04_17.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<UserEntity> findAllOrByCondition(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        List<UserEntity> list = userMapper.findAllOrByCondition(pageDTO);
        PageInfo<UserEntity> userEntityPageInfo = new PageInfo<>(list);
        return userEntityPageInfo;
    }

    @Override
    public Integer addUser(UserEntity user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer delUser(int id) {
        return userMapper.delUser(id);
    }

    @Override
    public Integer updateUser(UserEntity user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Result login(UserEntity user) {
        List<UserEntity> login = userMapper.login(user);
        if (login != null && login.size() > 0) {
            if (login.get(0).getPwd().equals(user.getPwd())) {
                return new Result(200, new UserEntity(
                        login.get(0).getUsername(),
                        login.get(0).getId(),
                        null,
                        login.get(0).getStatus()),
                        "登录成功");
            } else {
                return new Result(500, null, "账号或密码错误！");
            }
        } else {
            return new Result(500, null, "用户不存在！");
        }
    }

    @Override
    public List<UserEntity> findByCondition(UserEntity user) {
        return userMapper.findByCondition(user);
    }

    @Override
    public Integer updateStatus(UserEntity user) {
        return userMapper.updateStatus(user);
    }

    @Override
    public Integer updateUserData(UserEntity user) {
        return userMapper.updateUserData(user);
    }

    @Override
    public Result handleBatchDelete(List<UserEntity> userEntities) {
        Integer i = userMapper.handleBatchDelete(userEntities);
        return new Result(200, i, "批量删除成功!");
    }

    @Override
    public Result handleBatchResetPwd(BatchResetPwdDTO batchResetPwdDTO) {
        Integer i = userMapper.handleBatchResetPwd(batchResetPwdDTO);
        return new Result(200, i, "批量更新密码成功!");
    }

    @Override
    public Result handleBatchToggleStatus(BatchResetPwdDTO batchResetPwdDTO) {
        Integer i = userMapper.handleBatchToggleStatus(batchResetPwdDTO);
        return new Result(200, i, "批量更新状态成功!");
    }

    /*
     * 删除单个用户
     * */
    @Override
    public Result deleteSimpleUser(UserEntity user) {
        Integer i = userMapper.deleteSimpleUser(user);
        return new Result(200, i, user.getUsername() + "删除成功!");
    }
}
