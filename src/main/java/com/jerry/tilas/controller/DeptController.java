package com.jerry.tilas.controller;

import com.jerry.tilas.mapper.Deptmapper;
import com.jerry.tilas.pojo.Dept;
import com.jerry.tilas.pojo.Result;
import com.jerry.tilas.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    //依赖注入
    @Autowired
    DeptService deptService;

    //获取全部部门
    @GetMapping
    public Result getDepts(){
        log.info("获取全部部门信息");
        return Result.success(deptService.getDepts());
    }

    //删除单个部门
    @DeleteMapping
    public Result deleteDept(@RequestParam("id")Integer id){
        log.info("删除id：{}的部门",id);
        deptService.deleteDepts(id);
        return Result.success();
    }

    //添加单个部门
    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        log.info("添加部门：{}",dept.getName());
        deptService.addDept(dept);
        return Result.success();
    }

    //更新单个部门
    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        log.info("更新id:{}部门为：{}",dept.getId(),dept.getName());
        deptService.updateDept(dept);
        return Result.success();
    }

    //查询回显
    @GetMapping("/{id}")
    public Result getDept(@PathVariable("id")Integer id){
        log.info("查询id：{}部门",id);
        return Result.success(deptService.getDept(id));
    }
}
