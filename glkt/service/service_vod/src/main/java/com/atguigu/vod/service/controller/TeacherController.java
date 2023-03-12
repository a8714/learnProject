package com.atguigu.vod.service.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.vod.service.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author roo
 * @since 2023-03-12
 */
@Api(tags = "讲师操作controller")
@RestController
@RequestMapping(value="/admin/vod/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("查询所有讲师")
    @GetMapping("/findAll")
    public List<Teacher> findAll(){
        return teacherService.list();
    }
    @ApiOperation("根据id删除讲师")
    @DeleteMapping("{id}")
    public boolean removeById(  @PathVariable("id") Long id){
        return teacherService.removeById(id);
    }

}

