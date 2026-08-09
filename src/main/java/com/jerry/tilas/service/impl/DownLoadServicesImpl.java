package com.jerry.tilas.service.impl;

import com.jerry.tilas.service.DownLoadService;
import com.jerry.tilas.util.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DownLoadServicesImpl implements DownLoadService {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @Override
    public String upload(MultipartFile file) throws Exception {
        return aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
    }
}
