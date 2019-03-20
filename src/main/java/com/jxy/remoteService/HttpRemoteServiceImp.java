package com.jxy.remoteService;

import org.springframework.stereotype.Service;

/**
 * @Auther: jxy
 * @Date: 2019/3/20 16:46
 * @Description:
 */
@Service
public class HttpRemoteServiceImp implements HttpRemoteService {
    @Override
    public String say() {
        return "i am  a remote service by http";
    }
}
