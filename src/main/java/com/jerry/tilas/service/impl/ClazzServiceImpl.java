package com.jerry.tilas.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jerry.tilas.mapper.ClazzMapper;
import com.jerry.tilas.pojo.Clazz;
import com.jerry.tilas.pojo.ClazzQueryParam;
import com.jerry.tilas.pojo.ClazzResult;
import com.jerry.tilas.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public void addClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazz.setCreateTime(LocalDateTime.now());
        clazzMapper.addClazz(clazz);
    }

    @Override
    public ClazzResult<Clazz> getClazz(ClazzQueryParam param) {
        PageHelper.startPage(param.getPage(),param.getPageSize());
        List<Clazz> list=clazzMapper.getClazz(param);
        Page<Clazz> page=(Page<Clazz>)list;
        return new ClazzResult<>(page.getTotal(),page.getResult());
    }
}
