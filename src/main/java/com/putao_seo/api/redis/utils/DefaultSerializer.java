package com.putao_seo.api.redis.utils;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import java.nio.charset.Charset;

/**
 * @author : tangtonglong
 * 2019/5/23 17:40
 * @return
 */
public class DefaultSerializer implements RedisSerializer<Object> {
    private final Charset charset;

    public DefaultSerializer() {
        this(Charset.forName("UTF8"));
    }

    public DefaultSerializer(Charset charset) {
        Assert.notNull(charset, "Charset must not be null!");
        this.charset = charset;
    }


    @Override
    public byte[] serialize(Object o) throws SerializationException {
        return o == null ? null : String.valueOf(o).getBytes(charset);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return bytes == null ? null : new String(bytes, charset);
    }
}
