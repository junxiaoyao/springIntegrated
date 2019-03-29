package com.jxy.jmsService;

import com.jxy.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * @Auther: jxy
 * @Date: 2019/3/29 9:17
 * @Description:
 */
@Service
public class FirstJmsServiceImpl implements FirstJmsService {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(UserInfo userInfo) {
        jmsTemplate.convertAndSend(userInfo);
     /*   jmsTemplate.send("userInfoQueue", new MessageCreator() {
                    public Message createMessage(Session session)
                            throws JMSException {
                        return session.createObjectMessage(userInfo);
                    }
                }
        );*/
    }

    @Override
    public UserInfo getMessage() {
        try {
//            ObjectMessage message = (ObjectMessage) jmsTemplate.receive("userInfoQueue");
//            return (UserInfo) message.getObject();
            ObjectMessage message = (ObjectMessage) jmsTemplate.receive();
            return (UserInfo) message.getObject();
        } catch (JMSException e) {
            //e.printStackTrace();
            throw JmsUtils.convertJmsAccessException(e);
        }
    }
}
