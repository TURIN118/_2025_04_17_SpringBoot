package com.wnj._2025_04_17.entity;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : WNJ
 * @version : 1.0
 * @Project : _2025_04_17
 * @Package : com.wnj._2025_04_17.entity
 * @ClassName : .java
 * @createTime : 2025/4/28 12:43
 * @Email : NJ651217@163.com
 * @Description :
 */
@Data
public class BatchResetPwdDTO {
    private List<UserEntity> selectedItems; // 批量修改的用户信息
    private String newPwd;                  //新密码
    private Integer newStatus;              //新状态
}
