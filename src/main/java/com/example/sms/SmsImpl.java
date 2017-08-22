package com.example.sms;

import com.example.sms.channel.chuanglan.ChunglanFactory;
import com.example.sms.channel.mengwang.MengwangFactory;
import com.example.sms.channel.yimei.YimeiFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SmsImpl{

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void send(String name, String mobiles,String content) {

        //模板是否存在

        //模板是否可用

        //手机号每天发送次数（注册、找回密码类的短信需要验证次数）

        String channelName = "mengwang";

        //工厂创建通道
        ChannelFactory factory = null;
        if(StringUtils.equals(channelName, "mengwang")){
            factory = MengwangFactory.getFactory();
        }else if(StringUtils.equals(channelName,"mengwang")){
            factory = YimeiFactory.getFactory();
        }else if(StringUtils.equals(channelName,"mengwang")){
            factory = ChunglanFactory.getFactory();
        }
        Channel channel = factory.getChannel(channelName);

        //发送短信
        channel.send(name,mobiles,content);
        this.logger.info("发送短信成功");
        //记录发送次数
    }


    public static void main(String[] args) {
        new SmsImpl().send("aaaa","123456789","mengwang");
    }


}
