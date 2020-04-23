package com.sjt.jmq.core;

import com.sun.org.apache.xpath.internal.functions.FuncSubstring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author sjt
 * @date 2020-03-30 11:43:20
 */
public class DelayQueue{

    private static final Logger logger = LoggerFactory.getLogger(DelayQueue.class);
    public static final String DELAY_BUCKET_KEY_PREFIX ="delayBucket";
    public static final long DELAY_BUCKET_NUM =10L;

    /**
     * 获取delayBucketKey
     */
    private static String getDelayBucketKey(long delayQueueJobId){
        return DELAY_BUCKET_KEY_PREFIX + Math.floorMod(delayQueueJobId, DELAY_BUCKET_NUM);
    }

    public static void pushToDelayQueue(DelayQueueJob delayQueueJob){
        DelayQueueJobPool.addDelayQueueJob(delayQueueJob);
        ScoredSortedItem item = new ScoredSortedItem(delayQueueJob.getId(), delayQueueJob.getDelayTime());
        DelayBucket.addToBucket(getDelayBucketKey(delayQueueJob.getId()), item);
    }

    /**
     * 获取准备好的delayJob from  准备队列
     * 例如用户锁定的订单准备延时
     * @param topic
     */
    public static DelayQueueJob getJobFromReadyQueue(String topic){
        Long delayQueueJobId = ReadyQueue.pollFromReadyQueue(topic);
        if(delayQueueJobId==null){
            return null;
        }
        DelayQueueJob delayQueueJob = DelayQueueJobPool.getDelayQueueJob(delayQueueJobId);
        if(delayQueueJob==null){return null;}

        long delayTime = delayQueueJob.getDelayTime();
        //refersh delayTime
        long reDelayTime = System.currentTimeMillis()+delayQueueJob.getTtrTime()+1000L;
        delayQueueJob.setDelayTime(reDelayTime);
        //rein bucket
        ScoredSortedItem scoredSortedItem = new ScoredSortedItem(delayQueueJobId, reDelayTime);
        DelayBucket.addToBucket(getDelayBucketKey(delayQueueJobId),scoredSortedItem);
        //?????
        delayQueueJob.setDelayTime(delayTime);
        return delayQueueJob;

    }

    /**
     *
     * @param delayQueueJobId
     */
    public static void delate(long delayQueueJobId){DelayQueueJobPool.deleteDelayQueueJob(delayQueueJobId);}

    public static void finish(long delayQueueJobId){
        DelayQueueJob delayQueueJob = DelayQueueJobPool.getDelayQueueJob(delayQueueJobId);
        if (delayQueueJob==null){
            return;
        }
        DelayQueueJobPool.deleteDelayQueueJob(delayQueueJobId);
        ScoredSortedItem item = new ScoredSortedItem(delayQueueJobId, delayQueueJob.getDelayTime());
        DelayBucket.deleteFromBukcet(getDelayBucketKey(delayQueueJobId), item);
    }

    /**
     *
     * @param delayQueueJobId
     * @return
     */
    public static DelayQueueJob get(long delayQueueJobId){
        return DelayQueueJobPool.getDelayQueueJob(delayQueueJobId);


    }



}
