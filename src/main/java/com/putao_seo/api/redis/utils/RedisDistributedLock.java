package com.putao_seo.api.redis.utils;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Component
public class RedisDistributedLock {
	
	private static final Logger logger = LoggerFactory.getLogger(RedisDistributedLock.class);
	
	@Autowired
	@Qualifier("appStringRedisTemplate")
    StringRedisTemplate redis;
	
	/**
	 * 加锁
	 * @param keys 只一个key
	 * @param storeId 业务相关字符串
	 * @param expiration 超时时间 
	 * @return token or null token 意味着加锁成功 返回token是为了保证自己只能释放自己的锁   null 意味着加锁失败
	 */
	public String acquire(final String key, final String storeId, final long expiration) {
		String token = UUID.randomUUID().toString();
		boolean re = redis.opsForValue().setIfAbsent(storeId+":"+key, token);
		if(re) {
			logger.info("redis lock key:"+storeId+":"+key + ":" + token);
			redis.expire(storeId+":"+key, expiration, TimeUnit.MILLISECONDS);
			return token;
		}
		
		
		
		
//		Assert.isTrue(keys.size() == 1, "Cannot acquire lock for multiple keys with this lock: " + keys);
//
//		String LOCK_SCRIPT = "return redis.call('SET', KEYS[1], ARGV[1], 'PX', tonumber(ARGV[2]), 'NX') and true or false";
//		RedisScript<Boolean> lockScript = new DefaultRedisScript<>(LOCK_SCRIPT, Boolean.class);
//		String token = UUID.randomUUID().toString();
//		List<String> singletonKeyList =  Collections.singletonList (storeId + ":" + keys.get(0));
//		final boolean locked = redis.execute(lockScript, singletonKeyList, token, String.valueOf(expiration));
//		System.out.println("Tried to acquire lock for key {} with token {} in store {}. Locked: " + locked);	
//		return locked ? token : null;
		return null;
	}
	
	/**
	 * 释放锁
	 * @param keys 只一个key
	 * @param token 加锁时生成的字符串
	 * @param storeId 业务相关字符串
	 * @return
	 */
	public boolean release(final String key, final String token, final String storeId) {
		
		if(StringUtils.equals(redis.opsForValue().get(storeId+":"+key), token)) {
			logger.info("redis delete key:"+storeId+":"+key);
			return redis.delete(storeId+":"+key);
		}
		
		return false;
		
		
//		Assert.isTrue(keys.size() == 1, "Cannot release lock for multiple keys with this lock: " + keys);
//		String LOCK_RELEASE_SCRIPT = "return redis.call('GET', KEYS[1]) == ARGV[1] and (redis.call('DEL', KEYS[1]) == 1) or false";
//		RedisScript<Boolean> lockReleaseScript = new DefaultRedisScript<>(LOCK_RELEASE_SCRIPT, Boolean.class);
//		List<String> singletonKeyList =  Collections.singletonList (storeId + ":" + keys.get(0));
//		final boolean released = redis.execute(lockReleaseScript, singletonKeyList, token);
//		if (released) {
//			System.out.println("Release script deleted the record for key {} with token " + token + " in store {}");
//		} else {
//			System.out.println("Release script failed for key {} with token " + token + " in store {}");
//		}
//		return released;
	}
}
