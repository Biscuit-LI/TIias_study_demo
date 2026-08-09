package com.jerry.tilas.mapper;

import com.jerry.tilas.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface Deptmapper {
    //查询全部部门
    @Select("select id,name,id, name, create_time, update_time from dept")
    List<Dept> getDepts();

    //删除单个部门（无返回值）
    @Delete("delete from dept where id=#{id}")
    void deleteDept(@Param("id")Integer id);

    //新增部门
    @Insert("Insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime})")
    void addDept(Dept dept);

    //更新部门
    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void updateDept(Dept dept);

    //查询回显
    @Select("select id, name, create_time, update_time from dept where id=#{id}")
    Dept getDept(Integer id);
}
