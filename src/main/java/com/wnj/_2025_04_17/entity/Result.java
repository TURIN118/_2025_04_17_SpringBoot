package com.wnj._2025_04_17.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : WNJ
 * @version : 1.0
 * @Project : _2025_04_17
 * @Package : com.wnj._2025_04_17.entity
 * @ClassName : 返回统一类.java
 * @createTime : 2025/4/26 22:37
 * @Email : NJ651217@163.com
 * @Description :
 */
@Data
@ToString
public class Result {
    private Integer code;
    private Object data;
    private String msg;
    /*
    * 操作成功返回
    * */
    public static Result OK(Object data,String msg){
        return new Result(200,data,"msg");
    }
    /*
    * 操作失败返回
    * */
    public static Result ERR(Object data,String msg){
        return new Result(500,data,"msg");
    }

    public Result(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
