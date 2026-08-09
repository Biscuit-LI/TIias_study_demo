package com.jerry.tilas.service.impl;

import com.jerry.tilas.mapper.ReportMapper;
import com.jerry.tilas.pojo.EmpJobData;
import com.jerry.tilas.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public EmpJobData getEmpJobData() {
        List<Map<String, Object>> list = reportMapper.getEmpJobDatal();
        List<Object> jobList=list.stream().map(dataMap->dataMap.get("k1")).toList();
        List<Object> dataList=list.stream().map(dataMap->dataMap.get("k2")).toList();
        return new EmpJobData(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return reportMapper.getEmpGenderData();
    }
}
