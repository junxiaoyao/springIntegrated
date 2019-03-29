package com.jxy.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;


/**
 * @Auther: jxy
 * @Date: 2019/3/25 21:01
 * @Description:
 */
@Configuration
public class JmsConfig {
    @Bean
    public ConnectionFactory connectionFactory() {
/*        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://127.0.0.1:61616");*/
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://118.24.188.79:61616");
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate template = new JmsTemplate(connectionFactory);
        template.setDefaultDestinationName("userInfoQueue");
        return template;
    }
//    @Bean
//    public ActiveMQQueue activeMQQueue() {
//        ActiveMQQueue queue = new ActiveMQQueue();
//        queue.setPhysicalName("activeMqQueues");
//        return queue;
//    }
//
//    @Bean
//    public ActiveMQTopic activeMQTopic() {
//        return new ActiveMQTopic();
//    }
}
