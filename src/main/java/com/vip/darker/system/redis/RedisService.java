package com.vip.darker.system.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Darker
 * @Date: 2018/9/20 11:23
 * @Description: redis操作service
 */
@Service(value = RedisService.BEAN_NAME)
public class RedisService {

    public static final String BEAN_NAME = "redisService";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    //================================common=================================//

    /**
     * @description:指定缓存失效时间
     * @auther: WBA
     * @date: 2018/12/11 17:23
     * @param: [key, time]
     * @return: boolean
     */
    @SuppressWarnings(value = "all")
    public boolean setExpire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:根据主键获取过期时间
     * @auther: WBA
     * @date: 2018/12/11 17:24
     * @param: [key]
     * @return: long
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * @description:判断主键是否存在
     * @auther: WBA
     * @date: 2018/12/11 17:24
     * @param: [key]
     * @return: boolean
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * @description:根据主键,删除缓存
     * @auther: WBA
     * @date: 2018/12/11 17:24
     * @param: [key]
     * @return: void
     */
    @SuppressWarnings("unchecked")
    public void delKey(String[] key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * @description:根据主键,获取缓存
     * @auther: WBA
     * @date: 2018/12/11 17:24
     * @param: [key]
     * @return: java.lang.Object
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * @description:设置缓存
     * @auther: WBA
     * @date: 2018/12/11 17:25
     * @param: [key, value]
     * @return: boolean
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:设置缓存并设置过期时间
     * @auther: WBA
     * @date: 2018/12/11 17:25
     * @param: [key, value, time]
     * @return: boolean
     */
    public boolean set(String key, Object value, long time) {

        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:递增
     * @auther: WBA
     * @date: 2018/12/11 17:25
     * @param: [key, delta]
     * @return: long
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须>0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * @description:递减
     * @auther: WBA
     * @date: 2018/12/11 17:25
     * @param: [key, delta]
     * @return: long
     */
    public long desc(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须>0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    //================================map=================================//

    /**
     * @description:根据主键,获取缓存
     * @auther: WBA
     * @date: 2018/12/11 17:25
     * @param: [key]
     * @return: java.util.Map
     */
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * @description:设置缓存
     * @auther: WBA
     * @date: 2018/12/11 17:26
     * @param: [key, map]
     * @return: boolean
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:设置缓存并设置过期时间
     * @auther: WBA
     * @date: 2018/12/11 17:26
     * @param: [key, map, time]
     * @return: boolean
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                setExpire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:根据主键,获取缓存
     * @auther: WBA
     * @date: 2018/12/11 17:28
     * @param: [key, item]
     * @return: java.lang.Object
     */
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * @description:设置缓存
     * @auther: WBA
     * @date: 2018/12/11 17:28
     * @param: [key, item, value]
     * @return: boolean
     */
    public boolean hset(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:设置缓存并设置过期时间
     * @auther: WBA
     * @date: 2018/12/11 17:29
     * @param: [key, item, value, time]
     * @return: boolean
     */
    public boolean hset(String key, String item, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                setExpire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:删除hash表中的值
     * @auther: WBA
     * @date: 2018/12/11 17:29
     * @param: [key, item]
     * @return: void
     */
    public void hdel(String key, Object[] item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * @description:判断hash表中是否有该项的值
     * @auther: WBA
     * @date: 2018/12/11 17:29
     * @param: [key, item]
     * @return: boolean
     */
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * @description:hash递增,若不存在则新建
     * @auther: WBA
     * @date: 2018/12/11 17:29
     * @param: [key, item, by]
     * @return: double
     */
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * @description:hash递减
     * @auther: WBA
     * @date: 2018/12/11 17:30
     * @param: [key, item, by]
     * @return: double
     */
    public double hdesc(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    //================================set=================================//

    /**
     * @description:根据key获取set中的所有值
     * @auther: WBA
     * @date: 2018/12/11 17:30
     * @param: [key]
     * @return: java.util.Set<java.lang.Object>
     */
    public Set<Object> sGet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * @description:根据value查询set中是否包含此值
     * @auther: WBA
     * @date: 2018/12/11 17:30
     * @param: [key, value]
     * @return: boolean
     */
    public boolean sHasKey(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * @description:将数据放入set缓存
     * @auther: WBA
     * @date: 2018/12/11 17:30
     * @param: [key, value]
     * @return: long
     */
    public long sSet(String key, Object[] value) {
        return redisTemplate.opsForSet().add(key, value);
    }

    /**
     * @description:将数据放入set缓存并设置过期时间
     * @auther: WBA
     * @date: 2018/12/11 17:30
     * @param: [key, time, value]
     * @return: long
     */
    public long sSetAndTime(String key, long time, Object[] value) {

        long count = redisTemplate.opsForSet().add(key, value);

        if (time > 0) {
            setExpire(key, time);
        }
        return count;
    }

    /**
     * @description:根据key获取set缓存长度
     * @auther: WBA
     * @date: 2018/12/11 17:31
     * @param: [key]
     * @return: long
     */
    public long sGetSetSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * @description:移除值为value的set集合
     * @auther: WBA
     * @date: 2018/12/11 17:31
     * @param: [key, value]
     * @return: long
     */
    public long setRemove(String key, Object[] value) {
        return redisTemplate.opsForSet().remove(key, value);
    }

    //================================list=================================//

    /**
     * @description:获取list缓存内容
     * @auther: WBA
     * @date: 2018/12/11 17:31
     * @param: [key, start, end]
     * @return: java.util.List<java.lang.Object>
     */
    public List<Object> lGet(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * @description:获取list缓存长度
     * @auther: WBA
     * @date: 2018/12/11 17:31
     * @param: [key]
     * @return: long
     */
    public long lGetLisSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 根据索引获取list缓存中的值
     *
     * @description:
     * @auther: WBA
     * @date: 2018/12/11 17:31
     * @param: [key, index:索引(index>=0时,0->表头,1->第二个元素,依次类推;index<0时,-1->表尾,-2->倒数第二个元素,依次类推)]
     * @return: java.lang.Object
     */
    public Object lGetIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * @description:设置list缓存值
     * @auther: WBA
     * @date: 2018/12/11 17:32
     * @param: [key, value]
     * @return: boolean
     */
    public boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:设置list缓存值
     * @auther: WBA
     * @date: 2018/12/11 17:32
     * @param: [key, value, time]
     * @return: boolean
     */
    public boolean lSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:设置list缓存值
     * @auther: WBA
     * @date: 2018/12/11 17:32
     * @param: [key, value]
     * @return: boolean
     */
    public boolean lSet(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:设置list缓存值
     * @auther: WBA
     * @date: 2018/12/11 17:32
     * @param: [key, value, time]
     * @return: boolean
     */
    public boolean lSet(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:根据索引更新list缓存中的某条数据
     * @auther: WBA
     * @date: 2018/12/11 17:32
     * @param: [key, index, value]
     * @return: boolean
     */
    public boolean lUpdateIndex(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @description:移除N个值为value的数据
     * @auther: WBA
     * @date: 2018/12/11 17:32
     * @param: [key, count, value]
     * @return: long
     */
    public long lRemove(String key, long count, Object value) {
        return redisTemplate.opsForList().remove(key, count, value);
    }
}