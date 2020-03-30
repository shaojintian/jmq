package com.sjt.jmq.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayBucketHandler implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(DelayBucketHandler.class);

    private String delayBucketKey;

    public DelayBucketHandler(String delayBucketKey){this.delayBucketKey = delayBucketKey;}

    public String getDelayBucketKey(){return delayBucketKey};

    public void setDelayBucketKey(String delayBucketKey) {
        this.delayBucketKey = delayBucketKey;
    }

    @Override
    public void run(){

        while (true){

            try{
                ScoredSortedItem item = DelayBucket.getItemFromBucket(delayBucketKey);
                //no job
                if(item == null){
                    sleep();
                    continue;
                }
                //not reach delay time
                if(item.getDelayTime()>System.currentTimeMillis()){
                    sleep();
                    continue;
                }
                DelayQueueJob
                if()
            }catch (Exception e){
                logger.error("扫描Bucket error：",e);
            }
        }


    }

    private void sleep(){

        try {
            TimeUnit.SECONDS.sleep(1L);
        }catch (Exception e){
            logger.error("",e);
        }
    }


}
