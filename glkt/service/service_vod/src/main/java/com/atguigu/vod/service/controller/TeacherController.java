package com.atguigu.vod.service.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.vod.service.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author roo
 * @since 2023-03-12
 */
@RestController
@RequestMapping(value="/admin/vod/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/findAll")
    public List<Teacher> findAll(){
        return teacherService.list();
    }

}

