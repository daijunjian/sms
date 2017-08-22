package com.example.sms;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public interface ChannelFactory {

    /**
     * 通过模板名称获取通道
     *
     * @param templetName
     * @return channel
     */
    Channel getChannel(String templetName);

}
