package com.jerry.tilas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface DownLoadService {
    //文件上传（返回String地址URL）
    String upload(MultipartFile file) throws Exception;
}
