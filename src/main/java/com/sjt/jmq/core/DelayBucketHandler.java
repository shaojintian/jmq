package com.sjt.jmq.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayBucketHandler implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(DelayBucketHandler.class);

    private String delayBucketKey;

    public DelayBucketHandler(String delayBucketKey){this.delayBucketKey = delayBucketKey;}

    public String getDelayBucketKey(){return delayBucketKey;}

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
                //maybe reach delay time
                //get job
                DelayQueueJob delayQueueJob = DelayQueueJobPool.getDelayQueueJob(item.getDelayQueueJobId());
                //check whether valid job
                if(delayQueueJob ==null){
                    DelayBucket.deleteFromBukcet(this.delayBucketKey,item);
                    continue;
                }
                //double check reach delayTime
                if(delayQueueJob.getDelayTime() > System.currentTimeMillis()){
                    //not reach delay time
                    //delete old job
                    DelayBucket.deleteFromBukcet(this.delayBucketKey, item);
                    //refresh delayTime
                    DelayBucket.addToBucket(this.delayBucketKey,
                            new ScoredSortedItem(delayQueueJob.getId(),delayQueueJob.getDelayTime()));
                    continue;
                }
                //reach delay time
                ReadyQueue.pushToReadyQueue(delayQueueJob.getId(), delayQueueJob.getTopic());
                DelayBucket.deleteFromBukcet(this.delayBucketKey, item);
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
