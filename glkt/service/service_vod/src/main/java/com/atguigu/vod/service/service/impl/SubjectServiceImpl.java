package com.atguigu.vod.service.service.impl;

import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.vod.service.mapper.SubjectMapper;
import com.atguigu.vod.service.service.SubjectService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author roo
 * @since 2023-03-15
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public List<Subject> selectList(Long id) {
        //配置条件查询
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);

        List<Subject> subjects = baseMapper.selectList(wrapper);
        for (Subject subject:subjects) {
            Long subjectId = subject.getId();
            boolean isChild = this.isChildren(subjectId);
            subject.setHasChildren(isChild);
        }
        return subjects;
    }

    private boolean isChildren(Long id) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        Integer count = baseMapper.selectCount(wrapper);
        return count>0;
    }
}
