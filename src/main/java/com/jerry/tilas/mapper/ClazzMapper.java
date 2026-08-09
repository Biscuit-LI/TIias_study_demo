package com.jerry.tilas.mapper;

import com.jerry.tilas.pojo.Clazz;
import com.jerry.tilas.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    //添加班级
    @Insert("insert into clazz(name, room, begin_date, end_date, subject, master_id,create_time,update_time)" +
            " values(#{name},#{room},#{beginDate},#{endDate},#{subject},#{masterId},#{createTime},#{updateTime})")
    void addClazz(Clazz clazz);



    List<Clazz> getClazz(ClazzQueryParam param);
}
