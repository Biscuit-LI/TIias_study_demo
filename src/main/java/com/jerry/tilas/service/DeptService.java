package com.jerry.tilas.service;


import com.jerry.tilas.pojo.Dept;

import java.util.List;

public interface DeptService {
    //获取全部部门
    public abstract List<Dept> getDepts();

    //删除单个部门
    public abstract void deleteDepts(Integer id);

    //添加单个部门
    void addDept(Dept dept);

    //更新部门信息
    void updateDept(Dept dept);

    //获取单个部门（查询回显）
    Dept getDept(Integer id);
}
