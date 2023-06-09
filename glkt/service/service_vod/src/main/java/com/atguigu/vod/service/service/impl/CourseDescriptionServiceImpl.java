package com.atguigu.vod.service.service.impl;

import com.atguigu.ggkt.model.vod.CourseDescription;
import com.atguigu.vod.service.mapper.CourseDescriptionMapper;
import com.atguigu.vod.service.service.CourseDescriptionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author roo
 * @since 2023-03-15
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService {

    @Override
    public CourseDescription getBycourseId(Long id) {
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",id);
        CourseDescription courseDescription = baseMapper.selectOne(wrapper);
        return courseDescription;
    }
}
