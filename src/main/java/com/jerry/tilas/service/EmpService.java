package com.jerry.tilas.service;

import com.jerry.tilas.pojo.Emp;
import com.jerry.tilas.pojo.EmpQuaryParam;
import com.jerry.tilas.pojo.EmpResult;
import com.jerry.tilas.pojo.LoginInfo;

import java.util.List;

public interface EmpService {
//    //得到数据条数
//    Long getTotal();
//
//    //查询员工数据
//    List<Emp> getRows(Integer page,Integer pageSize);

    EmpResult<Emp> getempResult(EmpQuaryParam empQuaryParam);

    void addEmp(Emp emp);

    Emp getEmp(Integer id);

    void deleteEmp(List<Integer> ids);

    void updateEmp(Emp emp);

    LoginInfo empLogin(Emp emp);
}
