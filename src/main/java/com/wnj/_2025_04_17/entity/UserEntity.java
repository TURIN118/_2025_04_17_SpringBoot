package com.wnj._2025_04_17.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
    private String username;
    private int id;
    private String pwd;
    private int status;
}
