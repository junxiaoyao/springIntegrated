package com.jxy.remoteService;

import org.springframework.stereotype.Service;

/**
 * @Auther: jxy
 * @Date: 2019/3/20 11:12
 * @Description:
 */
@Service
public class HessionRemoteServiceImp implements HessionRemoteService {
    @Override
    public void say() {
        System.out.println("i am a rpc service by hession!");
    }
}
