package com.jerry.tilas.controller;


import com.jerry.tilas.pojo.Result;
import com.jerry.tilas.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        return Result.success(reportService.getEmpJobData());
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        return Result.success(reportService.getEmpGenderData());
    }



}
