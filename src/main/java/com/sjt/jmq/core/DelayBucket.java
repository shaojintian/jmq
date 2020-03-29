package com.sjt.jmq.core;

import com.sjt.jmq.util.RedissonUtil;
import org.redisson.api.RScoredSortedSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DelayBucket {

    private static final Logger logger = LoggerFactory.getLogger(DelayBucket.class);

    public static void addToBucket(String key ,ScoredSortedItem scoredSortedItem){
        RScoredSortedSet<ScoredSortedItem> scoredSortedSet = RedissonUtil.getScoredSortedSet(key);

        scoredSortedSet.add(scoredSortedItem., );
    }
}
