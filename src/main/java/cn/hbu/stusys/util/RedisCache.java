package cn.hbu.stusys.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.Callable;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.log4j.Logger;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCache<T> implements Cache {

	private static final Logger logger = Logger.getLogger(RedisCache.class);

	/**
	 * 区分名称
	 */
	private String name;

	/**
	 * redisTemplate
	 */
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 过期时间
	 */
	private Long liveTime=100000L;

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	/**
	 * 得到数据
	 * 
	 * @param key
	 * @return
	 */
	

	/**
	 * 反序列化
	 * 
	 * @param bytes
	 * @return
	 */
	private T toObject(byte[] bytes) {
		T obj = null;
		try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bis)) {
			obj = (T) ois.readObject();
		} catch (IOException ex) {
			logger.error("IOException", ex);
		} catch (ClassNotFoundException ex) {
			logger.error("ClassNotFoundException", ex);
		}
		return obj;
	}

	@Override
	public <T> T get(Object o, Class<T> aClass) {
		return null;
	}

	/**
	 * key-value 的形式放入缓存
	 * 
	 * @param key
	 * @param value
	 */
	@Override
	public void put(Object key, Object value) {
		logger.info("put cache, key:"+key);
		final String keyf = key.toString();
		final Object valuef = value;

		redisTemplate.execute(new RedisCallback<T>() {

			@Override
			public T doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = keyf.getBytes();
				byte[] valueb = toByteArray(valuef);
				connection.set(keyb, valueb);
				if (liveTime > 0L) {
					connection.expire(keyb, liveTime);
				}
				return null;
			}
		});
	}

	/**
	 * 序列化成二进制
	 * 
	 * @param obj
	 * @return
	 */
	private byte[] toByteArray(Object obj) {
		byte[] bytes = null;
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {

			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray();
		} catch (IOException ex) {
			logger.error("IOException", ex);
		}
		return bytes;
	}

	@Override
	public ValueWrapper putIfAbsent(Object o, Object o1) {
		return null;
	}

	/**
	 * 通过对应的key 进行删除缓存
	 * 
	 * @param key
	 */
	@Override
    public void evict(Object key) {
        logger.info("delete cache ,key:"+key);
        final String keyf = (String) key;
        redisTemplate.execute(new RedisCallback<T>() {

			@Override
			public T doInRedis(RedisConnection connection) throws DataAccessException {
				return (T) connection.del(keyf.getBytes());
			}
		});
    }

	/**
	 * 清除缓存
	 */
	@Override
    public void clear() {
        redisTemplate.execute(new RedisCallback<T>() {

			@Override
			public T doInRedis(RedisConnection connection) throws DataAccessException {
				// TODO 自动生成的方法存根
				connection.flushDb();
	            return null;
			}
		});
    }

	@Override
	public <T> T get(Object key, Callable<T> valueLoader) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Object getNativeCache() {
		// TODO 自动生成的方法存根
		return this.redisTemplate;
	}
	@Override
	public ValueWrapper get(Object key) {
		logger.info("get cache, key:" + key);
		final String keyf =  key.toString();
		Object object = null;
		object = redisTemplate.execute(new RedisCallback<T>() {

			public T doInRedis(RedisConnection connection)
					throws DataAccessException {
				// TODO 自动生成的方法存根
				byte[] keyb = keyf.getBytes();
				byte[] value = connection.get(keyb);
				if (value == null) {
					return null;
				}
				return toObject(value);
			}

		});
		return (object != null ? new SimpleValueWrapper(object) : null);
	}
}
