package com.jxy.entity;

import java.io.Serializable;

/**
 * @Auther: jxy
 * @Date: 2019/3/25 14:59
 * @Description:
 */
public class UserInfo implements Serializable{
    private String userName;
    private String msg;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
