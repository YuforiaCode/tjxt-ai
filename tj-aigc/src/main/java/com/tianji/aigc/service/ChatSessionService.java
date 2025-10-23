package com.tianji.aigc.service;

import com.tianji.aigc.vo.MessageVO;
import com.tianji.aigc.vo.SessionVO;

import java.util.List;

public interface ChatSessionService {

    /**
     * 创建会话session
     *
     * @param num 热门问题的数量
     * @return 会话信息
     */
    SessionVO createSession(Integer num);

    /**
     * 获取热门问题
     * @return 热门问题列表
     */
    List<SessionVO.Example> hotExamples(Integer num);

    /**
     * 根据会话id查询消息列表
     * @param sessionId 会话id
     * @return 消息列表
     */
    List<MessageVO> queryBySessionId(String sessionId);
}
