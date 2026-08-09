package com.jerry.tilas.service.impl;

import com.jerry.tilas.mapper.Deptmapper;
import com.jerry.tilas.pojo.Dept;
import com.jerry.tilas.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    Deptmapper deptmapper;

    @Override
    public List<Dept> getDepts() {
        return deptmapper.getDepts();
    }

    @Override
    public void deleteDepts(Integer id) {
        deptmapper.deleteDept(id);
    }

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.addDept(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptmapper.updateDept(dept);
    }

    @Override
    public Dept getDept(Integer id) {
        return deptmapper.getDept(id);
    }


}
