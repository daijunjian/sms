package com.example.sms.channel.mengwang;

import com.daijunjian.SmsDemo.Channel;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class MengwangChannel implements Channel {

    @Override
    public Channel send(String name, String mobiles, String content) {
        System.out.print("ChuanglanChannel发送成功");
        return null;
    }
}
