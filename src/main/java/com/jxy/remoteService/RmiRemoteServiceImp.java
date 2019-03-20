package com.jxy.remoteService;

import org.springframework.stereotype.Service;

/**
 * @Auther: jxy
 * @Date: 2019/3/15 16:19
 * @Description:
 */
@Service
public class RmiRemoteServiceImp implements RmiRemoteService {
    @Override
    public String say() {
        return "i say i am a rpc service by rmi";
    }
}
