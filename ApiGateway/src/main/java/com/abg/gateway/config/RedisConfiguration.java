package com.abg.gateway.config;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private Integer port;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.pool.max.connection}")
    private Integer maxConnection;

    @Value("${redis.pool.max.idle.connection}")
    private Integer maxIdleConnection;

    @Value("${redis.pool.min.idle.connection}")
    private Integer minIdleConnection;

    @Value("${redis.database.index}")
    private int databaseIndex;

    @Primary
    @Bean(name = "redisConnectionFactory")
    public LettuceConnectionFactory getConnectionFactory(GenericObjectPoolConfig<Void> genericObjectPoolConfig) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setPassword(password);
        redisStandaloneConfiguration.setDatabase(databaseIndex);

        LettuceClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(genericObjectPoolConfig)
                .build();

        return new LettuceConnectionFactory(redisStandaloneConfiguration, lettuceClientConfiguration);
    }

    @Bean
    public GenericObjectPoolConfig<Void> genericObjectPoolConfig() {
        GenericObjectPoolConfig<Void> genericObjectPoolConfig = new GenericObjectPoolConfig<>();
        genericObjectPoolConfig.setMaxTotal(maxConnection);
        genericObjectPoolConfig.setMaxIdle(maxIdleConnection);
        genericObjectPoolConfig.setMinIdle(minIdleConnection);
        return genericObjectPoolConfig;
    }

    @Bean("customReactiveRedisTemplate")
    public ReactiveRedisTemplate<String, ?> redisTemplate(LettuceConnectionFactory connectionFactory) {

        StringRedisSerializer keySerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();

        StringRedisSerializer hashKeySerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, Object> builder =
                RedisSerializationContext.newSerializationContext(keySerializer);

        RedisSerializationContext<String, Object> context = builder
                .value(valueSerializer)
                .hashKey(hashKeySerializer)
                .hashValue(jsonRedisSerializer).build();

        return new ReactiveRedisTemplate<>(connectionFactory, context);

    }

}
