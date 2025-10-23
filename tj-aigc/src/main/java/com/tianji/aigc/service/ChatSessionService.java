package com.tianji.aigc.service;

import com.tianji.aigc.vo.SessionVO;

public interface ChatSessionService {

    /**
     * 创建会话session
     *
     * @param num 热门问题的数量
     * @return 会话信息
     */
    SessionVO createSession(Integer num);

}
