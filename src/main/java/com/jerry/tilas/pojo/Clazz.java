package com.jerry.tilas.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer id;
    private String name;
    private String room;
    private String beginDate;
    private String endDate;
    private Integer subject;
    private Integer masterId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String status="未开发";
}
