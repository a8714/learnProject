package com.atguigu.vod.service.service;

import java.io.InputStream;

/**
 * @author roo
 * @date 2023/3/16
 */
public interface VodService {
    //上传视频
    String uploadVideo(InputStream inputStream, String originalFilename);
    //删除视频
    void removeVideo(String videoSourceId);
}
