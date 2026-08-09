package com.jerry.tilas.mapper;


import com.jerry.tilas.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpExprmapper {

    void addEmp(List<EmpExpr> empExprs);

    @Select("select emp_expr.* from emp_expr where emp_id=#{id}")
    List<EmpExpr> getEmpExpr(@Param("id")Integer id);

    void deleteEmp(List<Integer> ids);
}
