package com.atguigu.ggkt.wechat.service;

import java.util.Map;

/**
 * @author roo
 * @date 2023/3/17
 */
public interface MessageService {
    //接收消息
    String receiveMessage(Map<String, String> param);

    void pushPayMessage(long l);
}
