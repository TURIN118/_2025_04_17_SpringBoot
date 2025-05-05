package com.wnj._2025_04_17.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PayOrderEntity {
    private Integer orderId;
    private Integer amount;
    private Integer orderStatus;
    private Integer userId;
    private String  username;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}