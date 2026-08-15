package com.jerry.tilas.service;


import com.jerry.tilas.pojo.EmpResult;
import com.jerry.tilas.pojo.OperateLog;

public interface LogService {
    EmpResult<OperateLog> getLogs(int page, int pageSize);
}
