package com.tianji.aigc.service;

import com.tianji.aigc.vo.ChatEventVO;
import com.tianji.common.utils.UserContext;
import reactor.core.publisher.Flux;

public interface ChatService {

    /**
     * 聊天
     * @param question 用户的问题
     * @param sessionId 会话id
     * @return 回答内容(文本内容和事件类型)
     * 流式结构说明：每行数据，都是一个json数据
     * 流式对话 -> 应用system提示词 -> 会话记忆 -> 保存停止输出的记录 -> 查询课程 -> 展示课程卡片 -> 预下单 ->
     * 保存课程查询和预下单提供给前端的额外数据
     */
    Flux<ChatEventVO> chat(String question, String sessionId);

    /**
     * 停止生成
     * @param sessionId 会话id
     */
    void stop(String sessionId);

    /**
     * 获取对话id，规则：用户id_会话id
     * @param sessionId 会话id
     * @return 对话id
     */
    static String getConversationId(String sessionId) {
        return UserContext.getUser() + "_" + sessionId;
    }
}
