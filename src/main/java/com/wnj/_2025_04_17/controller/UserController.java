package com.wnj._2025_04_17.controller;

import com.github.pagehelper.PageInfo;
import com.wnj._2025_04_17.entity.BatchResetPwdDTO;
import com.wnj._2025_04_17.entity.PageDTO;
import com.wnj._2025_04_17.entity.Result;
import com.wnj._2025_04_17.entity.UserEntity;
import com.wnj._2025_04_17.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user")
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    /*
    * 获取所有用户
    * */
    @PostMapping(value = "/findAllOrByCondition")
    public PageInfo<UserEntity> findAllOrByCondition(PageDTO pageDTO) {
        return userService.findAllOrByCondition(pageDTO);
    }

    /*
    * 添加用户
    * */
    @PostMapping(value = "/add")
    public Integer addUser(@RequestBody UserEntity user) {
        return userService.addUser(user);
    }

    /*
    * 根据id删除用户
    * */
    @DeleteMapping("/delete/{id}")
    public Integer delUser(@PathVariable int id) {
        return userService.delUser(id);
    }

    /*
    * 更新用户信息
    * */
    @PutMapping(value = "/update")
    public Integer updateUser(@RequestBody UserEntity user) {
        return userService.updateUser(user);
    }


    /*
    * 登录接口
    * */
    @PostMapping(value = "/login")
    public Result login(@RequestBody UserEntity user) {
        return userService.login(user);
    }
    /*
    * 更新用户状态
    * */
    @PostMapping(value = "/update-status")
    public Integer updateStatus(UserEntity user) {
       return userService.updateStatus(user);
    }

    /*
    * 更新用户信息
    * */
    @PostMapping(value = "/updateUserData")
    public Integer updateUserData(UserEntity user){
        return userService.updateUserData(user);
    }

    /*
    * 批量删除用户信息
    * */
    @PostMapping(value = "/handleBatchDelete")
    public Result handleBatchDelete(@RequestBody List<UserEntity> userEntities){
        return userService.handleBatchDelete(userEntities);
    }

    /*
     * 批量更新用户密码
     * */
    @PostMapping(value = "/handleBatchResetPwd")
    public Result handleBatchResetPwd(@RequestBody BatchResetPwdDTO batchResetPwdDTO){
        return userService.handleBatchResetPwd(batchResetPwdDTO);
    }

    /*
     * 批量更新用户状态
     * */
    @PostMapping(value = "/handleBatchToggleStatus")
    public Result handleBatchToggleStatus(@RequestBody BatchResetPwdDTO batchResetPwdDTO){
        return userService.handleBatchToggleStatus(batchResetPwdDTO);
    }

    /*
    * 单个删除用户
    * */
    @PostMapping(value = "/deleteSimpleUser")
    public Result deleteSimpleUser(@RequestBody UserEntity user){
        return userService.deleteSimpleUser(user);
    }
}
