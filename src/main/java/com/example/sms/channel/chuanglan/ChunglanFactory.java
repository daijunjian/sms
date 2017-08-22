package com.example.sms.channel.chuanglan;

import com.daijunjian.SmsDemo.Channel;
import com.daijunjian.SmsDemo.channel.AbstractChannelFactory;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class ChunglanFactory extends AbstractChannelFactory{

    private static ChunglanFactory factory = new ChunglanFactory();

    private ChunglanFactory(){}

    public static ChunglanFactory getFactory(){
        return factory;
    }

    @Override
    protected Channel createChannel(String templetName) {
        return new ChuanglanChannel();
    }

}
