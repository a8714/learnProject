package com.atguigu.vod.service.controller;


import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.result.Result;
import com.atguigu.vod.service.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author roo
 * @since 2023-03-15
 */
@Api(tags = "课程分类管理")
@RestController
@RequestMapping("/service/subject")
@CrossOrigin
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    //查询下一层课程分类
    //根据parent_id
    @ApiOperation("查询下一层的课程分类")
    @GetMapping("getChildSubject/{id}")
    @CrossOrigin
    public Result getChildSubject(@PathVariable Long id) {
        List<Subject> list = subjectService.selectList(id);
        return Result.ok(list);
    }
}

