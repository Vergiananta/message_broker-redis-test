package com.message.message_broker.controller;

import com.message.message_broker.config.RedisMessageConfig;
import com.message.message_broker.config.RedisMessagePublisher;
import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class RedisController {
    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisMessagePublisher messagePublisher;


    @PostMapping("/publish")
    public void publish(@RequestBody Message message) {
        logger.info(">> publishing : {}", message);
        messagePublisher.publish(message.toString());
    }

    @GetMapping("/subscribe")
    public List<String> getMessages(){
        return RedisMessageConfig.messageList;
    }

}
