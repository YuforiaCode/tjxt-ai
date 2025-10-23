package com.tianji.aigc.service;

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
     *
     * @return 热门问题列表
     */
    List<SessionVO.Example> hotExamples(Integer num);
}
