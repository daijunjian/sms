package com.example.sms.优化;

import redis.clients.jedis.Jedis;

import java.util.concurrent.*;

/**
 * 思路：先保存在redis list中，然后启动一个现场，按照优先级从redis中每次取出5条，接着定义线程（5个大小），把这5条数据推送给通道商，如梦网并且入库
 *
 * Created by Dale on 2017/8/26.
 */
public class ThreadPoolSendSms {

    //定义一个3个线程的线程池
    final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(0));

    public static void main(String[] args) {

    }

    private Jedis jedis;
    String key1;//优先级高，如验证码短信
    String key2;//优先级中
    String key3;//优先级低，如催收短信

    class myThread implements  Runnable{

        public void run() {

            while (true){

                long len1 = jedis.llen(key1);
                long len2 = jedis.llen(key2);
                long len3 = jedis.llen(key3);

                if(len1 > 0){
                    send(key1);
                }
                else if(len2 > 0){
                    send(key2);
                }else{
                    send(key3);
                }

                //阻塞直到线程池中的任务都执行完，才进行下一轮
                while (threadPoolExecutor.getActiveCount() != 0){

                }

            }

        }

        //发送短信
        public void send(String key){
            for (int i = 0; i < 3; i++){
                final String str = jedis.lpop(key);
                if(str != null){
                    threadPoolExecutor.execute(new Runnable() {
                        public void run() {
                            //发送短信
                            String json = str;
                            //Factory.getFactroy().send(json);
                        }
                    });
                }
            }
        }

    }

}




