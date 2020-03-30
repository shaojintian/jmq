package com.sjt.jmq.listener;

import com.sjt.jmq.core.DelayBucketHandler;
import com.sjt.jmq.core.DelayQueue;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.concurrent.*;

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        ExecutorService excutorService = Executors.newFixedThreadPool((int)DelayQueue.DELAY_BUCKET_NUM);
        for(int i=0;i<DelayQueue.DELAY_BUCKET_NUM;i++){
            excutorService.execute(new DelayBucketHandler(DelayQueue.DELAY_BUCKET_KEY_PREFIX+i));
        }
    }
}


