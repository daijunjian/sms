package com.example.sms.channel;


import com.example.sms.Channel;
import com.example.sms.ChannelFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public abstract class AbstractChannelFactory implements ChannelFactory {

    private final ConcurrentHashMap<String,Channel> channels = new ConcurrentHashMap<String,Channel>();

    @Override
    public Channel getChannel(String templetName) {

        Channel channel = channels.get(templetName);
        if(channel == null){
            channels.put(templetName,createChannel(templetName));
        }
        return channel;
    }

    protected abstract Channel createChannel(String templetName);


}
