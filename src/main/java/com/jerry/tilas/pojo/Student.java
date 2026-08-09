package com.jerry.tilas.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String no;
    private Integer gender;
    private String phone;
    private Integer degree;
    private Integer clazzId;
    private String idCard;
    private Integer isCollege;
    private String address;
    private LocalDateTime graduationDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
