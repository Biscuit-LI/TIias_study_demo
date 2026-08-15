package com.jerry.tilas.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jerry.tilas.mapper.LogMapper;
import com.jerry.tilas.pojo.EmpResult;
import com.jerry.tilas.pojo.OperateLog;
import com.jerry.tilas.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;


    @Override
    public EmpResult<OperateLog> getLogs(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<OperateLog> logs = logMapper.getLogs();
        Page<OperateLog> page1=(Page<OperateLog>)logs;
        return new EmpResult<>(page1.getTotal(),page1.getResult());
    }
}
