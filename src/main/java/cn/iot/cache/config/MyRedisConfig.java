package cn.iot.cache.config;

//@Configuration
public class MyRedisConfig {
	/**
	 * 存储序列化
	 * @param connectionFactory
	 * @return
	 * @throws Exception
	 */
	//@Bean
	/*public RedisTemplate<String,Object> myRedisTemplate(
			RedisConnectionFactory connectionFactory) throws Exception{
		
		RedisTemplate<String,Object> redis = new RedisTemplate<>();
		redis.setConnectionFactory(connectionFactory);
		
		//使用Jackson2JsonRedisSerializer替换默认序列化
		Jackson2JsonRedisSerializer<Object> ser = new Jackson2JsonRedisSerializer<>(Object.class);
		redis.setDefaultSerializer(ser);
		//redis.setValueSerializer(ser);
		return redis;
		
	}*/
	
/*	 @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
	 }*/

	 /*   @Bean
	    public CacheManager cacheManager(RedisConnectionFactory factory) {
	        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
	        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

	        //解决查询缓存转换异常的问题
	        ObjectMapper om = new ObjectMapper();
	        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	        jackson2JsonRedisSerializer.setObjectMapper(om);

	        // 配置序列化（解决乱码的问题）,过期时间30秒
	        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
	                .entryTtl(Duration.ofSeconds(1800000))
	                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
	                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
	                .disableCachingNullValues();

	        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
	                .cacheDefaults(config)
	                .build();
	        return cacheManager;
	    }*/
}
