package com.jerry.tilas.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jerry.tilas.mapper.EmpExprmapper;
import com.jerry.tilas.mapper.Empmapper;
import com.jerry.tilas.pojo.Emp;
import com.jerry.tilas.pojo.EmpExpr;
import com.jerry.tilas.pojo.EmpQuaryParam;
import com.jerry.tilas.pojo.EmpResult;
import com.jerry.tilas.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private Empmapper empmapper;
    @Autowired
    private EmpExprmapper empExprmapper;
//    @Override
//    public EmpResult<Emp> getempResult(Integer page, Integer pagesize) {
//        return new EmpResult<>(empmapper.getTotal(),empmapper.getRows(page,pagesize));
//    }

//    @Override
//    public Long getTotal() {
//        return empmapper.getTotal();
//    }
//
//    @Override
//    public List<Emp> getRows(Integer page, Integer pageSize) {
//        return empmapper.getRows(page,pageSize);
//    }

    //返回员工数据（pagehelper）
    @Override
    public EmpResult<Emp> getempResult(EmpQuaryParam empQuaryParam) {
        PageHelper.startPage(empQuaryParam.getPage(),empQuaryParam.getPageSize());
        List<Emp> emps=empmapper.getEmps(empQuaryParam);
        Page<Emp> p=(Page<Emp>)emps;
        return new EmpResult<>(p.getTotal(),p.getResult());
    }

    //添加员工基本信息
    @Transactional(rollbackFor = {Exception.class} )
    @Override
    public void addEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        empmapper.addEmp(emp);

        List<EmpExpr> exprList=emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(expr->{
                expr.setEmpId(emp.getId());
            });
            empExprmapper.addEmp(exprList);
        }

    }

    //根据id查询员工信息
    @Override
    public Emp getEmp(Integer id) {
        Emp emp=empmapper.getEmp(id);
        emp.setExprList(empExprmapper.getEmpExpr(id));
        return emp;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteEmp(List<Integer> ids) {
        empmapper.deleteEmp(ids);
        empExprmapper.deleteEmp(ids);
    }

    @Override
    public void updateEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empmapper.updateEmp(emp);

        empExprmapper.deleteEmp(Arrays.asList(emp.getId()));
        List<EmpExpr> exprList=emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(expr->{expr.setEmpId(emp.getId());});
            empExprmapper.addEmp(exprList);
        }
    }


}
