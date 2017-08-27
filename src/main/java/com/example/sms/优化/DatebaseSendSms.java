package com.example.sms.优化;

/**
 * Created by Dale on 2017/8/27.
 */
public class DatebaseSendSms {

    public static void main(String[] args) {

        /**
         * 思路：先入库，然后写个定时任务，按照优先级从库中每次取出1000条，接着定义线程（5个大小），把这1000条数据推送给通道商，如梦网
         */
    }

}
