package com.example.sms.channel.yimei;


import com.example.sms.Channel;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class YimeiChannel implements Channel {

    @Override
    public Channel send(String name, String mobiles, String content) {
        System.out.print("YimeiChannel发送成功");
        return null;
    }

}
