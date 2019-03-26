package com.jxy.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.hibernate.engine.spi.ActionQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;
import javax.jms.IllegalStateException;

/**
 * @Auther: jxy
 * @Date: 2019/3/25 21:01
 * @Description:
 */
@Configuration
public class JmsConfig {
    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://127.0.0.1:61616");
        return connectionFactory;
    }

    @Bean
    public ActiveMQQueue activeMQQueue() {
        ActiveMQQueue queue = new ActiveMQQueue();
        queue.setPhysicalName("activeMqQueues");
        return queue;
    }

    @Bean
    public ActiveMQTopic activeMQTopic() {
        return new ActiveMQTopic();
    }
}
