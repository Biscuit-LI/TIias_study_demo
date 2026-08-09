package com.jerry.tilas.mapper;


import com.jerry.tilas.pojo.EmpJobData;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {

//    @MapKey("k1")
    @Select("select (case when job=1 then '班主任' when job=2 then '讲师'" +
            " when job=3 then '学工主管' when job=4 then '教研主管' " +
            "when job=5 then '咨询师' else '其他' end) k1,count(*) k2 from emp group by job")
    List<Map<String,Object>> getEmpJobDatal();

    @Select("select if(gender=1,'男','女') 'name',count(*) 'value' from emp group by gender")
    List<Map<String, Object>> getEmpGenderData();
}
