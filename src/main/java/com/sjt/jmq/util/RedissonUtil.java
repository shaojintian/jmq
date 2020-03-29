package com.sjt.jmq.util;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;



public class RedissonUtil {

    private static final Logger logger = LoggerFactory.getLogger(RedissonUtil.class);

    private static RedissonClient redissonClient;

    private RedissonUtil(){}

    static {

        try {
            Config config = Config.fromYAML(RedissonUtil.class.getClassLoader().getResource("redis.yaml"));
            long startTime = System.currentTimeMillis();
            redissonClient = Redisson.create(config);
            long endtime = System.currentTimeMillis();
            logger.info("initialize RedissonClient use {} ms",endtime-startTime);
            logger.info("redis config:{}",config.toYAML());

        }catch (Exception e){
            logger.error("initialize Redisson Client failed:",e);
        }


    }

    /**
     * require client
     *
     */
    public static RedissonClient getRedissonClient(){return redissonClient;}

    public static void close(){redissonClient.shutdown();}

    public static <V>RBucket<V> getRBucket(String objectName){return redissonClient.getBucket(objectName);}

    public static <K,V>RMap<K,V> getMap(String objectName){
        return redissonClient.getMap(objectName);
    }

    /**
     * 获取支持单个元素过期的map对象
     *
     * @param <K>        the type parameter
     * @param <V>        the type parameter
     * @param objectName the object name
     * @return the r map cache
     */
    public static <K,V> RMapCache<K,V> getMapCache(String objectName){
        return redissonClient.getMapCache(objectName);
    }

    /**
     * 获取set对象
     *
     * @param <V>        the type parameter
     * @param objectName the object name
     * @return the r set
     */
    public static <V> RSet<V> getSet(String objectName){
        return redissonClient.getSet(objectName);
    }

    /**
     * 获取SortedSet对象
     *
     * @param <V>        the type parameter
     * @param objectName the object name
     * @return the r sorted set
     */
    public static <V> RSortedSet<V> getSortedSet(String objectName){
        return redissonClient.getSortedSet(objectName);
    }

    /**
     * 获取ScoredSortedSett对象
     * @param objectName
     * @param <V>
     * @return
     */
    public static <V> RScoredSortedSet<V> getScoredSortedSet(String objectName) {
        return redissonClient.getScoredSortedSet(objectName);
    }

    /**
     * 获取list对象
     *
     * @param <V>        the type parameter
     * @param objectName the object name
     * @return the r list
     */
    public static <V> RList<V> getList(String objectName){
        return redissonClient.getList(objectName);
    }

    /**
     * 获取queue对象
     *
     * @param <V>        the type parameter
     * @param objectName the object name
     * @return the r queue
     */
    public static <V> RQueue<V> getQueue(String objectName){
        return redissonClient.getQueue(objectName);
    }


    /**
     * Get blocking queue r blocking queue.
     *
     * @param <V>        the type parameter
     * @param objectName the object name
     * @return the r blocking queue
     */
    public static <V> RBlockingQueue<V> getBlockingQueue(String objectName){
        return redissonClient.getBlockingQueue(objectName);
    }

    /**
     * Get atomic long r atomic long.
     *
     * @param objectName the object name
     * @return the r atomic long
     */
    public static RAtomicLong getAtomicLong(String objectName){
        return redissonClient.getAtomicLong(objectName);
    }

    /**
     * Get lock r lock.
     * @param objectName the object name
     * @return the r lock
     */
    public static RLock getLock(String objectName){
        return redissonClient.getLock(objectName);
    }

}
