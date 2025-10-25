package com.tianji.aigc.config;

import com.tianji.aigc.advisor.RecordOptimizationAdvisor;
import com.tianji.aigc.memory.RedisChatMemory;
import com.tianji.aigc.tools.CourseTools;
import com.tianji.aigc.tools.OrderTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAIConfig {

    /**
     * 配置 ChatClient
     */
    @Bean
    public ChatClient dashScopeChatClient(ChatClient.Builder dashScopeChatClientBuilder,
                                 Advisor loggerAdvisor,
                                 Advisor messageChatMemoryAdvisor,
                                 Advisor recordOptimizationAdvisor, // 记录优化
                                 CourseTools courseTools, // 课程工具
                                 OrderTools orderTools // 预下单工具
    ) {  // 日志记录器
        return dashScopeChatClientBuilder
                .defaultAdvisors(loggerAdvisor, messageChatMemoryAdvisor, recordOptimizationAdvisor) //添加 Advisor 功能增强
                //.defaultTools(courseTools, orderTools) //添加默认工具
                .build();
    }

    @Bean
    public ChatClient openAiChatClient(ChatClient.Builder openAiChatClientBuilder,
                                       Advisor loggerAdvisor  // 日志记录器
    ) {
        return openAiChatClientBuilder
                .defaultAdvisors(loggerAdvisor)
                .build();
    }

    /**
     * 日志记录器
     */
    @Bean
    public Advisor loggerAdvisor() {
        return new SimpleLoggerAdvisor();
    }

    @Bean
    public ChatMemory chatMemory() {
        return new RedisChatMemory();
    }

    /**
     * 基于Redis的会话记忆，聊天记忆整合到system message中实现多轮对话
     */
    @Bean
    public Advisor messageChatMemoryAdvisor(ChatMemory chatMemory) {
        return new MessageChatMemoryAdvisor(chatMemory);
    }

    /**
     * 优化对话历史记录
     */
    @Bean
    public Advisor recordOptimizationAdvisor(RedisChatMemory redisChatMemory) {
        return new RecordOptimizationAdvisor(redisChatMemory);
    }
}
