package com.example.sms.channel.yimei;


import com.example.sms.Channel;
import com.example.sms.channel.AbstractChannelFactory;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class YimeiFactory extends AbstractChannelFactory {

    private static YimeiFactory factory = new YimeiFactory();

    private YimeiFactory(){}

    public static YimeiFactory getFactory(){
        return factory;
    }

    @Override
    protected Channel createChannel(String templetName) {
        return new YimeiChannel();
    }

}
