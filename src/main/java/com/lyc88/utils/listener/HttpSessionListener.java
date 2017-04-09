package com.lyc88.utils.listener;

import javax.servlet.http.HttpSessionEvent;

/**
 * Created by Administrator on 2017/2/24.
 */
public class HttpSessionListener implements javax.servlet.http.HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println(httpSessionEvent.getSession().getId()+httpSessionEvent.getSession().isNew());
        System.out.println("session 创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session 销毁");

    }
}
