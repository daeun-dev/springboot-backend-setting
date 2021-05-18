package com.doosan.ddxp.api.core.config.redis;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.google.gson.JsonParser;

public class GsonRedisSerializer<T> implements RedisSerializer {

	private JsonParser parser;

	@Override
	public byte[] serialize(Object t) throws SerializationException {
		return t.toString().getBytes();
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		String jsonString = new String(bytes);
		return (T) parser.parseString(jsonString);
	}

	

}
