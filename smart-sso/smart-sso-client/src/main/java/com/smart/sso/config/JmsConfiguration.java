package com.smart.sso.config;

import com.smart.sso.client.PermissionJmsListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;

import javax.jms.ConnectionFactory;

/**
 * @FileName: JmsConfiguration
 * @Author: longer 199429
 * @Date: 2019-08-06 10:08
 * @Description: ${DESCRIPTION}
 */
@Configuration
@EnableJms
public class JmsConfiguration {

   /* @Bean
    public CachingConnectionFactory cachingConnectionFactory(ConnectionFactory connectionFactory,
                                                             @Value("${mq.cache}") Integer sessionSize) {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setTargetConnectionFactory(connectionFactory);
        cachingConnectionFactory.setSessionCacheSize(sessionSize);
        return cachingConnectionFactory;
    }*/

}
