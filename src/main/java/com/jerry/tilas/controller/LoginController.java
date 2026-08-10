package com.jerry.tilas.controller;

import com.jerry.tilas.pojo.ClazzQueryParam;
import com.jerry.tilas.pojo.Emp;
import com.jerry.tilas.pojo.LoginInfo;
import com.jerry.tilas.pojo.Result;
import com.jerry.tilas.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;


    @PostMapping
    public Result empLogin(@RequestBody Emp emp){
        log.info("用户尝试登录{}",emp.toString());
        LoginInfo loginInfo =empService.empLogin(emp);

        if(loginInfo!=null){
            log.info("{}登录成功",emp.getUsername());
            return Result.success(loginInfo);
        }
        log.info("登陆失败");
        return Result.error("登录失败，用户名或密码错误");
    }





}
