package com.jerry.tilas.controller;

import com.jerry.tilas.pojo.Emp;
import com.jerry.tilas.pojo.EmpQuaryParam;
import com.jerry.tilas.pojo.EmpResult;
import com.jerry.tilas.pojo.Result;
import com.jerry.tilas.service.DeptService;
import com.jerry.tilas.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/emps")
@RestController
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result getEmps(EmpQuaryParam empQuaryParam){
//        EmpResult<Emp> empResult = new EmpResult<>();
//        empResult.setTotal(empService.getTotal());
//        empResult.setRows(empService.getRows(page-1,pagesize));
        return Result.success(empService.getempResult(empQuaryParam));
    }


    //保存员工基本信息
    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        empService.addEmp(emp);
        return Result.success();
    }

    //根据id查询员工信息
    @GetMapping({"/{id}"})
    public Result getEmp(@PathVariable("id")Integer id){
        return Result.success(empService.getEmp(id));
    }

    //删除员工信息
    @DeleteMapping
    public Result deleteEmp(@RequestParam("ids") List<Integer> ids){
        empService.deleteEmp(ids);
        return Result.success();
    }

    //更新员工信息
    @PutMapping
    public Result updateEmp(@RequestBody Emp emp){
        empService.updateEmp(emp);
        return Result.success();
    }


}
