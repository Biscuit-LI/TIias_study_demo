package com.jerry.tilas.service;


import com.jerry.tilas.pojo.EmpJobData;

import java.util.List;
import java.util.Map;

public interface ReportService {

    EmpJobData getEmpJobData();

    List<Map<String,Object>> getEmpGenderData();
}
