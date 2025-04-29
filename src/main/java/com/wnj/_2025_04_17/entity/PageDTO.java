package com.wnj._2025_04_17.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : WNJ
 * @version : 1.0
 * @Project : _2025_04_17
 * @Package : com.wnj._2025_04_17.entity
 * @ClassName : 用户查询条件.java
 * @createTime : 2025/4/26 22:37
 * @Email : NJ651217@163.com
 * @Description :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageDTO {
    /*
    * 用户名称
    * */
    private String username;
    /*
    * 用户状态
    * */
    private String status;
    /*
    * 当前页面码
    * */
    private Integer currentPage;
    /*
    * 总条数
    * */
    private Integer total;
    /*
    * 每页的数量
    * */
    private Integer pageSize;
}
