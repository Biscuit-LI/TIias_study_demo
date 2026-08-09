package com.jerry.tilas.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.Inet4Address;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpJobData {
    private List<Object> jobList;
    private List<Object> dataList;
}
