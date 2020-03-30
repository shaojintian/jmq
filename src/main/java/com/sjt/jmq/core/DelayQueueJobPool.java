package com.sjt.jmq.core;

import com.sjt.jmq.util.RedissonUtil;
import org.redisson.api.RMap;

public class DelayQueueJobPool{

    private static final String DELAY_QUEUE_JOB_POOL = "delayQueueJobPool";

    /**
     * CRUD delayQueueJob
     */
    public static DelayQueueJob getDelayQueueJob(long delayQueueJobId){

        RMap<Long,DelayQueueJob> rmap = RedissonUtil.getMap(DELAY_QUEUE_JOB_POOL);

        return rmap.get(delayQueueJobId);

    }

    public static void addDelayQueueJob(DelayQueueJob delayQueueJob){

        RMap<Long,DelayQueueJob> rmap = RedissonUtil.getMap(DELAY_QUEUE_JOB_POOL);
        rmap.put(delayQueueJob.getId(), delayQueueJob);
    }

    public static void deleteDelayQueueJob(long delayQueueJobId){
        RMap<Long,DelayQueueJob> rMap = RedissonUtil.getMap(DELAY_QUEUE_JOB_POOL);
        rMap.remove(delayQueueJobId);
    }


}