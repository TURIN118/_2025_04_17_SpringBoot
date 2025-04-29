package com.wnj._2025_04_17.entity;

import lombok.Data;

@Data
public class UserEntity {
    private String username;
    private int id;
    private String pwd;
    private int status;

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", pwd='" + pwd + '\'' +
                ", status=" + status +
                '}';
    }
}
