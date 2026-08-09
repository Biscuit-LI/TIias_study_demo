package com.jerry.tilas.controller;


import com.jerry.tilas.pojo.Result;
import com.jerry.tilas.service.DownLoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class DownLoadController {
    @Autowired
    private DownLoadService downLoadService;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        return Result.success(downLoadService.upload(file));
    }



}
