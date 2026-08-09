package com.jerry.tilas.mapper;

import com.jerry.tilas.pojo.Emp;
import com.jerry.tilas.pojo.EmpQuaryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface Empmapper {
        //查询总条数
        @Select("Select count(*) from emp")
        Long getTotal();

//        //查询员工数据
//       @Select("Select emp.*,dept.name deptName from emp left join dept on emp.dept_id = dept.id order by emp.update_time desc limit #{page},#{pageSize}")
//        List<Emp> getRows(Integer page, Integer pageSize);
        //查询员工数据（pagehelper）
//        @Select("select emp.*,dept.name deptName from emp left join dept on emp.dept_id = dept.id where emp.name like concat('%',#{name},'%') and gender=${gender} and emp.entry_date between #{begin} and #{end}")
        //查询员工数据
        List<Emp> getEmps(EmpQuaryParam empQuaryParam);

        @Options(useGeneratedKeys = true,keyProperty = "id")
        @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
                "values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime}) ")
        void addEmp(Emp emp);

        @Select("select emp.* from emp where id=#{id}")
        Emp getEmp(Integer id);

        void deleteEmp(List<Integer> ids);

        void updateEmp(Emp emp);

}
