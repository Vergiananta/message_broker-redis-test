package com.message.message_broker.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisMessageConfig implements MessageListener {

    public static List<String> messageList = new ArrayList<>();

    @Override
    public void onMessage(Message message, byte[] bytes) {
        messageList.add(message.toString());
        System.out.print("Message received: "+message.toString());
    }
}
