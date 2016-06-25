package com.redis.service.impl;

import com.redis.domain.MessageList;
import com.redis.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;


public class SubServiceImpl implements SubService {
    @Autowired
    private ChannelTopic channelTopic;

    private MessageList messageList = new MessageList();

    public void onMessage(Message message, byte[] pattern) {
        System.out.println(message.toString() + "  " + channelTopic.getTopic());
        messageList.add(message.toString());
    }

    public MessageList getMessageList() {
        return messageList;
    }
}
