package com.mxp.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {
    @JmsListener(destination = "test.topic" )
    public void readMsg(String text) {

        System.out.println("接收到消息：" + text);


    }

    @JmsListener(destination = "my_map")
    public void readMap(Map map) {
        System.out.println(map);
    }
}