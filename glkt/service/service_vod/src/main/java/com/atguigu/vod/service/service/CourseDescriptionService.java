package com.atguigu.vod.service.service;

import com.atguigu.ggkt.model.vod.CourseDescription;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程简介 服务类
 * </p>
 *
 * @author roo
 * @since 2023-03-15
 */
public interface CourseDescriptionService extends IService<CourseDescription> {

    CourseDescription getBycourseId(Long id);
}
