package com.putao_seo.api.redis.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.redis.mini")
public class MiniRedisProperty extends RedisProperty {
}
