package com.tianji.aigc.service;

import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

public interface AudioService {

    /**
     * 文字转语音（TTS）
     * @param text 待合成的文本内容
     * @return 异步响应输出
     */
    ResponseBodyEmitter ttsStream(String text);

}
