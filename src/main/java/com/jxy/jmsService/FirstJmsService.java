package com.jxy.jmsService;

import com.jxy.entity.UserInfo;

public interface FirstJmsService {
    void sendMessage(UserInfo userInfo);
    UserInfo getMessage();
}
