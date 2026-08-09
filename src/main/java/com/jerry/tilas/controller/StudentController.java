package com.jerry.tilas.controller;

import com.jerry.tilas.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;




}
