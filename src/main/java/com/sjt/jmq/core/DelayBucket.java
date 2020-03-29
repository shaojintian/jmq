package com.sjt.jmq.core;

import com.sjt.jmq.util.RedissonUtil;
import org.redisson.api.RScoredSortedSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DelayBucket {

    private static final Logger logger = LoggerFactory.getLogger(DelayBucket.class);

    public static void addToBucket(String key ,ScoredSortedItem scoredSortedItem){
        RScoredSortedSet<ScoredSortedItem> scoredSortedSet = RedissonUtil.getScoredSortedSet(key);

        scoredSortedSet.add(scoredSortedItem.getDelayTime(), scoredSortedItem);
    }

    /**
     * get min delayTime item
     * @param key
     * @return
     */
    public static ScoredSortedItem getItemFromBucket(String key){
        RScoredSortedSet<ScoredSortedItem> scoredSortedSet = RedissonUtil.getScoredSortedSet(key);

        if(scoredSortedSet.size()<=0){
            return null;
        }

        return scoredSortedSet.first();
    }

    public static void deleteFromBukcet(String key,ScoredSortedItem scoredSortedItem){
        RScoredSortedSet<ScoredSortedItem> scoredSortedSet = RedissonUtil.getScoredSortedSet(key);
        scoredSortedSet.remove(scoredSortedItem);
    }

}
