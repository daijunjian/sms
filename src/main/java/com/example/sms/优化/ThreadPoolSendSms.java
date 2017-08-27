package com.example.sms.�Ż�;

import redis.clients.jedis.Jedis;

import java.util.concurrent.*;

/**
 * ˼·���ȱ�����redis list�У�Ȼ������һ���ֳ����������ȼ���redis��ÿ��ȡ��5�������Ŷ����̣߳�5����С��������5���������͸�ͨ���̣��������������
 *
 * Created by Dale on 2017/8/26.
 */
public class ThreadPoolSendSms {

    //����һ��3���̵߳��̳߳�
    final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(0));

    public static void main(String[] args) {

    }

    private Jedis jedis;
    String key1;//���ȼ��ߣ�����֤�����
    String key2;//���ȼ���
    String key3;//���ȼ��ͣ�����ն���

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

                //����ֱ���̳߳��е�����ִ���꣬�Ž�����һ��
                while (threadPoolExecutor.getActiveCount() != 0){

                }

            }

        }

        //���Ͷ���
        public void send(String key){
            for (int i = 0; i < 3; i++){
                final String str = jedis.lpop(key);
                if(str != null){
                    threadPoolExecutor.execute(new Runnable() {
                        public void run() {
                            //���Ͷ���
                            String json = str;
                            //Factory.getFactroy().send(json);
                        }
                    });
                }
            }
        }

    }

}




