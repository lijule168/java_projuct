package com.putao_seo.api.redis.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.putao_seo.api.redis.property.AppRedisProperty;
import com.putao_seo.api.redis.property.MiniRedisProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static com.putao_seo.api.constants.CommonConstants.REDIS_CACHE_TTL;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {


    @Autowired
    private AppRedisProperty appRedisProperty;

    @Autowired
    private MiniRedisProperty miniRedisProperty;

    @Primary
    @Bean(name = "miniRedisConnectionFactory")
    public RedisConnectionFactory miniRedisConnectionFactory() {
        ///FIXME 还没有设置pool
        RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(miniRedisProperty.getHost(), miniRedisProperty.getPort());
        if (miniRedisProperty.getPassword() != null) {
            standaloneConfig.setPassword(RedisPassword.of(miniRedisProperty.getPassword()));
        }
        LettuceConnectionFactory redisConnectionFactory = new LettuceConnectionFactory(standaloneConfig);
        redisConnectionFactory.setDatabase(miniRedisProperty.getDatabase());
        return redisConnectionFactory;
    }

    @Bean(name = "miniStringRedisTemplate")
    public StringRedisTemplate miniStringRedisTemplate(@Qualifier("miniRedisConnectionFactory") RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();


        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 解决 LocalDateTime 凡序列化

        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        om.registerModule(new JavaTimeModule().addDeserializer(LocalDateTime.class, localDateTimeDeserializer));
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        stringRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        stringRedisTemplate.afterPropertiesSet();

        return stringRedisTemplate;
    }

    
    @Bean(name = "appRedisConnectionFactory")
    public RedisConnectionFactory appRedisConnectionFactory() {
    	///FIXME 还没有设置pool
    	RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(appRedisProperty.getHost(), appRedisProperty.getPort());
    	if (appRedisProperty.getPassword() != null) {
    		standaloneConfig.setPassword(RedisPassword.of(appRedisProperty.getPassword()));
    	}
    	LettuceConnectionFactory redisConnectionFactory = new LettuceConnectionFactory(standaloneConfig);
        redisConnectionFactory.setDatabase(appRedisProperty.getDatabase());
        return redisConnectionFactory;
    }
    
    @Bean(name = "appStringRedisTemplate")
    public StringRedisTemplate appStringRedisTemplate(@Qualifier("appRedisConnectionFactory") RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();


        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 解决 LocalDateTime 凡序列化

        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        om.registerModule(new JavaTimeModule().addDeserializer(LocalDateTime.class, localDateTimeDeserializer));
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        stringRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        stringRedisTemplate.afterPropertiesSet();

        return stringRedisTemplate;
    }


    //自定义缓存key生成策略
    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, java.lang.reflect.Method method, Object... params) {
                StringBuffer sb = new StringBuffer();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for(Object obj:params){
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }


//    @Bean
//    public RedisTemplate<String, String> redisTemplate(@Qualifier("appRedisConnectionFactory")RedisConnectionFactory factory) {
//        ////解决键、值序列化问题
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }


//    /**
//     * 采用RedisCacheManager作为缓存管理器
//     * @param connectionFactory
//     */
//    @Bean
//    public CacheManager cacheManager(@Qualifier("appRedisConnectionFactory")RedisConnectionFactory connectionFactory) {
//        RedisCacheManager redisCacheManager = RedisCacheManager.create(connectionFactory);
//
//        return  redisCacheManager;
//    }




    @Bean
    public CacheManager cacheManager(@Qualifier("miniRedisConnectionFactory")RedisConnectionFactory redisConnectionFactory) {

        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                // 默认策略，未配置的 key 会使用这个
                this.getRedisCacheConfigurationWithTtl(REDIS_CACHE_TTL)
                // 指定 key 策略
//                this.getRedisCacheConfigurationMap()
        );
    }


    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 解决 LocalDateTime
        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        om.registerModule((new JavaTimeModule()).addDeserializer(LocalDateTime.class, localDateTimeDeserializer));
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(jackson2JsonRedisSerializer)
        ).entryTtl(Duration.ofSeconds(seconds));

        return redisCacheConfiguration;
    }

}


