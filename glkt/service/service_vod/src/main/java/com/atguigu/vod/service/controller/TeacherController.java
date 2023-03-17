package com.atguigu.vod.service.controller;


import com.atguigu.exception.GgktException;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.result.Result;
import com.atguigu.vod.service.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@RequestMapping(value = "/admin/vod/teacher")
//@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("查询所有讲师")
    @GetMapping("/findAll")
    public Result findAll() {
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询数据成功");
    }

    @ApiOperation("根据id删除讲师")
    @DeleteMapping("{id}")
    public Result removeById(@PathVariable("id") Long id) {
//        try {
//            int a = 10 / 0;
//
//        } catch (Exception e) {
//            throw new GgktException(20001, "出现自定义异常");
//        }

        boolean isSuccess = teacherService.removeById(id);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "获取分页列表")
    @PostMapping("{page}/{limit}")
    public Result index(@PathVariable Long page, @PathVariable Long limit, @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        Page<Teacher> pageParam = new Page<>(page, limit);
        if (teacherQueryVo == null) {
            Page<Teacher> page1 = teacherService.page(pageParam);
            return Result.ok(page1);
        } else {
            QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
            String name = teacherQueryVo.getName();//讲师名称
            Integer level = teacherQueryVo.getLevel();//讲师级别
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();//开始时间
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();//结束时间
            if (!StringUtils.isEmpty(name)) {
                wrapper.like("name", name);
            }
            if (!StringUtils.isEmpty(level)) {
                wrapper.eq("level", level);
            }
            if (!StringUtils.isEmpty(joinDateBegin)) {
                wrapper.ge("join_date", joinDateBegin);
            }
            if (!StringUtils.isEmpty(joinDateEnd)) {
                wrapper.le("join_date", joinDateEnd);
            }

            IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
            return Result.ok(pageModel);
        }

    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.save(teacher);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result edit(@PathVariable Long id) {
        Teacher byId = teacherService.getById(id);
        return Result.ok(byId);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    @CrossOrigin
    public Result updateById(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.updateById(teacher);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<String> ids) {
        boolean isSuccess = teacherService.removeByIds(ids);
        if (isSuccess) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }

    }
}

