package com.atguigu.vod.service.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author roo
 * @date 2023/3/15
 */
public interface FileService {
    //文件上传
    String upload(MultipartFile file);
}
