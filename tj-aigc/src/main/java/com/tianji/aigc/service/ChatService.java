package com.tianji.aigc.service;

import com.tianji.aigc.vo.ChatEventVO;
import reactor.core.publisher.Flux;

public interface ChatService {

    /**
     * 聊天
     * @param question 用户的问题
     * @param sessionId 会话id
     * @return 回答内容(文本内容和事件类型)
     * 流式结构说明：每行数据，都是一个json数据
     * 流式对话 -> 应用system提示词
     */
    Flux<ChatEventVO> chat(String question, String sessionId);

    /**
     * 停止生成
     * @param sessionId 会话id
     */
    void stop(String sessionId);
}
