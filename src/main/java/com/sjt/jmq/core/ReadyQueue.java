package com.sjt.jmq.core;

import com.sjt.jmq.util.RedissonUtil;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RBlockingQueue;

/**
 * store jobID which can be consumed by consumer
 * @author sjt
 * 2020-03-30 11:22:50
 */
public class ReadyQueue{

    /**
     * add a jobID to readyQueue
     */
    public static void pushToReadyQueue(long DelayQueueJobId,String topic){
        RBlockingQueue<Long> rBlockingQueue = RedissonUtil.getBlockingQueue(topic);
        rBlockingQueue.offer(DelayQueueJobId);
    }

    /**
     * get and delete jobID from readyQueue
     */
    public static Long pollFromReadyQueue(String topic){
        RBlockingQueue<Long> rBlockingQueue = RedissonUtil.getBlockingQueue(topic);
        return rBlockingQueue.poll();
    }

}