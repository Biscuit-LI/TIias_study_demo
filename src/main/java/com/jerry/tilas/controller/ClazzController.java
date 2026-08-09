package com.jerry.tilas.controller;

import com.jerry.tilas.pojo.Clazz;
import com.jerry.tilas.pojo.ClazzQueryParam;
import com.jerry.tilas.pojo.Result;
import com.jerry.tilas.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    //添加班级
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz){
        clazzService.addClazz(clazz);
        return Result.success();
    }

    //列表查询
    @GetMapping
    public Result getClazz(ClazzQueryParam param){
        return Result.success(clazzService.getClazz(param));
    }


}
