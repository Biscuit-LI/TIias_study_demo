package com.jerry.tilas.mapper;

import com.jerry.tilas.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    //AOP层插入日志信息
    @Insert("insert into operate_log(operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values(#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    void insert(OperateLog log);


    @Select("select operate_log.*,emp.name as operateEmpName from operate_log left join emp on operate_emp_id=emp.id")
    List<OperateLog> getLogs();

}
