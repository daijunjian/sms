package com.example.sms.channel.mengwang;

import com.daijunjian.SmsDemo.Channel;
import com.daijunjian.SmsDemo.channel.AbstractChannelFactory;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class MengwangFactory extends AbstractChannelFactory{

    private static MengwangFactory factory = new MengwangFactory();

    private MengwangFactory(){}

    public static MengwangFactory getFactory(){
        return factory;
    }

    @Override
    public Channel createChannel(String templetName) {
        return new MengwangChannel();
    }

}
