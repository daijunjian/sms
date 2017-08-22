package com.example.sms;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public interface Channel {

    /**
     * 通过模板名称获取通道
     *
     * @param  name, String mobiles,String content
     * @return channel
     */
    Channel send(String name, String mobiles, String content);

}
