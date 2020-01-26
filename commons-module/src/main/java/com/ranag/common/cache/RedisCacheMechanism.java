package com.ranag.common.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
//import redis.clients.jedis.Tuple;

import java.time.Duration;

public class RedisCacheMechanism {
    private static final Logger log = LogManager.getLogger(RedisCacheMechanism.class);
    private final static String CACHE_HOST = System.getProperty("CACHE_HOST","127.0.0.1");
    private final static String USER_KEY="USER_KEY_";
    private final static String POST="_POST_";
    private final static String ARTICLE="_ARTICLE_";

    private static JedisPool readJedisPool = null;
    private static JedisPool writeJedisPool = null;

    static {
        final JedisPoolConfig poolConfig = buildPoolConfig();
        System.out.println("CACHE_HOST:"+CACHE_HOST);
        readJedisPool = new JedisPool(CACHE_HOST,6379);
        writeJedisPool = new JedisPool(CACHE_HOST,6379);
    }


    public static void set(String key, String value) {
        if( (key == null || key.isEmpty()) || (value == null || value.isEmpty()) ) {
            log.warn("Key OR Value is EMPTY or NULL;key:{};value:{}.",key,value);
            return;
        }
        Jedis jedis = null;
        try {
            jedis = writeJedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            log.error("Error while setting data into cache.key:{};value:{}",key,value,e);
            e.printStackTrace();
        } finally {
            if(jedis!=null) {
                jedis.close();
            }
        }
    }

    public static void set(String key, int expInSecs, String value) {
        log.debug("key:{},expInSecs:{},value:{}",key,expInSecs,value);
        Jedis jedis = null;
        try {
            jedis = writeJedisPool.getResource();
            jedis.setex(key, expInSecs, value);
        } catch (Exception e) {
            log.error("Error while setting data into cache.key:{};value:{}",key,value,e);
           e.printStackTrace();
        } finally {
            if(jedis!=null) {
                jedis.close();
            }
        }
    }



    public static void zadd(String key, double score, String data) {
        Jedis jedis = null;
        try {
            jedis = writeJedisPool.getResource();
            jedis.zadd(key, score, data);
        } catch (Exception e) {
            log.error("Error while doing zadd data into cache.key:{};value:{}",key,data,e);
            e.printStackTrace();
        } finally {
            if(jedis!=null) {
                jedis.close();
            }
        }
    }


    public static Object get(String key, Class clazz) {
        Jedis jedis = null;
        String dupKey = key;
        if(key==null) {
            return null;
        }
        try {
            jedis = readJedisPool.getResource();
            if(jedis != null) {
                log.debug(" jedis:{} ", jedis.toString());
                String objVal = jedis.get(key);
                if(objVal!= null) {
                    return new ObjectMapper().readValue(objVal, clazz);
                }
            }

        } catch (Exception e) {
            clear(dupKey);
            log.error("Error while getting data from cache.key:{}",key,e);
           e.printStackTrace();
        } finally {
            if(jedis!=null) {
                jedis.close();
            }
        }
        return null;
    }

    public static String get(String key) {
        Jedis jedis = null;
        if(key==null) {
            return null;
        }
        try {
            jedis = readJedisPool.getResource();
            log.debug(" jedis:{} ",jedis.toString());
            System.out.println( "key : "+ jedis.get(key));
            return jedis.get(key);
        } catch (Exception e) {
            log.error("Error while getting data from cache.key:{}",key,e);
            e.printStackTrace();
        } finally {
            if(jedis!=null) {
                jedis.close();
            }
        }
        return null;
    }

    public static void clear(String key) {
        Jedis jedis = null;
        try {
            jedis = writeJedisPool.getResource();
            jedis.del(key);
        } catch (Exception e) {
            log.error("Error while getting data from cache.key:{}",key,e);
            e.printStackTrace();
        } finally {
            if(jedis!=null) {
                jedis.close();
            }
        }
    }

    public static JedisPoolConfig buildPoolConfig() {
        System.out.println("----REDIS----CACHE-----");
        int cachePoolMaxTotal = Integer.parseInt(System.getProperty("CACHE_POOL_MAX_TOTAL","100"));
        int cachePoolMaxIdle = Integer.parseInt(System.getProperty("CACHE_POOL_MAX_IDLE","50"));
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(cachePoolMaxTotal);
        poolConfig.setMaxIdle(cachePoolMaxIdle);
        poolConfig.setMinIdle(50);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(20).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(10).toMillis());
        poolConfig.setBlockWhenExhausted(false);
        return poolConfig;
    }

    public static String getUserCacheKey(int userId) {
        return USER_KEY+userId;
    }

    public static String getUserPostCacheKey(int userId, int postId) {
        return USER_KEY+userId+POST+postId;
    }

    public static String getUserArticleCacheKey(int userId, int articleId) {
        return USER_KEY+userId+ARTICLE+articleId;
    }
}
