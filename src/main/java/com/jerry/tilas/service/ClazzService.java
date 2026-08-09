package com.jerry.tilas.service;

import com.jerry.tilas.pojo.Clazz;
import com.jerry.tilas.pojo.ClazzQueryParam;
import com.jerry.tilas.pojo.ClazzResult;

public interface ClazzService {
    void addClazz(Clazz clazz);

    ClazzResult<Clazz> getClazz(ClazzQueryParam param);
}
